package migke.jhed.attributes.enums.script;

public enum ScriptLoading {
    ASYNC("async"), // Just the presence of the attribute
    DEFER("defer"); // Just the presence of the attribute

    private final String value;

    private ScriptLoading(String v) { this.value = v; }
    public String toString() {
        return value;
    }



}