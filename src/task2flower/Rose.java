package task2flower;

public class Rose extends Flower {
    public Rose(String color, double price, int daysAfterCut, int stemLength) {
        super(color, price, daysAfterCut, stemLength);
    }

    @Override
    public String getName() {
        return "Роза";
    }
}