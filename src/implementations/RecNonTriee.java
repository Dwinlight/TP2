package implementations;

import bibliotheque.Couple;
import bibliotheque.Liste;
import interfaces.CoucheHauteIteratif;
import interfaces.CoucheHauteRecursif;
import interfaces.FilePrioEnrichie;
import interfaces.FilePrioSimple;

public class RecNonTriee<T extends Comparable<T>> extends FilePrioSimpleImplNonTriee<T> implements CoucheHauteRecursif<T> {

    public RecNonTriee(Liste liste) {
        super(liste);
    }

    @Override
    public FilePrioEnrichie<T> fabriqueEnrichie() {
        return new RecNonTriee<>(Liste.vide());
    }

    @Override
    public FilePrioEnrichie<T> ajouterEnrichie(T t) {
        return new RecNonTriee(this.ajouter(t).toListe());
    }

    @Override
    public Couple<T, FilePrioEnrichie<T>> retirerEnrichie() {
        Couple<T,FilePrioSimple<T>> c = this.retirer();
        return Couple.def(c.un,new RecNonTriee(c.deux.toListe())) ;
    }

    @Override
    public FilePrioEnrichie<T> somme(FilePrioEnrichie<T> x) {
        return this.somme(x);
    }
}
