package migke.jhed.attributes;

import migke.jhed.attributes.enums.input.*;
import migke.jhed.elements.types.TagType;
import migke.jhed.utils.TextUtilty;

public class InputAttributes extends AttributesMap<TagType.Input> {

    @Override
    public <U> InputAttributes withAttr(String name, U value) {
        return (InputAttributes) super.withAttr(name, value);
    }

    public InputAttributes withType(InputType type) {
        return this.withAttr("type", type.toString());
    }

    /**
     * Sets the 'accept' attribute for file inputs.
     * Can accept MIME types (e.g., "image/png"), generic types (e.g., "image/*"),
     * or file extensions (e.g., ".pdf").
     *
     * @param acceptTypes An array of strings representing accepted file types.
     * @return This InputAttributes instance for chaining.
     */
    public InputAttributes withAccept(String... acceptTypes) {
        // MDN states it's a comma-separated list of unique file type specifiers.
        // Example: accept="image/png, image/jpeg, .pdf"
        return this.withAttr("accept", TextUtilty.join(acceptTypes));
    }

    /**
     * Sets the 'autocomplete' attribute.
     *
     * @param mode The autocomplete mode from the AutoCompleteMode enum.
     * @return This InputAttributes instance for chaining.
     */
    public InputAttributes withAutocomplete(AutoCompleteMode mode) {
        return this.withAttr("autocomplete", mode.toString());
    }

    /**
     * Sets the 'autofocus' attribute.
     *
     * @param autofocus If true, the element should automatically get focus.
     * @return This InputAttributes instance for chaining.
     */
    public InputAttributes withAutofocus(boolean autofocus) {
        return this.withAttr("autofocus", autofocus); // Assuming rendering handles boolean
    }

    /**
     * Sets the 'checked' attribute for checkbox/radio inputs.
     *
     * @param checked If true, the input is pre-selected.
     * @return This InputAttributes instance for chaining.
     */
    public InputAttributes withChecked(boolean checked) {
        return this.withAttr("checked", checked); // Assuming rendering handles boolean
    }

    /**
     * Sets the 'dirname' attribute, which sends the directionality of the element.
     *
     * @param dirname The name of the field that will contain the directionality.
     * @return This InputAttributes instance for chaining.
     */
    public InputAttributes withDirname(String dirname) {
        return this.withAttr("dirname", dirname);
    }

    /**
     * Sets the 'disabled' attribute.
     *
     * @param disabled If true, the input is disabled.
     * @return This InputAttributes instance for chaining.
     */
    public InputAttributes withDisabled(boolean disabled) {
        return this.withAttr("disabled", disabled); // Assuming rendering handles boolean
    }

    /**
     * Sets the 'form' attribute, associating the input with a form by its ID.
     *
     * @param formId The ID of the form element this input belongs to.
     * @return This InputAttributes instance for chaining.
     */
    public InputAttributes withForm(String formId) {
        return this.withAttr("form", formId);
    }

    /**
     * Sets the 'formaction' attribute, overriding the form's action for submit/image types.
     *
     * @param formaction The URL to submit the form data to.
     * @return This InputAttributes instance for chaining.
     */
    public InputAttributes withFormaction(String formaction) {
        return this.withAttr("formaction", formaction);
    }

    /**
     * Sets the 'formenctype' attribute, overriding the form's enctype for submit/image types.
     *
     * @param enctype The encoding type to use for form submission.
     * @return This InputAttributes instance for chaining.
     */
    public InputAttributes withFormenctype(FormEnctype enctype) {
        return this.withAttr("formenctype", enctype.toString());
    }

    /**
     * Sets the 'formmethod' attribute, overriding the form's method for submit/image types.
     *
     * @param method The HTTP method to use for form submission.
     * @return This InputAttributes instance for chaining.
     */
    public InputAttributes withFormmethod(FormMethod method) {
        return this.withAttr("formmethod", method.toString());
    }

    /**
     * Sets the 'formnovalidate' attribute, overriding the form's novalidate for submit/image types.
     *
     * @param formnovalidate If true, the form data is not validated.
     * @return This InputAttributes instance for chaining.
     */
    public InputAttributes withFormnovalidate(boolean formnovalidate) {
        return this.withAttr("formnovalidate", formnovalidate); // Assuming rendering handles boolean
    }

    /**
     * Sets the 'formtarget' attribute, overriding the form's target for submit/image types.
     *
     * @param target The Browse context (e.g., "_blank", "_self") for form submission.
     * @return This InputAttributes instance for chaining.
     */
    public InputAttributes withFormtarget(FormTarget target) {
        return this.withAttr("formtarget", target.toString());
    }

