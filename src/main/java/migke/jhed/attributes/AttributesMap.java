package migke.jhed.attributes;

import migke.jhed.elements.types.TagType;
import migke.jhed.utils.TextUtilty;
import migke.jhed.attributes.enums.Dir;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class AttributesMap<T extends TagType> {
    protected final Map<String, Attribute<?>> map = new HashMap<>();

    public <U> AttributesMap<T> withAttr(String name, U value) {
        this.map.put(name, new Attribute<>(name, value));
        return this;
    }

    public <U> AttributesMap<T> withAttrs(AttributesMap<T> attributesMap) {
        this.map.putAll(attributesMap.map);
        return this;
    }

    public AttributesMap<T> withClass(String... classNames) {
        return this.withAttr("class", TextUtilty.join(classNames));
    }

    public AttributesMap<T> withId(String id) {
        return this.withAttr("id", id);
    }

    public AttributesMap<T> withStyle(String style) {
        return this.withAttr("style", style);
    }

    public AttributesMap<T> withTitle(String title) {
        return this.withAttr("title", title);
    }

    public AttributesMap<T> withLang(String lang) {
        return this.withAttr("lang", lang);
    }

    public AttributesMap<T> withDir(Dir dir) {
        return this.withAttr("dir", dir.toString());
    }

    public AttributesMap<T> withTabindex(int tabindex) {
        return this.withAttr("tabindex", tabindex);
    }

    public AttributesMap<T> withAccesskey(String accesskey) {
        return this.withAttr("accesskey", accesskey);
    }

    public AttributesMap<T> withContenteditable(boolean contenteditable) {
        return this.withAttr("contenteditable", contenteditable);
    }

    public AttributesMap<T> withSpellcheck(boolean spellcheck) {
        return this.withAttr("spellcheck", spellcheck);
    }

    public Attribute<?> getAttr(String name) {
        return this.map.get(name);
    }
    boolean isPotentiallyDangerousURL(String str) {
        return ((str.contains(":") || str.contains("&#58;")) && Pattern.compile("^(http|https)://").matcher(str).find());
    }

    public boolean hasAttr(String name) {
        return this.map.containsKey(name);
    }

    @Override
    public String toString() {
        var builder = new StringBuilder();

        for (var attr : this.map.values()) {
            var canBeDangerous = attr.value() instanceof String
                    && attr.name().equals("href")
                    && isPotentiallyDangerousURL(attr.value().toString());

            builder.append(" ").append(attr.name());
            if (!(attr.value() instanceof Boolean)) {
                builder
                        .append("='")
                        .append(canBeDangerous ? "" : attr.value().toString())
                        .append("'");
            }
        }
        return builder.toString();
    }
}