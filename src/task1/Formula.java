package task1;

public abstract class Formula {
    private final String name;

    protected Formula(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double calculate();

    public abstract String getFormula();

    public void print() {
        System.out.println(getName());
        System.out.println("Формула: " + getFormula());
        System.out.println("Результат: " + calculate());
    }
}