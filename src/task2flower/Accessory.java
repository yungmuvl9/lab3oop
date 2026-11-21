package task2flower;

public abstract class Accessory {
    private String color;
    private double unitPrice;

    protected Accessory(String color, double unitPrice) {
        setColor(color);
        setUnitPrice(unitPrice);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (color == null || color.trim().isEmpty()) {
            throw new IllegalArgumentException("¬ведите цвет аксессуара.");
        }
        this.color = color.trim();
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        if (!Double.isFinite(unitPrice) || unitPrice < 0) {
            throw new IllegalArgumentException("÷ена должна быть неотрицательным числом.");
        }
        this.unitPrice = unitPrice;
    }

    public abstract String getName();

    public abstract String getMaterialInfo();

    public abstract double getCost();

    @Override
    public String toString() {
        return String.format("%s, цвет: %s, %s, стоимость: %.2f руб.",
                getName(), color, getMaterialInfo(), getCost());
    }
}