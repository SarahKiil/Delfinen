import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class FileHandler {

    File f = new File("SvømmerDatabase.txt");


    public void gemSvømmere(ArrayList<Svømmer> a) {

        PrintStream output = null;
        try {
            output = new PrintStream(f);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        for (Svømmer s : a) {
            output.println(s.getNavn() + "," +
                    s.getIDNummer() + "," +
                    s.getAldersGruppe() + "," +
                    s.isErAktiv() + "," +
                    s.getAlder() + "," +
                    s.getAdresse() + "," +
                    s.getEmailAdresse() + "," +
                    s.getTelefonNummer()+"," +s.getSvømmeDisciplin() + "," +
                    s.getBedsteResultatCrawl() + "," +
                            s.getBedsteResultatRygCrawl() + "," +
                    s.getBedsteResultatBrystSvømning() + "," +
                    s.getBedsteResultatButterfly() + "," +
                    s.getBedsteResultatCrawlDato() + "," +
                    s.getBedsteResultatRygCrawlDato() + "," +
                    s.getBedsteResultatBrystSvømningDato() + "," +
                    s.getBedsteResultatButterflyDato()

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

            int alderIÅrstal = Integer.parseInt(attributter[4]);
            int alderIMåneder = Integer.parseInt(attributter[5]);
            int alderIDage = Integer.parseInt(attributter[6]);


            int telefonNummer = Integer.parseInt(attributter[9]);
            int crawl = Integer.parseInt(attributter[11]);
            int rygCrawl = Integer.parseInt(attributter[12]);
            int brystSvømning = Integer.parseInt(attributter[13]);
            int butterfly = Integer.parseInt(attributter[14]);
            int idNummer = Integer.parseInt(attributter[1]);

            Date dagsDato = new Date();
            Date alder = new Date((alderIÅrstal-1900)+(alderIMåneder-1)+alderIDage);
            long forskelIÅr = Math.abs(dagsDato.getYear()-alder.getYear());
            String aldersGruppe = "Junior";
            if (forskelIÅr > 17) {
                aldersGruppe = "Senior";
            }
            a.add(new Svømmer(attributter[0], idNummer, attributter[2], erAktiv, alder, attributter[7], attributter[8], telefonNummer, attributter[9], crawl, rygCrawl, brystSvømning, butterfly, attributter[15], attributter[16], attributter[17], attributter[18]));

        }

    }
}

