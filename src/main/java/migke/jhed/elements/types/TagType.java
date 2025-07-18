package migke.jhed.elements.types;

@FunctionalInterface
public interface TagType {
    String getName();

    // full Elements
    class Html implements TagType {
        public static final Html instance = new Html();
        @Override public String getName() { return "html"; }
    }

    class Head implements TagType {
        public static final Head instance = new Head();
        @Override public String getName() { return "head"; }
    }

    class Body implements TagType {
        public static final Body instance = new Body();
        @Override public String getName() { return "body"; }
    }

    class Title implements TagType {
        public static final Title instance = new Title();
        @Override public String getName() { return "title"; }
    }

    // Sectioning Content
    class Article implements TagType {
        public static final Article instance = new Article();
        @Override public String getName() { return "article"; }
    }

    class Section implements TagType {
        public static final Section instance = new Section();
        @Override public String getName() { return "section"; }
    }

    class Nav implements TagType {
        public static final Nav instance = new Nav();
        @Override public String getName() { return "nav"; }
    }

    class Aside implements TagType {
        public static final Aside instance = new Aside();
        @Override public String getName() { return "aside"; }
    }

    class Header implements TagType {
        public static final Header instance = new Header();
        @Override public String getName() { return "header"; }
    }

    class Footer implements TagType {
        public static final Footer instance = new Footer();
        @Override public String getName() { return "footer"; }
    }

    class Main implements TagType {
        public static final Main instance = new Main();
        @Override public String getName() { return "main"; }
    }

    class Address implements TagType {
        public static final Address instance = new Address();
        @Override public String getName() { return "address"; }
    }

    // Grouping Content
    class P implements TagType {
        public static final P instance = new P();
        @Override public String getName() { return "p"; }
    }

    class Div implements TagType {
        public static final Div instance = new Div();
        @Override public String getName() { return "div"; }
    }

    class Ul implements TagType {
        public static final Ul instance = new Ul();
        @Override public String getName() { return "ul"; }
    }

    class Ol implements TagType {
        public static final Ol instance = new Ol();
        @Override public String getName() { return "ol"; }
    }

    class Li implements TagType {
        public static final Li instance = new Li();
        @Override public String getName() { return "li"; }
    }

    class Dl implements TagType {
        public static final Dl instance = new Dl();
        @Override public String getName() { return "dl"; }
    }

    class Dt implements TagType {
        public static final Dt instance = new Dt();
        @Override public String getName() { return "dt"; }
    }

    class Dd implements TagType {
        public static final Dd instance = new Dd();
        @Override public String getName() { return "dd"; }
    }

    class Blockquote implements TagType {
        public static final Blockquote instance = new Blockquote();
        @Override public String getName() { return "blockquote"; }
    }

    // Text-level Semantics
    class A implements TagType {
        public static final A instance = new A();
        @Override public String getName() { return "a"; }
    }

    class Span implements TagType {
        public static final Span instance = new Span();
        @Override public String getName() { return "span"; }
    }

    class Strong implements TagType {
        public static final Strong instance = new Strong();
        @Override public String getName() { return "strong"; }
    }

    class Em implements TagType {
        public static final Em instance = new Em();
        @Override public String getName() { return "em"; }
    }

    class B implements TagType {
        public static final B instance = new B();
        @Override public String getName() { return "b"; }
    }

    class I implements TagType {
        public static final I instance = new I();
        @Override public String getName() { return "i"; }
    }

    class U implements TagType {
        public static final U instance = new U();
        @Override public String getName() { return "u"; }
    }

    class S implements TagType {
        public static final S instance = new S();
        @Override public String getName() { return "s"; }
    }

    class Small implements TagType {
        public static final Small instance = new Small();
        @Override public String getName() { return "small"; }
    }

    class Cite implements TagType {
        public static final Cite instance = new Cite();
        @Override public String getName() { return "cite"; }
    }

    class Code implements TagType {
        public static final Code instance = new Code();
        @Override public String getName() { return "code"; }
    }

    class Del implements TagType {
        public static final Del instance = new Del();
        @Override public String getName() { return "del"; }
    }

    class Ins implements TagType {
        public static final Ins instance = new Ins();
        @Override public String getName() { return "ins"; }
    }

    class Kbd implements TagType {
        public static final Kbd instance = new Kbd();
        @Override public String getName() { return "kbd"; }
    }

