package task2flower;

public abstract class Flower {
    private String color;
    private double price;
    private int daysAfterCut;
    private int stemLength;

    protected Flower(String color, double price,
                     int daysAfterCut, int stemLength) {
        setColor(color);
        setPrice(price);
        setDaysAfterCut(daysAfterCut);
        setStemLength(stemLength);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (color == null || color.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Цвет не должен быть пустым."
            );
        }

        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (!Double.isFinite(price) || price < 0) {
            throw new IllegalArgumentException(
                    "Цена должна быть конечной и неотрицательной."
            );
        }

        this.price = price;
    }

    public int getDaysAfterCut() {
        return daysAfterCut;
    }

    public void setDaysAfterCut(int daysAfterCut) {
        if (daysAfterCut < 0) {
            throw new IllegalArgumentException(
                    "Количество дней не может быть отрицательным."
            );
        }

        this.daysAfterCut = daysAfterCut;
    }

    public int getStemLength() {
        return stemLength;
    }

    public void setStemLength(int stemLength) {
        if (stemLength <= 0) {
            throw new IllegalArgumentException(
                    "Длина стебля должна быть больше нуля."
            );
        }

        this.stemLength = stemLength;
    }

    // Свежесть уменьшается на один балл за день.
    public int getFreshness() {
        return Math.max(0, 10 - getDaysAfterCut());
    }

    // Итоговая стоимость с учётом свежести.
    public double getCost() {
        int freshness = getFreshness();

        if (freshness <= 4) {
            return getPrice() * 0.5;
        } else if (freshness <= 7) {
            return getPrice() * 0.8;
        }

        return getPrice();
    }

    public abstract String getName();

    @Override
    public String toString() {
        return getName()
                + ", цвет: " + color
                + ", базовая цена: " + price + " руб."
                + ", стоимость: " + getCost() + " руб."
                + ", дней после срезки: " + daysAfterCut
                + ", свежесть: " + getFreshness() + "/10"
                + ", длина стебля: " + stemLength + " см";
    }
}