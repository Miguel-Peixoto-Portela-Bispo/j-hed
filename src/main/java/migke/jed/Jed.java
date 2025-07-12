package migke.jed;

public class Jed {
    public static ElementsBuilder build = new ElementsBuilder();

    public static Attributes<TagType.Input> inputAttrs() {
        return new Attributes<>();
    }
}
