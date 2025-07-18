package migke.jhed.attributes.enums.network;

public enum CrossOrigin {
    ANONYMOUS("anonymous"),
    USE_CREDENTIALS("use-credentials");

    private final String value;

    CrossOrigin(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}