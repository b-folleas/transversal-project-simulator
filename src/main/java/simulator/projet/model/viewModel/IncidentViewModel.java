package simulator.projet.model.viewModel;

import simulator.projet.model.IncidentType;

import java.io.Serializable;

public class IncidentViewModel implements Serializable {

    private int posX;
    private int posY;
    private float intensity;
    private IncidentType incidentType;

    public IncidentViewModel() {

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

    public float getIntensity() {
        return intensity;
    }

    public void setIntensity(float intensity) {
        this.intensity = intensity;
    }

    public IncidentType getIncidentType() {
        return incidentType;
    }

    public void setIncidentType(IncidentType incidentType) {
        this.incidentType = incidentType;
    }

    public IncidentViewModel( int posX, int posY, float intensity, IncidentType incidentType) {
        this.posX = posX;
        this.posY = posY;
        this.intensity = intensity;
        this.incidentType = incidentType;
    }

    @Override
    public String toString() {
        return "IncidentViewModel{" +
                "posX=" + posX +
                ", posY=" + posY +
                ", intensity=" + intensity +
                ", incidentType=" + incidentType +
                '}';
    }
}
