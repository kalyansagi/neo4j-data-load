package main.java.entities;

import javax.management.Descriptor;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "MeshHeading")
public class MeshHeading {

    private String descriptorName;
    private String ui;

    @XmlElement(name = "DescriptorName")
    public String getDescriptorName() {
        return descriptorName;
    }

    @XmlAttribute(name = "UI")
    public String getUi() {
        return ui;
    }

    public void setUi(String ui) {
        this.ui = ui;
    }

    public void setDescriptorName(String descriptorName) {
        this.descriptorName = descriptorName;
    }
}
