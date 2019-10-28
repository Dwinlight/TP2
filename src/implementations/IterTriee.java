package implementations;

import bibliotheque.Couple;
import bibliotheque.Liste;
import interfaces.CoucheHauteIteratif;
import interfaces.FilePrioEnrichie;
import interfaces.FilePrioSimple;

public class IterTriee<T extends Comparable<T>> extends FilePrioSimpleTriee<T> implements CoucheHauteIteratif<T>  {

    public IterTriee(Liste l) {
        super(l);
    }

    @Override
    public FilePrioEnrichie<T> fabriqueEnrichie() {
        return new IterTriee<>(Liste.vide()) ;
    }

    @Override
    public FilePrioEnrichie<T> ajouterEnrichie(T t) {
        return new IterTriee(this.ajouter(t).toListe());
    }

    @Override
    public Couple<T, FilePrioEnrichie<T>> retirerEnrichie() {
        Couple<T,FilePrioSimple<T>> c = this.retirer();
        return Couple.def(c.un,new IterTriee(c.deux.toListe())) ;
    }

    @Override
    public FilePrioEnrichie<T> somme(FilePrioEnrichie<T> x) {
        return this.somme(x);
    }
}
