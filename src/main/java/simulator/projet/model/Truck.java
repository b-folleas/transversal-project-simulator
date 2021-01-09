package simulator.projet.model;

import java.io.Serializable;
import java.util.List;

public class Truck implements Serializable {

    private Long id;
    private MapItem mapItem;
    private Barrack barrack;
    private boolean availability;
    private List<Incident> incidents;
    private int matricule;

    public Truck(Long id, MapItem mapItem, Barrack barrack, boolean availability, List<Incident> incidents, int matricule) {
        this.id = id;
        this.mapItem = mapItem;
        this.barrack = barrack;
        this.availability = availability;
        this.incidents = incidents;
        this.matricule = matricule;
    }

    public Truck() {

    }

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

    public List<Incident> getIncidents() {
        return incidents;
    }

    public void setIncidents(List<Incident> incidents) {
        this.incidents = incidents;
    }

    public Barrack getBarrack() {
        return barrack;
    }

    public void setBarrack(Barrack barrack) {
        this.barrack = barrack;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public int getMatricule() {
        return matricule;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "id=" + id +
                ", mapItem=" + mapItem +
                ", barrack=" + barrack +
                ", availability=" + availability +
                ", incidents=" + incidents +
                ", matricule=" + matricule +
                '}';
    }

}
