package task1;

public class Square extends Function {
    public Square() {super ("x^2");}

    @Override
    public boolean isDefined(double x) {
        return Double.isFinite(x);
    }

    @Override
    public double calculate(double x ){return x * x; }

}
