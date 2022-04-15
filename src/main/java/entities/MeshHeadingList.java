package main.java.entities;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "MeshHeadingList")
public class MeshHeadingList {

    List<MeshHeading> meshHeadingList;

    @XmlElement(name = "MeshHeading")
    public List<MeshHeading> getMeshHeadingList() {
        return meshHeadingList;
    }

    public void setMeshHeadingList(List<MeshHeading> meshHeadingList) {
        this.meshHeadingList = meshHeadingList;
    }


}
