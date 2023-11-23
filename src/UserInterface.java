import java.util.Scanner;

public class UserInterface {
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
        System.out.println("5. Luk programmet");
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
                lukProgrammet();

        }
    }

    private void gemSvømmere() {
        controller.gemSvømmmere();
        menu();
    }

    private void lukProgrammet() {
        controller.gemSvømmmere();
        System.out.println("Programmet lukkes og dine ændringer gemmes");
        System.exit(0);
    }

    private void tilføjSvømmer() {
        System.out.println("Hvad er navnet på svømmeren?");
        String navn = keyboard.next();
        System.out.println("Hvad er alderen på svømmeren?");
        int alder = keyboard.nextInt();
        System.out.println("Hvad er svømmerens adresse?");
        keyboard.nextLine();
        String adresse = keyboard.nextLine();
        System.out.println("Hvad er svømmerens emailadresse?");
        String emailAdresse = keyboard.nextLine();
        System.out.println("Hvad er svømmerens telefonnummer?");
        int telefonNummer = keyboard.nextInt();
        System.out.println("Hvad er svømmerens svømmedesciplin?");
        String svømmeDisciplin = keyboard.next();

        String aldersGruppe = "Junior";
        if (alder > 17) {
            aldersGruppe = "Senior";
        }

        controller.tilføjSvømmer(navn, aldersGruppe, true, alder, adresse, emailAdresse, telefonNummer, svømmeDisciplin);
        controller.gemSvømmmere();

        menu();

    }

    private void søgPåEnSvømmer() {
        if (controller.visMedlemmer().size() == 0) {
            System.out.println("Du har ikke registreret nogen medlemmer endnu.");
            tilføjSvømmer();
        }
        System.out.println("Skriv navnet på det medlem, du vil søge efter:");
        String søgeNavn = keyboard.next();
        System.out.println("Matchende medlemmer fundet:" + controller.søgMedlem(søgeNavn));
        System.out.println("Skriv navnet på det medlem, du vil se informationer om:");
        keyboard.nextLine();
        String bestemtSøgeNavn = keyboard.nextLine();
        if (controller.visMedlem(bestemtSøgeNavn) == null) {
            System.out.println("Kunne ikke finde: " + bestemtSøgeNavn);
            tilføjSvømmer();
        }
        System.out.println(controller.visMedlem(bestemtSøgeNavn));
        System.out.println("Tryk på enter for at gå tilbage til menuen.");
        keyboard.nextLine();
        menu();
    }

    private void redigerEtMedlem() {
        if (controller.visMedlemmer().size() == 0) {
            System.out.println("Du har ikke nogle superhelte endnu.");
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
        char redigerMedlem = keyboard.next().charAt(0);
        switch (redigerMedlem) {
            case '1':
                redigerNavn(bestemtSøgeNavn);
            case '2':
                redigerAlder(bestemtSøgeNavn);
            case '3':
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

    private void redigerAlder(String bestemtSøgeNavn) {
        System.out.println("Hvad vil du ændre alderen til?");
        if (!keyboard.hasNextInt()) {
            String text = keyboard.next();
            System.out.println(text + " er ikke et gyldigt tal. Prøv igen.");
        }
        int nyAlder = keyboard.nextInt();
        controller.redigerAlder(bestemtSøgeNavn, nyAlder);
        System.out.println("Alderen er ændret!");
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
        }
        int nytTelefonnummer = keyboard.nextInt();
        controller.redigerAlder(bestemtSøgeNavn, nytTelefonnummer);
        System.out.println("Telefonnummeret er ændret!");
        System.out.println(controller.visMedlem(bestemtSøgeNavn));

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

        System.out.println("Tryk på enter for at gå tilbage til menuen.");
        keyboard.nextLine();
        menu();

    }


}


