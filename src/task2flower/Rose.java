package task2flower;

public class Rose extends Flower {
    public Rose(String color, double price, int freshness, int stemLength){
        super(color, price, freshness, stemLength);
    }

    @Override
    public String getName(){
        return "Роза";
    }

}
