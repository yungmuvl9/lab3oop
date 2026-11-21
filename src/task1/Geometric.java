package task1;

public class Geometric extends Formula {
    private double a;
    public Geometric(double a) {
        super("Площадь квадрата");
        this.a = a;
    }

    @Override
    public double calculate() {
        return a * a;
    }

    @Override
    public String getFormula() {
        return "S = a^2";
    }
}