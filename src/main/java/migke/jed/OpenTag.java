package migke.jed;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OpenTag<T extends TagType> extends ClosedTag<T> {
    public final Object[] children;

    public OpenTag(T type, Attributes<T> attributes, Object[] children) {
        super(type, attributes);
        this.children = children;
    }

    @Override
    public String render() {
        var childrenText = Stream.of(this.children).map((obj) -> switch (obj) {
            case ClosedTag c -> c.render();
            default -> obj.toString();
        }).collect(Collectors.joining(" "));
        return super.render() + childrenText + "</" + type.getName() + ">";
    }
}
