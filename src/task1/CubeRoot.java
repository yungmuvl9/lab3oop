package task1;

public class CubeRoot extends Function {
    public CubeRoot(){super("кубический корень из x");}

    @Override
    public boolean isDefined(double x) {
        return Double.isFinite(x);
    }

    @Override
    public double calculate(double x){
        return Math.cbrt(x);
    }
}
