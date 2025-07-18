package migke.jhed.attributes;

import migke.jhed.attributes.enums.media.Preload;
import migke.jhed.attributes.enums.network.CrossOrigin;
import migke.jhed.elements.types.TagType;

public class AudioAttributes extends AttributesMap<TagType.Audio> {

    @Override
    public <U> AudioAttributes withAttr(String name, U value) {
        return (AudioAttributes) super.withAttr(name, value);
    }

    public AudioAttributes withSrc(String src) {
        return this.withAttr("src", src);
    }

    public AudioAttributes withAutoplay(boolean autoplay) {
        return this.withAttr("autoplay", autoplay);
    }

    public AudioAttributes withControls(boolean controls) {
        return this.withAttr("controls", controls);
    }

    public AudioAttributes withLoop(boolean loop) {
        return this.withAttr("loop", loop);
    }

    public AudioAttributes withMuted(boolean muted) {
        return this.withAttr("muted", muted);
    }

    public AudioAttributes withPreload(Preload preload) {
        return this.withAttr("preload", preload.toString());
    }

    public AudioAttributes withCrossOrigin(CrossOrigin crossOrigin) {
        return this.withAttr("crossorigin", crossOrigin.toString());
    }
}
