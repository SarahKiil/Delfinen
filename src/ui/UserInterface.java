package ui;

import domain.Controller;


import java.util.Scanner;
import java.util.Date;

public class UserInterface {
    private boolean ændret = false;
    private Controller controller;
    Scanner keyboard = new Scanner(System.in);
    private boolean kørProgrammet = true;

    public void startProgram() {
        controller = new Controller();
        controller.tilføjGemteMedlemmer();
        controller.tilføjGemteResultater();
        while (kørProgrammet) {
            menu();
        }
    }

    char menuValg = 0;

    private void menu() {
        do {
            System.out.println("Delfinens digitale administrative system. Tryk på et tal for at vælge et menupunkt: 🐬🌊🐬");
            System.out.println("1. Opret et nyt medlem.");
            System.out.println("2. Vis registrede medlemmer.");
            System.out.println("3. Ændre informationer om eksisterende medlem.");
            System.out.println("4. Gem de ændrede data.");
            System.out.println("5. Vis træningsresultater.");
            System.out.println("6. Indtast nye træningsresultater.");
            System.out.println("7. Stævne menu.");
            System.out.println("8. Kontingent menu.");
            System.out.println("9. Luk programmet.");
            if (!keyboard.hasNextInt()) {
                String text = keyboard.next();
                System.out.println(text + " er ikke et gyldigt tal. Prøv igen.");

            }
            menuValg = keyboard.next().charAt(0);

            switch (menuValg) {
                case '1':
                    tilføjSvømmer();
                    break;
                case '2':
                    søgPåEnSvømmer();
                    break;
                case '3':
                    redigerEtMedlem();
                    break;
                case '4':
                    gemSvømmere();
                    break;
                case '5':
                    visTræningsResultat();
                    break;
                case '6':
                    indtastTræningsResultat();
                    break;
                case '7':
                    stævneMenu();
                    break;
                case '8':
                    kontingentMenu();
                    break;
                case '9':
                    lukProgrammet();
                    break;
            }
        } while (menuValg != '9');
    }


    private void gemSvømmere() {
        System.out.println("Dine ændringer er nu gemt!");
        controller.gemSvømmmere();
        controller.gemResultater();
    }

