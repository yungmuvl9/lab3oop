package task1;

public class Reciprocal extends Function {
    public Reciprocal() {super("1/x, x!=0");}

    @Override
    public boolean isDefined(double x) {
        return Double.isFinite(x) && x != 0;
    }
    @Override
    public double calculate (double x){
        if (!isDefined(x)) {
            throw new IllegalArgumentException("деление на ноль невозможно.");
        }
        return 1/x;
    }
}
