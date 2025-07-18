package migke.jhed.attributes.enums.input;

public enum FormEnctype {
    APPLICATION_X_WWW_FORM_URLENCODED("application/x-www-form-urlencoded"),
    MULTIPART_FORM_DATA("multipart/form-data"),
    TEXT_PLAIN("text/plain");

    private final String value;

    FormEnctype(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}