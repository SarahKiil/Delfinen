package domain;

import data.Database;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;

public class Controller {

    private Database db;

    public Controller() {
        db = new Database();

    }

    public void tilføjSvømmer(String navn, int idNummer, String aldersGruppe, boolean erAktiv, Date alder, String adresse, String emailAdresse, int telefonNummer, String svømmeDisciplin) {
        db.tilføjSvømmer(navn, idNummer, aldersGruppe, erAktiv, alder, adresse, emailAdresse, telefonNummer, svømmeDisciplin);
    }

    public ArrayList visMedlemmer() {
        return db.visMedlemmer();
    }

    public void gemSvømmmere() {
        db.gemSvømmere(db.visMedlemmer());
    }

    public void tilføjGemteMedlemmer() {
        db.tilføjGemteMedlemmer(db.visMedlemmer());
    }

    public String søgMedlem(String søgeNavn) {
        return db.søgMedlem(søgeNavn);
    }

    public Svømmer visMedlem(String bestemtSøgeNavn) {
        return db.visMedlem(bestemtSøgeNavn);
    }

    public Svømmer visMedlemID(int søgeID) {
        return db.visMedlemID(søgeID);
    }

    /*public int getAlderIÅrstal(){
        return db.getAlderIÅrstal();
    }

    public int getAlderIMåneder(){
        return db.getAlderIMåneder();
    }*/

   /* public int getAlderIDage(){
        return db.getAlderIDage();
    }*/


    public void ændreNavn(String bestemtSøgeNavn, String nytNavn) {
        db.ændreNavn(bestemtSøgeNavn, nytNavn);
    }

    /*public void redigerAlder(String bestemtSøgeNavn, int nyAlder) {
        sv.redigerAlder(bestemtSøgeNavn, nyAlder);
    }*/

    public void redigerAdresse(String bestemtSøgeNavn, String nyAdresse) {
        db.redigerAdresse(bestemtSøgeNavn, nyAdresse);
    }

    public void redigerEmailAdresse(String bestemtSøgeNavn, String nyEmailAdresse) {
        db.redigerEmailAdresse(bestemtSøgeNavn, nyEmailAdresse);
    }

    public void redigerErAktiv(String bestemtSøgeNavn, boolean nyErAktiv) {
        db.redigerErAktiv(bestemtSøgeNavn, nyErAktiv);
    }

    public void redigerSvømmeDisciplin(String bestemtSøgeNavn, String nySvømmeDisciplin){
        db.redigerSvømmeDisciplin(bestemtSøgeNavn, nySvømmeDisciplin);
    }

    public void redigerTelefonnummer(String bestemtSøgeNavn, int nytTelefonnummer){
        db.redigerTelefonnummer(bestemtSøgeNavn, nytTelefonnummer);
    }

   /* public int getBedsteResultatCrawl(){
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
    }*/

    public int skabIDNummer(){
        return db.skabIDNummer();
    }
}


