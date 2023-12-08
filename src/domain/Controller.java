package domain;

import data.Database;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import domain.Stævne;

public class Controller {

    private Database db;
    private Stævne st;

    public Controller() {
        db = new Database();


    }

    public void tilføjSvømmer(String navn, int idNummer, String aldersGruppe, boolean erAktiv, boolean erKonkurrenceSvømmer, Date alder, String adresse, String emailAdresse, int telefonNummer, String svømmeDisciplin, double betaltBeløb) {
        db.tilføjSvømmer(navn, idNummer, aldersGruppe, erAktiv, erKonkurrenceSvømmer, alder, adresse, emailAdresse, telefonNummer, svømmeDisciplin, betaltBeløb);
    }

    public ArrayList visMedlemmer() {
        return db.visMedlemmer();
    }

    public ArrayList bedsteStævneResultater(String disciplin, String aldersGruppe){
        return db.bedsteStævneResultater(disciplin, aldersGruppe);
    }

    public ArrayList visStævneResultater(String disciplin){
        return db.visStævneResultater(disciplin);
    }

    public void gemSvømmmere() {
        db.gemSvømmere(db.visMedlemmer());
    }

    public void gemResultater() {
        db.gemResultater(db.visMedlemmer());
    }

    public void tilføjGemteMedlemmer() {
        db.tilføjGemteMedlemmer(db.visMedlemmer());
    }

    public void tilføjGemteResultater(){
        db.tilføjGemteResultater(db.visMedlemmer());
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

    public double beregnMedlemsRestance(String bestemSøgeNavn){
        return db.beregnMedlemsRestance(bestemSøgeNavn);
    }

    public double betaltKontingentIAlt(){
        return db.betaltKontingentIAlt();
    }


    public void ændreNavn(String bestemtSøgeNavn, String nytNavn) {
        db.ændreNavn(bestemtSøgeNavn, nytNavn);
    }


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


    public double beregnSamletKontingent(){
        return db.beregnSamletKontingent();
    }

    public int skabIDNummer(){
        return db.skabIDNummer();
    }
}


