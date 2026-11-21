package task2flower;

public abstract class Flower {
    private String color = "красный";
    private double price = 100.0;
    private int daysAfterCut = 0;
    private int stemLength = 30;

    protected Flower(String color, double price, int daysAfterCut, int stemLength) {
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
            System.out.println("Цвет не может быть пустым. Установлено значение по умолчанию: " + this.color);
            return;
        }
        this.color = color.trim();
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (!Double.isFinite(price) || price < 0) {
            System.out.println("Цена не может быть отрицательной. Установлено значение по умолчанию: " + this.price + " руб.");
            return;
        }
        this.price = price;
    }

    public int getDaysAfterCut() {
        return daysAfterCut;
    }

    public void setDaysAfterCut(int daysAfterCut) {
        if (daysAfterCut < 0) {
            System.out.println("Количество дней не может быть отрицательным. Установлено значение по умолчанию: " + this.daysAfterCut);
            return;
        }
        this.daysAfterCut = daysAfterCut;
    }

    public int getStemLength() {
        return stemLength;
    }

    public void setStemLength(int stemLength) {
        if (stemLength <= 0) {
            System.out.println("Длина стебля должна быть больше нуля. Установлено значение по умолчанию: " + this.stemLength + " см.");
            return;
        }
        this.stemLength = stemLength;
    }

    public int getFreshness() {
        return Math.max(0, 10 - getDaysAfterCut());
    }

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
        return String.format(
                "%s, цвет: %s, базовая цена: %.2f руб., стоимость: %.2f руб., дней после срезки: %d, свежесть: %d/10, длина стебля: %d см",
                getName(), color, price, getCost(), daysAfterCut, getFreshness(), stemLength
        );
    }
}