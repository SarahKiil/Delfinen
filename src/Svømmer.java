import java.util.ArrayList;

public class Svømmer {
    private String navn;
    private String aldersGruppe;
    private boolean erAktiv;
    private int alder;
    private String adresse;
    private String emailAdresse;
    private int telefonNummer;
    private String svømmeDisciplin;
    FileHandler fh;

    public Svømmer(String navn, String aldersGruppe, boolean erAktiv, int alder, String adresse, String emailAdresse, int telefonNummer, String svømmeDisciplin) {
        this.navn = navn;
        this.aldersGruppe = aldersGruppe;
        this.erAktiv = erAktiv;
        this.adresse = adresse;
        this.alder = alder;
        this.emailAdresse = emailAdresse;
        this.telefonNummer = telefonNummer;
        this.svømmeDisciplin = svømmeDisciplin;

    }



    public Svømmer(){
        fh = new FileHandler();
    }

    private ArrayList<Svømmer> medlemmer= new ArrayList<Svømmer>();

    public void gemSvømmere(ArrayList medlemmer) {
        fh.gemSvømmere(medlemmer);
    }

    public ArrayList visMedlemmer(){
        return medlemmer;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getAldersGruppe() {
        return aldersGruppe;
    }

    public void setAldersGruppe(String aldersGruppe) {
        this.aldersGruppe = aldersGruppe;
    }

    public boolean isErAktiv() {
        return erAktiv;
    }

    public void setErAktiv(boolean erAktiv) {
        this.erAktiv = erAktiv;
    }

    public int getAlder() {
        return alder;
    }

    public void setAlder(int alder) {
        this.alder = alder;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmailAdresse() {
        return emailAdresse;
    }

    public void setEmailAdresse(String emailAdresse) {
        this.emailAdresse = emailAdresse;
    }

    public int getTelefonNummer() {
        return telefonNummer;
    }

    public void setTelefonNummer(int telefonNummer) {
        this.telefonNummer = telefonNummer;
    }

    public String getSvømmeDisciplin (){
        return svømmeDisciplin;
    }

    public void setSvømmeDisciplin(String svømmeDisciplin){
        this.svømmeDisciplin = svømmeDisciplin;
    }

    public ArrayList<Svømmer> getMedlemmer() {
        return medlemmer;
    }

    public void setMedlemmer(ArrayList<Svømmer> medlemmer) {
        this.medlemmer = medlemmer;
    }

    @Override
    public String toString() {
        return "Svømmer{" +
                "navn='" + navn + '\'' +
                ", aldersGruppe='" + aldersGruppe + '\'' +
                ", erAktiv=" + erAktiv +
                ", alder=" + alder +
                ", adresse='" + adresse + '\'' +
                ", emailAdresse='" + emailAdresse + '\'' +
                ", telefonNummer=" + telefonNummer +
                ", medlemmer=" + medlemmer +
                '}';
    }



    public void tilføjSvømmer(String navn, String aldersGruppe, boolean erAktiv, int alder, String adresse, String emailAdresse, int telefonNummer, String svømmeDisciplin) {
        medlemmer.add(new Svømmer(navn, aldersGruppe, erAktiv, alder, adresse, emailAdresse, telefonNummer, svømmeDisciplin));
    }
}
