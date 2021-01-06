package simulator.projet.model;

public enum Ground {
    ROAD("ROAD"),
    GARDEN("ROAD"),
    BUILDING("BUILDING"),
    WATER("WATER");

    private final String text;

    public String getText() {
        return text;
    }

    Ground(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}

