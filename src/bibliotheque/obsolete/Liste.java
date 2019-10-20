package bibliotheque.obsolete;

public interface Liste<E> {
    // Sélecteurs
    default boolean estVide() {
        return !this.estCons();
    }

    default boolean estCons() {
        return !this.estVide();
    }

    // Destructeurs
    E tete();

    Liste<E> reste();

    // Fabriques (constructeurs)
    Liste<E> creerVide();

    Liste<E> creerCons(E t, Liste<E> r);

    // Patron interpréteur (interprétation triviale)
    int taille();

    public static <T> Liste<T> cons(T tete, Liste<T> reste) {
        return new Cons<T>(tete, reste);
    }

    public static <T> Liste<T> vide() {
        return new Vide<>();
    }
}

class Vide<E> implements Liste<E> {

    @Override
    public boolean estVide() {
        return true;
    }

    @Override
    public E tete() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Liste<E> reste() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Liste<E> creerVide() {
        return new Vide<>();
    }

    @Override
    public Liste<E> creerCons(E t, Liste<E> r) {
        return new Cons<>(t, r);
    }

    @Override
    public int taille() {
        return 0;
    }

}

class Cons<E> implements Liste<E> {

    private E tete;
    private Liste<E> reste;

    public Cons(E tete, Liste<E> reste) {
        this.tete = tete;
        this.reste = reste;
    }

    @Override
    public boolean estCons() {
        return true;
    }

    @Override
    public E tete() {
        return this.tete;
    }

    @Override
    public Liste<E> reste() {
        return this.reste;
    }

    @Override
    public Liste<E> creerVide() {
        return new Vide<>();
    }

    @Override
    public Liste<E> creerCons(E t, Liste<E> r) {
        return new Cons<>(t, r);
    }

    @Override
    public int taille() {
        return 1 + this.reste().taille();
    }

}
