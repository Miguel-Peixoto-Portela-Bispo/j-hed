package migke.jhed.elements;

import migke.jhed.attributes.AttributesMap;
import migke.jhed.elements.types.TagType;

public class FullElement<T extends TagType> extends VoidElement<T> {
    public final Object[] children;

    public FullElement(T type, AttributesMap<T> attributes, Object[] children) {
        super(type, attributes);
        this.children = children;
    }
}
