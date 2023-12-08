package domain;

public class Resultat {
    private String navn;
    private int tid;

    public Resultat(String navn, int tid){
        this.navn=navn;
        this.tid=tid;
    }

    public Integer getTid(){
        return tid;
    }

    @Override
    public String toString() {
        return "Svømmerens navn: " + navn  +
                ", tid: " + tid;
    }
}
