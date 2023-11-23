import java.util.ArrayList;

public class Controller {

    private Svømmer sv;

    public Controller() {
        sv = new Svømmer();

    }

    public void tilføjSvømmer(String navn, String aldersGruppe, boolean erAktiv, int alder, String adresse, String emailAdresse, int telefonNummer, String svømmeDisciplin) {
        sv.tilføjSvømmer(navn, aldersGruppe, erAktiv, alder, adresse, emailAdresse, telefonNummer, svømmeDisciplin);
    }

    public ArrayList visMedlemmer() {
        return sv.visMedlemmer();
    }

    public void gemSvømmmere() {
        sv.gemSvømmere(sv.visMedlemmer());
    }

    public void tilføjGemteMedlemmer() {
        sv.tilføjGemteMedlemmer(sv.visMedlemmer());
    }

    public String søgMedlem(String søgeNavn) {
        return sv.søgMedlem(søgeNavn);
    }

    public Svømmer visMedlem(String bestemtSøgeNavn) {
        return sv.visMedlem(bestemtSøgeNavn);
    }

    public void ændreNavn(String bestemtSøgeNavn, String nytNavn) {
        sv.ændreNavn(bestemtSøgeNavn, nytNavn);
    }

    public void redigerAlder(String bestemtSøgeNavn, int nyAlder) {
        sv.redigerAlder(bestemtSøgeNavn, nyAlder);
    }

    public void redigerAdresse(String bestemtSøgeNavn, String nyAdresse) {
        sv.redigerAdresse(bestemtSøgeNavn, nyAdresse);
    }

    public void redigerEmailAdresse(String bestemtSøgeNavn, String nyEmailAdresse) {
        sv.redigerEmailAdresse(bestemtSøgeNavn, nyEmailAdresse);
    }

    public void redigerErAktiv(String bestemtSøgeNavn, boolean nyErAktiv) {
        sv.redigerErAktiv(bestemtSøgeNavn, nyErAktiv);
    }

    public void redigerSvømmeDisciplin(String bestemtSøgeNavn, String nySvømmeDisciplin){
        sv.redigerSvømmeDisciplin(bestemtSøgeNavn, nySvømmeDisciplin);
    }

    public void redigerTelefonnummer(String bestemtSøgeNavn, int nytTelefonnummer){
        sv.redigerTelefonnummer(bestemtSøgeNavn, nytTelefonnummer);
    }
}


