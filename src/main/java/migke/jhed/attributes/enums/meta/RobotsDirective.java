package migke.jhed.attributes.enums.meta;

public enum RobotsDirective {
    ALL("all"),
    NOINDEX("noindex"),
    NOFOLLOW("nofollow"),
    NONE("none"),
    ARCHIVE("archive"),
    NOARCHIVE("noarchive"),
    NOSNIPPET("nosnippet"),
    MAX_SNIPPET("max-snippet"), // With content="[number]"
    MAX_IMAGE_PREVIEW("max-image-preview"), // With content="none", "standard", "large"
    MAX_VIDEO_PREVIEW("max-video-preview"), // With content="[number]"
    NOODP("noodp"), // Deprecated, but some might still use
    NOYDIR("noydir"), // Deprecated, but some might still use
    UNAVAILABLE_AFTER("unavailable_after"); // With content="[RFC 850 date/time]"

    private final String value;

    RobotsDirective(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
