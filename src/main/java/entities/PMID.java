package main.java.entities;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "PMID")
public class PMID {
    private String _Version;
    private String __text;


    // Getter Methods
    @XmlAttribute(name = "Version")
    public String get_Version() {
        return _Version;
    }

    @XmlElement(name = "PMID")
    public String get__text() {
        return __text;
    }

    // Setter Methods

    public void set_Version(String _Version) {
        this._Version = _Version;
    }

    public void set__text(String __text) {
        this.__text = __text;
    }
}
