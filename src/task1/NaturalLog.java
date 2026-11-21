package task1;

public class NaturalLog extends Function {
    public NaturalLog() {super("ln(x), x>0");}

    @Override
    public boolean isDefined(double x) {
        return Double.isFinite(x) && x > 0;
    }

    @Override
    public double calculate(double x){
        if(isDefined(x)){
            throw new IllegalArgumentException("x должен быть положительным");
        }
        return Math.log(x);
    }
}