    private void visTræningsResultat() {
        if (controller.visMedlemmer().size() == 0) {
            System.out.println("Der er ingen medlemmer i systemet.");

        }
        System.out.println("Søg efter et medlem du vil se resultater for:");
        String søgeNavn = keyboard.next();

        if (controller.søgMedlem(søgeNavn) == null) {
            System.out.println("Medlemmet kunne ikke findes!");

        }
        System.out.println("Matchende medlemmer fundet: " + controller.søgMedlem(søgeNavn));
        System.out.println("Skriv navnet på det medlem, du vil se resultater for:");
        keyboard.nextLine();
        String bestemtSøgeNavn = keyboard.nextLine();
        System.out.println(controller.visMedlem(bestemtSøgeNavn));
        if (controller.visMedlem(bestemtSøgeNavn) == null) {
            System.out.println("Medlemmet kunne ikke findes.");

        }

        System.out.println("Hvilken træningsdisciplin vil du se den bedste tid i?");
        System.out.println("1. Crawl");
        System.out.println("2. Rygcrawl");
        System.out.println("3. Brystsvømning");
        System.out.println("4. Butterfly");
        if (!keyboard.hasNextInt()) {
            String text = keyboard.next();
            System.out.println(text + " er ikke et gyldigt tal. Prøv igen.");
            visTræningsResultat();
        }
        char brugerValg = keyboard.next().charAt(0);


        switch (brugerValg) {
            case '1':
                if (controller.visMedlem(bestemtSøgeNavn).getBedsteResultatCrawl() == 0) {
                    System.out.println("Svømmeren har ingen resultater for denne disciplin");
                    System.out.println("Tryk på enter for at gå tilbage til menuen.");
                    keyboard.nextLine();
                    keyboard.nextLine();
                }
                else if (controller.visMedlem(bestemtSøgeNavn).getBedsteResultatCrawl() > 0) {
                System.out.println(bestemtSøgeNavn + " bedste resultat i crawl er " + controller.visMedlem(bestemtSøgeNavn).getBedsteResultatCrawl() + " sekunder, opnået den " + controller.visMedlem(bestemtSøgeNavn).getBedsteResultatCrawlDato());
                System.out.println("Tryk på enter for at gå tilbage til menuen.");
                keyboard.nextLine();
                keyboard.nextLine();}
                break;

            case '2':
                if (controller.visMedlem(bestemtSøgeNavn).getBedsteResultatRygCrawl() == 0) {
                    System.out.println("Svømmeren har ingen resultater for denne disciplin");
                    System.out.println("Tryk på enter for at gå tilbage til menuen.");
                    keyboard.nextLine();
                    keyboard.nextLine();

                }
                else if (controller.visMedlem(bestemtSøgeNavn).getBedsteResultatCrawl() > 0){
                System.out.println(bestemtSøgeNavn + " bedste resultat i rygcrawl er " + controller.visMedlem(bestemtSøgeNavn).getBedsteResultatRygCrawl() + " sekunder, opnået den " + controller.visMedlem(bestemtSøgeNavn).getBedsteResultatRygCrawlDato());
                System.out.println("Tryk på enter for at gå tilbage til menuen.");
                keyboard.nextLine();
                keyboard.nextLine();}
                break;

            case '3':
                if (controller.visMedlem(bestemtSøgeNavn).getBedsteResultatBrystSvømning() == 0) {
                    System.out.println("Svømmeren har ingen resultater for denne disciplin");
                    System.out.println("Tryk på enter for at gå tilbage til menuen.");
                    keyboard.nextLine();
                    keyboard.nextLine();

                }
                else if (controller.visMedlem(bestemtSøgeNavn).getBedsteResultatBrystSvømning() > 0){
                System.out.println(bestemtSøgeNavn + " bedste resultat i brystsvømning er " + controller.visMedlem(bestemtSøgeNavn).getBedsteResultatBrystSvømning() + " sekunder, opnået den " + controller.visMedlem(bestemtSøgeNavn).getBedsteResultatBrystSvømningDato());
                System.out.println("Tryk på enter for at gå tilbage til menuen.");
                keyboard.nextLine();
                keyboard.nextLine();}
                break;

            case '4':
                if (controller.visMedlem(bestemtSøgeNavn).getBedsteResultatButterfly() == 0) {
                    System.out.println("Svømmeren har ingen resultater for denne disciplin");
                    System.out.println("Tryk på enter for at gå tilbage til menuen.");
                    keyboard.nextLine();
                    keyboard.nextLine();

                }
                else if (controller.visMedlem(bestemtSøgeNavn).getBedsteResultatButterfly() > 0){
                System.out.println(bestemtSøgeNavn + " bedste resultat i butterfly er " + controller.visMedlem(bestemtSøgeNavn).getBedsteResultatButterfly() + " sekunder, opnået den " + controller.visMedlem(bestemtSøgeNavn).getBedsteResultatButterflyDato());
                System.out.println("Tryk på enter for at gå tilbage til menuen.");
                keyboard.nextLine();
                keyboard.nextLine();}
                break;
        }

    }

