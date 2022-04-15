package main.java.entities;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "PubmedArticle")
public class PubmedArticle {
    private MedlineCitation MedlineCitationObject;
    private PubmedData PubmedDataObject;


    // Getter Methods
    @XmlElement(name = "MedlineCitation")
    public MedlineCitation getMedlineCitation() {
        return MedlineCitationObject;
    }

    @XmlElement(name = "PubmedData")
    public PubmedData getPubmedData() {
        return PubmedDataObject;
    }

    // Setter Methods

    public void setMedlineCitation(MedlineCitation MedlineCitationObject) {
        this.MedlineCitationObject = MedlineCitationObject;
    }

    public void setPubmedData(PubmedData PubmedDataObject) {
        this.PubmedDataObject = PubmedDataObject;
    }
}
