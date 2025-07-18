package migke.jhed.attributes;

import migke.jhed.attributes.enums.media.RelPurpose;
import migke.jhed.attributes.enums.network.CrossOrigin;
import migke.jhed.attributes.enums.network.LinkRel;
import migke.jhed.elements.types.TagType;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LinkAttributes extends AttributesMap<TagType.Link> {

    @Override
    public <U> LinkAttributes withAttr(String name, U value) {
        return (LinkAttributes) super.withAttr(name, value);
    }

    public LinkAttributes withHref(String href) {
        return this.withAttr("href", href);
    }

    public LinkAttributes withRel(LinkRel... rels) {
        return this.withAttr("rel", Arrays.stream(rels)
                                        .map(LinkRel::toString)
                                        .collect(Collectors.joining(" ")));
    }

    public LinkAttributes withAs(RelPurpose as) {
        return this.withAttr("as", as.toString());
    }

    public LinkAttributes withType(String mediaType) {
        return this.withAttr("type", mediaType);
    }

    public LinkAttributes withCrossOrigin(CrossOrigin crossOrigin) {
        return this.withAttr("crossorigin", crossOrigin.toString());
    }

    public LinkAttributes withIntegrity(String integrity) {
        return this.withAttr("integrity", integrity);
    }

    public LinkAttributes withHreflang(String hreflang) {
        return this.withAttr("hreflang", hreflang);
    }

    public LinkAttributes withMedia(String mediaQuery) {
        return this.withAttr("media", mediaQuery);
    }

    public LinkAttributes withSizes(String sizes) { // For icon/apple-touch-icon rels
        return this.withAttr("sizes", sizes);
    }

    public LinkAttributes withTitle(String title) { // Can be used for alternate stylesheets
        return this.withAttr("title", title);
    }

    public LinkAttributes withDisabled(boolean disabled) { // For stylesheets
        return this.withAttr("disabled", disabled);
    }
}