    private void indtastTræningsResultat() {
        if (controller.visMedlemmer().size() == 0) {
            System.out.println("Der er ingen medlemmer i systemet.");

        }
        System.out.println("Søg efter et medlem du vil ændre resultaterne for for:");
        String søgeNavn = keyboard.next();

        if (controller.søgMedlem(søgeNavn) == null) {
            System.out.println("Medlemmet kunne ikke findes!");

        }
        System.out.println("Matchende medlemmer fundet: " + controller.søgMedlem(søgeNavn));
        System.out.println("Skriv navnet på det medlem, du vil se resultaterne for:");
        keyboard.nextLine();
        String bestemtSøgeNavn = keyboard.nextLine();
        System.out.println(controller.visMedlem(bestemtSøgeNavn));
        if (controller.visMedlem(bestemtSøgeNavn) == null) {
            System.out.println("Medlemmet kunne ikke findes.");

        }

        boolean svømmerCrawl = false;
        boolean svømmerRygCrawl = false;
        boolean svømmerBrystsvømning = false;
        boolean svømmerButterfly = false;

        if (controller.visMedlem(bestemtSøgeNavn).getSvømmeDisciplin().toLowerCase().contains("crawl")) {
            System.out.println("1. Crawl");
            svømmerCrawl = true;
        }
        if (controller.visMedlem(bestemtSøgeNavn).getSvømmeDisciplin().toLowerCase().contains("rygcrawl")) {
            System.out.println("2. Rygcrawl");
            svømmerRygCrawl = true;
        }
        if (controller.visMedlem(bestemtSøgeNavn).getSvømmeDisciplin().toLowerCase().contains("brystsvømning")) {
            System.out.println("3. Brystsvømning");
            svømmerBrystsvømning = true;
        }
        if (controller.visMedlem(bestemtSøgeNavn).getSvømmeDisciplin().toLowerCase().contains("butterfly")) {
            System.out.println("4. Butterfly");
            svømmerButterfly = true;
        }

        if (!svømmerButterfly && !svømmerBrystsvømning && !svømmerCrawl && !svømmerRygCrawl) {
            System.out.println("Denne svømmer er ikke aktiv i nogle træningsdiscipliner");
            System.out.println("Tryk på enter for at gå tilbage til menuen.");
            keyboard.nextLine();

        }

        System.out.println("Hvilken træningsdisciplin vil du indtaste resultat for");
        if (!keyboard.hasNextInt()) {
            String text = keyboard.next();
            System.out.println(text + " er ikke et gyldigt tal. Prøv igen.");
        }
        char brugerValg = keyboard.next().charAt(0);


        System.out.println("5. Gå tilbage til menuen.");
        switch (brugerValg) {
            case '1':
                if (svømmerCrawl) {
                    System.out.println("Hvad er det nye svømmeresultat i crawl(i sekunder)? ");
                    int nytResultat = keyboard.nextInt();
                    if (nytResultat < controller.visMedlem(bestemtSøgeNavn).getBedsteResultatCrawl()) {
                        controller.visMedlem(bestemtSøgeNavn).setBedsteResultatCrawl(nytResultat);
                    }
                    System.out.println("Hvad er datoen for det nye resultat? (d/m/å)");
                    String nytResultatDato = keyboard.next();
                    controller.visMedlem(bestemtSøgeNavn).setBedsteResultatCrawlDato(nytResultatDato);
                    System.out.println("Du har nu opdateret svømmeresultatet.");
                    System.out.println("Tryk på enter for at gå tilbage til menuen.");
                    keyboard.nextLine();

                } else if (!svømmerCrawl) {
                    System.out.println("Svømmeren er ikke aktiv i denne disciplin");

                }
                break;
            case '2':
                if (svømmerRygCrawl) {
                    System.out.println("Hvad er det nye svømmeresultat i rygcrawl(i sekunder)? ");
                    int nytResultat = keyboard.nextInt();
                    if (nytResultat < controller.visMedlem(bestemtSøgeNavn).getBedsteResultatRygCrawl()) {
                        controller.visMedlem(bestemtSøgeNavn).setBedsteResultatRygCrawl(nytResultat);
                    }
                    ;
                    System.out.println("Hvad er datoen for det nye resultat? (d/m/å)");
                    String nytResultatDato = keyboard.next();
                    controller.visMedlem(bestemtSøgeNavn).setBedsteResultatRygCrawlDato(nytResultatDato);
                    System.out.println("Du har nu opdateret svømmeresultatet.");
                    System.out.println("Tryk på enter for at gå tilbage til menuen.");
                    keyboard.nextLine();

                } else if (!svømmerRygCrawl) {
                    System.out.println("Svømmeren er ikke aktiv i denne disciplin");

                }
                break;
            case '3':
                if (svømmerBrystsvømning) {
                    System.out.println("Hvad er det nye svømmeresultat i brystsvømning(i sekunder)? ");
                    int nytResultat = keyboard.nextInt();
                    if (nytResultat < controller.visMedlem(bestemtSøgeNavn).getBedsteResultatBrystSvømning()) {
                        controller.visMedlem(bestemtSøgeNavn).setBedsteResultatBrystSvømning(nytResultat);
                    }
                    System.out.println("Hvad er datoen for det nye resultat? (d/m/å)");
                    String nytResultatDato = keyboard.next();
                    controller.visMedlem(bestemtSøgeNavn).setBedsteResultatBrystSvømningDato(nytResultatDato);
                    System.out.println("Du har nu opdateret svømmeresultatet.");
                    System.out.println("Tryk på enter for at gå tilbage til menuen.");
                    keyboard.nextLine();

                } else if (!svømmerBrystsvømning) {
                    System.out.println("Svømmeren er ikke aktiv i denne disciplin");

                }
                break;
            case '4':
                if (svømmerButterfly) {
                    System.out.println("Hvad er det nye svømmeresultat i butterfly (i sekunder)? ");
                    int nytResultat = keyboard.nextInt();
                    if (nytResultat < controller.visMedlem(bestemtSøgeNavn).getBedsteResultatButterfly()) {
                        controller.visMedlem(bestemtSøgeNavn).setBedsteResultatButterfly(nytResultat);
                    }
                    System.out.println("Hvad er datoen for det nye resultat? (d/m/å)");
                    String nytResultatDato = keyboard.next();
                    controller.visMedlem(bestemtSøgeNavn).setBedsteResultatButterflyDato(nytResultatDato);
                    System.out.println("Du har nu opdateret svømmeresultatet.");
                    System.out.println("Tryk på enter for at gå tilbage til menuen.");
                    keyboard.nextLine();

                } else if (!svømmerButterfly) {
                    System.out.println("Svømmeren er ikke aktiv i denne disciplin");

                }
                break;

        }
    }


