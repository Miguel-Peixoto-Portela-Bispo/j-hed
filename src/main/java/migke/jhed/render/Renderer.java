package migke.jhed.render;

import migke.jhed.HtmlBuilder;
import migke.jhed.elements.FullElement;
import migke.jhed.elements.RawText;
import migke.jhed.elements.VoidElement;
import migke.jhed.elements.types.TagType;
import migke.jhed.utils.TextUtilty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Renderer {
    private final List<Object> elements;

    public Renderer() {
        this.elements = new ArrayList<>();
    }

    public Renderer add(String string) {
        this.elements.add(string);
        return this;
    }
    public Renderer add(RawText rawText) {
        this.elements.add(rawText);
        return this;
    }
    public <T extends TagType, U extends FullElement<T>> Renderer add(U element) {
        this.elements.add(element);
        return this;
    }
    public <T extends TagType, U extends VoidElement<T>> Renderer add(U element) {
        this.elements.add(element);
        return this;
    }

    public String render(int... indexes) {
        var acc = "";
        for(var index : indexes)
            acc = TextUtilty.join(acc, this.renderOne(elements.get(index)));
        return acc;
    }
    public String render() {
        return Stream.of(elements.toArray()).reduce("", (acc, cur) -> TextUtilty.join(acc.toString(), renderOne(cur))).toString();
    }

    private String renderVoidElement(VoidElement<?> element) {
        return TextUtilty.join("<", element.type.getName(), element.attributes.toString(), ">");
    }

    private String renderFullElement(FullElement<?> element) {
        return TextUtilty.join(this.renderVoidElement(element), this.renderChildren(element), "</", element.type.getName(), ">");
    }

    private String renderChildren(FullElement<?> element) {
        return Stream.of(element.children).map(this::renderOne).collect(Collectors.joining());
    }
    private String renderOne(Object element) {
        return switch (element){
            case FullElement<?> e -> this.renderFullElement(e);
            case VoidElement<?> e -> this.renderVoidElement(e);
            case RawText e -> e.text();
            default -> TextUtilty.escape(element.toString());
        };
    }
}
