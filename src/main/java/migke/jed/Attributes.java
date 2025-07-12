package migke.jed;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Attributes<T extends TagType> {
    protected final Map<String, Attribute> map = new HashMap<>();

    public Attributes<T> withAttr(String name, Object value) {
        this.map.put(name, new Attribute(name, value));
        return this;
    }

    public Attribute getAttr(String name) {
        return this.map.get(name);
    }

    boolean isPotentiallyDangerousURL(String str) {
        return ((str.contains(":") || str.contains("&#58;")) && Pattern.compile("^(http|https)://").matcher(str).find());
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
                        .append(canBeDangerous ? "" : attr.value())
                        .append("'");
            }
        }
        return builder.toString();
    }

    public static class InputAttributes extends Attributes<TagType.Input> {
        public InputAttributes withType(String value) {
            var name = "type";
            this.map.put(name, new Attribute(name, value));
            return this;
        }
    }
}