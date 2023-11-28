import java.util.ArrayList;
import java.util.Date;

public class Controller {

    private Svømmer sv;

    public Controller() {
        sv = new Svømmer();

    }

    public void tilføjSvømmer(String navn, int idNummer, String aldersGruppe, boolean erAktiv, Date alder, String adresse, String emailAdresse, int telefonNummer, String svømmeDisciplin) {
        sv.tilføjSvømmer(navn, idNummer, aldersGruppe, erAktiv, alder, adresse, emailAdresse, telefonNummer, svømmeDisciplin);
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

    public Svømmer visMedlemID(int søgeID) {
        return sv.visMedlemID(søgeID);
    }

    public int getAlderIÅrstal(){
        return sv.getAlderIÅrstal();
    }

    public int getAlderIMåneder(){
        return sv.getAlderIMåneder();
    }

    public int getAlderIDage(){
        return sv.getAlderIDage();
    }


    public void ændreNavn(String bestemtSøgeNavn, String nytNavn) {
        sv.ændreNavn(bestemtSøgeNavn, nytNavn);
    }

    /*public void redigerAlder(String bestemtSøgeNavn, int nyAlder) {
        sv.redigerAlder(bestemtSøgeNavn, nyAlder);
    }*/

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

    public int getBedsteResultatCrawl(){
        return sv.getBedsteResultatCrawl();
    }

    public int getBedsteResultatRygCrawl(){
        return sv.getBedsteResultatRygCrawl();
    }

    public int getBedsteResultatBrystSvømning(){
        return sv.getBedsteResultatBrystSvømning();
    }

    public int getBedsteResultatButterfly(){
        return sv.getBedsteResultatButterfly();
    }

    public String getBedsteResultatCrawlDato(){
        return sv.getBedsteResultatCrawlDato();
    }

    public String getBedsteResultatRygCrawlDato(){
        return sv.getBedsteResultatRygCrawlDato();
    }

    public String getBedsteResultatBrystSvømningDato(){
        return sv.getBedsteResultatBrystSvømningDato();
    }

    public String getBedsteResultatButterflyDato(){
        return sv.getBedsteResultatButterflyDato();
    }


    public void setBedsteResultatCrawl( int bedsteResultatCrawl){
        sv.setBedsteResultatCrawl(bedsteResultatCrawl);
    }

    public void setBedsteResultatRygCrawl(int bedsteResultatRygCrawl){
        sv.setBedsteResultatRygCrawl(bedsteResultatRygCrawl);
    }

    public void setBedsteResultatBrystSvømning(int bedsteResultatBrystSvømning){
        sv.setBedsteResultatBrystSvømning(bedsteResultatBrystSvømning);
    }

    public void setBedsteResultatButterfly(int bedsteResultatButterfly){
        sv.setBedsteResultatButterfly(bedsteResultatButterfly);
    }

    public void setBedsteResultatCrawlDato(String bedsteResultatCrawlDato){
        sv.setBedsteResultatCrawlDato(bedsteResultatCrawlDato);
    }

    public void setBedsteResultatRygCrawlDato(String bedsteResultatRygCrawlDato){
        sv.setBedsteResultatRygCrawlDato(bedsteResultatRygCrawlDato);
    }

    public void setBedsteResultatBrystSvømningDato(String bedsteResultatBrystSvømningDato){
        sv.setBedsteResultatBrystSvømningDato(bedsteResultatBrystSvømningDato);
    }

    public void setBedsteResultatButterflyDato(String bedsteResultatButterflyDato){
        sv.setBedsteResultatButterflyDato(bedsteResultatButterflyDato);
    }

    public int skabIDNummer(){
        return sv.skabIDNummer();
    }
}


