package Consumabile;

public class Floare extends Consumabile {
    private String tipFloare;

    public Floare(String nume, int cantitate, String tipFloare) {
        super(nume, cantitate);
        this.tipFloare = tipFloare;
    }

    @Override
    public String toString() {
        return "Consumabile.Floare [Tip: " + tipFloare + ", " + super.toString() + "]";
    }
}