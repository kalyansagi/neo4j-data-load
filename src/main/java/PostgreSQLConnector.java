package main.java;

import main.java.entities.PubmedArticleSet;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class PostgreSQLConnector {

    public void createTables() {
        Connection connection;
        Statement statement;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/postgres",
                            "studentportal", "studentportal");
            System.out.println("Opened database successfully");

            statement = connection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS JOURNAL " +
                    "(ISSN VARCHAR(100), " +
                    "TITLE VARCHAR(1000), " +
                    "ISO_ABBREV VARCHAR(500));";
            String sql1 = "CREATE TABLE IF NOT EXISTS AUTHOR " +
                    "(AUTHOR_ID VARCHAR(100), " +
                    "FULL_NAME VARCHAR(500));";
            String sql2 = "CREATE TABLE IF NOT EXISTS KEYWORD " +
                    "(KEY_ID VARCHAR(100), " +
                    "TERM VARCHAR(500));";
            String sql3 = "CREATE TABLE IF NOT EXISTS MESH " +
                    "(MESH_UI VARCHAR(100), " +
                    "TERM VARCHAR(500));";
            String sql4 = "CREATE TABLE IF NOT EXISTS CITATION " +
                    "(PMID VARCHAR(500), " +
                    "ARTICLE_TITLE VARCHAR(1000), " +
                    "ABSTRACT_TEXT VARCHAR(5000));";

            statement.executeUpdate(sql);
            statement.executeUpdate(sql1);
            statement.executeUpdate(sql2);
            statement.executeUpdate(sql3);
            statement.executeUpdate(sql4);
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

    }

    public void insertIntoJournal(final PubmedArticleSet pubmedArticleSet) throws SQLException, ClassNotFoundException {
        Connection connection;
        AtomicInteger total = new AtomicInteger();
        Class.forName("org.postgresql.Driver");
        connection = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/postgres",
                        "studentportal", "studentportal");
        connection.setAutoCommit(false);
        System.out.println("Opened database successfully");

        String sql = "INSERT INTO JOURNAL (ISSN, TITLE, ISO_ABBREV) "
                + "VALUES (?, ?, ?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        pubmedArticleSet.getPubmedArticles().forEach(a -> {
            try {

                preparedStatement.setString(1, a.getMedlineCitation().getArticle().getJournal().getIssn());
                preparedStatement.setString(2, a.getMedlineCitation().getArticle().getJournal().getTitle());
                preparedStatement.setString(3, a.getMedlineCitation().getArticle().getJournal().getISOAbbreviation());
                preparedStatement.execute();
                System.out.println("Inserting Journal " + a.getMedlineCitation().getPMID());
                total.getAndIncrement();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        connection.commit();
        connection.close();
    }

    public void insertIntoAuthor(final PubmedArticleSet pubmedArticleSet) throws SQLException, ClassNotFoundException {
        Connection connection;
        AtomicInteger total = new AtomicInteger();
        Class.forName("org.postgresql.Driver");
        connection = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/postgres",
                        "studentportal", "studentportal");
        connection.setAutoCommit(false);
        System.out.println("Opened database successfully");

        String sql = "INSERT INTO AUTHOR (author_id, full_name) "
                + "VALUES (?, ?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        pubmedArticleSet.getPubmedArticles().forEach(a -> {
            try {
                String full_name = a.getMedlineCitation().getArticle().getAuthorList() != null ? (a.getMedlineCitation().getArticle().getAuthorList().getAuthors().get(0).getForeName() + " " + a.getMedlineCitation().getArticle().getAuthorList().getAuthors().get(0).getLastName()) : UUID.randomUUID().toString();
                preparedStatement.setString(1, getMd5(full_name));
                preparedStatement.setString(2, full_name);
                preparedStatement.execute();
                System.out.println("Inserting Author ");
                total.getAndIncrement();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        connection.commit();
        connection.close();
    }

    public void insertIntoKeyword(final PubmedArticleSet pubmedArticleSet) throws SQLException, ClassNotFoundException {
        Connection connection;
        AtomicInteger total = new AtomicInteger();
        Class.forName("org.postgresql.Driver");
        connection = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/postgres",
                        "studentportal", "studentportal");
        connection.setAutoCommit(false);
        System.out.println("Opened database successfully");

        String sql = "INSERT INTO KEYWORD (KEY_ID, TERM) "
                + "VALUES (?, ?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        pubmedArticleSet.getPubmedArticles().forEach(a -> {
            try {
                //preparedStatement.setString(1, UUID.randomUUID().toString());
                preparedStatement.setString(1, getMd5(a.getMedlineCitation().getKeywordListObject() != null ? (a.getMedlineCitation().getKeywordListObject().getKeywords().get(0)) : UUID.randomUUID().toString()));
                preparedStatement.setString(2, a.getMedlineCitation().getKeywordListObject() != null ? (a.getMedlineCitation().getKeywordListObject().getKeywords().get(0)) : "No keywords found");
                preparedStatement.execute();
                System.out.println("Inserting Keyword ");
                total.getAndIncrement();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        connection.commit();
        connection.close();
    }

    public static String getMd5(String input) {
        try {

            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest
            //  of an input digest() return array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }

        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertIntoMesh(final PubmedArticleSet pubmedArticleSet) throws SQLException, ClassNotFoundException {
        Connection connection;
        AtomicInteger total = new AtomicInteger();
        Class.forName("org.postgresql.Driver");
        connection = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/postgres",
                        "studentportal", "studentportal");
        connection.setAutoCommit(false);
        System.out.println("Opened database successfully");

        String sql = "INSERT INTO MESH (MESH_UI, TERM) "
                + "VALUES (?, ?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        pubmedArticleSet.getPubmedArticles().forEach(a -> {
            try {
                preparedStatement.setString(1, UUID.randomUUID().toString());
                preparedStatement.setString(2, a.getMedlineCitation().getMeshHeadingListObject() != null ? (a.getMedlineCitation().getMeshHeadingListObject().getMeshHeadingList().get(0).getDescriptorName()) : "No keywords found");
                preparedStatement.execute();
                System.out.println("Inserting MESH ");
                total.getAndIncrement();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        connection.commit();
        connection.close();
    }


    public void insertIntoPapers(final PubmedArticleSet pubmedArticleSet) throws SQLException, ClassNotFoundException {
        Connection connection;
        AtomicInteger total = new AtomicInteger();

        Class.forName("org.postgresql.Driver");
        connection = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/postgres",
                        "studentportal", "studentportal");
        connection.setAutoCommit(false);
        System.out.println("Opened database successfully");

        String sql = "INSERT INTO CITATION (PMID, ARTICLE_TITLE, ABSTRACT_TEXT) "
                + "VALUES (?, ?, ?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        pubmedArticleSet.getPubmedArticles().forEach(a -> {
            try {

                preparedStatement.setInt(1, a.getMedlineCitation().getPMID());
                preparedStatement.setString(2, a.getMedlineCitation().getArticle().getArticleTitle());
                preparedStatement.setString(3, a.getMedlineCitation().getArticle().getAbstract() != null ? a.getMedlineCitation().getArticle().getAbstract().getAbstractText() : "No Abstract found");
                preparedStatement.execute();
                System.out.println("Inserting PMID" + a.getMedlineCitation().getPMID());
                total.getAndIncrement();
                System.out.println("Inserting CITATION ");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        connection.commit();
        connection.close();
        System.out.println("Total " + total + " Records inserted successfully");

    }
}

