package migke.jhed.attributes;

import migke.jhed.attributes.enums.meta.MetaHttpEquiv;
import migke.jhed.attributes.enums.meta.MetaName;
import migke.jhed.attributes.enums.meta.ReferrerPolicy;
import migke.jhed.attributes.enums.meta.RobotsDirective;
import migke.jhed.elements.types.TagType;

public class MetaAttributes extends AttributesMap<TagType.Meta> {

    @Override
    public <U> MetaAttributes withAttr(String name, U value) {
        // Enforce mutual exclusivity for 'charset', 'name', 'http-equiv'
        if (name.equals("charset")) {
            if (this.hasAttr("name") || this.hasAttr("http-equiv")) {
                throw new IllegalStateException("<meta> tag cannot have 'charset' along with 'name' or 'http-equiv'.");
            }
        } else if (name.equals("name") || name.equals("http-equiv")) {
            if (this.hasAttr("charset") || (name.equals("name") && this.hasAttr("http-equiv")) || (name.equals("http-equiv") && this.hasAttr("name"))) {
                throw new IllegalStateException("<meta> tag can only have one of 'charset', 'name', or 'http-equiv'.");
            }
        }
        return (MetaAttributes) super.withAttr(name, value);
    }

    /**
     * Sets the 'charset' attribute for character encoding declaration.
     * This is typically "UTF-8".
     * Cannot be used with `withName()` or `withHttpEquiv()`.
     */
    public MetaAttributes withCharset(String charset) {
        // The spec technically only allows "UTF-8" for HTML, but for flexibility...
        return this.withAttr("charset", charset);
    }

    /**
     * Sets the 'name' attribute for document-level metadata.
     * The `content` attribute must also be set.
     * Cannot be used with `withCharset()` or `withHttpEquiv()`.
     *
     * @param name The type of metadata.
     * @return This MetaAttributes instance for chaining.
     */
    public MetaAttributes withName(MetaName name) {
        return this.withAttr("name", name.toString());
    }

    /**
     * Sets a custom 'name' attribute for metadata.
     * Useful for Open Graph (`og:title`), Twitter Cards (`twitter:card`), etc.,
     * which use non-standard but widely adopted names.
     * The `content` attribute must also be set.
     * Cannot be used with `withCharset()` or `withHttpEquiv()`.
     *
     * @param customName The custom name (e.g., "og:title").
     * @return This MetaAttributes instance for chaining.
     */
    public MetaAttributes withCustomName(String customName) {
        if (customName == null || customName.trim().isEmpty()) {
            throw new IllegalArgumentException("Custom name cannot be null or empty.");
        }
        return this.withAttr("name", customName);
    }


    /**
     * Sets the 'http-equiv' attribute for pragma directives.
     * The `content` attribute must also be set.
     * Cannot be used with `withCharset()` or `withName()`.
     *
     * @param httpEquiv The HTTP equivalent directive.
     * @return This MetaAttributes instance for chaining.
     */
    public MetaAttributes withHttpEquiv(MetaHttpEquiv httpEquiv) {
        return this.withAttr("http-equiv", httpEquiv.toString());
    }

    /**
     * Sets a custom 'http-equiv' attribute.
     * The `content` attribute must also be set.
     * Cannot be used with `withCharset()` or `withName()`.
     *
     * @param customHttpEquiv The custom http-equiv value.
     * @return This MetaAttributes instance for chaining.
     */
    public MetaAttributes withCustomHttpEquiv(String customHttpEquiv) {
        if (customHttpEquiv == null || customHttpEquiv.trim().isEmpty()) {
            throw new IllegalArgumentException("Custom http-equiv cannot be null or empty.");
        }
        return this.withAttr("http-equiv", customHttpEquiv);
    }

    /**
     * Sets the 'content' attribute, which provides the value for 'name' or 'http-equiv'.
     * This method should almost always be called after `withName()` or `withHttpEquiv()`.
     *
     * @param content The content value for the metadata or directive.
     * @return This MetaAttributes instance for chaining.
     */
    public MetaAttributes withContent(String content) {
        return this.withAttr("content", content);
    }