    private void lukProgrammet() {
        if (ændret) {
            controller.gemSvømmmere();
        }
        System.out.println("Programmet lukkes og dine ændringer gemmes");
        kørProgrammet = false;
    }

    private void tilføjSvømmer() {
        System.out.println("Hvad er navnet på svømmeren?");
        keyboard.nextLine();
        String navn = keyboard.nextLine();

        System.out.println("Hvilket årstal er medlemmer født?");
        if (!keyboard.hasNextInt()) {
            String text = keyboard.next();
            System.out.println(text + " er ikke et gyldigt tal. Prøv igen.");
            tilføjSvømmer();
        }
        int alderÅrstal = keyboard.nextInt();
        System.out.println("Hvilken måned er medlemmet født (i tal)?");
        if (!keyboard.hasNextInt()) {
            String text = keyboard.next();
            System.out.println(text + " er ikke et gyldigt tal. Prøv igen.");
            tilføjSvømmer();
        }
        int alderMåned = keyboard.nextInt();
        System.out.println("Hvilken dag i måneden er medlemmet født?");
        if (!keyboard.hasNextInt()) {
            String text = keyboard.next();
            System.out.println(text + " er ikke et gyldigt tal. Prøv igen.");
            tilføjSvømmer();
        }
        int alderDag = keyboard.nextInt();
        System.out.println("Hvad er svømmerens adresse?");
        keyboard.nextLine();
        String adresse = keyboard.nextLine();
        System.out.println("Hvad er svømmerens emailadresse?");
        String emailAdresse = keyboard.nextLine();
        System.out.println("Hvad er svømmerens telefonnummer?");
        if (!keyboard.hasNextInt()) {
            String text = keyboard.next();
            System.out.println(text + " er ikke et gyldigt tal. Prøv igen.");
            tilføjSvømmer();
        }
        int telefonnummer = keyboard.nextInt();
        System.out.println("Er svømmeren en konkurrence svømmer?");
        System.out.println("1. Ja.");
        System.out.println("2. Nej.");
        char konkurrenceValg = keyboard.next().charAt(0);
        boolean erKonkurrenceSvømmer = false;
        if (konkurrenceValg == '1') {
            erKonkurrenceSvømmer = true;
        }
        System.out.println("Vælg hvilke discipliner du vil tilføje ved at skrive tallene(uden at bruge enter i mellem)");
        System.out.println("1. Crawl");
        System.out.println("2. Rygcrawl.");
        System.out.println("3. Butterfly");
        System.out.println("4. Brystsvømning");
        String svømmeDisciplin = "intet";
        String disciplinValg = keyboard.next();
        if (disciplinValg.contains("1") && disciplinValg.contains("2") && disciplinValg.contains("3") && disciplinValg.contains("4")) {
            svømmeDisciplin = "crawl; rygcrawl; butterfly og brystsvømning";
        }
        if (disciplinValg.contains("1") && disciplinValg.contains("3") && disciplinValg.contains("4")) {
            svømmeDisciplin = "crawl; rygcrawl; butterfly og brystsvømning";
        } else if (disciplinValg.contains("1") && disciplinValg.contains("2") && disciplinValg.contains("3")) {
            svømmeDisciplin = "crawl; brystsvømning og butterfly";
        } else if (disciplinValg.contains("1") && disciplinValg.contains("2") && disciplinValg.contains("4")) {
            svømmeDisciplin = "crawl; brystsvømning og brystsvømning";
        } else if (disciplinValg.contains("1") && disciplinValg.contains("3") && disciplinValg.contains("4")) {
            svømmeDisciplin = "crawl; butterfly og brystsvømning";
        } else if (disciplinValg.contains("2") && disciplinValg.contains("3") && disciplinValg.contains("4")) {
            svømmeDisciplin = "rygcrawl; brystsvømning og butterfly";
        } else if (disciplinValg.contains("3") && disciplinValg.contains("4")) {
            svømmeDisciplin = "butterfly og brystsvømning";
        } else if (disciplinValg.contains("1") && disciplinValg.contains("2")) {
            svømmeDisciplin = "crawl og rygcrawl";
        } else if (disciplinValg.contains("1") && disciplinValg.contains("3")) {
            svømmeDisciplin = "crawl og butterfly";
        } else if (disciplinValg.contains("1") && disciplinValg.contains("4")) {
            svømmeDisciplin = "crawl og brystsvømning";
        } else if (disciplinValg.contains("2") && disciplinValg.contains("3")) {
            svømmeDisciplin = "rygcrawl og butterfly";
        } else if (disciplinValg.contains("2") && disciplinValg.contains("4")) {
            svømmeDisciplin = "rygcrawl og brystsvømning";
        } else if (disciplinValg.contains("1")) {
            svømmeDisciplin = "crawl";
        } else if (disciplinValg.contains("2")) {
            svømmeDisciplin = "rygcrawl";
        } else if (disciplinValg.contains("3")) {
            svømmeDisciplin = "buttefly";
        } else if (disciplinValg.contains("4")) {
            svømmeDisciplin = "brystsvømning";
        }




        int idNummer = controller.skabIDNummer();


        Date dagsDato = new Date();
        Date alder = new Date(alderÅrstal, alderMåned, alderDag);
        int forskelIÅr = (dagsDato.getYear() + 1900) - alder.getYear();
        String aldersGruppe = "Junior";
        if (forskelIÅr > 19) {
            aldersGruppe = "Senior";
        }
        if (forskelIÅr == 18 && (dagsDato.getMonth() + 1) < alder.getMonth()) {
            aldersGruppe = "Senior";
        }
        if (forskelIÅr == 18 && (dagsDato.getMonth() + 1) < alder.getMonth() && dagsDato.getDate() <= alder.getDate()) {
            aldersGruppe = "Senior";
        }

        controller.tilføjSvømmer(navn, idNummer, aldersGruppe, true, erKonkurrenceSvømmer, alder, adresse, emailAdresse, telefonnummer, svømmeDisciplin, 0);
        controller.gemSvømmmere();
        System.out.println("Svømmeren er oprettet.");
        ændret = true;

        System.out.println("Tryk på enter for at gå tilbage til menuen.");
        keyboard.nextLine();


    }

