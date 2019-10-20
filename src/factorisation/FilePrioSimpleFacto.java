package factorisation;

import bibliotheque.Couple;
import bibliotheque.Liste;
import interfaces.FilePrioSimple;

import java.util.List;

public abstract class FilePrioSimpleFacto<T> implements FilePrioSimple<T> {

    protected Liste<T> elements;

    // Abstract method
    protected abstract FilePrioSimple<T> fabrique(Liste l);
    protected abstract FilePrioSimple<T> insertion(T t);
    protected abstract Couple<T,FilePrioSimple<T>> retrait();

    // Accesseurs
    @Override
    public boolean estVide() {
        return this.elements.estVide();
    }
    @Override
    public int taille() {
        return this.elements.taille();
    }
    @Override
    public Liste<T> toListe() {
        return this.elements;
    }


    // Service 1

    @Override
    public FilePrioSimple<T> ajouter(T t) {
        return this.insertion(t);
    }
    public Couple<T, FilePrioSimple<T>> retirer(){
        return this.retrait();
    }

    // Fabrique

    public FilePrioSimple<T> fabrique(){
        return fabrique(Liste.vide());
    }

}
