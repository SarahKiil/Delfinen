package domain;
import java.util.Comparator;

public class ResultatComparator implements Comparator<Resultat> {
    @Override
    public int compare(Resultat d1, Resultat d2){
        return d1.getTid().compareTo(d2.getTid());
    }
}