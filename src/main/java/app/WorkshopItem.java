package app;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Workshop")
@XmlType(propOrder = {"name", "id"})
public class WorkshopItem {
    String name;
    String id;

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public WorkshopItem(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public WorkshopItem() {
    }

    @XmlAttribute
    public void setName(String name) {
        this.name = name;
    }
    @XmlAttribute
    public void setId(String id) {
        this.id = id;
    }
}
