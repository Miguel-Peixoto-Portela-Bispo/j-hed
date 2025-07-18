package migke.jhed.attributes.enums.media;

public enum LoadingMode {
    EAGER("eager"),
    LAZY("lazy");

    private final String value;

    LoadingMode(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}