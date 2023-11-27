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

    public Svømmer() {
        fh = new FileHandler();
    }

    private ArrayList<Svømmer> medlemmer = new ArrayList<Svømmer>();

    public void gemSvømmere(ArrayList medlemmer) {
        fh.gemSvømmere(medlemmer);

    }

    public void tilføjGemteMedlemmer(ArrayList medlemmer) {
        fh.addGemteMedlemmer(medlemmer);
    }

    public String søgMedlem(String søgeNavn) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Svømmer s : medlemmer) {
            if (s.getNavn().toLowerCase().contains(søgeNavn.toLowerCase()))
                stringBuilder.append(s.getNavn() + ". ");
        }
        return stringBuilder.toString();
    }

    public Svømmer visMedlem(String bestemtSøgeNavn) {
        for (Svømmer s : medlemmer) {
            if (s.getNavn().equalsIgnoreCase(bestemtSøgeNavn)) {
                return s;
            }

        }

        return null;
    }

    public ArrayList visMedlemmer() {
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

    public String getSvømmeDisciplin() {
        return svømmeDisciplin;
    }

    public void setSvømmeDisciplin(String svømmeDisciplin) {
        this.svømmeDisciplin = svømmeDisciplin;
    }

    public ArrayList<Svømmer> getMedlemmer() {
        return medlemmer;
    }

    public void ændreNavn(String bestemtSøgeNavn, String nytNavn) {
        for (Svømmer s : medlemmer) {
            if (s.getNavn().equalsIgnoreCase(bestemtSøgeNavn)) {
                s.setNavn(nytNavn);
            }
        }
    }

    public void setMedlemmer(ArrayList<Svømmer> medlemmer) {
        this.medlemmer = medlemmer;
    }

    @Override
    public String toString() {
        return "Svømmerens " +
                "navn: " + navn + '\'' +
                ", aldersgruppen svømmeren tilhører: " + aldersGruppe + '\'' +
                ", er medlemmet aktivt? " + erAktiv +
                ", medlemmets alder: " + alder +
                ", medlemmets adresse: " + adresse + '\'' +
                ", medlemmets emailadresse: " + emailAdresse + '\'' +
                ", telefonnummer: " + telefonNummer;
    }


    public void tilføjSvømmer(String navn, String aldersGruppe, boolean erAktiv, int alder, String adresse, String emailAdresse, int telefonNummer, String svømmeDisciplin) {
        medlemmer.add(new Svømmer(navn, aldersGruppe, erAktiv, alder, adresse, emailAdresse, telefonNummer, svømmeDisciplin));
    }

    public void redigerAlder(String bestemtSøgeNavn, int nyAlder) {
        for (Svømmer s : medlemmer) {
            if (s.getNavn().equalsIgnoreCase(bestemtSøgeNavn)) {
                s.setAlder(nyAlder);
            }
            if (nyAlder == 18){
                s.setAldersGruppe("Senior");
            }
        }
    }

    public void redigerAdresse(String bestemtSøgeNavn, String nyAdresse) {
        for (Svømmer s : medlemmer) {
            if (s.getNavn().equalsIgnoreCase(bestemtSøgeNavn)) {
                s.setAdresse(nyAdresse);
            }
        }
    }

    public void redigerErAktiv(String bestemtSøgeNavn, boolean nyErAktiv) {
        for (Svømmer s : medlemmer) {
            if (s.getNavn().equalsIgnoreCase(bestemtSøgeNavn)) {
                s.setErAktiv(nyErAktiv);
            }
        }
    }

    public void redigerEmailAdresse(String bestemtSøgeNavn, String nyEmailAdresse) {
        for (Svømmer s : medlemmer) {
            if (s.getNavn().equalsIgnoreCase(bestemtSøgeNavn)) {
                s.setEmailAdresse(nyEmailAdresse);
            }
        }
    }

    public void redigerSvømmeDisciplin(String bestemtSøgeNavn, String nySvømmeDisciplin) {
        for (Svømmer s : medlemmer) {
            if (s.getNavn().equalsIgnoreCase(bestemtSøgeNavn)) {
                s.setSvømmeDisciplin(nySvømmeDisciplin);
            }
        }
    }

    public void redigerTelefonnummer(String bestemtSøgeNavn, int nytTelefonnummer) {
        for (Svømmer s : medlemmer) {
            if (s.getNavn().equalsIgnoreCase(bestemtSøgeNavn)) {
                s.setTelefonNummer(nytTelefonnummer);
            }
        }
    }
}