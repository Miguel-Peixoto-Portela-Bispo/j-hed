package migke.jhed.attributes;

import migke.jhed.attributes.enums.media.LoadingMode;
import migke.jhed.attributes.enums.network.CrossOrigin;
import migke.jhed.attributes.enums.network.FetchPriority;
import migke.jhed.elements.types.TagType;

public class ImgAttributes extends AttributesMap<TagType.Img> {

    @Override
    public <U> ImgAttributes withAttr(String name, U value) {
        return (ImgAttributes) super.withAttr(name, value);
    }

    public ImgAttributes withSrc(String src) {
        return this.withAttr("src", src);
    }

    public ImgAttributes withAlt(String alt) {
        return this.withAttr("alt", alt);
    }

    public ImgAttributes withWidth(int width) {
        return this.withAttr("width", width);
    }

    public ImgAttributes withHeight(int height) {
        return this.withAttr("height", height);
    }

    /**
     * Sets the 'srcset' attribute for responsive images.
     * Expects a string like "image-480w.jpg 480w, image-800w.jpg 800w".
     * For more type-safety, you could create a helper class to build this string.
     */
    public ImgAttributes withSrcset(String srcset) {
        return this.withAttr("srcset", srcset);
    }

    /**
     * Sets the 'sizes' attribute for responsive images.
     * Expects a string like "(max-width: 600px) 480px, 800px".
     */
    public ImgAttributes withSizes(String sizes) {
        return this.withAttr("sizes", sizes);
    }

    public ImgAttributes withCrossOrigin(CrossOrigin crossOrigin) {
        return this.withAttr("crossorigin", crossOrigin.toString());
    }

    public ImgAttributes withIsmap(boolean ismap) {
        return this.withAttr("ismap", ismap);
    }

    public ImgAttributes withLoading(LoadingMode loading) {
        return this.withAttr("loading", loading.toString());
    }

    public ImgAttributes withDecoding(String decoding) { // "sync", "async", "auto" - can be an enum
        return this.withAttr("decoding", decoding);
    }

    public ImgAttributes withFetchpriority(FetchPriority priority) {
        return this.withAttr("fetchpriority", priority.toString());
    }
}