package task2flower;

public class Obertka extends Upakovka {
    private double lengthCm;
    private double widthCm;

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
        this.lengthCm = lengthCm;
    }

    public double getWidthCm() {
        return widthCm;
    }

    public void setWidthCm(double widthCm) {
        this.widthCm = widthCm;
    }

    @Override
    public String getName() {
        return "Обёртка";
    }

    @Override
    public double getAreaSquareMeters() {
        // Длина и ширина заданы в сантиметрах
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