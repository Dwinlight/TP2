package interfaces;

import bibliotheque.Couple;

public interface CoucheHauteRecursif<T> extends FilePrioEnrichie<T> {
    default FilePrioEnrichie<T> somme(CoucheHauteRecursif<T> t){
        if (t.estVide()) {
            return this;
        }
        else {
            Couple<T, FilePrioEnrichie<T>> c = t.retirerEnrichie();
            FilePrioEnrichie<T> f = this.ajouterEnrichie(c.un);
            return f.somme(c.deux);

        }
    }
    default FilePrioEnrichie<T> zero() {
        return  this.fabriqueEnrichie() ;
    }
}