    private void søgPåEnSvømmer() {
        if (controller.visMedlemmer().size() == 0) {
            System.out.println("Du har ikke registreret nogen medlemmer endnu.");
            tilføjSvømmer();
        }

        System.out.println("Vil du søge ved at bruge medlemmets navn eller medlems ID?");
        System.out.println("1. Navn.");
        System.out.println("2. ID.");
        if (!keyboard.hasNextInt()) {
            String text = keyboard.next();
            System.out.println(text + " er ikke et gyldigt tal. Prøv igen.");
            søgPåEnSvømmer();
        }
        char søgeValg = keyboard.next().charAt(0);
        if (søgeValg == '2') {
            søgViaID();
        }
        System.out.println("Skriv navnet på det medlem, du vil søge efter:");
        String søgeNavn = keyboard.next();
        System.out.println("Matchende medlemmer fundet:" + controller.søgMedlem(søgeNavn));
        System.out.println("Skriv navnet på det medlem, du vil se informationer om:");
        keyboard.nextLine();
        String bestemtSøgeNavn = keyboard.nextLine();
        if (controller.visMedlem(bestemtSøgeNavn) == null) {
            System.out.println("Kunne ikke finde: " + bestemtSøgeNavn);

        }
        System.out.println(controller.visMedlem(bestemtSøgeNavn));
        if (controller.visMedlem(bestemtSøgeNavn).isErKonkurrenceSvømmer() && controller.visMedlem(bestemtSøgeNavn).getAldersGruppe().contains("Junior")){
            System.out.println("Svømmerens træner er træner 1");
        }
        if (controller.visMedlem(bestemtSøgeNavn).isErKonkurrenceSvømmer() && controller.visMedlem(bestemtSøgeNavn).getAldersGruppe().contains("Senior")){
                System.out.println("Svømmerens træner er træner 2"); }
                System.out.println("Tryk på enter for at gå tilbage til menuen.");
        keyboard.nextLine();

    }

    private void søgViaID() {
        System.out.println("Hvad er medlemmets ID nummer?");
        int søgeID = keyboard.nextInt();
        System.out.println(controller.visMedlemID(søgeID));
        keyboard.nextLine();
        System.out.println("Tryk på enter for at gå tilbage til menuen.");
        keyboard.nextLine();

    }