    /**
     * Specifically for `name="robots"` or `name="googlebot"`.
     *
     * @param directives A list of RobotsDirective enums.
     * @param parameters Optional parameters for directives like MAX_SNIPPET, e.g., "50", "none".
     * The order must match the directives.
     * If a directive doesn't need a parameter, pass null or empty string.
     * Example: `withRobots(new RobotsDirective[]{RobotsDirective.NOINDEX, RobotsDirective.MAX_SNIPPET}, null, "150")`
     * This method is for `name="robots"` or `name="googlebot"`.
     * @return This MetaAttributes instance for chaining.
     */
    public MetaAttributes withRobots(RobotsDirective[] directives, String... parameters) {
        if (directives == null || directives.length == 0) {
            return this.withAttr("name", MetaName.ROBOTS.toString()).withContent("none");
        }

        if (parameters != null && directives.length != parameters.length) {
            // This could be made more lenient if desired, but strict for now
            throw new IllegalArgumentException("Number of robots directives must match number of parameters.");
        }

        StringBuilder contentBuilder = new StringBuilder();
        for (int i = 0; i < directives.length; i++) {
            if (i > 0) {
                contentBuilder.append(", ");
            }
            contentBuilder.append(directives[i].toString());
            if (parameters != null && parameters[i] != null && !parameters[i].trim().isEmpty()) {
                contentBuilder.append(":").append(parameters[i].trim());
            }
        }
        return this.withAttr("name", MetaName.ROBOTS.toString()).withContent(contentBuilder.toString());
    }

    /**
     * Specifically for `name="referrer"`.
     *
     * @param policy The referrer policy.
     * @return This MetaAttributes instance for chaining.
     */
    public MetaAttributes withReferrerPolicy(ReferrerPolicy policy) {
        return this.withAttr("name", MetaName.REFERRER.toString()).withContent(policy.toString());
    }

    /**
     * For `http-equiv="refresh"` for timed redirects or page reloads.
     *
     * @param seconds The time in seconds before refresh/redirect.
     * @param url     Optional URL to redirect to. If null, page reloads.
     * @return This MetaAttributes instance for chaining.
     */
    public MetaAttributes withRefresh(int seconds, String url) {
        if (seconds < 0) {
            throw new IllegalArgumentException("Refresh seconds must be non-negative.");
        }
        String content = String.valueOf(seconds);
        if (url != null && !url.trim().isEmpty()) {
            content += ";url=" + url;
        }
        return this.withAttr("http-equiv", MetaHttpEquiv.REFRESH.toString()).withContent(content);
    }

    /**
     * For `name="viewport"`.
     *
     * @param width          e.g., "device-width", a pixel value.
     * @param initialScale   e.g., 1.0.
     * @param userScalable   Whether user can zoom (true/false).
     * @param minimumScale   Optional minimum zoom level.
     * @param maximumScale   Optional maximum zoom level.
     * @return This MetaAttributes instance for chaining.
     */
    public MetaAttributes withViewport(String width, Double initialScale, Boolean userScalable, Double minimumScale, Double maximumScale) {
        StringBuilder contentBuilder = new StringBuilder();
        if (width != null && !width.trim().isEmpty()) {
            contentBuilder.append("width=").append(width.trim());
        }
        if (initialScale != null) {
            if (!contentBuilder.isEmpty()) contentBuilder.append(", ");
            contentBuilder.append("initial-scale=").append(initialScale);
        }
        if (userScalable != null) {
            if (!contentBuilder.isEmpty()) contentBuilder.append(", ");
            contentBuilder.append("user-scalable=").append(userScalable ? "yes" : "no");
        }
        if (minimumScale != null) {
            if (!contentBuilder.isEmpty()) contentBuilder.append(", ");
            contentBuilder.append("minimum-scale=").append(minimumScale);
        }
        if (maximumScale != null) {
            if (!contentBuilder.isEmpty()) contentBuilder.append(", ");
            contentBuilder.append("maximum-scale=").append(maximumScale);
        }

        if (contentBuilder.isEmpty()) {
            throw new IllegalArgumentException("At least one viewport parameter (width or initialScale) must be provided.");
        }

        return this.withAttr("name", MetaName.VIEWPORT.toString()).withContent(contentBuilder.toString());
    }

    /**
     * Convenience method for a common responsive viewport setting.
     */
    public MetaAttributes withResponsiveViewport() {
        return withViewport("device-width", 1.0, false, null, null);
    }
}
