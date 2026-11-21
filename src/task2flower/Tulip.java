package task2flower;

public class Tulip extends Flower {
    public Tulip(String color, double price,
                 int daysAfterCut, int stemLength) {
        super(color, price, daysAfterCut, stemLength);
    }

    @Override
    public String getName() {
        return "“юльпан";
    }
}
