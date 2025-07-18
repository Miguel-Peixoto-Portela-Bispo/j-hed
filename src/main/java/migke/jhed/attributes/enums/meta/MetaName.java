package migke.jhed.attributes.enums.meta;

public enum MetaName {
    APPLICATION_NAME("application-name"),
    AUTHOR("author"),
    COLOR_SCHEME("color-scheme"), // e.g., "light dark"
    DESCRIPTION("description"),
    GENERATOR("generator"),
    KEYWORDS("keywords"), // Less relevant for modern SEO, but still exists
    REFERRER("referrer"), // Referrer Policy
    ROBOTS("robots"), // e.g., "noindex, nofollow"
    THEME_COLOR("theme-color"),
    VIEWPORT("viewport"), // Essential for responsive design
    // Commonly used but not officially standard (you can add more as needed)
    OG_TITLE("og:title"), // Open Graph
    OG_DESCRIPTION("og:description"), // Open Graph
    OG_IMAGE("og:image"), // Open Graph
    OG_URL("og:url"), // Open Graph
    TWITTER_CARD("twitter:card"), // Twitter Cards
    TWITTER_SITE("twitter:site"), // Twitter Cards
    TWITTER_CREATOR("twitter:creator"), // Twitter Cards
    TWITTER_TITLE("twitter:title"), // Twitter Cards
    TWITTER_DESCRIPTION("twitter:description"), // Twitter Cards
    TWITTER_IMAGE("twitter:image"), // Twitter Cards
    // For specific directives to Google bot (often overlaps with 'robots')
    GOOGLE("google"), // e.g., "notranslate"
    GOOGLEBOT("googlebot"),
    // Add more as needed for specific frameworks/tools (e.g., Apple web app meta tags)
    APPLE_MOBILE_WEB_APP_CAPABLE("apple-mobile-web-app-capable"),
    APPLE_MOBILE_WEB_APP_STATUS_BAR_STYLE("apple-mobile-web-app-status-bar-style"),
    FORMAT_DETECTION("format-detection"); // e.g., "telephone=no"


    private final String value;

    MetaName(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
