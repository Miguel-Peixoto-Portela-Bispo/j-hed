package migke.jed;

@FunctionalInterface
public interface TagType {
    String getName();

    class H1 implements TagType {
        static final H1 instance = new H1();

        @Override
        public String getName() {
            return "h1";
        }
    }
    class H2 implements TagType {
        static final H2 instance = new H2();

        @Override
        public String getName() {
            return "h2";
        }
    }
    class H3 implements TagType {
        static final H3 instance = new H3();

        @Override
        public String getName() {
            return "h3";
        }
    }
    class H4 implements TagType {
        static final H4 instance = new H4();

        @Override
        public String getName() {
            return "h4";
        }
    }
    class H5 implements TagType {
        static final H5 instance = new H5();

        @Override
        public String getName() {
            return "h5";
        }
    }
    class H6 implements TagType {
        static final H6 instance = new H6();

        @Override
        public String getName() {
            return "h6";
        }
    }
    class Div implements TagType {
        static final Div instance = new Div();

        @Override
        public String getName() {
            return "div";
        }
    }
    class Input implements TagType {
        static final Input instance = new Input();

        @Override
        public String getName() {
            return "input";
        }
    }
}