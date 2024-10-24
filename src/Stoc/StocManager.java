package Stoc;

import Consumabile.Consumabile;
import Consumabile.Balon;
import Consumabile.Floare;
import javax.swing.*;
import java.util.ArrayList;

public class StocManager implements StocManagerInterface {
    private ArrayList<Consumabile> consumabile;

    public StocManager() {
        consumabile = new ArrayList<>();

        consumabile.add(new Balon("Baloane ", 100, "Roz"));
        consumabile.add(new Balon("Baloane ", 50, "Albastre"));
        consumabile.add(new Floare("Flori Rosii", 200, "Trandafir"));
        consumabile.add(new Floare("Flori Albe", 120, "Crin"));
    }

    public void afiseazaConsumabile() {
        if (consumabile.isEmpty()) {
            System.out.println("Nu există consumabile în stoc.");
        } else {
            StringBuilder sb = new StringBuilder("Consumabile disponibile:\n");
            for (Consumabile consumabil : consumabile) {
                sb.append(consumabil.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        }
    }

    public void adaugaConsumabil(Consumabile consumabil) {
        consumabile.add(consumabil);
    }

    public boolean scadeDinStoc(String numeConsumabil, int cantitate) {
        for (Consumabile consumabil : consumabile) {
            if (consumabil.getNume().equalsIgnoreCase(numeConsumabil)) {
                if (consumabil.getCantitate() >= cantitate) {
                    consumabil.scadeCantitate(cantitate);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void verificaNecesar(int prag) {
        StringBuilder sb = new StringBuilder("Consumabile sub pragul minim (" + prag + "):\n");
        boolean existaConsumabileScazute = false;

        for (Consumabile consumabil : consumabile) {
            if (consumabil.getCantitate() < prag) {
                sb.append(consumabil.toString()).append("\n");
                existaConsumabileScazute = true;
            }
        }

        if (existaConsumabileScazute) {
            JOptionPane.showMessageDialog(null, sb.toString(), "Avertisment: Stoc scăzut", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Toate consumabilele sunt peste pragul minim.");
        }
    }

    public ArrayList<Consumabile> getConsumabile() {
        return consumabile;
    }
}
