import java.util.ArrayList;
import java.util.Random;
import java.util.Date;

public class Svømmer {
    private String navn;
    private int idNummer;
    private String aldersGruppe;
    private boolean erAktiv;
    private Date alder;
    private String adresse;
    private String emailAdresse;
    private int telefonNummer;
    private String svømmeDisciplin;
    private int bedsteResultatCrawl = 0;
    private int bedsteResultatRygCrawl = 0;
    private int bedsteResultatBrystSvømning = 0;
    private int bedsteResultatButterfly = 0;
    private String bedsteResultatCrawlDato = "Intet";
    private String bedsteResultatRygCrawlDato = "Intet";
    private String bedsteResultatBrystSvømningDato = "Intet";
    private String bedsteResultatButterflyDato = "Intet";

    FileHandler fh;


    public Svømmer(String navn, int idNummer, String aldersGruppe, boolean erAktiv, Date alder, String adresse, String emailAdresse, int telefonNummer, String svømmeDisciplin) {
        this.navn = navn;
        this.idNummer = idNummer;
        this.aldersGruppe = aldersGruppe;
        this.erAktiv = erAktiv;
        this.adresse = adresse;
        this.alder = alder;
        this.emailAdresse = emailAdresse;
        this.telefonNummer = telefonNummer;
        this.svømmeDisciplin = svømmeDisciplin;

    }

    public Svømmer(String navn, int idNummer, String aldersGruppe, boolean erAktiv, Date alder, String adresse, String emailAdresse, int telefonNummer, String svømmeDisciplin, int bedsteResultatCrawl, int bedsteResultatRygCrawl, int bedsteResultatBrystSvømning, int bedsteResultatButterfly, String bedsteResultatCrawlDato, String bedsteResultatRygCrawlDato, String bedsteResultatBrystSvømningDato, String bedsteResultatButterflyDatoytr) {
        this.navn = navn;
        this.idNummer = idNummer;
        this.aldersGruppe = aldersGruppe;
        this.erAktiv = erAktiv;
        this.alder = alder;
        this.adresse = adresse;
        this.emailAdresse = emailAdresse;
        this.telefonNummer = telefonNummer;
        this.svømmeDisciplin = svømmeDisciplin;
        this.bedsteResultatCrawl = bedsteResultatCrawl;
        this.bedsteResultatRygCrawl = bedsteResultatRygCrawl;
        this.bedsteResultatBrystSvømning = bedsteResultatBrystSvømning;
        this.bedsteResultatButterfly = bedsteResultatButterfly;
        this.bedsteResultatCrawlDato = bedsteResultatCrawlDato;
        this.bedsteResultatRygCrawlDato = bedsteResultatRygCrawlDato;
        this.bedsteResultatBrystSvømningDato = bedsteResultatBrystSvømningDato;
        this.bedsteResultatButterflyDato = bedsteResultatButterflyDato;

    }

    public Svømmer() {
        fh = new FileHandler();
    }

    private ArrayList<Svømmer> medlemmer = new ArrayList<Svømmer>();

    public int getAlderIÅrstal(){
        return alder.getYear();
    }

    public int getAlderIMåneder(){
        return alder.getMonth();
    }

    public int getAlderIDage(){
        return alder.getDate();
    }
    public int getBedsteResultatCrawl() {
        return bedsteResultatCrawl;
    }

    public void setBedsteResultatCrawl(int bedsteResultatCrawl) {
        this.bedsteResultatCrawl = bedsteResultatCrawl;
    }

    public int getBedsteResultatRygCrawl() {
        return bedsteResultatRygCrawl;
    }

    public void setBedsteResultatRygCrawl(int bedsteResultatRygCrawl) {
        this.bedsteResultatRygCrawl = bedsteResultatRygCrawl;
    }

    public int getBedsteResultatBrystSvømning() {
        return bedsteResultatBrystSvømning;
    }

    public void setBedsteResultatBrystSvømning(int bedsteResultatBrystSvømning) {
        this.bedsteResultatBrystSvømning = bedsteResultatBrystSvømning;
    }

    public int getBedsteResultatButterfly() {
        return bedsteResultatButterfly;
    }

    public void setBedsteResultatButterfly(int bedsteResultatButterfly) {
        this.bedsteResultatButterfly = bedsteResultatButterfly;
    }

    public String getBedsteResultatCrawlDato() {
        return bedsteResultatCrawlDato;
    }

    public void setBedsteResultatCrawlDato(String bedsteResultatCrawlDato) {
        this.bedsteResultatCrawlDato = bedsteResultatCrawlDato;
    }

    public String getBedsteResultatRygCrawlDato() {
        return bedsteResultatRygCrawlDato;
    }

    public void setBedsteResultatRygCrawlDato(String bedsteResultatRygCrawlDato) {
        this.bedsteResultatRygCrawlDato = bedsteResultatRygCrawlDato;
    }

    public String getBedsteResultatBrystSvømningDato() {
        return bedsteResultatBrystSvømningDato;
    }

    public void setBedsteResultatBrystSvømningDato(String bedsteResultatBrystSvømningDato) {
        this.bedsteResultatBrystSvømningDato = bedsteResultatBrystSvømningDato;
    }

    public String getBedsteResultatButterflyDato() {
        return bedsteResultatButterflyDato;
    }

    public void setBedsteResultatButterflyDato(String bedsteResultatButterflyDato) {
        this.bedsteResultatButterflyDato = bedsteResultatButterflyDato;
    }



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

    public Svømmer visMedlemID(int søgeID) {
        for (Svømmer s : medlemmer) {
            if (s.getIDNummer() == søgeID) {
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

    public Date getAlder() {
        return alder;
    }

    public void setAlder(Date alder) {
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

    public int getIDNummer(){
        return idNummer;
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
                " ID: " + idNummer + '\'' +
                ", aldersgruppen svømmeren tilhører: " + aldersGruppe + '\'' +
                ", er medlemmet aktivt? " + erAktiv +

                ", medlemmets fødselsdagsdato: " + getAlderIDage() + ". " + getAlderIMåneder() + ". " + getAlderIÅrstal() +
                ", medlemmets adresse: " + adresse + '\'' +
                ", medlemmets emailadresse: " + emailAdresse + '\'' +
                ", telefonnummer: " + telefonNummer;
    }


    public void tilføjSvømmer(String navn, int idNummer, String aldersGruppe, boolean erAktiv, Date alder, String adresse, String emailAdresse, int telefonNummer, String svømmeDisciplin) {
        medlemmer.add(new Svømmer(navn, idNummer, aldersGruppe, erAktiv, alder, adresse, emailAdresse, telefonNummer, svømmeDisciplin));
    }

    /*public void redigerAlder(String bestemtSøgeNavn, int nyAlder) {
        for (Svømmer s : medlemmer) {
            if (s.getNavn().equalsIgnoreCase(bestemtSøgeNavn)) {
                s.setAlder(nyAlder);
            }
            if (nyAlder == 18){
                s.setAldersGruppe("Senior");
            }
        }
    }*/

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

    public int skabIDNummer() {
        Random random = new Random();
        int nytIDNummer = random.nextInt(10000000);
        for (Svømmer s : medlemmer)
            while (nytIDNummer==s.getIDNummer()){
                nytIDNummer = random.nextInt(10000000);
            }
        return nytIDNummer;
    }
}