package domain;

public class Stævne {
    private String navn;
    private String dato;
    private int resultat;
    private String disciplin;

    public Stævne(String navn, String dato, int resultat, String disciplin) {
        this.navn = navn;
        this.dato = dato;
        this.resultat = resultat;
        this.disciplin = disciplin;
    }

    public Stævne(){}



    public String getNavn(){
        return navn;
    }

    public String getDato(){
        return dato;
    }

    public int getResultat(){
        return resultat;
    }

    public String getDisciplin(){
        return disciplin;
    }



    @Override
    public String toString() {
        return
                "Stævnets navn: " + navn  +
                ", dato for stævnet: " + dato +
                ", svømmeresultat: " + resultat +
                ", disciplin: " + disciplin +
                        " ]";
    }
}
