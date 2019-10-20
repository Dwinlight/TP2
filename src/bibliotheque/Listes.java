package bibliotheque;

public class Listes {
    public static <T> T tete(Liste<T> l) {
        return l.filtrage(() -> {
            throw new RuntimeException("Liste vide : 'tete' impossible.");
        }, (t, r) -> t);
    }

    public static <T> Liste<T> reste(Liste<T> l) {
        return l.filtrage(() -> {
            throw new RuntimeException("Liste vide : 'reste' impossible.");
        }, (t, r) -> r);
    }

    public static <T> boolean estVide(Liste<T> l) {
        return l.filtrage(() -> true, (t, r) -> false);
    }

    public static <T extends Comparable<T>> Liste<T> insertionListeOrdonnee(T x, Liste<T> l) {
        Liste<T> gauche = Liste.vide();
        Liste<T> droite = l;
        while (!droite.estVide() && (tete(droite).compareTo(x) < 0)) {
            gauche = Liste.cons(tete(droite), gauche);
            droite = reste(droite);
        }
        droite = Liste.cons(x, droite);
        while (!gauche.estVide()) {
            droite = Liste.cons(tete(gauche), droite);
            gauche = reste(gauche);
        }
        return droite;
    }

    public static <T extends Comparable<T>> Couple<T, Liste<T>> retraitMinimumListe(Liste<T> l) {
        if (estVide(l)) {
            throw new RuntimeException("Liste vide : retrait minimum impossible.");
        }
        T min = tete(l);
        Liste<T> gauche = Liste.vide();
        Liste<T> droite = reste(l);
        while (!estVide(droite)) {
            if (tete(droite).compareTo(min) < 0) {
                gauche = Liste.cons(min, gauche);
                min = tete(droite);
            } else {
                gauche = Liste.cons(tete(droite), gauche);
            }
            droite = reste(droite);
        }
        return Couple.def(min, gauche);
    }

    public static <T extends Comparable<T>> Liste<T> insertionRecListeOrdonnee(T x, Liste<T> l) {
        return l.filtrage(() -> Liste.cons(x, Liste.vide()),
                (t, r) -> (x.compareTo(t) <= 0) ? Liste.cons(x, l) : Liste.cons(t, insertionListeOrdonnee(x, r)));
    }

    public static <T extends Comparable<T>> Couple<T, Liste<T>> retraitRecMinimumListe(Liste<T> l) {
        return l.filtrage(() -> {
            throw new RuntimeException("Liste vide : retrait minimum impossible.");
        }, (t, r) -> r.filtrage(() -> Couple.def(t, r), (tr, rr) -> {
            Couple<T, Liste<T>> c = retraitMinimumListe(r);
            return ((t.compareTo(c.un) < 0) ? Couple.def(t, r) : Couple.def(c.un, Liste.cons(t, c.deux)));
        }));
    }

    @SafeVarargs
    public static <T> Liste<T> def(T... elts) {
        Liste<T> res = Liste.vide();
        for (int i = elts.length - 1; i >= 0; i--) {
            res = Liste.cons(elts[i], res);
        }
        return res;
    }
}