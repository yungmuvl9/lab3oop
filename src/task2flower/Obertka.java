package task2flower;

public class Obertka extends Upakovka {
    private double lengthCm = 50.0;
    private double widthCm = 50.0;

    public Obertka(String color, double lengthCm,
                         double widthCm, double pricePerSquareMeter) {
        super(color, pricePerSquareMeter);
        setLengthCm(lengthCm);
        setWidthCm(widthCm);
    }

    public double getLengthCm() {
        return lengthCm;
    }

    public void setLengthCm(double lengthCm) {
        if (!Double.isFinite(lengthCm) || lengthCm <= 0) {
            System.out.println("Длина листа должна быть больше нуля. Установлено значение по умолчанию: " + this.lengthCm + " см.");
            return;
        }
        this.lengthCm = lengthCm;
    }

    public double getWidthCm() {
        return widthCm;
    }

    public void setWidthCm(double widthCm) {
        if (!Double.isFinite(widthCm) || widthCm <= 0) {
            System.out.println("Ширина листа должна быть больше нуля. Установлено значение по умолчанию: " + this.widthCm + " см.");
            return;
        }
        this.widthCm = widthCm;
    }

    @Override
    public String getName() {
        return "Обёртка";
    }

    @Override
    public double getAreaSquareMeters() {
        return lengthCm * widthCm / 10_000.0;
    }

    @Override
    public double getCost() {
        return getAreaSquareMeters() * getUnitPrice();
    }

    @Override
    public String getMaterialInfo() {
        return String.format(
                "лист %.1f x %.1f см, площадь %.4f м^2, тариф %.2f руб./м^2",
                lengthCm, widthCm, getAreaSquareMeters(), getUnitPrice()
        );
    }
}