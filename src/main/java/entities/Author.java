package main.java.entities;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Author")
public class Author {
    private String LastName;
    private String ForeName;
    private String Initials;
    private String _ValidYN;


    // Getter Methods

    @XmlElement(name = "LastName")
    public String getLastName() {
        return LastName;
    }

    @XmlElement(name = "ForeName")
    public String getForeName() {
        return ForeName;
    }

    @XmlElement(name = "Initials")
    public String getInitials() {
        return Initials;
    }

    @XmlAttribute(name = "ValidYN")
    public String get_ValidYN() {
        return _ValidYN;
    }

    // Setter Methods

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public void setForeName(String ForeName) {
        this.ForeName = ForeName;
    }

    public void setInitials(String Initials) {
        this.Initials = Initials;
    }

    public void set_ValidYN(String _ValidYN) {
        this._ValidYN = _ValidYN;
    }
}
