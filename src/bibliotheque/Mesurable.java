package bibliotheque;

public interface Mesurable {
    int taille();

    default boolean estVide() {
        return this.taille() == 0;
    }

}
