package implementations;

import bibliotheque.Couple;
import bibliotheque.Liste;
import interfaces.CoucheHauteRecursif;
import interfaces.FilePrioEnrichie;
import interfaces.FilePrioSimple;

public class RecTriee<T extends Comparable<T>>  extends FilePrioSimpleTriee<T> implements CoucheHauteRecursif<T> {

    public RecTriee(Liste l) {
        super(l);
    }

    @Override
    public FilePrioEnrichie<T> fabriqueEnrichie() {
        return new RecTriee(Liste.vide());
    }

    @Override
    public FilePrioEnrichie<T> ajouterEnrichie(T t) {
        return new RecTriee(this.ajouter(t).toListe());
    }

    @Override
    public Couple<T, FilePrioEnrichie<T>> retirerEnrichie() {
        Couple<T,FilePrioSimple<T>>  c =  this.retirer() ;
        return Couple.def(c.un, new RecTriee(c.deux.toListe())) ;
    }

    @Override
    public FilePrioEnrichie<T> somme(FilePrioEnrichie<T> x) {
        return this.somme(x);
    }
}