    private void redigerEtMedlem() {
        if (controller.visMedlemmer().size() == 0) {
            System.out.println("Du har ikke nogle medlemmer endnu.");

        }
        System.out.println("Skriv navnet på det medlem, du vil søge efter:");
        String søgeNavn = keyboard.next();

        if (controller.søgMedlem(søgeNavn) == null) {
            System.out.println("Medlemmet kunne ikke findes.");

        }
        System.out.println("Matchende medlemmer fundet: " + controller.søgMedlem(søgeNavn));
        System.out.println("Skriv navnet på det medlem, du vil ændre på:");
        keyboard.nextLine();
        String bestemtSøgeNavn = keyboard.nextLine();
        System.out.println(controller.visMedlem(bestemtSøgeNavn));
        if (controller.visMedlem(bestemtSøgeNavn) == null) {
            System.out.println("Medlemmet kunne ikke findes.");

        }
        System.out.println("Hvad vil du ændre?");
        System.out.println("1. Medlemmets navn");
        System.out.println("2. Medlemmets aktivitetsstatus");
        System.out.println("3. Medlemmets adresse");
        System.out.println("4. Medlemmets emailadresse");
        System.out.println("5. Medlemmets telefonnummer");
        System.out.println("6. Medlemmets svømmedisciplin");
        System.out.println("7. Medlemmets konkurrencestatus");

        if (!keyboard.hasNextInt()) {
            String text = keyboard.next();
            System.out.println(text + " er ikke et gyldigt tal. Prøv igen.");
            redigerEtMedlem();
        }

        char redigerMedlem = keyboard.next().charAt(0);
        switch (redigerMedlem) {
            case '1':
                redigerNavn(bestemtSøgeNavn);
                break;
            case '2':
                redigerAktivitetsStatus(bestemtSøgeNavn);
                break;
            case '3':
                redigerAdresse(bestemtSøgeNavn);
                break;
            case '4':
                redigerEmailAdresse(bestemtSøgeNavn);
                break;
            case '5':
                redigerTelefonnummer(bestemtSøgeNavn);
                break;
            case '6':
                redigerSvømmeDisciplin(bestemtSøgeNavn);
                break;
            case '7':
                redigerKonkurrenceStatus(bestemtSøgeNavn);
                break;
        }

    }

    private void redigerKonkurrenceStatus(String bestemtSøgeNavn){
        System.out.println("Er medlemmet en konkurrencesvømmer?");
        System.out.println("1. Ja.");
        System.out.println("2. Nej.");
        char konkurrenceValg = keyboard.next().charAt(0);
        if (konkurrenceValg == '1'){
            controller.visMedlem(bestemtSøgeNavn).setErKonkurrenceSvømmer(true);
        }
        else if (konkurrenceValg == '2'){
            controller.visMedlem(bestemtSøgeNavn).setErKonkurrenceSvømmer(false);
        }
        ændret = true;

        System.out.println("Tryk på enter for at gå tilbage til menuen.");
        keyboard.nextLine();
    }

    private void redigerNavn(String bestemtSøgeNavn) {
        System.out.println("Hvad vil du ændre navnet til?");
        keyboard.nextLine();
        String nytNavn = keyboard.nextLine();
        System.out.println("Navnet er ændret!");
        controller.ændreNavn(bestemtSøgeNavn, nytNavn);
        System.out.println("Navnet er ændret!");
        bestemtSøgeNavn = nytNavn;
        System.out.println(controller.visMedlem(bestemtSøgeNavn));

        System.out.println("Tryk på enter for at gå tilbage til menuen.");
        keyboard.nextLine();

    }


    private void redigerAdresse(String bestemtSøgeNavn) {
        System.out.println("Hvad vil du ændre adressen til?");
        keyboard.nextLine();
        String nyAdresse = keyboard.nextLine();
        controller.redigerAdresse(bestemtSøgeNavn, nyAdresse);
        System.out.println("Adressen er ændret!");
        System.out.println(controller.visMedlem(bestemtSøgeNavn));

        ændret = true;
        System.out.println("Tryk på enter for at gå tilbage til menuen.");
        keyboard.nextLine();

    }

    private void redigerAktivitetsStatus(String bestemtSøgeNavn) {
        System.out.println("Er medlemmet stadig aktiv?");
        System.out.println("1. Ja");
        System.out.println("2. Nej");
        char erAktiv = keyboard.next().charAt(0);
        boolean nyErAktiv = true;

        if (erAktiv == '2') {
            nyErAktiv = false;
            controller.visMedlem(bestemtSøgeNavn).setErKonkurrenceSvømmer(false);
        }
        controller.redigerErAktiv(bestemtSøgeNavn, nyErAktiv);
        System.out.println("Aktivitetsstatus er ændret");
        System.out.println(controller.visMedlem(bestemtSøgeNavn));

        ændret = true;

        System.out.println("Tryk på enter for at gå tilbage til menuen.");
        keyboard.nextLine();


    }

