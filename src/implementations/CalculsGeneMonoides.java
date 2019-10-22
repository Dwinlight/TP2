package implementations;

import interfaces.FilePrioEnrichie;

import java.util.List;

public class CalculsGeneMonoides<T> {

    public FilePrioEnrichie<T> somme(List<FilePrioEnrichie<T>> l , FilePrioEnrichie<T> f) {

       return   l.stream().reduce(f,((a,b)->a.somme(b)));
     }
}
