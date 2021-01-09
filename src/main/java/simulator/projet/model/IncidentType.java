package simulator.projet.model;

import java.io.Serializable;

public enum IncidentType implements Serializable {
    FLOOD("FLOOD"),
    FIRE("FIRE"),
    ACCIDENT("ACCIDENT"),
    TORNADO("TORNADO");

    private final String text;

    IncidentType(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
