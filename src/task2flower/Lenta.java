package task2flower;

public class Lenta extends Accessory {
    private double lengthCm = 50.0;

    public Lenta(String color, double lengthCm, double pricePerMeter) {
        super(color, pricePerMeter);
        setLengthCm(lengthCm);
    }

    public double getLengthCm() {
        return lengthCm;
    }

    public void setLengthCm(double lengthCm) {
        if (!Double.isFinite(lengthCm) || lengthCm <= 0) {
            System.out.println("Длина ленты должна быть больше нуля. Установлено значение по умолчанию: " + this.lengthCm + " см.");
            return;
        }
        this.lengthCm = lengthCm;
    }

    public double getLengthMeters() {
        return lengthCm / 100.0;
    }

    @Override
    public String getName() {
        return "Лента";
    }

    @Override
    public String getMaterialInfo() {
        return String.format("длина: %.1f см, цена за метр: %.2f руб.",
                lengthCm, getUnitPrice());
    }

    @Override
    public double getCost() {
        return getLengthMeters() * getUnitPrice();
    }
}