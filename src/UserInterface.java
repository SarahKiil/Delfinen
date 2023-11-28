import java.time.Period;
import java.util.Scanner;
import java.util.Date;
import java.time.LocalDate;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class UserInterface {
    private boolean ændret = false;
    private Svømmer sv;
    private Controller controller;
    Scanner keyboard = new Scanner(System.in);

    public void startProgram() {
        UserInterface m = new UserInterface();
        m.controller = new Controller();
        m.loadSvømmere();
    }

    private void loadSvømmere() {
        controller.tilføjGemteMedlemmer();
        menu();
    }

    private void menu() {
        System.out.println("Delfinens digitale administrative system. Tryk på et tal for at vælge et menupunkt:");
        System.out.println("1. Opret et nyt medlem.");
        System.out.println("2. Vis registrede medlemmer.");
        System.out.println("3. Ændre informationer om eksisterende medlem.");
        System.out.println("4. Gem de ændrede data.");
        System.out.println("5. Vis træningsresultater.");
        System.out.println("6. Indtast nye træningsresultater.");
        System.out.println("9. Luk programmet.");
        if (!keyboard.hasNextInt()) {
            String text = keyboard.next();
            System.out.println(text + " er ikke et gyldigt tal. Prøv igen.");
            menu();
        }
        char brugerValg = keyboard.next().charAt(0);

        switch (brugerValg) {
            case '1':
                tilføjSvømmer();
            case '2':
                søgPåEnSvømmer();
            case '3':
                redigerEtMedlem();
            case '4':
                gemSvømmere();
            case '5':
                visTræningsResultat();
            case '6':
                indtastTræningsResultat();
            case '9':
                lukProgrammet();

        }
        menu();
    }

    private void gemSvømmere() {
        System.out.println("Dine ændringer er nu gemt!");
        controller.gemSvømmmere();
        menu();
    }
    
    private void visTræningsResultat() {
        if (controller.visMedlemmer().size() == 0) {
            System.out.println("Der er ingen medlemmer i systemet.");
            menu();
        }
        System.out.println("Søg efter et medlem du vil se resultater for:");
        String søgeNavn = keyboard.next();

        if (controller.søgMedlem(søgeNavn) == null) {
            System.out.println("Medlemmet kunne ikke findes!");
            menu();

        }
        System.out.println("Matchende medlemmer fundet: " + controller.søgMedlem(søgeNavn));
        System.out.println("Skriv navnet på det medlem, du vil se resultater for:");
        keyboard.nextLine();
        String bestemtSøgeNavn = keyboard.nextLine();
        System.out.println(controller.visMedlem(bestemtSøgeNavn));
        if (controller.visMedlem(bestemtSøgeNavn) == null) {
            System.out.println("Medlemmet kunne ikke findes.");
            menu();
        }

        System.out.println("Hvilken træningsdisciplin vil du se den bedste tid i?");
        System.out.println("1. Crawl");
        System.out.println("2. Rygcrawl");
        System.out.println("3. Brystsvømning");
        System.out.println("4. Butterfly");
        System.out.println("5. Gå tilbage til menuen.");
        if (!keyboard.hasNextInt()) {
            String text = keyboard.next();
            System.out.println(text + " er ikke et gyldigt tal. Prøv igen.");
            visTræningsResultat();
        }
        char brugerValg = keyboard.next().charAt(0);

        
        switch (brugerValg) {
            case '1':
                if (controller.visMedlem(bestemtSøgeNavn).getBedsteResultatCrawl()==0){
                    System.out.println("Svømmer har ingen resultater for denne disciplin");
                    System.out.println("Tryk på enter for at gå tilbage til menuen.");
                    keyboard.nextLine();
                    menu();
                }
                System.out.println(bestemtSøgeNavn + " bedste resultat i crawl er " + controller.visMedlem(bestemtSøgeNavn).getBedsteResultatCrawl() + " sekunder, opnået den " + controller.visMedlem(bestemtSøgeNavn).getBedsteResultatCrawlDato());
                System.out.println("Tryk på enter for at gå tilbage til menuen.");
                keyboard.nextLine();
                menu();
            case '2':
                if (controller.visMedlem(bestemtSøgeNavn).getBedsteResultatRygCrawl()==0){
                    System.out.println("Svømmer har ingen resultater for denne disciplin");
                    System.out.println("Tryk på enter for at gå tilbage til menuen.");
                    keyboard.nextLine();
                    menu();
                }
                System.out.println(bestemtSøgeNavn + " bedste resultat i rygcrawl er " + controller.visMedlem(bestemtSøgeNavn).getBedsteResultatRygCrawl() + " sekunder, opnået den " + controller.visMedlem(bestemtSøgeNavn).getBedsteResultatRygCrawlDato());
                System.out.println("Tryk på enter for at gå tilbage til menuen.");
                keyboard.nextLine();
                menu();
            case '3':
                if (controller.visMedlem(bestemtSøgeNavn).getBedsteResultatBrystSvømning()==0){
                    System.out.println("Svømmer har ingen resultater for denne disciplin");
                    System.out.println("Tryk på enter for at gå tilbage til menuen.");
                    keyboard.nextLine();
                    menu();
                }
                System.out.println(bestemtSøgeNavn + " bedste resultat i brystsvømning er " + controller.visMedlem(bestemtSøgeNavn).getBedsteResultatBrystSvømning() + " sekunder, opnået den " + controller.visMedlem(bestemtSøgeNavn).getBedsteResultatBrystSvømningDato());
                System.out.println("Tryk på enter for at gå tilbage til menuen.");
                keyboard.nextLine();
                menu();
            case '4':
                if (controller.visMedlem(bestemtSøgeNavn).getBedsteResultatButterfly()==0){
                    System.out.println("Svømmer har ingen resultater for denne disciplin");
                    System.out.println("Tryk på enter for at gå tilbage til menuen.");
                    keyboard.nextLine();
                    menu();
                }
                System.out.println(bestemtSøgeNavn + " bedste resultat i butterfly er " + controller.visMedlem(bestemtSøgeNavn).getBedsteResultatButterfly() + " sekunder, opnået den " + controller.visMedlem(bestemtSøgeNavn).getBedsteResultatButterflyDato());
                System.out.println("Tryk på enter for at gå tilbage til menuen.");
                keyboard.nextLine();
                menu();
            case '5':
                menu();
        }
        visTræningsResultat();
    }

    private void indtastTræningsResultat(){
        if (controller.visMedlemmer().size() == 0) {
            System.out.println("Der er ingen medlemmer i systemet.");
            menu();
        }
        System.out.println("Søg efter et medlem du vil se resultater for:");
        String søgeNavn = keyboard.next();

        if (controller.søgMedlem(søgeNavn) == null) {
            System.out.println("Medlemmet kunne ikke findes!");
            menu();
        }
        System.out.println("Matchende medlemmer fundet: " + controller.søgMedlem(søgeNavn));
        System.out.println("Skriv navnet på det medlem, du vil se resultater for:");
        String bestemtSøgeNavn = keyboard.next();
        System.out.println(controller.visMedlem(bestemtSøgeNavn));
        if (controller.visMedlem(bestemtSøgeNavn) == null) {
            System.out.println("Medlemmet kunne ikke findes.");
            menu();
        }

        boolean svømmerCrawl = false;
        boolean svømmerRygCrawl = false;
        boolean svømmerBrystsvømning = false;
        boolean svømmerButterfly = false;

        if (controller.visMedlem(bestemtSøgeNavn).getSvømmeDisciplin().toLowerCase().contains("crawl")){
        System.out.println("1. Crawl");
        svømmerCrawl = true;
        }
        if (controller.visMedlem(bestemtSøgeNavn).getSvømmeDisciplin().toLowerCase().contains("rygcrawl")){
        System.out.println("2. Rygcrawl");
        svømmerRygCrawl = true;
        }
        if (controller.visMedlem(bestemtSøgeNavn).getSvømmeDisciplin().toLowerCase().contains("brystsvømning")){
        System.out.println("3. Brystsvømning");
        svømmerBrystsvømning = true;
        }
        if (controller.visMedlem(bestemtSøgeNavn).getSvømmeDisciplin().toLowerCase().contains("butterfly")){
        System.out.println("4. Butterfly");
        svømmerButterfly = true;
        }

        if (!svømmerButterfly && !svømmerBrystsvømning && !svømmerCrawl && !svømmerRygCrawl){
            System.out.println("Denne svømmer er ikke aktiv i nogle træningsdiscipliner");
            System.out.println("Tryk på enter for at gå tilbage til menuen.");
            keyboard.nextLine();
            menu();
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
                if (svømmerCrawl){
                    System.out.println("Hvad er det nye svømmeresultat i crawl? ");
                    int nytResultat = keyboard.nextInt();
                    controller.visMedlem(bestemtSøgeNavn).setBedsteResultatCrawl(nytResultat);
                    System.out.println("Hvad er datoen for det nye resultat? (d/m/å)");
                    String nytResultatDato = keyboard.next();
                    controller.visMedlem(bestemtSøgeNavn).setBedsteResultatCrawlDato(nytResultatDato);
                    System.out.println("Du har nu opdateret svømmeresultatet.");
                    System.out.println("Tryk på enter for at gå tilbage til menuen.");
                    keyboard.nextLine();
                    menu();
                }
                else if (!svømmerCrawl){
                    System.out.println("Svømmeren er ikke aktiv i denne disciplin");
                    menu(); }
            case '2':
                if (svømmerRygCrawl){
                    System.out.println("Hvad er det nye svømmeresultat i crawl? ");
                    int nytResultat = keyboard.nextInt();
                    controller.visMedlem(bestemtSøgeNavn).setBedsteResultatRygCrawl(nytResultat);
                    System.out.println("Hvad er datoen for det nye resultat? (d/m/å)");
                    String nytResultatDato = keyboard.next();
                    controller.visMedlem(bestemtSøgeNavn).setBedsteResultatRygCrawlDato(nytResultatDato);
                    System.out.println("Du har nu opdateret svømmeresultatet.");
                    System.out.println("Tryk på enter for at gå tilbage til menuen.");
                    keyboard.nextLine();
                    menu();
                }
                else if (!svømmerRygCrawl){
                    System.out.println("Svømmeren er ikke aktiv i denne disciplin");
                    menu();
                }
            case '3':
                if (svømmerBrystsvømning){
                    System.out.println("Hvad er det nye svømmeresultat i brystsvømning? ");
                    int nytResultat = keyboard.nextInt();
                    controller.visMedlem(bestemtSøgeNavn).setBedsteResultatBrystSvømning(nytResultat);
                    System.out.println("Hvad er datoen for det nye resultat? (d/m/å)");
                    String nytResultatDato = keyboard.next();
                    controller.visMedlem(bestemtSøgeNavn).setBedsteResultatBrystSvømningDato(nytResultatDato);
                    System.out.println("Du har nu opdateret svømmeresultatet.");
                    System.out.println("Tryk på enter for at gå tilbage til menuen.");
                    keyboard.nextLine();
                    menu();
                }
                else if (!svømmerBrystsvømning){
                    System.out.println("Svømmeren er ikke aktiv i denne disciplin");
                    menu(); }
            case '4':
                if (svømmerButterfly){
                    System.out.println("Hvad er det nye svømmeresultat i crawl? ");
                    int nytResultat = keyboard.nextInt();
                    controller.visMedlem(bestemtSøgeNavn).setBedsteResultatButterfly(nytResultat);
                    System.out.println("Hvad er datoen for det nye resultat? (d/m/å)");
                    String nytResultatDato = keyboard.next();
                    controller.visMedlem(bestemtSøgeNavn).setBedsteResultatButterflyDato(nytResultatDato);
                    System.out.println("Du har nu opdateret svømmeresultatet.");
                    System.out.println("Tryk på enter for at gå tilbage til menuen.");
                    keyboard.nextLine();
                    menu();
                }
                else if (!svømmerButterfly){
                    System.out.println("Svømmeren er ikke aktiv i denne disciplin");
                    menu(); }
            case '5':
                menu();
        }
        indtastTræningsResultat();
    }




    private void lukProgrammet() {
        if (ændret){
        controller.gemSvømmmere();}
        System.out.println("Programmet lukkes og dine ændringer gemmes");
        System.exit(0);
    }

    private void tilføjSvømmer() {
        System.out.println("Hvad er navnet på svømmeren?");
        String navn = keyboard.nextLine();
        keyboard.nextLine();
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
        int telefonNummer = keyboard.nextInt();
        System.out.println("Hvad er svømmerens svømmedesciplin?");
        String svømmeDisciplin = keyboard.next();
        keyboard.nextLine();




        int idNummer = controller.skabIDNummer();
        Date dagsDato = new Date();
        //Date alder = new Date((alderÅrstal-1900)+(alderMåned-1)+alderDag);
        Date alder = new Date(alderÅrstal,alderMåned,alderDag);
        long forskelIÅr = Math.abs(dagsDato.getYear()-alder.getYear());
        String aldersGruppe = "Junior";
        if (forskelIÅr > 17) {
            aldersGruppe = "Senior";
        }

        controller.tilføjSvømmer(navn, idNummer, aldersGruppe, true, alder, adresse, emailAdresse, telefonNummer, svømmeDisciplin);
        controller.gemSvømmmere();
        System.out.println("Svømmeren er oprettet.");
        ændret = true;

        System.out.println("Tryk på enter for at gå tilbage til menuen.");
        keyboard.nextLine();
        menu();


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
        if (søgeValg == '2'){
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
            menu();
        }
        System.out.println(controller.visMedlem(bestemtSøgeNavn));
        System.out.println("Tryk på enter for at gå tilbage til menuen.");
        keyboard.nextLine();
        menu();
    }

    private void søgViaID(){
        System.out.println("Hvad er medlemmets ID nummer?");
        int søgeID = keyboard.nextInt();
        System.out.println(controller.visMedlemID(søgeID));
        keyboard.nextLine();
        System.out.println("Tryk på enter for at gå tilbage til menuen.");
        keyboard.nextLine();
        menu();
    }

    private void redigerEtMedlem() {
        if (controller.visMedlemmer().size() == 0) {
            System.out.println("Du har ikke nogle medlemmer endnu.");
            menu();
        }
        System.out.println("Skriv navnet på det medlem, du vil søge efter:");
        String søgeNavn = keyboard.next();

        if (controller.søgMedlem(søgeNavn) == null) {
            System.out.println("Medlemmet kunne ikke findes.");
            menu();
        }
        System.out.println("Matchende medlemmer fundet: " + controller.søgMedlem(søgeNavn));
        System.out.println("Skriv navnet på det medlem, du vil ændre på:");
        keyboard.nextLine();
        String bestemtSøgeNavn = keyboard.nextLine();
        System.out.println(controller.visMedlem(bestemtSøgeNavn));
        if (controller.visMedlem(bestemtSøgeNavn) == null) {
            System.out.println("Medlemmet kunne ikke findes.");
            menu();
        }
        System.out.println("Hvad vil du ændre?");
        System.out.println("1. Medlemmets navn");
        System.out.println("2. Medlemmets alder");
        System.out.println("3. Medlemmets aktivitetsstatus");
        System.out.println("4. Medlemmets adresse");
        System.out.println("5. Medlemmets emailadresse");
        System.out.println("6. Medlemmets telefonnummer");
        System.out.println("7. Medlemmets svømmedisciplin");

        if (!keyboard.hasNextInt()) {
            String text = keyboard.next();
            System.out.println(text + " er ikke et gyldigt tal. Prøv igen.");
            redigerEtMedlem();
        }

        char redigerMedlem = keyboard.next().charAt(0);
        switch (redigerMedlem) {
            case '1':
                redigerNavn(bestemtSøgeNavn);
            case '2':
                redigerAktivitetsStatus(bestemtSøgeNavn);
            case '4':
                redigerAdresse(bestemtSøgeNavn);
            case '5':
                redigerEmailAdresse(bestemtSøgeNavn);
            case '6':
                redigerTelefonnummer(bestemtSøgeNavn);
            case '7':
                redigerSvømmeDisciplin(bestemtSøgeNavn);
        }
        redigerEtMedlem();
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
        menu();
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
        menu();
    }

    private void redigerAktivitetsStatus(String bestemtSøgeNavn) {
        System.out.println("Er medlemmet stadig aktiv?");
        System.out.println("1. Ja");
        System.out.println("2. Nej");
        char erAktiv = keyboard.next().charAt(0);
        boolean nyErAktiv = true;

        if (erAktiv == '2'){
            nyErAktiv = false;
        }
        controller.redigerErAktiv(bestemtSøgeNavn, nyErAktiv);
        System.out.println("Styrkeniveauet er ændret");
        System.out.println(controller.visMedlem(bestemtSøgeNavn));

        ændret = true;
        System.out.println("Tryk på enter for at gå tilbage til menuen.");
        keyboard.nextLine();
        menu();


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
        menu();

    }

    private void redigerTelefonnummer(String bestemtSøgeNavn) {
        System.out.println("Hvad vil du ændre telefonnummeret til?");
        keyboard.nextInt();
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
        menu();

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
        menu();
    }
}


