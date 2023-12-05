package domain;

import java.util.ArrayList;
import java.util.Collections;
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
    private ArrayList<Stævne> stævner = new ArrayList<Stævne>();
    private ArrayList<Integer> stævneResultater = new ArrayList<>();
    private boolean erKonkurrenceSvømmer = false;
    private double betaltBeløb;


    public Svømmer(String navn, int idNummer, String aldersGruppe, boolean erAktiv, boolean erKonkurrenceSvømmer, Date alder, String adresse, String emailAdresse, int telefonNummer, String svømmeDisciplin, double betaltBeløb) {
        this.navn = navn;
        this.idNummer = idNummer;
        this.aldersGruppe = aldersGruppe;
        this.erAktiv = erAktiv;
        this.erKonkurrenceSvømmer = erKonkurrenceSvømmer;
        this.adresse = adresse;
        this.alder = alder;
        this.emailAdresse = emailAdresse;
        this.telefonNummer = telefonNummer;
        this.svømmeDisciplin = svømmeDisciplin;
        this.betaltBeløb = betaltBeløb;

    }

    public Svømmer(String navn, int idNummer, String aldersGruppe, boolean erAktiv, boolean erKonkurrenceSvømmer, Date alder, String adresse, String emailAdresse, int telefonNummer, String svømmeDisciplin, int bedsteResultatCrawl, int bedsteResultatRygCrawl, int bedsteResultatBrystSvømning, int bedsteResultatButterfly, String bedsteResultatCrawlDato, String bedsteResultatRygCrawlDato, String bedsteResultatBrystSvømningDato, String bedsteResultatButterflyDato, double betaltBeløb) {
        this.navn = navn;
        this.idNummer = idNummer;
        this.aldersGruppe = aldersGruppe;
        this.erAktiv = erAktiv;
        this.erKonkurrenceSvømmer = erKonkurrenceSvømmer;
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
        this.betaltBeløb = betaltBeløb;

    }

    public Svømmer() {

    }

    public void tilføjStævne(String navn, String dato, int resultat, String disciplin){
        stævner.add(new Stævne(navn, dato, resultat, disciplin));
    }

    public ArrayList<Stævne> visStævner(){
        return stævner;
    }

    public void sorterStævneResultat() {

        for (Stævne t : stævner) {
            stævneResultater.add(t.getResultat());
        }

    }

    public int visStævneResultat() {
        Collections.sort(stævneResultater);
        for (Integer i : stævneResultater) {
            return i;
        }
        return 0;
    }


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

    public boolean isErKonkurrenceSvømmer(){
        return erKonkurrenceSvømmer;
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

    public int getIDNummer(){
        return idNummer;
    }

    public double getBetaltBeløb(){
        return betaltBeløb;
    }

    public void setBetaltBeløb(double betaltBeløb){
        this.betaltBeløb=betaltBeløb;
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
    
}