    /**
     * Sets the 'height' attribute for image inputs.
     *
     * @param height The height of the image in pixels.
     * @return This InputAttributes instance for chaining.
     */
    public InputAttributes withHeight(int height) {
        return this.withAttr("height", height);
    }

    /**
     * Sets the 'list' attribute, associating the input with a datalist by its ID.
     *
     * @param datalistId The ID of the `<datalist>` element that provides autocomplete options.
     * @return This InputAttributes instance for chaining.
     */
    public InputAttributes withList(String datalistId) {
        return this.withAttr("list", datalistId);
    }

    /**
     * Sets the 'max' attribute for numeric/date/time inputs.
     *
     * @param max The maximum allowed value (can be a number, date, or time string).
     * @return This InputAttributes instance for chaining.
     */
    public InputAttributes withMax(String max) { // For numbers, dates, or times
        return this.withAttr("max", max);
    }

    /**
     * Sets the 'maxlength' attribute for text-based inputs.
     *
     * @param maxlength The maximum number of characters allowed.
     * @return This InputAttributes instance for chaining.
     */
    public InputAttributes withMaxlength(int maxlength) {
        return this.withAttr("maxlength", maxlength);
    }

    /**
     * Sets the 'min' attribute for numeric/date/time inputs.
     *
     * @param min The minimum allowed value (can be a number, date, or time string).
     * @return This InputAttributes instance for chaining.
     */
    public InputAttributes withMin(String min) { // For numbers, dates, or times
        return this.withAttr("min", min);
    }

    /**
     * Sets the 'minlength' attribute for text-based inputs.
     *
     * @param minlength The minimum number of characters required.
     * @return This InputAttributes instance for chaining.
     */
    public InputAttributes withMinlength(int minlength) {
        return this.withAttr("minlength", minlength);
    }

    /**
     * Sets the 'multiple' attribute for file/email inputs.
     *
     * @param multiple If true, allows the user to select multiple files/email addresses.
     * @return This InputAttributes instance for chaining.
     */
    public InputAttributes withMultiple(boolean multiple) {
        return this.withAttr("multiple", multiple); // Assuming rendering handles boolean
    }

    /**
     * Sets the 'name' attribute.
     *
     * @param name The name of the input, used when submitting form data.
     * @return This InputAttributes instance for chaining.
     */
    public InputAttributes withName(String name) {
        return this.withAttr("name", name);
    }

    /**
     * Sets the 'pattern' attribute for text-based inputs.
     *
     * @param pattern A regular expression that the input's value must match.
     * @return This InputAttributes instance for chaining.
     */
    public InputAttributes withPattern(String pattern) {
        return this.withAttr("pattern", pattern);
    }

    /**
     * Sets the 'placeholder' attribute for text-based inputs.
     *
     * @param placeholder A short hint describing the expected value of the input field.
     * @return This InputAttributes instance for chaining.
     */
    public InputAttributes withPlaceholder(String placeholder) {
        return this.withAttr("placeholder", placeholder);
    }

    /**
     * Sets the 'readonly' attribute.
     *
     * @param readonly If true, the input is read-only.
     * @return This InputAttributes instance for chaining.
     */
    public InputAttributes withReadonly(boolean readonly) {
        return this.withAttr("readonly", readonly); // Assuming rendering handles boolean
    }

    /**
     * Sets the 'required' attribute.
     *
     * @param required If true, the input must be filled out before submitting.
     * @return This InputAttributes instance for chaining.
     */
    public InputAttributes withRequired(boolean required) {
        return this.withAttr("required", required); // Assuming rendering handles boolean
    }

    /**
     * Sets the 'size' attribute for text-based inputs.
     *
     * @param size The visible width of the input in characters.
     * @return This InputAttributes instance for chaining.
     */
    public InputAttributes withSize(int size) {
        return this.withAttr("size", size);
    }

    /**
     * Sets the 'src' attribute for image inputs.
     *
     * @param src The URL of the image to display for an image input.
     * @return This InputAttributes instance for chaining.
     */
    public InputAttributes withSrc(String src) { // For type="image"
        return this.withAttr("src", src);
    }

    /**
     * Sets the 'step' attribute for numeric/date/time inputs.
     *
     * @param step The step interval for valid values. Can be "any" or a number.
     * @return This InputAttributes instance for chaining.
     */
    public InputAttributes withStep(String step) {
        return this.withAttr("step", step);
    }

    /**
     * Sets the 'value' attribute.
     *
     * @param value The initial value of the input.
     * @return This InputAttributes instance for chaining.
     */
    public InputAttributes withValue(String value) {
        return this.withAttr("value", value);
    }

    /**
     * Sets the 'width' attribute for image inputs.
     *
     * @param width The width of the image in pixels.
     * @return This InputAttributes instance for chaining.
     */
    public InputAttributes withWidth(int width) {
        return this.withAttr("width", width);
    }
}