    class Q implements TagType {
        public static final Q instance = new Q();
        @Override public String getName() { return "q"; }
    }

    class Samp implements TagType {
        public static final Samp instance = new Samp();
        @Override public String getName() { return "samp"; }
    }

    class Sub implements TagType {
        public static final Sub instance = new Sub();
        @Override public String getName() { return "sub"; }
    }

    class Sup implements TagType {
        public static final Sup instance = new Sup();
        @Override public String getName() { return "sup"; }
    }

    class Var implements TagType {
        public static final Var instance = new Var();
        @Override public String getName() { return "var"; }
    }

    class Time implements TagType {
        public static final Time instance = new Time();
        @Override public String getName() { return "time"; }
    }

    class Mark implements TagType {
        public static final Mark instance = new Mark();
        @Override public String getName() { return "mark"; }
    }

    // Embedded Content
    class Audio implements TagType {
        public static final Audio instance = new Audio();
        @Override public String getName() { return "audio"; }
    }

    class Video implements TagType {
        public static final Video instance = new Video();
        @Override public String getName() { return "video"; }
    }

    class Iframe implements TagType {
        public static final Iframe instance = new Iframe();
        @Override public String getName() { return "iframe"; }
    }

    class Object implements TagType {
        public static final Object instance = new Object();
        @Override public String getName() { return "object"; }
    }

    class Picture implements TagType {
        public static final Picture instance = new Picture();
        @Override public String getName() { return "picture"; }
    }

    // Table Content
    class Table implements TagType {
        public static final Table instance = new Table();
        @Override public String getName() { return "table"; }
    }

    class Caption implements TagType {
        public static final Caption instance = new Caption();
        @Override public String getName() { return "caption"; }
    }

    class Thead implements TagType {
        public static final Thead instance = new Thead();
        @Override public String getName() { return "thead"; }
    }

    class Tbody implements TagType {
        public static final Tbody instance = new Tbody();
        @Override public String getName() { return "tbody"; }
    }

    class Tfoot implements TagType {
        public static final Tfoot instance = new Tfoot();
        @Override public String getName() { return "tfoot"; }
    }

    class Tr implements TagType {
        public static final Tr instance = new Tr();
        @Override public String getName() { return "tr"; }
    }

    class Th implements TagType {
        public static final Th instance = new Th();
        @Override public String getName() { return "th"; }
    }

    class Td implements TagType {
        public static final Td instance = new Td();
        @Override public String getName() { return "td"; }
    }

    class Colgroup implements TagType {
        public static final Colgroup instance = new Colgroup();
        @Override public String getName() { return "colgroup"; }
    }

    // Forms
    class Form implements TagType {
        public static final Form instance = new Form();
        @Override public String getName() { return "form"; }
    }

    class Button implements TagType {
        public static final Button instance = new Button();
        @Override public String getName() { return "button"; }
    }

    class Select implements TagType {
        public static final Select instance = new Select();
        @Override public String getName() { return "select"; }
    }

    class Option implements TagType {
        public static final Option instance = new Option();
        @Override public String getName() { return "option"; }
    }

    class Optgroup implements TagType {
        public static final Optgroup instance = new Optgroup();
        @Override public String getName() { return "optgroup"; }
    }

    class Textarea implements TagType {
        public static final Textarea instance = new Textarea();
        @Override public String getName() { return "textarea"; }
    }

    class Label implements TagType {
        public static final Label instance = new Label();
        @Override public String getName() { return "label"; }
    }

    class Fieldset implements TagType {
        public static final Fieldset instance = new Fieldset();
        @Override public String getName() { return "fieldset"; }
    }

    class Legend implements TagType {
        public static final Legend instance = new Legend();
        @Override public String getName() { return "legend"; }
    }

    class Datalist implements TagType {
        public static final Datalist instance = new Datalist();
        @Override public String getName() { return "datalist"; }
    }

    // Interactive Elements
    class Details implements TagType {
        public static final Details instance = new Details();
        @Override public String getName() { return "details"; }
    }

    class Summary implements TagType {
        public static final Summary instance = new Summary();
        @Override public String getName() { return "summary"; }
    }

    class Dialog implements TagType {
        public static final Dialog instance = new Dialog();
        @Override public String getName() { return "dialog"; }
    }

