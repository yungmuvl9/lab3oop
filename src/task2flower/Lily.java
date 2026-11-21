package task2flower;

public class Lily extends Flower {
    public Lily(String color, double price,
                int daysAfterCut, int stemLength) {
        super(color, price, daysAfterCut, stemLength);
    }

    @Override
    public String getName() {
        return "Лилия";
    }
}