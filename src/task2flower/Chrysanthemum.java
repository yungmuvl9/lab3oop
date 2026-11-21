package task2flower;
;

public class Chrysanthemum extends Flower {
    public Chrysanthemum(String color, double price,
                         int daysAfterCut, int stemLength) {
        super(color, price, daysAfterCut, stemLength);
    }

    @Override
    public String getName() {
        return "Хризантема";
    }

    @Override
    public int getFreshness() {
        return Math.max(0, 10 - getDaysAfterCut() / 2);
    }
}
