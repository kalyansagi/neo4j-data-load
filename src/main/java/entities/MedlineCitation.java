package main.java.entities;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "MedlineCitation")
public class MedlineCitation {
    DateCompleted DateCompletedObject;
    DateRevised DateRevisedObject;
    Article ArticleObject;
    MedlineJournalInfo MedlineJournalInfoObject;
    MeshHeadingList MeshHeadingListObject;

    @XmlElement(name = "MeshHeadingList")
    public MeshHeadingList getMeshHeadingListObject() {
        return MeshHeadingListObject;
    }

    public void setMeshHeadingListObject(MeshHeadingList meshHeadingListObject) {
        MeshHeadingListObject = meshHeadingListObject;
    }

    KeywordList KeywordListObject;

    @XmlElement(name = "KeywordList")
    public KeywordList getKeywordListObject() {
        return KeywordListObject;
    }

    public void setKeywordListObject(KeywordList keywordListObject) {
        KeywordListObject = keywordListObject;
    }


    @XmlElement(name = "PMID")
    public int getPMID() {
        return PMID;
    }

    public void setPMID(int PMID) {
        this.PMID = PMID;
    }

    private int PMID;
    private String _Status;
    private String _Owner;


    // Getter Methods


    @XmlElement(name = "DateCompleted")
    public DateCompleted getDateCompleted() {
        return DateCompletedObject;
    }

    @XmlElement(name = "DateRevised")
    public DateRevised getDateRevised() {
        return DateRevisedObject;
    }

    @XmlElement(name = "Article")
    public Article getArticle() {
        return ArticleObject;
    }

    @XmlElement(name = "MedlineJournalInfo")
    public MedlineJournalInfo getMedlineJournalInfo() {
        return MedlineJournalInfoObject;
    }

    @XmlAttribute(name = "Status")
    public String get_Status() {
        return _Status;
    }

    @XmlAttribute(name = "Owner")
    public String get_Owner() {
        return _Owner;
    }

    // Setter Methods


    public void setDateCompleted(DateCompleted DateCompletedObject) {
        this.DateCompletedObject = DateCompletedObject;
    }

    public void setDateRevised(DateRevised DateRevisedObject) {
        this.DateRevisedObject = DateRevisedObject;
    }

    public void setArticle(Article ArticleObject) {
        this.ArticleObject = ArticleObject;
    }

    public void setMedlineJournalInfo(MedlineJournalInfo MedlineJournalInfoObject) {
        this.MedlineJournalInfoObject = MedlineJournalInfoObject;
    }

    public void setMeshHeadingList(MeshHeadingList MeshHeadingListObject) {
        this.MeshHeadingListObject = MeshHeadingListObject;
    }

    public void set_Status(String _Status) {
        this._Status = _Status;
    }

    public void set_Owner(String _Owner) {
        this._Owner = _Owner;
    }
}
