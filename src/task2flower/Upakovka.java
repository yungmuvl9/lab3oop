package task2flower;

public abstract class Upakovka extends Accessory {
    protected Upakovka(String color, double unitPrice) {
        super(color, unitPrice);
    }

    public abstract double getAreaSquareMeters();
}