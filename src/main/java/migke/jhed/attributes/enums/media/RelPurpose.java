package migke.jhed.attributes.enums.media;

public enum RelPurpose {
    AUDIO("audio"),
    DOCUMENT("document"),
    EMBED("embed"),
    FETCH("fetch"),
    FONT("font"),
    IMAGE("image"),
    OBJECT("object"),
    SCRIPT("script"),
    STYLE("style"),
    TRACK("track"),
    WORKER("worker"),
    VIDEO("video");

    private final String value;

    RelPurpose(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}