    private void redigerEmailAdresse(String bestemtSøgeNavn) {
        System.out.println("Hvad vil du ændre emailadressen til?");
        keyboard.nextLine();
        String nyEmailAdresse = keyboard.nextLine();
        controller.redigerEmailAdresse(bestemtSøgeNavn, nyEmailAdresse);
        System.out.println("Emailadressen er ændret");
        System.out.println(controller.visMedlem(bestemtSøgeNavn));

        ændret = true;
        System.out.println("Tryk på enter for at gå tilbage til menuen.");
        keyboard.nextLine();


    }

    private void redigerTelefonnummer(String bestemtSøgeNavn) {
        System.out.println("Hvad vil du ændre telefonnummeret til?");
        if (!keyboard.hasNextInt()) {
            String text = keyboard.next();
            System.out.println(text + " er ikke et gyldigt tal. Prøv igen.");
            redigerTelefonnummer(bestemtSøgeNavn);
        }
        int nytTelefonnummer = keyboard.nextInt();
        controller.redigerTelefonnummer(bestemtSøgeNavn, nytTelefonnummer);
        System.out.println("Telefonnummeret er ændret!");
        System.out.println(controller.visMedlem(bestemtSøgeNavn));

        ændret = true;
        System.out.println("Tryk på enter for at gå tilbage til menuen.");
        keyboard.nextLine();
        keyboard.nextLine();


    }

    private void redigerSvømmeDisciplin(String bestemtSøgeNavn) {
        System.out.println("Hvad vil du ændre svømmedisciplinerne til?");
        keyboard.nextLine();
        String nySvømmeDisciplin = keyboard.nextLine();
        controller.redigerSvømmeDisciplin(bestemtSøgeNavn, nySvømmeDisciplin);
        System.out.println("Svømmedisciplinerne er ændret");
        System.out.println(controller.visMedlem(bestemtSøgeNavn));

        ændret = true;
        System.out.println("Tryk på enter for at gå tilbage til menuen.");
        keyboard.nextLine();

    }

    private void stævneMenu() {
        System.out.println("Vil du oprette et nyt stævne eller se stævne resultater?");
        System.out.println("1. Opret nyt stævne.");
        System.out.println("2. Se stævne resultat for bestemt person.");
        System.out.println("3. Se bedste resulter indenfor en disciplin.");
        char stævneValg = keyboard.next().charAt(0);
        if (stævneValg == '1') {
            System.out.println("Opretter nyt stævne.");
            System.out.println("Hvad er navnet på stævnet?");
            String stævneNavn = keyboard.next();
            System.out.println("Hvilken dato fandt stævnet sted?");
            String stævneDato = keyboard.next();
            System.out.println("Stævnet er oprettet. Tilføj nu en svømmer til stævnet.");

            if (controller.visMedlemmer().size() == 0) {
                System.out.println("Du har ikke registreret nogen medlemmer endnu.");
                tilføjSvømmer();
            }


           char valg = 2;
            do {
                System.out.println("Skriv navnet på det medlem, du vil søge efter:");
                String søgeNavn = keyboard.next();
                System.out.println("Matchende medlemmer fundet:" + controller.søgMedlem(søgeNavn));
                System.out.println("Skriv navnet på det medlem, der deltog i stævnet");
                keyboard.nextLine();
                String bestemtSøgeNavn = keyboard.nextLine();
                if (controller.visMedlem(bestemtSøgeNavn) == null) {
                    System.out.println("Kunne ikke finde: " + bestemtSøgeNavn);

                }
                if (controller.visMedlem(bestemtSøgeNavn).isErKonkurrenceSvømmer() == false){
                    System.out.println("Dette medlem er ikke en aktiv konkurrencesvømmer.");
                    menu();
                }
                System.out.println("Hvilken disciplin deltog svømmeren i?");
                String disciplin = keyboard.nextLine();
                System.out.println("Hvad var svømmerens resultat(i sekunder)?");
                int resultat = keyboard.nextInt();
                controller.visMedlem(bestemtSøgeNavn).tilføjStævne(stævneNavn, stævneDato, resultat, disciplin);
                System.out.println("Skal der tilføjes endnu en svømmer til stævnet?");
                System.out.println("1. Tilføj ekstra svømmer.");
                System.out.println("2. Gå tilbage til menu.");
                valg = keyboard.next().charAt(0);
            } while (valg != '2');
        } else if (stævneValg == '2') {
            System.out.println("Skriv navnet på det medlem, du vil søge efter:");
            String søgeNavn = keyboard.next();
            System.out.println("Matchende medlemmer fundet:" + controller.søgMedlem(søgeNavn));
            System.out.println("Skriv navnet på det medlem, du vil se stævne resultater for");
            keyboard.nextLine();
            String bestemtSøgeNavn = keyboard.nextLine();
            if (controller.visMedlem(bestemtSøgeNavn) == null) {
                System.out.println("Kunne ikke finde: " + bestemtSøgeNavn);

            }
            System.out.println("Svømmeren har deltaget i følgende stævner: " + controller.visMedlem(bestemtSøgeNavn).visStævner());

        } else if (stævneValg == '3') {
            System.out.println("Vil du se resultaterne for juniorer eller seniorer?");
            System.out.println("1. Junior");
            System.out.println("2. Senior");
            char alderValg = keyboard.next().charAt(0);
            String aldersGruppe = "Senior";
            if (alderValg == '1') {
                aldersGruppe = "Junior";
            }

            System.out.println("Hvilken disciplin vil du se resultater for?");
            System.out.println("1. Crawl");
            System.out.println("2. Rygcrawl");
            System.out.println("3. Butterfly");
            System.out.println("4. Brystsvømning");
            char disciplinValg = keyboard.next().charAt(0);
            String disciplin = "crawl";
            if (disciplinValg == '1') {
                disciplin = "crawl";
            }
            if (disciplinValg == '2') {
                disciplin = "Rygcrawl";
            }
            if (disciplinValg == '3') {
                disciplin = "Butterfly";
            }
            if (disciplinValg == '4') {
                disciplin = "Brystsvømning";
            }

            System.out.println(controller.bedsteStævneResultater(disciplin, aldersGruppe));
        }
    }

