package migke.jhed;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

import migke.jhed.attributes.AttributesMap;
import migke.jhed.elements.RawText;
import migke.jhed.render.Renderer;
import migke.jhed.elements.VoidElement;
import migke.jhed.elements.FullElement;
import migke.jhed.elements.types.TagType;
import migke.jhed.utils.VoidFunction;
import migke.jhed.utils.TextUtilty;

public class HtmlBuilder {

    //*******************
    // variables
    //*******************
    private final List<Object> elements;
    private final Stack<HtmlBuilder> nestingStack;


    //*******************
    // constructor
    //*******************
    public HtmlBuilder() {
        this.nestingStack = new Stack<>();
        this.elements = new ArrayList<>();
        this.nestingStack.push(this);
    }

    //*******************
    // utils
    //*******************
    @SafeVarargs
    public final HtmlBuilder pipe(VoidFunction<HtmlBuilder>... transformations) {
        var clone = this.createCopy();
        Stream.of(transformations).forEach(transform -> transform.apply(clone));
        return clone;
    }

    //*******************
    // user specified element in text
    //*******************
    public RawText raw(String html) {
        var rawText = new RawText(html);

        this.elements.add(rawText);
        return rawText;
    }

    //*******************
    // text element
    //*******************

    public String textln(String text) {
        text = TextUtilty.join(text, "\n");
        this.nestingStack.peek().elements.add(text);
        return text;
    }
    public String text(String text) {
        this.nestingStack.peek().elements.add(text);
        return text;
    }


