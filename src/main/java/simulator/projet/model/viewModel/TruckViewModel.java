package simulator.projet.model.viewModel;


import simulator.projet.model.Barrack;

import java.io.Serializable;

public class TruckViewModel implements Serializable {

    private int posX;
    private int posY;
    private int matricule;
    private boolean availability;
    private Barrack barrack;

    public TruckViewModel(int posX, int posY, int matricule, boolean availability, Barrack barrack) {
        this.posX = posX;
        this.posY = posY;
        this.matricule = matricule;
        this.availability = availability;
        this.barrack = barrack;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getMatricule() {
        return matricule;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public Barrack getBarrack() {
        return barrack;
    }

    public void setBarrack(Barrack barrack) {
        this.barrack = barrack;
    }
}

