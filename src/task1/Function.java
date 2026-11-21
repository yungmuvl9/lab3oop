package task1;

public abstract class Function {
    private String name;

    protected Function(String name){
        setName(name);
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("название функции не должно быть пустым!");

        }
        this.name = name;
    }

    public boolean isDefined(double x) {
        return Double.isFinite(x);
    }

    public abstract double calculate(double x);

    public void calculateInterval(double start, double end, double step){
        if (!Double.isFinite(start) || !Double.isFinite(end)
                || !Double.isFinite(step) || step <= 0 || start > end) {
            System.out.println("Некорректный интервал или шаг.");
            return;
        }

        double steps = (end - start) / step;
        int count = (int) Math.floor(steps + 1e-10);

        for(int i = 0; i <= count; i++){
            double x = start + i * step;
            if(i > 0 && Math.abs(x) < step * 1e-10){
                x = 0;
            }
            if(x > end){
                x = end;
            }
            if (!isDefined(x)) {
                System.out.println("x = " + x + ": функция не определена");
                continue;
            }

            double result = calculate(x);

            if (Double.isFinite(result)) {
                System.out.printf("x = %.4f; f(x) = %.4f%n", x, result);
            } else {
                System.out.println("x = " + x + ": результат не является конечным числом");
            }
        }
    }
    @Override
    public String toString(){
        return name;
    }

}
