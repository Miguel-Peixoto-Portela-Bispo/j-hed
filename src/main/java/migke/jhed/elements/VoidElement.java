package migke.jhed.elements;

import migke.jhed.attributes.AttributesMap;
import migke.jhed.elements.types.TagType;

public class VoidElement<T extends TagType> {
    public final T type;
    public final AttributesMap<T> attributes;

    public VoidElement(T type, AttributesMap<T> attributes) {
        this.attributes = attributes;
        this.type = type;
    }

}
