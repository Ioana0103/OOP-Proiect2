import Stoc.StocManager;

import java.util.Scanner;

public class Client {
    public void meniuClient(Scanner scanner, StocManager stocManager) {
        String comanda;

        System.out.println("\nMeniu Client - Comenzi disponibile:");
        System.out.println("1. Afișează toate consumabilele");
        System.out.println("2. Ieșire");

        do {
            System.out.print("Alege o comandă (1, 2): ");
            comanda = scanner.nextLine().trim();

            if (comanda.equals("1")) {
                stocManager.afiseazaConsumabile();
            } else if (!comanda.equals("2")) {
                System.out.println("Comandă invalidă! Te rog alege din nou.");
            }
        } while (!comanda.equals("2"));

        System.out.println("Ieșire din aplicația client.");
    }
}
