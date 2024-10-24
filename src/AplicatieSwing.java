import Consumabile.Consumabile;
import Consumabile.Balon;
import Consumabile.Floare;
import Stoc.StocManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AplicatieSwing extends JFrame {
    private StocManager stocManager;

    public AplicatieSwing() {

        stocManager = new StocManager();


        setTitle("Aplicație de Gestionare a Consumabilelor");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        JButton butonAfisare = new JButton("Afișează Consumabile");
        butonAfisare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stocManager.afiseazaConsumabile();
            }
        });


        JButton butonAdauga = new JButton("Adaugă Consumabil");
        butonAdauga.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adaugaConsumabil();
            }
        });


        JButton butonScade = new JButton("Scade din Stoc");
        butonScade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                scadeDinStoc();
            }
        });


        JButton butonVerificaNecesar = new JButton("Verifică Necesar");
        butonVerificaNecesar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verificaNecesar();
            }
        });

        setLayout(new FlowLayout());
        add(butonAfisare);
        add(butonAdauga);
        add(butonScade);
        add(butonVerificaNecesar);
    }

    private void adaugaConsumabil() {
        String tipConsumabil = JOptionPane.showInputDialog(this, "Tip consumabil (Balon/Floare):");

        String nume = JOptionPane.showInputDialog(this, "Introdu numele consumabilului:");
        String cantitateStr = JOptionPane.showInputDialog(this, "Introdu cantitatea consumabilului:");
        String proprietateSpeciala = "";

        try {
            int cantitate = Integer.parseInt(cantitateStr);

            Consumabile consumabil = null;
            if (tipConsumabil.equalsIgnoreCase("Balon")) {
                proprietateSpeciala = JOptionPane.showInputDialog(this, "Introdu culoarea balonului:");
                consumabil = new Balon(nume, cantitate, proprietateSpeciala);
            } else if (tipConsumabil.equalsIgnoreCase("Floare")) {
                proprietateSpeciala = JOptionPane.showInputDialog(this, "Introdu tipul florii:");
                consumabil = new Floare(nume, cantitate, proprietateSpeciala);
            } else {
                JOptionPane.showMessageDialog(this, "Tip consumabil necunoscut!", "Eroare", JOptionPane.ERROR_MESSAGE);
                return;
            }

            boolean exista = false;
            for (Consumabile c : stocManager.getConsumabile()) {
                if (c.getNume().equalsIgnoreCase(consumabil.getNume())) {
                    c.adaugaCantitate(cantitate);
                    exista = true;
                    break;
                }
            }

            if (!exista) {
                stocManager.adaugaConsumabil(consumabil);
            }

            JOptionPane.showMessageDialog(this, "Consumabil adăugat cu succes!");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Cantitatea trebuie să fie un număr valid.", "Eroare", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void scadeDinStoc() {
        String nume = JOptionPane.showInputDialog(this, "Introdu numele consumabilului pentru a scădea:");
        String cantitateStr = JOptionPane.showInputDialog(this, "Introdu cantitatea de scăzut:");

        try {
            int cantitate = Integer.parseInt(cantitateStr);
            boolean success = stocManager.scadeDinStoc(nume, cantitate);
            if (success) {
                JOptionPane.showMessageDialog(this, "Cantitatea a fost scăzută cu succes!");
            } else {
                JOptionPane.showMessageDialog(this, "Nu s-a putut scădea cantitatea.", "Eroare", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Cantitatea trebuie să fie un număr valid.", "Eroare", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void verificaNecesar() {
        String pragStr = JOptionPane.showInputDialog(this, "Introdu pragul minim pentru verificare:");

        try {
            int prag = Integer.parseInt(pragStr);
            stocManager.verificaNecesar(prag);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Pragul trebuie să fie un număr valid.", "Eroare", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        AplicatieSwing aplicatie = new AplicatieSwing();
        aplicatie.setVisible(true);
    }
}
