package interfaces;

import bibliotheque.Couple;

public interface
CoucheHauteIteratif <T> extends FilePrioEnrichie<T> {
    default FilePrioEnrichie<T> somme(CoucheHauteIteratif<T> t){
        FilePrioEnrichie<T> s = this.fabriqueEnrichie();
        Couple<T, FilePrioEnrichie<T>> tempo = t.retirerEnrichie();
        s.ajouterEnrichie(tempo.un);
        while (!tempo.deux.estVide()) {
            tempo = tempo.deux.retirerEnrichie();
            s.ajouterEnrichie(tempo.un);
        }
        tempo = this.retirerEnrichie();
        while (!tempo.deux.estVide()) {
            tempo = tempo.deux.retirerEnrichie();
            s.ajouterEnrichie(tempo.un);
        }

        return s;
    }
    default FilePrioEnrichie<T> zero() {
        return this.fabriqueEnrichie();
    }
}
