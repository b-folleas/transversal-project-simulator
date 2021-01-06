package simulator.projet.model;

import java.util.List;

public class Truck {

    private int id;
    private MapItem mapItem;
    private Barrack barrack;
    private boolean availability;
    private List<Incident> incidents;
    private int matricule;

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
