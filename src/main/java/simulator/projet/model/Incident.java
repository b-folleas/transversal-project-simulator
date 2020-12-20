package simulator.projet.model;

public class Incident {
    private int id;
    private MapItem mapItem;
    private String incidentType;
    private int intensity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MapItem getMapItem() {
        return mapItem;
    }

    public void setMapItem(MapItem mapItem) {
        this.mapItem = mapItem;
    }

    public String getIncidentType() {
        return incidentType;
    }

    public void setIncidentType(String incidentType) {
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
