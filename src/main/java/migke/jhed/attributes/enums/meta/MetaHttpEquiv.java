package migke.jhed.attributes.enums.meta;

public enum MetaHttpEquiv {
    CONTENT_SECURITY_POLICY("Content-Security-Policy"), // For CSP headers
    CONTENT_TYPE("Content-Type"), // Less common with <meta charset="...">
    DEFAULT_STYLE("Default-Style"),
    REFRESH("refresh"), // For page refresh/redirects
    X_UA_COMPATIBLE("X-UA-Compatible"), // IE compatibility mode
    CACHE_CONTROL("Cache-Control"), // HTTP caching directives
    EXPIRES("Expires"), // HTTP caching directives (deprecated in favor of Cache-Control)
    PRAGMA("Pragma"), // HTTP caching directives (deprecated in favor of Cache-Control)
    SET_COOKIE("Set-Cookie"); // Not recommended for use with <meta http-equiv>

    private final String value;

    MetaHttpEquiv(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}