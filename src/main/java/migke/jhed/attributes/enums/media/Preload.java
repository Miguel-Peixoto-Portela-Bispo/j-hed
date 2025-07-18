package migke.jhed.attributes.enums.media;

public enum Preload {
    NONE("none"),
    METADATA("metadata"),
    AUTO("auto");

    private final String value;

    Preload(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
