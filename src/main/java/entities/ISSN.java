package main.java.entities;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ISSN")
public class ISSN {

    private String issnType;
    private String text;


    // Getter Methods

    public String getIssnType() {
        return issnType;
    }

    public String getText() {
        return text;
    }

    // Setter Methods

    public void setIssnType(String issnType) {
        this.issnType = issnType;
    }

    public void setText(String text) {
        this.text = text;
    }
}