    //*******************
    // full elements
    //*******************
    public FullElement<TagType.Html> html() {
        return this.html(() -> {});
    }
    public FullElement<TagType.Html> html(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Html>();
        return this.html(attributes, body);
    }
    public FullElement<TagType.Html> html(AttributesMap<TagType.Html> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Html.instance, attributes, body);
    }

    public FullElement<TagType.Head> head() {
        return this.head(() -> {});
    }
    public FullElement<TagType.Head> head(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Head>();
        return this.head(attributes, body);
    }
    public FullElement<TagType.Head> head(AttributesMap<TagType.Head> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Head.instance, attributes, body);
    }

    public FullElement<TagType.Body> body() {
        return this.body(() -> {});
    }
    public FullElement<TagType.Body> body(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Body>();
        return this.body(attributes, body);
    }
    public FullElement<TagType.Body> body(AttributesMap<TagType.Body> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Body.instance, attributes, body);
    }

    public FullElement<TagType.Title> title() {
        return this.title(() -> {});
    }
    public FullElement<TagType.Title> title(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Title>();
        return this.title(attributes, body);
    }
    public FullElement<TagType.Title> title(AttributesMap<TagType.Title> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Title.instance, attributes, body);
    }

    // --- Sectioning Content ---
    public FullElement<TagType.Article> article() {
        return this.article(() -> {});
    }
    public FullElement<TagType.Article> article(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Article>();
        return this.article(attributes, body);
    }
    public FullElement<TagType.Article> article(AttributesMap<TagType.Article> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Article.instance, attributes, body);
    }

    public FullElement<TagType.Section> section() {
        return this.section(() -> {});
    }
    public FullElement<TagType.Section> section(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Section>();
        return this.section(attributes, body);
    }
    public FullElement<TagType.Section> section(AttributesMap<TagType.Section> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Section.instance, attributes, body);
    }

    public FullElement<TagType.Nav> nav() {
        return this.nav(() -> {});
    }
    public FullElement<TagType.Nav> nav(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Nav>();
        return this.nav(attributes, body);
    }
    public FullElement<TagType.Nav> nav(AttributesMap<TagType.Nav> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Nav.instance, attributes, body);
    }

    public FullElement<TagType.Aside> aside() {
        return this.aside(() -> {});
    }
    public FullElement<TagType.Aside> aside(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Aside>();
        return this.aside(attributes, body);
    }
    public FullElement<TagType.Aside> aside(AttributesMap<TagType.Aside> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Aside.instance, attributes, body);
    }

    public FullElement<TagType.Header> header() {
        return this.header(() -> {});
    }
    public FullElement<TagType.Header> header(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Header>();
        return this.header(attributes, body);
    }
    public FullElement<TagType.Header> header(AttributesMap<TagType.Header> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Header.instance, attributes, body);
    }

    public FullElement<TagType.Footer> footer() {
        return this.footer(() -> {});
    }
    public FullElement<TagType.Footer> footer(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Footer>();
        return this.footer(attributes, body);
    }
    public FullElement<TagType.Footer> footer(AttributesMap<TagType.Footer> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Footer.instance, attributes, body);
    }

    public FullElement<TagType.Main> main() {
        return this.main(() -> {});
    }
    public FullElement<TagType.Main> main(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Main>();
        return this.main(attributes, body);
    }
    public FullElement<TagType.Main> main(AttributesMap<TagType.Main> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Main.instance, attributes, body);
    }

    public FullElement<TagType.Address> address() {
        return this.address(() -> {});
    }
    public FullElement<TagType.Address> address(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Address>();
        return this.address(attributes, body);
    }
    public FullElement<TagType.Address> address(AttributesMap<TagType.Address> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Address.instance, attributes, body);
    }

    // --- Grouping Content ---
    public FullElement<TagType.P> p() {
        return this.p(() -> {});
    }
    public FullElement<TagType.P> p(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.P>();
        return this.p(attributes, body);
    }
    public FullElement<TagType.P> p(AttributesMap<TagType.P> attributes, VoidFunction.NoParams body) {
        return tag(TagType.P.instance, attributes, body);
    }

    public FullElement<TagType.Div> div() {
        return this.div(() -> {});
    }
    public FullElement<TagType.Div> div(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Div>();
        return this.div(attributes, body);
    }
    public FullElement<TagType.Div> div(AttributesMap<TagType.Div> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Div.instance, attributes, body);
    }

    public FullElement<TagType.Ul> ul() {
        return this.ul(() -> {});
    }
    public FullElement<TagType.Ul> ul(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Ul>();
        return this.ul(attributes, body);
    }
    public FullElement<TagType.Ul> ul(AttributesMap<TagType.Ul> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Ul.instance, attributes, body);
    }

    public FullElement<TagType.Ol> ol() {
        return this.ol(() -> {});
    }
    public FullElement<TagType.Ol> ol(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Ol>();
        return this.ol(attributes, body);
    }
    public FullElement<TagType.Ol> ol(AttributesMap<TagType.Ol> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Ol.instance, attributes, body);
    }

    public FullElement<TagType.Li> li() {
        return this.li(() -> {});
    }
    public FullElement<TagType.Li> li(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Li>();
        return this.li(attributes, body);
    }
    public FullElement<TagType.Li> li(AttributesMap<TagType.Li> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Li.instance, attributes, body);
    }

    public FullElement<TagType.Dl> dl() {
        return this.dl(() -> {});
    }
    public FullElement<TagType.Dl> dl(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Dl>();
        return this.dl(attributes, body);
    }
    public FullElement<TagType.Dl> dl(AttributesMap<TagType.Dl> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Dl.instance, attributes, body);
    }

    public FullElement<TagType.Dt> dt() {
        return this.dt(() -> {});
    }
    public FullElement<TagType.Dt> dt(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Dt>();
        return this.dt(attributes, body);
    }
    public FullElement<TagType.Dt> dt(AttributesMap<TagType.Dt> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Dt.instance, attributes, body);
    }

    public FullElement<TagType.Dd> dd() {
        return this.dd(() -> {});
    }
    public FullElement<TagType.Dd> dd(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Dd>();
        return this.dd(attributes, body);
    }
    public FullElement<TagType.Dd> dd(AttributesMap<TagType.Dd> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Dd.instance, attributes, body);
    }

    public FullElement<TagType.Blockquote> blockquote() {
        return this.blockquote(() -> {});
    }
    public FullElement<TagType.Blockquote> blockquote(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Blockquote>();
        return this.blockquote(attributes, body);
    }
    public FullElement<TagType.Blockquote> blockquote(AttributesMap<TagType.Blockquote> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Blockquote.instance, attributes, body);
    }

    // --- Text-level Semantics ---
    public FullElement<TagType.A> a() {
        return this.a(() -> {});
    }
    public FullElement<TagType.A> a(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.A>();
        return this.a(attributes, body);
    }
    public FullElement<TagType.A> a(AttributesMap<TagType.A> attributes, VoidFunction.NoParams body) {
        return tag(TagType.A.instance, attributes, body);
    }

    public FullElement<TagType.Span> span() {
        return this.span(() -> {});
    }
    public FullElement<TagType.Span> span(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Span>();
        return this.span(attributes, body);
    }
    public FullElement<TagType.Span> span(AttributesMap<TagType.Span> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Span.instance, attributes, body);
    }

    public FullElement<TagType.Strong> strong() {
        return this.strong(() -> {});
    }
    public FullElement<TagType.Strong> strong(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Strong>();
        return this.strong(attributes, body);
    }
    public FullElement<TagType.Strong> strong(AttributesMap<TagType.Strong> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Strong.instance, attributes, body);
    }

    public FullElement<TagType.Em> em() {
        return this.em(() -> {});
    }
    public FullElement<TagType.Em> em(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Em>();
        return this.em(attributes, body);
    }
    public FullElement<TagType.Em> em(AttributesMap<TagType.Em> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Em.instance, attributes, body);
    }

    public FullElement<TagType.B> b() {
        return this.b(() -> {});
    }
    public FullElement<TagType.B> b(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.B>();
        return this.b(attributes, body);
    }
    public FullElement<TagType.B> b(AttributesMap<TagType.B> attributes, VoidFunction.NoParams body) {
        return tag(TagType.B.instance, attributes, body);
    }

    public FullElement<TagType.I> i() {
        return this.i(() -> {});
    }
    public FullElement<TagType.I> i(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.I>();
        return this.i(attributes, body);
    }
    public FullElement<TagType.I> i(AttributesMap<TagType.I> attributes, VoidFunction.NoParams body) {
        return tag(TagType.I.instance, attributes, body);
    }

    public FullElement<TagType.U> u() {
        return this.u(() -> {});
    }
    public FullElement<TagType.U> u(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.U>();
        return this.u(attributes, body);
    }
    public FullElement<TagType.U> u(AttributesMap<TagType.U> attributes, VoidFunction.NoParams body) {
        return tag(TagType.U.instance, attributes, body);
    }

    public FullElement<TagType.S> s() {
        return this.s(() -> {});
    }
    public FullElement<TagType.S> s(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.S>();
        return this.s(attributes, body);
    }
    public FullElement<TagType.S> s(AttributesMap<TagType.S> attributes, VoidFunction.NoParams body) {
        return tag(TagType.S.instance, attributes, body);
    }

    public FullElement<TagType.Small> small() {
        return this.small(() -> {});
    }
    public FullElement<TagType.Small> small(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Small>();
        return this.small(attributes, body);
    }
    public FullElement<TagType.Small> small(AttributesMap<TagType.Small> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Small.instance, attributes, body);
    }

    public FullElement<TagType.Cite> cite() {
        return this.cite(() -> {});
    }
    public FullElement<TagType.Cite> cite(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Cite>();
        return this.cite(attributes, body);
    }
    public FullElement<TagType.Cite> cite(AttributesMap<TagType.Cite> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Cite.instance, attributes, body);
    }

    public FullElement<TagType.Code> code() {
        return this.code(() -> {});
    }
    public FullElement<TagType.Code> code(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Code>();
        return this.code(attributes, body);
    }
    public FullElement<TagType.Code> code(AttributesMap<TagType.Code> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Code.instance, attributes, body);
    }

    public FullElement<TagType.Del> del() {
        return this.del(() -> {});
    }
    public FullElement<TagType.Del> del(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Del>();
        return this.del(attributes, body);
    }
    public FullElement<TagType.Del> del(AttributesMap<TagType.Del> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Del.instance, attributes, body);
    }

    public FullElement<TagType.Ins> ins() {
        return this.ins(() -> {});
    }
    public FullElement<TagType.Ins> ins(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Ins>();
        return this.ins(attributes, body);
    }
    public FullElement<TagType.Ins> ins(AttributesMap<TagType.Ins> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Ins.instance, attributes, body);
    }

    public FullElement<TagType.Kbd> kbd() {
        return this.kbd(() -> {});
    }
    public FullElement<TagType.Kbd> kbd(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Kbd>();
        return this.kbd(attributes, body);
    }
    public FullElement<TagType.Kbd> kbd(AttributesMap<TagType.Kbd> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Kbd.instance, attributes, body);
    }

    public FullElement<TagType.Q> q() {
        return this.q(() -> {});
    }
    public FullElement<TagType.Q> q(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Q>();
        return this.q(attributes, body);
    }
    public FullElement<TagType.Q> q(AttributesMap<TagType.Q> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Q.instance, attributes, body);
    }

    public FullElement<TagType.Samp> samp() {
        return this.samp(() -> {});
    }
    public FullElement<TagType.Samp> samp(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Samp>();
        return this.samp(attributes, body);
    }
    public FullElement<TagType.Samp> samp(AttributesMap<TagType.Samp> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Samp.instance, attributes, body);
    }

    public FullElement<TagType.Sub> sub() {
        return this.sub(() -> {});
    }
    public FullElement<TagType.Sub> sub(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Sub>();
        return this.sub(attributes, body);
    }
    public FullElement<TagType.Sub> sub(AttributesMap<TagType.Sub> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Sub.instance, attributes, body);
    }

    public FullElement<TagType.Sup> sup() {
        return this.sup(() -> {});
    }
    public FullElement<TagType.Sup> sup(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Sup>();
        return this.sup(attributes, body);
    }
    public FullElement<TagType.Sup> sup(AttributesMap<TagType.Sup> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Sup.instance, attributes, body);
    }

    public FullElement<TagType.Var> var() {
        return this.var(() -> {});
    }
    public FullElement<TagType.Var> var(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Var>();
        return this.var(attributes, body);
    }
    public FullElement<TagType.Var> var(AttributesMap<TagType.Var> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Var.instance, attributes, body);
    }

    public FullElement<TagType.Time> time() {
        return this.time(() -> {});
    }
    public FullElement<TagType.Time> time(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Time>();
        return this.time(attributes, body);
    }
    public FullElement<TagType.Time> time(AttributesMap<TagType.Time> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Time.instance, attributes, body);
    }

    public FullElement<TagType.Mark> mark() {
        return this.mark(() -> {});
    }
    public FullElement<TagType.Mark> mark(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Mark>();
        return this.mark(attributes, body);
    }
    public FullElement<TagType.Mark> mark(AttributesMap<TagType.Mark> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Mark.instance, attributes, body);
    }

    // --- Embedded Content ---
    public FullElement<TagType.Audio> audio() {
        return this.audio(() -> {});
    }
    public FullElement<TagType.Audio> audio(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Audio>();
        return this.audio(attributes, body);
    }
    public FullElement<TagType.Audio> audio(AttributesMap<TagType.Audio> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Audio.instance, attributes, body);
    }

    public FullElement<TagType.Video> video() {
        return this.video(() -> {});
    }
    public FullElement<TagType.Video> video(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Video>();
        return this.video(attributes, body);
    }
    public FullElement<TagType.Video> video(AttributesMap<TagType.Video> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Video.instance, attributes, body);
    }

    public FullElement<TagType.Iframe> iframe() {
        return this.iframe(() -> {});
    }
    public FullElement<TagType.Iframe> iframe(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Iframe>();
        return this.iframe(attributes, body);
    }
    public FullElement<TagType.Iframe> iframe(AttributesMap<TagType.Iframe> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Iframe.instance, attributes, body);
    }

    public FullElement<TagType.Object> object() {
        return this.object(() -> {});
    }
    public FullElement<TagType.Object> object(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Object>();
        return this.object(attributes, body);
    }
    public FullElement<TagType.Object> object(AttributesMap<TagType.Object> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Object.instance, attributes, body);
    }

    public FullElement<TagType.Picture> picture() {
        return this.picture(() -> {});
    }
    public FullElement<TagType.Picture> picture(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Picture>();
        return this.picture(attributes, body);
    }
    public FullElement<TagType.Picture> picture(AttributesMap<TagType.Picture> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Picture.instance, attributes, body);
    }

    // --- Table Content ---
    public FullElement<TagType.Table> table() {
        return this.table(() -> {});
    }
    public FullElement<TagType.Table> table(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Table>();
        return this.table(attributes, body);
    }
    public FullElement<TagType.Table> table(AttributesMap<TagType.Table> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Table.instance, attributes, body);
    }

    public FullElement<TagType.Caption> caption() {
        return this.caption(() -> {});
    }
    public FullElement<TagType.Caption> caption(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Caption>();
        return this.caption(attributes, body);
    }
    public FullElement<TagType.Caption> caption(AttributesMap<TagType.Caption> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Caption.instance, attributes, body);
    }

    public FullElement<TagType.Thead> thead() {
        return this.thead(() -> {});
    }
    public FullElement<TagType.Thead> thead(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Thead>();
        return this.thead(attributes, body);
    }
    public FullElement<TagType.Thead> thead(AttributesMap<TagType.Thead> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Thead.instance, attributes, body);
    }

    public FullElement<TagType.Tbody> tbody() {
        return this.tbody(() -> {});
    }
    public FullElement<TagType.Tbody> tbody(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Tbody>();
        return this.tbody(attributes, body);
    }
    public FullElement<TagType.Tbody> tbody(AttributesMap<TagType.Tbody> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Tbody.instance, attributes, body);
    }

    public FullElement<TagType.Tfoot> tfoot() {
        return this.tfoot(() -> {});
    }
    public FullElement<TagType.Tfoot> tfoot(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Tfoot>();
        return this.tfoot(attributes, body);
    }
    public FullElement<TagType.Tfoot> tfoot(AttributesMap<TagType.Tfoot> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Tfoot.instance, attributes, body);
    }

    public FullElement<TagType.Tr> tr() {
        return this.tr(() -> {});
    }
    public FullElement<TagType.Tr> tr(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Tr>();
        return this.tr(attributes, body);
    }
    public FullElement<TagType.Tr> tr(AttributesMap<TagType.Tr> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Tr.instance, attributes, body);
    }

    public FullElement<TagType.Th> th() {
        return this.th(() -> {});
    }
    public FullElement<TagType.Th> th(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Th>();
        return this.th(attributes, body);
    }
    public FullElement<TagType.Th> th(AttributesMap<TagType.Th> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Th.instance, attributes, body);
    }

    public FullElement<TagType.Td> td() {
        return this.td(() -> {});
    }
    public FullElement<TagType.Td> td(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Td>();
        return this.td(attributes, body);
    }
    public FullElement<TagType.Td> td(AttributesMap<TagType.Td> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Td.instance, attributes, body);
    }

    public FullElement<TagType.Colgroup> colgroup() {
        return this.colgroup(() -> {});
    }
    public FullElement<TagType.Colgroup> colgroup(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Colgroup>();
        return this.colgroup(attributes, body);
    }
    public FullElement<TagType.Colgroup> colgroup(AttributesMap<TagType.Colgroup> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Colgroup.instance, attributes, body);
    }

    // --- Forms ---
    public FullElement<TagType.Form> form() {
        return this.form(() -> {});
    }
    public FullElement<TagType.Form> form(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Form>();
        return this.form(attributes, body);
    }
    public FullElement<TagType.Form> form(AttributesMap<TagType.Form> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Form.instance, attributes, body);
    }

    public FullElement<TagType.Button> button() {
        return this.button(() -> {});
    }
    public FullElement<TagType.Button> button(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Button>();
        return this.button(attributes, body);
    }
    public FullElement<TagType.Button> button(AttributesMap<TagType.Button> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Button.instance, attributes, body);
    }

    public FullElement<TagType.Select> select() {
        return this.select(() -> {});
    }
    public FullElement<TagType.Select> select(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Select>();
        return this.select(attributes, body);
    }
    public FullElement<TagType.Select> select(AttributesMap<TagType.Select> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Select.instance, attributes, body);
    }

    public FullElement<TagType.Option> option() {
        return this.option(() -> {});
    }
    public FullElement<TagType.Option> option(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Option>();
        return this.option(attributes, body);
    }
    public FullElement<TagType.Option> option(AttributesMap<TagType.Option> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Option.instance, attributes, body);
    }

    public FullElement<TagType.Optgroup> optgroup() {
        return this.optgroup(() -> {});
    }
    public FullElement<TagType.Optgroup> optgroup(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Optgroup>();
        return this.optgroup(attributes, body);
    }
    public FullElement<TagType.Optgroup> optgroup(AttributesMap<TagType.Optgroup> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Optgroup.instance, attributes, body);
    }

    public FullElement<TagType.Textarea> textarea() {
        return this.textarea(() -> {});
    }
    public FullElement<TagType.Textarea> textarea(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Textarea>();
        return this.textarea(attributes, body);
    }
    public FullElement<TagType.Textarea> textarea(AttributesMap<TagType.Textarea> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Textarea.instance, attributes, body);
    }

    public FullElement<TagType.Label> label() {
        return this.label(() -> {});
    }
    public FullElement<TagType.Label> label(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Label>();
        return this.label(attributes, body);
    }
    public FullElement<TagType.Label> label(AttributesMap<TagType.Label> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Label.instance, attributes, body);
    }

    public FullElement<TagType.Fieldset> fieldset() {
        return this.fieldset(() -> {});
    }
    public FullElement<TagType.Fieldset> fieldset(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Fieldset>();
        return this.fieldset(attributes, body);
    }
    public FullElement<TagType.Fieldset> fieldset(AttributesMap<TagType.Fieldset> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Fieldset.instance, attributes, body);
    }

    public FullElement<TagType.Legend> legend() {
        return this.legend(() -> {});
    }
    public FullElement<TagType.Legend> legend(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Legend>();
        return this.legend(attributes, body);
    }
    public FullElement<TagType.Legend> legend(AttributesMap<TagType.Legend> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Legend.instance, attributes, body);
    }

    public FullElement<TagType.Datalist> datalist() {
        return this.datalist(() -> {});
    }
    public FullElement<TagType.Datalist> datalist(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Datalist>();
        return this.datalist(attributes, body);
    }
    public FullElement<TagType.Datalist> datalist(AttributesMap<TagType.Datalist> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Datalist.instance, attributes, body);
    }

    // --- Interactive Elements ---
    public FullElement<TagType.Details> details() {
        return this.details(() -> {});
    }
    public FullElement<TagType.Details> details(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Details>();
        return this.details(attributes, body);
    }
    public FullElement<TagType.Details> details(AttributesMap<TagType.Details> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Details.instance, attributes, body);
    }

    public FullElement<TagType.Summary> summary() {
        return this.summary(() -> {});
    }
    public FullElement<TagType.Summary> summary(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Summary>();
        return this.summary(attributes, body);
    }
    public FullElement<TagType.Summary> summary(AttributesMap<TagType.Summary> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Summary.instance, attributes, body);
    }

    public FullElement<TagType.Dialog> dialog() {
        return this.dialog(() -> {});
    }
    public FullElement<TagType.Dialog> dialog(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Dialog>();
        return this.dialog(attributes, body);
    }
    public FullElement<TagType.Dialog> dialog(AttributesMap<TagType.Dialog> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Dialog.instance, attributes, body);
    }

    // --- Headings (H1 to H6) ---
    public FullElement<TagType.H1> h1() {
        return this.h1(() -> {});
    }
    public FullElement<TagType.H1> h1(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.H1>();
        return this.h1(attributes, body);
    }
    public FullElement<TagType.H1> h1(AttributesMap<TagType.H1> attributes, VoidFunction.NoParams body) {
        return tag(TagType.H1.instance, attributes, body);
    }

    public FullElement<TagType.H2> h2() {
        return this.h2(() -> {});
    }
    public FullElement<TagType.H2> h2(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.H2>();
        return this.h2(attributes, body);
    }
    public FullElement<TagType.H2> h2(AttributesMap<TagType.H2> attributes, VoidFunction.NoParams body) {
        return tag(TagType.H2.instance, attributes, body);
    }

    public FullElement<TagType.H3> h3() {
        return this.h3(() -> {});
    }
    public FullElement<TagType.H3> h3(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.H3>();
        return this.h3(attributes, body);
    }
    public FullElement<TagType.H3> h3(AttributesMap<TagType.H3> attributes, VoidFunction.NoParams body) {
        return tag(TagType.H3.instance, attributes, body);
    }

    public FullElement<TagType.H4> h4() {
        return this.h4(() -> {});
    }
    public FullElement<TagType.H4> h4(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.H4>();
        return this.h4(attributes, body);
    }
    public FullElement<TagType.H4> h4(AttributesMap<TagType.H4> attributes, VoidFunction.NoParams body) {
        return tag(TagType.H4.instance, attributes, body);
    }

    public FullElement<TagType.H5> h5() {
        return this.h5(() -> {});
    }
    public FullElement<TagType.H5> h5(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.H5>();
        return this.h5(attributes, body);
    }
    public FullElement<TagType.H5> h5(AttributesMap<TagType.H5> attributes, VoidFunction.NoParams body) {
        return tag(TagType.H5.instance, attributes, body);
    }

    public FullElement<TagType.H6> h6() {
        return this.h6(() -> {});
    }
    public FullElement<TagType.H6> h6(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.H6>();
        return this.h6(attributes, body);
    }
    public FullElement<TagType.H6> h6(AttributesMap<TagType.H6> attributes, VoidFunction.NoParams body) {
        return tag(TagType.H6.instance, attributes, body);
    }

    // --- Other common elements ---
    public FullElement<TagType.Script> script() {
        return this.script(() -> {});
    }
    public FullElement<TagType.Script> script(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Script>();
        return this.script(attributes, body);
    }
    public FullElement<TagType.Script> script(AttributesMap<TagType.Script> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Script.instance, attributes, body);
    }

    public FullElement<TagType.Style> style() {
        return this.style(() -> {});
    }
    public FullElement<TagType.Style> style(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Style>();
        return this.style(attributes, body);
    }
    public FullElement<TagType.Style> style(AttributesMap<TagType.Style> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Style.instance, attributes, body);
    }

    public FullElement<TagType.Canvas> canvas() {
        return this.canvas(() -> {});
    }
    public FullElement<TagType.Canvas> canvas(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Canvas>();
        return this.canvas(attributes, body);
    }
    public FullElement<TagType.Canvas> canvas(AttributesMap<TagType.Canvas> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Canvas.instance, attributes, body);
    }

    public FullElement<TagType.Figcaption> figcaption() {
        return this.figcaption(() -> {});
    }
    public FullElement<TagType.Figcaption> figcaption(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Figcaption>();
        return this.figcaption(attributes, body);
    }
    public FullElement<TagType.Figcaption> figcaption(AttributesMap<TagType.Figcaption> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Figcaption.instance, attributes, body);
    }

    public FullElement<TagType.Figure> figure() {
        return this.figure(() -> {});
    }
    public FullElement<TagType.Figure> figure(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Figure>();
        return this.figure(attributes, body);
    }
    public FullElement<TagType.Figure> figure(AttributesMap<TagType.Figure> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Figure.instance, attributes, body);
    }

    public FullElement<TagType.Template> template() {
        return this.template(() -> {});
    }
    public FullElement<TagType.Template> template(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Template>();
        return this.template(attributes, body);
    }
    public FullElement<TagType.Template> template(AttributesMap<TagType.Template> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Template.instance, attributes, body);
    }

    public FullElement<TagType.Data> data() {
        return this.data(() -> {});
    }
    public FullElement<TagType.Data> data(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Data>();
        return this.data(attributes, body);
    }
    public FullElement<TagType.Data> data(AttributesMap<TagType.Data> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Data.instance, attributes, body);
    }

    public FullElement<TagType.Meter> meter() {
        return this.meter(() -> {});
    }
    public FullElement<TagType.Meter> meter(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Meter>();
        return this.meter(attributes, body);
    }
    public FullElement<TagType.Meter> meter(AttributesMap<TagType.Meter> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Meter.instance, attributes, body);
    }

    public FullElement<TagType.Progress> progress() {
        return this.progress(() -> {});
    }
    public FullElement<TagType.Progress> progress(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Progress>();
        return this.progress(attributes, body);
    }
    public FullElement<TagType.Progress> progress(AttributesMap<TagType.Progress> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Progress.instance, attributes, body);
    }

    public FullElement<TagType.Output> output() {
        return this.output(() -> {});
    }
    public FullElement<TagType.Output> output(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Output>();
        return this.output(attributes, body);
    }
    public FullElement<TagType.Output> output(AttributesMap<TagType.Output> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Output.instance, attributes, body);
    }

    public FullElement<TagType.Pre> pre() {
        return this.pre(() -> {});
    }
    public FullElement<TagType.Pre> pre(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.Pre>();
        return this.pre(attributes, body);
    }
    public FullElement<TagType.Pre> pre(AttributesMap<TagType.Pre> attributes, VoidFunction.NoParams body) {
        return tag(TagType.Pre.instance, attributes, body);
    }

    public FullElement<TagType.CodeBlock> codeBlock() { // Using the renamed class
        return this.codeBlock(() -> {});
    }
    public FullElement<TagType.CodeBlock> codeBlock(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.CodeBlock>();
        return this.codeBlock(attributes, body);
    }
    public FullElement<TagType.CodeBlock> codeBlock(AttributesMap<TagType.CodeBlock> attributes, VoidFunction.NoParams body) {
        return tag(TagType.CodeBlock.instance, attributes, body);
    }

    public FullElement<TagType.SourceCode> sourceCode() { // Using the renamed class
        return this.sourceCode(() -> {});
    }
    public FullElement<TagType.SourceCode> sourceCode(VoidFunction.NoParams body) {
        var attributes = new AttributesMap<TagType.SourceCode>();
        return this.sourceCode(attributes, body);
    }
    public FullElement<TagType.SourceCode> sourceCode(AttributesMap<TagType.SourceCode> attributes, VoidFunction.NoParams body) {
        return tag(TagType.SourceCode.instance, attributes, body);
    }

    //*******************
    // void elements
    //*******************
    public VoidElement<TagType.Area> area() {
        var attributes = new AttributesMap<TagType.Area>();
        return tag(TagType.Area.instance, attributes);
    }
    public VoidElement<TagType.Area> area(AttributesMap<TagType.Area> attributes) {
        return tag(TagType.Area.instance, attributes);
    }

    public VoidElement<TagType.Base> base() {
        var attributes = new AttributesMap<TagType.Base>();
        return tag(TagType.Base.instance, attributes);
    }
    public VoidElement<TagType.Base> base(AttributesMap<TagType.Base> attributes) {
        return tag(TagType.Base.instance, attributes);
    }

    public VoidElement<TagType.Br> br() {
        var attributes = new AttributesMap<TagType.Br>();
        return tag(TagType.Br.instance, attributes);
    }
    public VoidElement<TagType.Br> br(AttributesMap<TagType.Br> attributes) {
        return tag(TagType.Br.instance, attributes);
    }

    public VoidElement<TagType.Col> col() {
        var attributes = new AttributesMap<TagType.Col>();
        return tag(TagType.Col.instance, attributes);
    }
    public VoidElement<TagType.Col> col(AttributesMap<TagType.Col> attributes) {
        return tag(TagType.Col.instance, attributes);
    }

    public VoidElement<TagType.Embed> embed() {
        var attributes = new AttributesMap<TagType.Embed>();
        return tag(TagType.Embed.instance, attributes);
    }
    public VoidElement<TagType.Embed> embed(AttributesMap<TagType.Embed> attributes) {
        return tag(TagType.Embed.instance, attributes);
    }

    public VoidElement<TagType.Hr> hr() {
        var attributes = new AttributesMap<TagType.Hr>();
        return tag(TagType.Hr.instance, attributes);
    }
    public VoidElement<TagType.Hr> hr(AttributesMap<TagType.Hr> attributes) {
        return tag(TagType.Hr.instance, attributes);
    }

    public VoidElement<TagType.Img> img() {
        var attributes = new AttributesMap<TagType.Img>();
        return tag(TagType.Img.instance, attributes);
    }
    public VoidElement<TagType.Img> img(AttributesMap<TagType.Img> attributes) {
        return tag(TagType.Img.instance, attributes);
    }

    public VoidElement<TagType.Input> input() {
        var attributes = new AttributesMap<TagType.Input>(); // Assuming InputAttributes extends AttributesMap<TagType.Input>
        return tag(TagType.Input.instance, attributes);
    }
    public VoidElement<TagType.Input> input(AttributesMap<TagType.Input> attributes) { // Use AttributesMap for consistency
        return tag(TagType.Input.instance, attributes);
    }

    public VoidElement<TagType.Link> link() {
        var attributes = new AttributesMap<TagType.Link>();
        return tag(TagType.Link.instance, attributes);
    }
    public VoidElement<TagType.Link> link(AttributesMap<TagType.Link> attributes) {
        return tag(TagType.Link.instance, attributes);
    }

    public VoidElement<TagType.Meta> meta() {
        var attributes = new AttributesMap<TagType.Meta>();
        return tag(TagType.Meta.instance, attributes);
    }
    public VoidElement<TagType.Meta> meta(AttributesMap<TagType.Meta> attributes) {
        return tag(TagType.Meta.instance, attributes);
    }

    public VoidElement<TagType.Param> param() {
        var attributes = new AttributesMap<TagType.Param>();
        return tag(TagType.Param.instance, attributes);
    }
    public VoidElement<TagType.Param> param(AttributesMap<TagType.Param> attributes) {
        return tag(TagType.Param.instance, attributes);
    }

    public VoidElement<TagType.Source> source() {
        var attributes = new AttributesMap<TagType.Source>();
        return tag(TagType.Source.instance, attributes);
    }
    public VoidElement<TagType.Source> source(AttributesMap<TagType.Source> attributes) {
        return tag(TagType.Source.instance, attributes);
    }

    public VoidElement<TagType.Track> track() {
        var attributes = new AttributesMap<TagType.Track>();
        return tag(TagType.Track.instance, attributes);
    }
    public VoidElement<TagType.Track> track(AttributesMap<TagType.Track> attributes) {
        return tag(TagType.Track.instance, attributes);
    }

    public VoidElement<TagType.Wbr> wbr() {
        var attributes = new AttributesMap<TagType.Wbr>();
        return tag(TagType.Wbr.instance, attributes);
    }
    public VoidElement<TagType.Wbr> wbr(AttributesMap<TagType.Wbr> attributes) {
        return tag(TagType.Wbr.instance, attributes);
    }

    //*******************
    // element generators
    //*******************
    public VoidElement<TagType> tag(String name) {
        TagType type = () -> name;
        var attributes = new AttributesMap<>();
        var tag = new VoidElement<>(type, attributes);

        this.nestingStack.peek().elements.add(tag);
        return tag;
    }
    public VoidElement<TagType> tag(String name, AttributesMap<TagType> attributes) {
        TagType type = () -> name;
        var tag = new VoidElement<>(type, attributes);

        this.nestingStack.peek().elements.add(tag);
        return tag;
    }
    public FullElement<TagType> tag(String name, VoidFunction.NoParams body) {
        TagType type = () -> name;
        var attributes = new AttributesMap<>();
        var builder = this.execute(body);
        var tag = new FullElement<>(type, attributes, builder.elements.toArray());

        this.nestingStack.peek().elements.add(tag);
        return tag;
    }
    public FullElement<TagType> tag(String name, AttributesMap<TagType> attributes, VoidFunction.NoParams body) {
        TagType type = () -> name;
        var builder = this.execute(body);
        var tag = new FullElement<>(type, attributes, builder.elements.toArray());

        this.nestingStack.peek().elements.add(tag);
        return tag;
    }
    public <T extends TagType, U extends VoidElement<T>> U tag(T type) {
        var attributes = new AttributesMap<T>();
        var tag = (U) new VoidElement<>(type, attributes);

        this.nestingStack.peek().elements.add(tag);
        return tag;
    }
    public <T extends TagType> VoidElement<T> tag(T type, AttributesMap<T> attributes) {
        var tag = new VoidElement<>(type, attributes);

        this.nestingStack.peek().elements.add(tag);
        return tag;
    }
    public <T extends TagType> FullElement<T> tag(T type, AttributesMap<T> attributes, VoidFunction.NoParams body) {
        var builder = this.execute(body);
        var tag = new FullElement<>(type, attributes, builder.elements.toArray());

        this.nestingStack.peek().elements.add(tag);
        return tag;
    }

    //*******************
    // for rendering
    //*******************
    public Renderer createRenderer() {
        var renderer = new Renderer();

        elements.forEach((e) -> {
            switch (e) {
                case FullElement<?> f -> renderer.add(f);
                case VoidElement<?> f -> renderer.add(f);
                case RawText r -> renderer.add(r);
                case String s -> renderer.add(s);
                default -> renderer.add(e.toString());
            }
        });
        return renderer;
    }

    //*******************
    // private methods
    //*******************
    private HtmlBuilder execute(VoidFunction.NoParams body) {
        this.nestingStack.push(new HtmlBuilder());
        body.apply();
        return this.nestingStack.pop();
    }
    private HtmlBuilder createCopy() {
        var stackCopy = ((Stack<HtmlBuilder>) this.nestingStack.clone());
        return stackCopy.getLast();
    }
}