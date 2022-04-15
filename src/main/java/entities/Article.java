package main.java.entities;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Article")
public class Article {
    Journal JournalObject;
    private String ArticleTitle;
    Pagination PaginationObject;
    AuthorList AuthorListObject;
    private String Language;
    PublicationTypeList PublicationTypeListObject;
    private String VernacularTitle;
    private String _PubModel;

    @XmlElement(name = "Abstract")
    public Abstractt getAbstract() {
        return Abstract;
    }

    public void setAbstract(Abstractt anAbstract) {
        Abstract = anAbstract;
    }

    private Abstractt Abstract;


    // Getter Methods

    @XmlElement(name = "Journal")
    public Journal getJournal() {
        return JournalObject;
    }

    @XmlElement(name = "ArticleTitle")
    public String getArticleTitle() {
        return ArticleTitle;
    }

    public Pagination getPagination() {
        return PaginationObject;
    }

    @XmlElement(name = "AuthorList")
    public AuthorList getAuthorList() {
        return AuthorListObject;
    }

    public String getLanguage() {
        return Language;
    }

    public PublicationTypeList getPublicationTypeList() {
        return PublicationTypeListObject;
    }

    public String getVernacularTitle() {
        return VernacularTitle;
    }

    public String get_PubModel() {
        return _PubModel;
    }

    // Setter Methods

    public void setJournal(Journal JournalObject) {
        this.JournalObject = JournalObject;
    }

    public void setArticleTitle(String ArticleTitle) {
        this.ArticleTitle = ArticleTitle;
    }

    public void setPagination(Pagination PaginationObject) {
        this.PaginationObject = PaginationObject;
    }

    public void setAuthorList(AuthorList AuthorListObject) {
        this.AuthorListObject = AuthorListObject;
    }

    public void setLanguage(String Language) {
        this.Language = Language;
    }

    public void setPublicationTypeList(PublicationTypeList PublicationTypeListObject) {
        this.PublicationTypeListObject = PublicationTypeListObject;
    }

    public void setVernacularTitle(String VernacularTitle) {
        this.VernacularTitle = VernacularTitle;
    }

    public void set_PubModel(String _PubModel) {
        this._PubModel = _PubModel;
    }
}