    // Headings (H1 to H6)
    class H1 implements TagType {
        public static final H1 instance = new H1();
        @Override public String getName() { return "h1"; }
    }

    class H2 implements TagType {
        public static final H2 instance = new H2();
        @Override public String getName() { return "h2"; }
    }

    class H3 implements TagType {
        public static final H3 instance = new H3();
        @Override public String getName() { return "h3"; }
    }

    class H4 implements TagType {
        public static final H4 instance = new H4();
        @Override public String getName() { return "h4"; }
    }

    class H5 implements TagType {
        public static final H5 instance = new H5();
        @Override public String getName() { return "h5"; }
    }

    class H6 implements TagType {
        public static final H6 instance = new H6();
        @Override public String getName() { return "h6"; }
    }

    // Other common elements
    class Script implements TagType {
        public static final Script instance = new Script();
        @Override public String getName() { return "script"; }
    }

    class Style implements TagType {
        public static final Style instance = new Style();
        @Override public String getName() { return "style"; }
    }

    class Canvas implements TagType {
        public static final Canvas instance = new Canvas();
        @Override public String getName() { return "canvas"; }
    }

    class Figcaption implements TagType {
        public static final Figcaption instance = new Figcaption();
        @Override public String getName() { return "figcaption"; }
    }

    class Figure implements TagType {
        public static final Figure instance = new Figure();
        @Override public String getName() { return "figure"; }
    }

    class Template implements TagType {
        public static final Template instance = new Template();
        @Override public String getName() { return "template"; }
    }

    class Data implements TagType {
        public static final Data instance = new Data();
        @Override public String getName() { return "data"; }
    }

    class Meter implements TagType {
        public static final Meter instance = new Meter();
        @Override public String getName() { return "meter"; }
    }

    class Progress implements TagType {
        public static final Progress instance = new Progress();
        @Override public String getName() { return "progress"; }
    }

    class Output implements TagType {
        public static final Output instance = new Output();
        @Override public String getName() { return "output"; }
    }

    class Pre implements TagType {
        public static final Pre instance = new Pre();
        @Override public String getName() { return "pre"; }
    }

    class CodeBlock implements TagType { // Renamed to avoid conflict with `Code`
        public static final CodeBlock instance = new CodeBlock();
        @Override public String getName() { return "pre"; } // <pre> for code blocks
    }

    class SourceCode implements TagType { // Renamed to avoid conflict with `Source` (void element)
        public static final SourceCode instance = new SourceCode();
        @Override public String getName() { return "code"; } // <code> for inline code
    }

    // void elements
    class Area implements TagType {
        public static final Area instance = new Area();

        @Override
        public String getName() {
            return "area";
        }
    }

    class Base implements TagType {
        public static final Base instance = new Base();

        @Override
        public String getName() {
            return "base";
        }
    }

    class Br implements TagType {
        public static final Br instance = new Br();

        @Override
        public String getName() {
            return "br";
        }
    }

    class Col implements TagType {
        public static final Col instance = new Col();

        @Override
        public String getName() {
            return "col";
        }
    }

    class Embed implements TagType {
        public static final Embed instance = new Embed();

        @Override
        public String getName() {
            return "embed";
        }
    }

    class Hr implements TagType {
        public static final Hr instance = new Hr();

        @Override
        public String getName() {
            return "hr";
        }
    }

    class Img implements TagType {
        public static final Img instance = new Img();

        @Override
        public String getName() {
            return "img";
        }
    }

    class Input implements TagType {
        public static final Input instance = new Input();

        @Override
        public String getName() {
            return "input";
        }
    }

    class Link implements TagType {
        public static final Link instance = new Link();

        @Override
        public String getName() {
            return "link";
        }
    }

    class Meta implements TagType {
        public static final Meta instance = new Meta();

        @Override
        public String getName() {
            return "meta";
        }
    }

    class Param implements TagType {
        public static final Param instance = new Param();

        @Override
        public String getName() {
            return "param";
        }
    }

    class Source implements TagType {
        public static final Source instance = new Source();

        @Override
        public String getName() {
            return "source";
        }
    }

    class Track implements TagType {
        public static final Track instance = new Track();

        @Override
        public String getName() {
            return "track";
        }
    }

    class Wbr implements TagType {
        public static final Wbr instance = new Wbr();

        @Override
        public String getName() {
            return "wbr";
        }
    }
}