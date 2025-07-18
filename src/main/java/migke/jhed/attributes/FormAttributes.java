package migke.jhed.attributes;

import migke.jhed.attributes.enums.input.AutoCompleteMode;
import migke.jhed.attributes.enums.input.FormEnctype;
import migke.jhed.attributes.enums.input.FormMethod;
import migke.jhed.attributes.enums.input.FormTarget;
import migke.jhed.attributes.enums.network.LinkRel;
import migke.jhed.elements.types.TagType;

import java.util.Arrays;
import java.util.stream.Collectors;

public class FormAttributes extends AttributesMap<TagType.Form> {

    @Override
    public <U> FormAttributes withAttr(String name, U value) {
        return (FormAttributes) super.withAttr(name, value);
    }

    public FormAttributes withAction(String action) {
        return this.withAttr("action", action);
    }

    public FormAttributes withMethod(FormMethod method) {
        return this.withAttr("method", method.toString());
    }

    public FormAttributes withEnctype(FormEnctype enctype) {
        return this.withAttr("enctype", enctype.toString());
    }

    public FormAttributes withName(String name) {
        return this.withAttr("name", name);
    }

    public FormAttributes withNovalidate(boolean novalidate) {
        return this.withAttr("novalidate", novalidate);
    }

    public FormAttributes withTarget(FormTarget target) {
        return this.withAttr("target", target.toString());
    }

    public FormAttributes withAutocomplete(AutoCompleteMode mode) { // Form's autocomplete
        return this.withAttr("autocomplete", mode.toString());
    }

    public FormAttributes withRel(LinkRel... rels) { // Added in HTML5.2
        return this.withAttr("rel", Arrays.stream(rels)
                .map(LinkRel::toString)
                .collect(Collectors.joining(" ")));
    }
}
