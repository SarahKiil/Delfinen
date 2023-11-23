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

    public void tilføjSvømmer(){
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

    }


