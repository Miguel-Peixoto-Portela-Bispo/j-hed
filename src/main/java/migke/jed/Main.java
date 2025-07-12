package migke.jed;
import static migke.jed.Jed.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(
            build.div((build) -> {
                build.text("\n<name>: ");
                build.input(inputAttrs().withAttr("type", "text"));
                build.text("\n<age>: ");
                build.input(inputAttrs().withAttr("type", "number"));
                build.text("\n");
            }).render()
        );
    }
}