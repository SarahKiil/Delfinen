import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
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
            output.println(s.getNavn().replace(' ', '@') + "," +
                    s.getAldersGruppe().replace(' ', '@') + "," +
                    s.isErAktiv() + "," +
                    s.getAlder() + "," +
                    s.getAdresse().replace(' ', '@') + "," +
                    s.getEmailAdresse().replace(' ', '@') + "," +
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
            String linje = sc.next();
            String[] attributter = linje.replace('@', ' ').split(",");

            boolean erAktiv = true;
            if (attributter[2] == "true") {
                erAktiv = true;
            } else if (attributter[2]=="false") {
                erAktiv = false;
                
            }

            int alder = Integer.parseInt(attributter[3]);

            int telefonNummer = Integer.parseInt(attributter[6]);
            int crawl = Integer.parseInt(attributter[8]);
            int rygCrawl = Integer.parseInt(attributter[9]);
            int brystSvømning = Integer.parseInt(attributter[10]);
            int butterfly = Integer.parseInt(attributter[11]);
            a.add(new Svømmer(attributter[0], attributter[1], erAktiv, alder, attributter[4], attributter[5], telefonNummer, attributter[7], crawl, rygCrawl, brystSvømning, butterfly, attributter[12], attributter[13], attributter[14], attributter[15]));

        }

    }
}

