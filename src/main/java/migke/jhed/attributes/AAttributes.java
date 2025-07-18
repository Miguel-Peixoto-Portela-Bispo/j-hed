package migke.jhed.attributes;

import migke.jhed.attributes.enums.page.Target;
import migke.jhed.attributes.enums.network.LinkRel;
import migke.jhed.elements.types.TagType;

import java.util.Arrays;
import java.util.stream.Collectors;

public class AAttributes extends AttributesMap<TagType.A> {

    public AAttributes() {
        super();
    }

    @Override
    public <U> AAttributes withAttr(String name, U value) {
        return (AAttributes) super.withAttr(name, value);
    }

    public AAttributes withHref(String href) {
        return this.withAttr("href", href);
    }

    public AAttributes withTarget(Target target) {
        return this.withAttr("target", target.toString());
    }

    /**
     * Sets the 'download' attribute, suggesting a filename for download.
     * If true, it just sets the attribute. If a filename is provided, it uses that.
     */
    public AAttributes withDownload() {
        return this.withAttr("download", true);
    }

    public AAttributes withDownload(String filename) {
        return this.withAttr("download", filename);
    }

    /**
     * Sets the 'ping' attribute for multiple URLs to ping on click.
     *
     * @param urls An array of URLs to ping.
     * @return This AAttributes instance for chaining.
     */
    public AAttributes withPing(String... urls) {
        return this.withAttr("ping", String.join(" ", urls));
    }

    public AAttributes withRel(LinkRel... rels) {
        return this.withAttr("rel", Arrays.stream(rels)
                .map(LinkRel::toString)
                .collect(Collectors.joining(" ")));
    }

    public AAttributes withHreflang(String hreflang) {
        return this.withAttr("hreflang", hreflang);
    }

    public AAttributes withType(String mediaType) {
        return this.withAttr("type", mediaType);
    }

    public AAttributes withReferrerpolicy(String policy) { // Can be enum if you want to define all values
        return this.withAttr("referrerpolicy", policy);
    }
}