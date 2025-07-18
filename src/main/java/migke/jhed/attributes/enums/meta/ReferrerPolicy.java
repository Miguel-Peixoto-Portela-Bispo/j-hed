package migke.jhed.attributes.enums.meta;

public enum ReferrerPolicy {
    NO_REFERRER("no-referrer"),
    NO_REFERRER_WHEN_DOWNGRADE("no-referrer-when-downgrade"), // Default for modern browsers
    ORIGIN("origin"),
    ORIGIN_WHEN_CROSS_ORIGIN("origin-when-cross-origin"),
    SAME_ORIGIN("same-origin"),
    STRICT_ORIGIN("strict-origin"),
    STRICT_ORIGIN_WHEN_CROSS_ORIGIN("strict-origin-when-cross-origin"),
    UNSAFE_URL("unsafe-url");

    private final String value;

    ReferrerPolicy(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
