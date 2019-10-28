package implementations;

import bibliotheque.Couple;
import bibliotheque.Liste;
import interfaces.CoucheHauteIteratif;
import interfaces.FilePrioEnrichie;
import interfaces.FilePrioSimple;

public class IterNonTriee<T extends Comparable<T>> extends FilePrioSimpleImplNonTriee<T> implements CoucheHauteIteratif<T> {


    public IterNonTriee(Liste liste) {
        super(liste);
    }

    @Override
    public FilePrioEnrichie<T> fabriqueEnrichie() {
        return new IterNonTriee<T>(Liste.vide());
    }

    @Override
    public FilePrioEnrichie<T> ajouterEnrichie(T t) {
        return new IterNonTriee(this.ajouter(t).toListe());
    }

    @Override
    public Couple<T, FilePrioEnrichie<T>> retirerEnrichie() {
        Couple<T,FilePrioSimple<T>> c = this.retirer();
        return Couple.def(c.un,new IterNonTriee(c.deux.toListe()));
    }

    @Override
    public FilePrioEnrichie<T> somme(FilePrioEnrichie<T> x) {
        return this.somme(x);
    }
}
