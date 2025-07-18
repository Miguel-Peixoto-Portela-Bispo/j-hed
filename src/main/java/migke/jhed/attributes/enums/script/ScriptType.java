package migke.jhed.attributes.enums.script;

public enum ScriptType {
    JAVASCRIPT("text/javascript"), // Legacy, but common
    MODULE("module"), // ES Modules
    // Add other types as needed
    JSON("application/json"); // For <script type="application/json"> with JSON data

    private final String value;

    ScriptType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}