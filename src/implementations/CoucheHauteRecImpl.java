package implementations;

import bibliotheque.Couple;
import bibliotheque.Liste;
import interfaces.CoucheHauteRecursif;
import interfaces.FilePrioEnrichie;
import interfaces.FilePrioSimple;

public class CoucheHauteRecImpl<T> implements CoucheHauteRecursif<T> {

    private FilePrioSimple<T> file;

    @Override
    public FilePrioEnrichie<T> fabriqueEnrichie() {
        return this.zero();
    }

    @Override
    public FilePrioEnrichie<T> ajouterEnrichie(T t) {
        return (FilePrioEnrichie<T>)this.file.ajouter(t);
    }

    @Override
    public Couple<T, FilePrioEnrichie<T>> retirerEnrichie() {
        Couple<T, FilePrioSimple<T>> c = this.file.retirer();
        return Couple.def(c.un, (FilePrioEnrichie<T>) c.deux);
    }

    @Override
    public FilePrioEnrichie<T> somme(FilePrioEnrichie<T> x) {
        return this.somme((CoucheHauteRecursif<T>)this.file);
    }

    @Override
    public boolean estVide() {
        return this.file.estVide();
    }

    @Override
    public int taille() {
        return this.file.taille();
    }

    @Override
    public Liste<T> toListe() {
        return this.file.toListe();
    }

    @Override
    public FilePrioSimple<T> fabrique() {
        return this.file.fabrique();
    }

    @Override
    public FilePrioSimple<T> ajouter(T t) {
        return this.file.ajouter(t);
    }

    @Override
    public Couple<T, FilePrioSimple<T>> retirer() {
        return this.file.retirer();
    }
}
