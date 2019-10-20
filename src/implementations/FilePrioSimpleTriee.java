package implementations;

import bibliotheque.Couple;
import bibliotheque.Liste;
import bibliotheque.Listes;
import factorisation.FilePrioSimpleFacto;
import interfaces.FilePrioSimple;

import java.io.File;
import java.util.List;

public class FilePrioSimpleTriee<T extends Comparable<T>> extends FilePrioSimpleFacto<T> {


    public FilePrioSimpleTriee(Liste l){
        super.elements = l;
    }
    @Override
    protected FilePrioSimple<T> fabrique(Liste l) {
        return new FilePrioSimpleTriee<T>(l);
    }

    @Override
    public FilePrioSimple<T> insertion(T t) {
        return new FilePrioSimpleTriee<T>(Listes.insertionListeOrdonnee(t,super.elements));
    }

    @Override
    protected Couple<T, FilePrioSimple<T>> retrait() {
        Couple<T, Liste<T>> couple = Listes.retraitMinimumListe(super.elements);
        return Couple.def(couple.un, new FilePrioSimpleTriee<>(couple.deux));
    }
}
