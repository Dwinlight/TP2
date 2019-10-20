package implementations;

import bibliotheque.Couple;
import bibliotheque.Liste;
import interfaces.CoucheHauteRecursif;
import interfaces.FilePrioEnrichie;
import interfaces.FilePrioSimple;

public class RecNonTriee<T> implements CoucheHauteRecursif<T> {
    @Override
    public FilePrioEnrichie<T> fabriqueEnrichie() {
        return null;
    }

    @Override
    public FilePrioEnrichie<T> ajouterEnrichie(T t) {
        return null;
    }

    @Override
    public Couple<T, FilePrioEnrichie<T>> retirerEnrichie() {
        return null;
    }

    @Override
    public FilePrioEnrichie<T> somme(FilePrioEnrichie<T> x) {
        return null;
    }

    @Override
    public boolean estVide() {
        return false;
    }

    @Override
    public int taille() {
        return 0;
    }

    @Override
    public Liste<T> toListe() {
        return null;
    }

    @Override
    public FilePrioSimple<T> fabrique() {
        return null;
    }

    @Override
    public FilePrioSimple<T> ajouter(T t) {
        return null;
    }

    @Override
    public Couple<T, FilePrioSimple<T>> retirer() {
        return null;
    }
}
