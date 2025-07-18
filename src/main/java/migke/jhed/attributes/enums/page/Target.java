package migke.jhed.attributes.enums.page;

public enum Target {
    SELF("_self"),
    BLANK("_blank"),
    PARENT("_parent"),
    TOP("_top");

    private final String value;

    Target(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}