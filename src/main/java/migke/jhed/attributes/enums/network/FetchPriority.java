package migke.jhed.attributes.enums.network;

public enum FetchPriority {
    HIGH("high"),
    LOW("low"),
    AUTO("auto");

    private final String value;

    FetchPriority(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}