package data;
import domain.Stævne;
import domain.Svømmer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class FileHandler {

    File f = new File("SvømmerDatabase.txt");
    File fi = new File("ResultatDatabase.txt");


    public void gemSvømmere(ArrayList<Svømmer> a) {

        PrintStream output = null;
        try {
            output = new PrintStream(f);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        for (Svømmer s : a) {
            for (Stævne t : s.visStævner())
                output.println(s.getNavn() + "," +
                        s.getIDNummer() + "," +
                        s.getAldersGruppe() + "," +
                        s.isErAktiv() + "," +
                        s.isErKonkurrenceSvømmer() + "," +
                        s.getAlderIÅrstal() + "," +
                        s.getAlderIMåneder() + "," +
                        s.getAlderIDage() + "," +
                        s.getAdresse() + "," +
                        s.getEmailAdresse() + "," +
                        s.getTelefonNummer() + "," +
                        s.getSvømmeDisciplin() + "," +
                        s.getBedsteResultatCrawl() + "," +
                        s.getBedsteResultatRygCrawl() + "," +
                        s.getBedsteResultatBrystSvømning() + "," +
                        s.getBedsteResultatButterfly() + "," +
                        s.getBedsteResultatCrawlDato() + "," +
                        s.getBedsteResultatRygCrawlDato() + "," +
                        s.getBedsteResultatBrystSvømningDato() + "," +
                        s.getBedsteResultatButterflyDato() + "," +
                        t.getNavn() + "," +
                        t.getDato() + "," +
                        t.getResultat() + "," +
                        t.getDisciplin()

                    );
        }
        output.close();
    }


    public void addGemteMedlemmer(ArrayList<Svømmer> a) {

        Scanner sc = null;
        try {
            sc = new Scanner(f);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (sc.hasNext()) {
            String linje = sc.nextLine();
            String[] attributter = linje.split(",");

            boolean erAktiv = true;
            if (attributter[3] == "true") {
                erAktiv = true;
            } else if (attributter[3]=="false") {
                erAktiv = false;
                
            }

            boolean erKonkurrenceSvømmer = true;
            if (attributter[4] == "true") {
                erKonkurrenceSvømmer = true;
            } else if (attributter[4] == "false") {
                erKonkurrenceSvømmer = false;

            }

            int alderIÅrstal = Integer.parseInt(attributter[5]);
            int alderIMåneder = Integer.parseInt(attributter[6]);
            int alderIDage = Integer.parseInt(attributter[7]);


            int telefonNummer = Integer.parseInt(attributter[10]);
            int crawl = Integer.parseInt(attributter[12]);
            int rygCrawl = Integer.parseInt(attributter[13]);
            int brystSvømning = Integer.parseInt(attributter[14]);
            int butterfly = Integer.parseInt(attributter[15]);
            int idNummer = Integer.parseInt(attributter[1]);

            Date dagsDato = new Date();
            Date alder = new Date(alderIÅrstal,alderIMåneder,alderIDage);
            int forskelIÅr = (dagsDato.getYear()+1900)-alder.getYear();
            String aldersGruppe = "Junior";
            if (forskelIÅr > 19) {
                aldersGruppe = "Senior";
            }
            if (forskelIÅr == 18 && (dagsDato.getMonth()+1) < alder.getMonth()) {
                aldersGruppe = "Senior";
            }
            if (forskelIÅr == 18 && (dagsDato.getMonth()+1) < alder.getMonth() && dagsDato.getDate() <= alder.getDate()) {
                aldersGruppe = "Senior";
            }


            a.add(new Svømmer(attributter[0], idNummer, aldersGruppe,erKonkurrenceSvømmer, erAktiv, alder, attributter[7], attributter[8], telefonNummer, attributter[10], crawl, rygCrawl, brystSvømning, butterfly, attributter[15], attributter[16], attributter[17], attributter[18]));

        }

    }

    public void gemResultater(ArrayList<Svømmer> a) {

        PrintStream output = null;
        try {
            output = new PrintStream(fi);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        for (Svømmer s : a) {
            for (Stævne t : s.visStævner())
                output.println(
                        s.getIDNummer() + "," +
                                t.getNavn() + "," +
                                t.getDato() + "," +
                                t.getResultat() + "," +
                                t.getDisciplin()

                );
        }
        output.close();
    }

    public void addGemteResultater(ArrayList<Svømmer> a) {

        Scanner sc = null;
        try {
            sc = new Scanner(fi);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (sc.hasNext()) {
            String linje = sc.nextLine();
            String[] attributter = linje.split(",");
            int idCheck = Integer.parseInt(attributter[0]);
            int tid = Integer.parseInt(attributter[3]);
            for (Svømmer s : a) {
                if (idCheck == s.getIDNummer()) {
                    s.tilføjStævne(attributter[1], attributter[2], tid, attributter[4]);
                }
            }
        }
    }
}