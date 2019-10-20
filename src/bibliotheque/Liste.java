package bibliotheque;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public interface Liste<E> extends Mesurable {

  <R> R filtrage(Supplier<R> casVide, BiFunction<E, Liste<E>, R> casCons);

  public static <T> Liste<T> cons(T tete, Liste<T> reste) {
    return new Liste<T>() {
      private int taille = 1 + reste.taille();

      @Override
      public int taille() {
        return this.taille;
      }

      @Override
      public <R> R filtrage(Supplier<R> casVide, BiFunction<T, Liste<T>, R> casCons) {
        return casCons.apply(tete, reste);
      }

      @Override
      public String toString() {
        return tete.toString() + "::" + reste.toString();
      }

      @Override
      public boolean equals(Object obj) {
        if (!(obj instanceof Liste<?>)) {
          return false;
        }
        Liste<?> l = (Liste<?>) obj;
        return l.filtrage(() -> false, (t, r) -> tete.equals(t) && reste.equals(r));
      }
    };
  }

  public static <T> Liste<T> vide() {
    return new Liste<T>() {

      @Override
      public int taille() {
        return 0;
      }

      @Override
      public <R> R filtrage(Supplier<R> casVide, BiFunction<T, Liste<T>, R> casCons) {
        return casVide.get();
      }

      @Override
      public String toString() {
        return "[]";
      }

      @Override
      public boolean equals(Object obj) {
        if (!(obj instanceof Liste<?>)) {
          return false;
        }
        Liste<?> l = (Liste<?>) obj;
        return l.filtrage(() -> true, (t, r) -> false);
      }

    };
  }
}
