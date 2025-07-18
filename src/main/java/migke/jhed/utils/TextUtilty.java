package migke.jhed.utils;

import java.util.regex.Pattern;
import java.util.stream.Stream;

public class TextUtilty {
    public static String escape(String str) {
        var pattern = Pattern.compile("[\"&'<>]");
        var matcher = pattern.matcher(str);
        return matcher.replaceAll((res) -> {
            var matched = res.group();
            return switch (matched) {
                case "\"" -> "&quot;";
                case "&" -> "&amp;";
                case "'" -> "&#x27;";
                case "<" -> "&lt;";
                case ">" -> "&gt;";
                default -> matched;
            };
        });
    }

    public static String join(String... strings) {
        return Stream.of(strings).reduce("", (acc, cur) -> new StringBuilder().append(acc).append(cur).toString());
    }
}
