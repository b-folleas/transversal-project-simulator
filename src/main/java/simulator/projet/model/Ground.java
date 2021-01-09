package simulator.projet.model;

import java.io.Serializable;

public enum Ground implements Serializable {
    ROAD("ROAD"),
    GARDEN("ROAD"),
    BUILDING("BUILDING"),
    WATER("WATER");

    private final String text;

    Ground(final String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return text;
    }
}

