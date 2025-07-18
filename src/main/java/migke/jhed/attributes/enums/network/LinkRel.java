package migke.jhed.attributes.enums.network;

public enum LinkRel {
    ALTERNATE("alternate"),
    AUTHOR("author"),
    CANONICAL("canonical"),
    DNS_PREFETCH("dns-prefetch"),
    ICON("icon"),
    LICENSE("license"),
    MANIFEST("manifest"),
    MODULEPRELOAD("modulepreload"),
    NOFOLLOW("nofollow"),
    NOOPENER("noopener"),
    NOREFERRER("noreferrer"),
    PRECONNECT("preconnect"),
    PREFETCH("prefetch"),
    PRELOAD("preload"),
    PRERENDER("prerender"), // Often discouraged
    SEARCH("search"),
    STYLESHEET("stylesheet"),
    TAG("tag");

    private final String value;

    LinkRel(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}