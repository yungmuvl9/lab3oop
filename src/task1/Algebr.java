package task1;

public class Algebr extends Formula {
    private double a;
    private double b;

    public Algebr(double a, double b) {
        super(" вадрат суммы");
        this.a = a;
        this.b = b;
    }

    @Override
    public double calculate() {
        return a * a - 2 * a * b + b * b;
    }

    @Override
    public String getFormula() {
        return "(a + b)? = a? + 2ab + b?";
    }
}