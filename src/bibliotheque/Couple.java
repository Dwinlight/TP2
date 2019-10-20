package bibliotheque;

public class Couple<T1, T2> {
    public final T1 un;
    public final T2 deux;

    private Couple(T1 x, T2 y) {
        this.un = x;
        this.deux = y;
    }

    public static <E1, E2> Couple<E1, E2> def(E1 x, E2 y) {
        return new Couple<>(x, y);
    }
}
