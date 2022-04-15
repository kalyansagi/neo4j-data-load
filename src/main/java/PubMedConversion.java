package main.java;

import main.java.entities.PubmedArticle;
import main.java.entities.PubmedArticleSet;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class PubMedConversion {
    public static void main(String[] args) {
        final long startTime = System.currentTimeMillis();
        File xmlFile = new File("src/main/resources/toy.xml");
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(PubmedArticleSet.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            PubmedArticleSet pubmedArticleSet = (PubmedArticleSet) jaxbUnmarshaller.unmarshal(xmlFile);
            System.out.println(pubmedArticleSet);
            PostgreSQLConnector postgreSQLConnector = new PostgreSQLConnector();
//            postgreSQLConnector.createTables();
            generateScript(pubmedArticleSet);
//            postgreSQLConnector.insertIntoPapers(pubmedArticleSet);
//            postgreSQLConnector.insertIntoJournal(pubmedArticleSet);
//            postgreSQLConnector.insertIntoAuthor(pubmedArticleSet);
//            postgreSQLConnector.insertIntoKeyword(pubmedArticleSet);
//            postgreSQLConnector.insertIntoMesh(pubmedArticleSet);
            final long endTime = System.currentTimeMillis();
            System.out.println("Total time taken for process:" + (endTime - startTime));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private static void generateScript(final PubmedArticleSet pubmedArticleSet) {
        AtomicInteger i = new AtomicInteger(1);
        pubmedArticleSet.getPubmedArticles().forEach(a -> {
            printscript(a, i.get());
            i.getAndIncrement();
        });
        AtomicInteger j = new AtomicInteger(1);
        pubmedArticleSet.getPubmedArticles().forEach(a -> {
            relations(a, j.get());
            j.getAndIncrement();
        });

    }

    private static void printscript(PubmedArticle a, int i) {
        String article_title_temp = a.getMedlineCitation().getArticle().getArticleTitle();
        String article_title = article_title_temp.replaceAll("[^a-zA-Z0-9]", "");
        String pmid = String.valueOf(a.getMedlineCitation().getPMID());
        String abstract_text_temp = a.getMedlineCitation().getArticle().getAbstract() != null ? a.getMedlineCitation().getArticle().getAbstract().getAbstractText() : "No Abstract found";
        String abstract_text = abstract_text_temp.replaceAll("[^a-zA-Z0-9]", "");
        String full_name = a.getMedlineCitation().getArticle().getAuthorList() != null ? (a.getMedlineCitation().getArticle().getAuthorList().getAuthors().get(0).getForeName() + " " + a.getMedlineCitation().getArticle().getAuthorList().getAuthors().get(0).getLastName()) : UUID.randomUUID().toString();
        String author_id = PostgreSQLConnector.getMd5(full_name);
        String term = a.getMedlineCitation().getKeywordListObject() != null ? (a.getMedlineCitation().getKeywordListObject().getKeywords().get(0)) : "No keywords found";
        String key_id = PostgreSQLConnector.getMd5(term != null ? term : UUID.randomUUID().toString());
        String issn = a.getMedlineCitation().getArticle().getJournal().getIssn();
        String title = a.getMedlineCitation().getArticle().getJournal().getTitle();
        String mesh_uid = UUID.randomUUID().toString();
        String mesh_term = a.getMedlineCitation().getMeshHeadingListObject() != null ? (a.getMedlineCitation().getMeshHeadingListObject().getMeshHeadingList().get(0).getDescriptorName()) : "No keywords found";
        String keyword = "CREATE (keyword" + i + ":Keyword" + i + " {key_id:'" + key_id + "',term:'" + term + "'})";
        String citation = "CREATE (citation" + i + ":Citation" + i + " {pmid:'" + pmid + "', article_title:'" + article_title + "',abstract_text:'" + abstract_text + "'})";
        String journal = "CREATE (journal" + i + ":Journal" + i + " {issn:'" + issn + "', title:'" + title + "' })";
        String author = "CREATE (author" + i + ":Author" + i + " {author_id:'" + author_id + "', full_name:'" + full_name + "'})";
        String mesh = "CREATE (mesh" + i + ":Mesh" + i + " {mesh_ui:'" + mesh_uid + "', term:'" + mesh_term + "'})";
//        String relation;
//        if (i == 1) {
//            relation = "CREATE (citation" + i + ")-[:WRITTEN_BY]->(author" + i + "),";
//        } else {
//            relation = "(citation" + i + ")-[:WRITTEN_BY]->(author" + i + ")";
//        }

        System.out.println(keyword + "\n" + citation + "\n" + journal + "\n" + author + "\n" + mesh + "\n");
        /*
        CREATE (citation:Citation {pmid:'1', article_title:'Formate assay in body fluids: application in methanol poisoning.', abstract_text:'No Abstract found'})
        CREATE (author:Author {author_id:'3fe7c5ecc57feadda9b3d3d3c18fb828', full_name:'A B Makar'})
	    CREATE (citation)-[:WRITTEN_BY]->(author);

         */

    }

    private static void relations(PubmedArticle a, int i) {
        String relation;
        if (i == 1) {
            relation = "CREATE (citation" + i + ")-[:WRITTEN_BY]->(author" + i + ")," + "\n" + "(citation" + i + ")-[:CONTAINS]->(keyword" + i + ")," + "\n" + "(citation" + i + ")-[:PUBLISHED_BY]->(journal" + i + ")," + "\n" + "(citation" + i + ")-[:CONTAINS]->(mesh" + i + "),";
        } else {
            relation = "(citation" + i + ")-[:WRITTEN_BY]->(author" + i + ")," + "\n" + "(citation" + i + ")-[:CONTAINS]->(keyword" + i + ")," + "\n" + "(citation" + i + ")-[:PUBLISHED_BY]->(journal" + i + ")," + "\n" + "(citation" + i + ")-[:CONTAINS]->(mesh" + i + "),";
        }
        System.out.println(relation + "\n");
    }
}
