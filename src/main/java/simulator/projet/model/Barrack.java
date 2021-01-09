package simulator.projet.model;

import java.io.Serializable;

public class Barrack implements Serializable {

    private Long id;
    private String name;
    private MapItem mapItem;

    public Barrack() {
    }

    public Barrack(String name, MapItem mapItem) {
        this.name = name;
        this.mapItem = mapItem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MapItem getMapItem() {
        return mapItem;
    }

    public void setMapItem(MapItem mapItem) {
        this.mapItem = mapItem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Barrack{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mapItem=" + mapItem +
                '}';
    }
}
