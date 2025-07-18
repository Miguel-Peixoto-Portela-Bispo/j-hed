package migke.jhed.utils;

@FunctionalInterface
public interface VoidFunction<P> {
    void apply(P param);
    @FunctionalInterface
    interface NoParams {
        void apply();
    }
}
