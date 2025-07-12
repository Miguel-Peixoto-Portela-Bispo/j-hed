package migke.jed;

public class ClosedTag<T extends TagType> {
    public final T type;
    public final Attributes<T> attributes;

    public ClosedTag(T type, Attributes<T> attributes) {
        this.attributes = attributes;
        this.type = type;
    }

    public String render() {
        return "<" + type.getName() + attributes.toString() + ">";
    }
}
