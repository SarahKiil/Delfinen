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
}