    private void kontingentMenu() {
        System.out.println("Hvad vil du se?");
        System.out.println("1. Se klubbens samlet beløb for kontingent.");
        System.out.println("2. Se et medlems betalte beløb og restance");
        System.out.println("3. Ændre beløb medlem har betalt");
        char kontingentValg = keyboard.next().charAt(0);
        if (kontingentValg == '1') {
            System.out.println("I alt er der blevet indbetalt " + controller.betaltKontingentIAlt() + " kroner.");
            System.out.println("Der vil blive indbetalt " + controller.beregnSamletKontingent() + " kroner i år.");
        } else if (kontingentValg == '2') {
            if (controller.visMedlemmer().size() == 0) {
                System.out.println("Du har ikke registreret nogen medlemmer endnu.");
                tilføjSvømmer();
            }

            System.out.println("Skriv navnet på det medlem, du vil søge efter:");
            String søgeNavn = keyboard.next();
            System.out.println("Matchende medlemmer fundet:" + controller.søgMedlem(søgeNavn));
            System.out.println("Skriv navnet på det medlem, du vil ændre kontingentbeløbet for:");
            keyboard.nextLine();
            String bestemtSøgeNavn = keyboard.nextLine();
            if (controller.visMedlem(bestemtSøgeNavn) == null) {
                System.out.println("Kunne ikke finde: " + bestemtSøgeNavn);
            }
            System.out.println("Medlemmet har betalt: " + controller.visMedlem(bestemtSøgeNavn).getBetaltBeløb() + " kroner.");
            System.out.println("Medlemmet mangler at betale " + controller.beregnMedlemsRestance(bestemtSøgeNavn));
            System.out.println("Tryk på enter for at gå tilbage til menuen.");
            keyboard.nextLine();
        } else if (kontingentValg == '3') {
            if (controller.visMedlemmer().size() == 0) {
                System.out.println("Du har ikke registreret nogen medlemmer endnu.");
            }

            System.out.println("Skriv navnet på det medlem, du vil søge efter:");
            String søgeNavn = keyboard.next();
            System.out.println("Matchende medlemmer fundet:" + controller.søgMedlem(søgeNavn));
            System.out.println("Skriv navnet på det medlem, du vil ændre kontingentbeløbet for:");
            keyboard.nextLine();
            String bestemtSøgeNavn = keyboard.nextLine();
            if (controller.visMedlem(bestemtSøgeNavn) == null) {
                System.out.println("Kunne ikke finde: " + bestemtSøgeNavn);
            }

            System.out.println("Hvor meget har denne person betalt i år?");
            double betaltBeløb = keyboard.nextDouble();
            controller.visMedlem(bestemtSøgeNavn).setBetaltBeløb(betaltBeløb);
            System.out.println("Det betalte kontingent er ændret.");
            System.out.println("Tryk på enter for at gå tilbage til menuen.");
            keyboard.nextLine();
            ændret = true;
        }
    }
}






