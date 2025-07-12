package migke.jed.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextEscaper {
    private static Map<String, String> map = Map.ofEntries(
        Map.entry("\"", "&quot;"),
        Map.entry("&", "&amp;"),
        Map.entry("'", "&#x27;"),
        Map.entry("<", "&lt;"),
        Map.entry(">", "&gt;")
    );
    public static String escape(String str) {
        var pattern = Pattern.compile("[\"&'<>]");
        var matcher = pattern.matcher(str);
        return matcher.replaceAll((res) -> map.get(res.group()));
    }
}
