package simulator.projet.model;

public class IncidentToIncreaseModel {

    private Long idIncident;
    private int nbHorloge;
    private int intensity;

    public IncidentToIncreaseModel() {
    }

    public IncidentToIncreaseModel(Long idIncident, int intensity) {
        this.idIncident = idIncident;
        this.nbHorloge = 0;
        this.intensity = intensity;
    }

    public Long getIdIncident() {
        return idIncident;
    }

    public void setIdIncident(Long idIncident) {
        this.idIncident = idIncident;
    }

    public int getNbHorloge() {
        return nbHorloge;
    }

    public void setNbHorloge(int nbHorloge) {
        this.nbHorloge = nbHorloge;
    }

    public int getIntensity() {
        return intensity;
    }

    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }

    public void incrementNext() {
        this.nbHorloge++;
    }

    public boolean incrementIntencity() {
        this.nbHorloge = 0;
        if (this.intensity < 10) {
            this.intensity++;
            return true;
        } else {
            return false;
        }
    }
}
