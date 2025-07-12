package migke.jed;

import java.util.ArrayList;
import java.util.List;
import migke.jed.utils.Function;
import migke.jed.utils.TextEscaper;

public class ElementsBuilder {
    public List<Object> elements = new ArrayList<>();

    public String text(String text) {
        text = TextEscaper.escape(text);
        elements.add(text);
        return text;
    }

    public OpenTag<TagType.Div> div(Attributes<TagType.Div> attributes, Function<ElementsBuilder> body) {
        return tag(TagType.Div.instance, attributes, body);
    }
    public OpenTag<TagType.Div> div(Function<ElementsBuilder> body) {
        var attributes = new Attributes<TagType.Div>();
        return tag(TagType.Div.instance, attributes, body);
    }

    public ClosedTag<TagType.Input> input() {
        var attributes = new Attributes<TagType.Input>();
        return tag(TagType.Input.instance, attributes);
    }
    public ClosedTag<TagType.Input> input(Attributes<TagType.Input> attributes) {
        return tag(TagType.Input.instance, attributes);
    }

    public <T extends ClosedTag<TagType>> T tag(String name) {
        TagType type = () -> name;
        var attributes = new Attributes<>();
        T tag = (T) new ClosedTag<>(type, attributes);

        elements.add(tag);
        return tag;
    }

    public <T extends ClosedTag<TagType>> T tag(String name, Attributes<TagType> attributes) {
        TagType type = () -> name;
        T tag = (T) new ClosedTag<>(type, attributes);

        elements.add(tag);
        return tag;
    }

    public <T extends TagType, U extends ClosedTag<T>> U tag(T type) {
        var attributes = new Attributes<T>();
        var tag = (U) new ClosedTag<>(type, attributes);

        elements.add(tag);
        return tag;
    }

    public <T extends TagType> ClosedTag<T> tag(T type, Attributes<T> attributes) {
        var tag = new ClosedTag<>(type, attributes);

        elements.add(tag);
        return tag;
    }

    public <T extends TagType> OpenTag<T> tag(T type, Attributes<T> attributes, Function<ElementsBuilder> body) {
        var factory = this.execute(body);
        var tag = new OpenTag<>(type, attributes, factory.elements.toArray());

        elements.add(tag);
        return tag;
    }

    private ElementsBuilder execute(Function<ElementsBuilder> body) {
        var result = new ElementsBuilder();
        body.apply(result);
        return result;
    }
}