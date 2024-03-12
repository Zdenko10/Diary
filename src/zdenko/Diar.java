package zdenko;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Scanner;

public class Diar {
    Scanner sc = new Scanner(System.in);
    LinkedList<Zaznam> zaznamy = new LinkedList<>();

    public void program() {
        boolean pokracovat = true;
        while (pokracovat) {
            vykresli();
            String volba = sc.nextLine();
            switch (volba) {
                case "novy":
                    vytvorZaznam();
                    break;
                case "zaznamy":
                    vypisZaznamy();
                    break;
                case "smaz":
                    vymazZaznam();
                    break;
                case "zavri":
                    System.out.println("Rád jsem posloužil.");
                    sc.close();
                    break;
                default:
                    System.out.println("Tuto možnost nemám ve svých možnostech.");
            }
            if (volba.equals("zavri")) {
                pokracovat = false;
            }
        }
    }

    private void vykresli() {
        System.out.println("----------------   MENU   ----------------\n" +
                "Deník se ovládá následujícími příkazy:\n" +
                "- novy: Vytvoření nového záznamu\n" +
                "- zaznamy: Zobrazí všechny záznamy\n" +
                "- smaz: Odstranění záznamu\n" +
                "- zavri: Zavření deníku a ukončení programu\n" +
                "----------------   MENU   ----------------\n" +
                "------------------------------------------\n" +
                "Počet záznamů: " + zaznamy.size() + "\n" +
                "------------------------------------------\n" +
                "Zadejte příkaz:");
    }

    private void vytvorZaznam() {
        System.out.println("------------------------------------------\n" +
                "Zadejte text k záznamu:");
        Zaznam zaznam = new Zaznam(sc.nextLine(), LocalDate.now());
        zaznamy.addLast(zaznam);
        System.out.println("Záznam byl vytvořen\n" +
                "------------------------------------------");
    }

    private void vypisZaznamy() {
        System.out.println("------------------------------------------\n" +
                "Počet záznamů: " + zaznamy.size());
        System.out.println("------------------------------------------\n" +
                "------------------------------------------");
        for (int i = 0; i < zaznamy.size(); i++) {
            System.out.println("Záznam [" + i + "] " + "vytvořen " + zaznamy.get(i).getDatum() + ":");
            System.out.println(zaznamy.get(i).getText());
            System.out.println();
        }
        System.out.println("------------------------------------------");
    }

    private void vymazZaznam() {
        vypisZaznamy();
        try {
            System.out.println("Jaký záznam si přejete vymazat?");
            System.out.println("- pro vymazání záznamu zadejte index záznamu, například => 1");
            System.out.println("Záznam k vymazání: ");
            int index = Integer.parseInt(sc.nextLine());
            zaznamy.remove(index);
        } catch (Exception exception) {
            System.err.println("Neplatné zadání!");
        }

    }

}