package Consumabile;

public class Balon extends Consumabile {
    private String culoare;

    public Balon(String nume, int cantitate, String culoare) {
        super(nume, cantitate);
        this.culoare = culoare;
    }

    @Override
    public String toString() {
        return "Consumabile.Consumabile.Balon [Culoare: " + culoare + ", " + super.toString() + "]";
    }
}