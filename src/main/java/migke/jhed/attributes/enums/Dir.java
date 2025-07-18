package migke.jhed.attributes.enums;

public enum Dir {
    LTR("ltr"), // Left-to-right
    RTL("rtl"), // Right-to-left
    AUTO("auto"); // Let the browser decide

    private final String value;

    Dir(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}