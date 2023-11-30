package data;

import domain.Svømmer;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Database {

    private FileHandler fh;

    private Svømmer sv;

    public Database() {
        sv = new Svømmer();
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

    public void tilføjSvømmer(String navn, int idNummer, String aldersGruppe, boolean erAktiv, Date alder, String adresse, String emailAdresse, int telefonNummer, String svømmeDisciplin) {
        medlemmer.add(new Svømmer(navn, idNummer, aldersGruppe, erAktiv, alder, adresse, emailAdresse, telefonNummer, svømmeDisciplin));
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
