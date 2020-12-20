package simulator.projet.model;

public class Truck {

    private int id;
    private MapItem mapItem;
    private Barrack barrack;
    private boolean availability;
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
                ", matricule=" + matricule +
                '}';
    }
}
