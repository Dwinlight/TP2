package interfaces;

import bibliotheque.Couple;
import bibliotheque.Liste;
import hierarchie.MonoideAdditif;

public interface FilePrioEnrichie<T> extends MonoideAdditif<FilePrioEnrichie<T>>, FilePrioSimple<T> {
    // Fabrique

    public FilePrioEnrichie<T> fabriqueEnrichie();

    // Services 1 spé
    public FilePrioEnrichie<T> ajouterEnrichie(T t);

    public Couple<T,FilePrioEnrichie<T>> retirerEnrichie();





}
