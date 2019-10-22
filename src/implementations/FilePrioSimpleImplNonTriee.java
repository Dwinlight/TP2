package implementations;

import bibliotheque.Couple;
import bibliotheque.Liste;
import bibliotheque.Listes;
import factorisation.FilePrioSimpleFacto;
import interfaces.FilePrioSimple;

public class FilePrioSimpleImplNonTriee<T extends Comparable<T>> extends FilePrioSimpleFacto<T> {




    public FilePrioSimpleImplNonTriee(Liste liste) {
        super.elements = liste;
    }

    @Override
    public FilePrioSimple<T> fabrique(Liste l) {
        return new FilePrioSimpleImplNonTriee(l);
    }

    @Override
    public FilePrioSimple<T> insertion(T t) {
        return fabrique(Liste.cons(t, super.elements));
    }

    @Override
    public Couple<T, FilePrioSimple<T>> retrait() {
        Couple<T, Liste<T>> couple = Listes.retraitMinimumListe(super.elements);
        return Couple.def(couple.un, new FilePrioSimpleTriee<>(couple.deux));
    }
}
