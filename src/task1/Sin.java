package task1;

public class Sin extends Function {
    public Sin() {super("sin(x)");}

    @Override
    public boolean isDefined(double x) {
        return Double.isFinite(x);
    }

    @Override
    public double calculate(double x){
        return Math.sin(x);}
}
