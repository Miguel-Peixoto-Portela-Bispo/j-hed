package migke.jhed.attributes;

import migke.jhed.attributes.enums.network.CrossOrigin;
import migke.jhed.attributes.enums.script.ScriptLoading;
import migke.jhed.attributes.enums.script.ScriptType;
import migke.jhed.elements.types.TagType;

public class ScriptAttributes extends AttributesMap<TagType.Script> {

    @Override
    public <U> ScriptAttributes withAttr(String name, U value) {
        return (ScriptAttributes) super.withAttr(name, value);
    }

    public ScriptAttributes withSrc(String src) {
        return this.withAttr("src", src);
    }

    public ScriptAttributes withType(ScriptType type) {
        return this.withAttr("type", type.toString());
    }

    public ScriptAttributes withAsync(boolean async) {
        return this.withAttr("async", async);
    }

    public ScriptAttributes withDefer(boolean defer) {
        return this.withAttr("defer", defer);
    }

    public ScriptAttributes withCrossOrigin(CrossOrigin crossOrigin) {
        return this.withAttr("crossorigin", crossOrigin.toString());
    }

    public ScriptAttributes withIntegrity(String integrity) {
        return this.withAttr("integrity", integrity);
    }

    public ScriptAttributes withNonce(String nonce) { // For CSP
        return this.withAttr("nonce", nonce);
    }

    public ScriptAttributes withNomodule(boolean nomodule) { // For fallback for module scripts
        return this.withAttr("nomodule", nomodule);
    }

    public ScriptAttributes withReferrerpolicy(String policy) { // Can be enum
        return this.withAttr("referrerpolicy", policy);
    }

    public ScriptAttributes withLoading(ScriptLoading scriptLoading) {
        return this.withAttr(scriptLoading.toString(), true);
    }
}
