package migke.jhed.attributes;

import migke.jhed.attributes.enums.media.Preload;
import migke.jhed.attributes.enums.network.CrossOrigin;
import migke.jhed.elements.types.TagType;

public class VideoAttributes extends AttributesMap<TagType.Video> {
    public <U> VideoAttributes withAttr(String name, U value) {
        return (VideoAttributes) super.withAttr(name, value);
    }

    public VideoAttributes withSrc(String src) {
        return this.withAttr("src", src);
    }

    public VideoAttributes withAutoplay(boolean autoplay) {
        return this.withAttr("autoplay", autoplay);
    }

    public VideoAttributes withControls(boolean controls) {
        return this.withAttr("controls", controls);
    }

    public VideoAttributes withLoop(boolean loop) {
        return this.withAttr("loop", loop);
    }

    public VideoAttributes withMuted(boolean muted) {
        return this.withAttr("muted", muted);
    }

    public VideoAttributes withPreload(Preload preload) {
        return this.withAttr("preload", preload.toString());
    }

    public VideoAttributes withPoster(String posterUrl) {
        return this.withAttr("poster", posterUrl);
    }

    public VideoAttributes withWidth(int width) {
        return this.withAttr("width", width);
    }

    public VideoAttributes withHeight(int height) {
        return this.withAttr("height", height);
    }

    public VideoAttributes withCrossOrigin(CrossOrigin crossOrigin) {
        return this.withAttr("crossorigin", crossOrigin.toString());
    }
}
