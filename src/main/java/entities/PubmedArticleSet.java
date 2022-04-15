package main.java.entities;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "PubmedArticleSet")
public class PubmedArticleSet {

    List<PubmedArticle> pubmedArticles;

    @XmlElement(name = "PubmedArticle")
    public List<PubmedArticle> getPubmedArticles() {
        return pubmedArticles;
    }

    public void setPubmedArticles(List<PubmedArticle> pubmedArticles) {
        this.pubmedArticles = pubmedArticles;
    }


    // Getter Methods

//    @XmlElement(name = "PubmedArticle")
//    public PubmedArticle getPubmedArticle() {
//        return PubmedArticleObject;
//    }
//
//    // Setter Methods
//
//    public void setPubmedArticle(PubmedArticle PubmedArticleObject) {
//        this.PubmedArticleObject = PubmedArticleObject;
//    }
}
