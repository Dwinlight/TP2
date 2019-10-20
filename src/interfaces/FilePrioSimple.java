package interfaces;

import bibliotheque.Couple;
import bibliotheque.Liste;

public interface FilePrioSimple<T> {

    // Accesseurs
    public boolean estVide();
    public int taille();
    Liste<T> toListe();

    // Fabrique

    public FilePrioSimple<T> fabrique();

    // Services 1
    public FilePrioSimple<T> ajouter(T t);
    public Couple<T,FilePrioSimple<T>> retirer();



}
