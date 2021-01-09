package simulator.projet.model;

import java.io.Serializable;

public class Incident implements Serializable {
    private Long id;
    private MapItem mapItem;
    private IncidentType incidentType;
    private int intensity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MapItem getMapItem() {
        return mapItem;
    }

    public void setMapItem(MapItem mapItem) {
        this.mapItem = mapItem;
    }

    public IncidentType getIncidentType() {
        return incidentType;
    }

    public void setIncidentType(IncidentType incidentType) {
        this.incidentType = incidentType;
    }

    public int getIntensity() {
        return intensity;
    }

    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }

    @Override
    public String toString() {
        return "Incident{" +
                "id=" + id +
                ", mapItem=" + mapItem +
                ", incidentType='" + incidentType + '\'' +
                ", intensity=" + intensity +
                '}';
    }
}
