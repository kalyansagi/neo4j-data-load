package main.java.entities;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Abstract")
public class Abstractt {

    private String AbstractText;

    @XmlElement(name = "AbstractText")
    public String getAbstractText() {
        return AbstractText;
    }

    public void setAbstractText(String abstractText) {
        AbstractText = abstractText;
    }

}
