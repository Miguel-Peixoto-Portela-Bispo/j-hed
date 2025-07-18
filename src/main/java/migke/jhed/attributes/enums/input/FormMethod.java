package migke.jhed.attributes.enums.input;

public enum FormMethod {
    GET("get"),
    POST("post");

    private final String value;

    FormMethod(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
