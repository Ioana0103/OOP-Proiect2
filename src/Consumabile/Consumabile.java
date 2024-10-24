package Consumabile;

public class Consumabile {
    private String nume;
    private int cantitate;

    public Consumabile(String nume, int cantitate) {
        this.nume = nume;
        this.cantitate = cantitate;
    }

    public String getNume() {
        return nume;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void scadeCantitate(int cantitateDeScazut) {
        this.cantitate -= cantitateDeScazut;
    }

    public void adaugaCantitate(int cantitateDeAdaugat) {
        this.cantitate += cantitateDeAdaugat;
    }

    @Override
    public String toString() {
        return "Consumabil [Nume: " + nume + ", Cantitate: " + cantitate + "]";
    }
}
