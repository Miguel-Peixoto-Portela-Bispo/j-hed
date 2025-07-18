package migke.jhed;

import migke.jhed.attributes.*;
import migke.jhed.elements.types.TagType;
import migke.jhed.render.Renderer;

public class JHed {
    public static HtmlBuilder build() { return new HtmlBuilder(); }

    public static Renderer createRenderer() { return new Renderer(); }

    public static <T extends TagType> AttributesMap<T> attrs(Class<T> type) { return new AttributesMap<T>(); }

    public static InputAttributes inputAttrs() { return new InputAttributes(); }
    public static MetaAttributes metaAttrs() { return new MetaAttributes(); }
    public static AAttributes aAttrs() { return new AAttributes(); }
    public static FormAttributes formAttrs() { return new FormAttributes(); }
    public static AudioAttributes audioAttrs() { return new AudioAttributes(); }
    public static VideoAttributes videoAttrs() { return new VideoAttributes(); }
    public static ScriptAttributes scriptAttrs() { return new ScriptAttributes(); }
    public static LinkAttributes linkAttrs() { return new LinkAttributes(); }
    public static ImgAttributes imgAttrs() { return new ImgAttributes(); }
}
