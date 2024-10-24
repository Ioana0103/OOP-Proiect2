package Stoc;

import Consumabile.Consumabile;
public interface StocManagerInterface {
    void afiseazaConsumabile();
    void adaugaConsumabil(Consumabile consumabil);
    boolean scadeDinStoc(String numeConsumabil, int cantitate);
    void verificaNecesar(int prag);
}
