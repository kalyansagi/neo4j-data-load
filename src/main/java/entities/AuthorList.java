package main.java.entities;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "AuthorList")
public class AuthorList {

    List<Author> authors;
    private String _CompleteYN;


    // Getter Methods
    @XmlElement(name = "Author")
    public List<Author> getAuthors() {
        return authors;
    }

    @XmlAttribute(name = "CompleteYN")
    public String get_CompleteYN() {
        return _CompleteYN;
    }

    // Setter Methods

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public void set_CompleteYN(String _CompleteYN) {
        this._CompleteYN = _CompleteYN;
    }
}
