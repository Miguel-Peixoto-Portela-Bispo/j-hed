package migke.jhed.attributes.enums.input;

public enum FormTarget {
    SELF("_self"),
    BLANK("_blank"),
    PARENT("_parent"),
    TOP("_top");

    private final String value;

    FormTarget(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}