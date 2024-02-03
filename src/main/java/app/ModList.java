package app;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "mods")
@XmlType(propOrder = {"name", "mods"})
public class ModList {
    String name;

    public ModList(String name) {
        this.name = name;
        this.mods = new ArrayList<>();
    }

    public ModList() {
        this.mods = new ArrayList<>();
    }

    @XmlAttribute
    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "Workshop")
    List<WorkshopItem> mods;

    public String getName() {
        return name;
    }

    public List<WorkshopItem> getMods() {
        return mods;
    }
}
