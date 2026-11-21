package task2flower;

public class Korzinka extends Upakovka {
    private double diameterCm;
    private boolean hasLiner;
    private double linerPricePerSquareMeter;
    private String material;
    private double price;
    private double diameterСm = 30.0;

    public Korzinka(String color, String material, double diameterCm,
                    double basketPrice, boolean hasLiner,
                    double linerPricePerSquareMeter) {
        super(color, basketPrice);
        this.material = material;
        setDiameterCm(diameterCm);  // Проверка выполняется при создании
        this.hasLiner = hasLiner;
        this.linerPricePerSquareMeter = linerPricePerSquareMeter;
    }

    public double getDiameterCm() {
        return diameterCm;
    }

    public void setDiameterCm(double diameterCm) {
        if (!Double.isFinite(diameterCm) || diameterCm <= 0) {
            System.out.println("Диаметр должен быть больше нуля. "
                    + "Сохранено значение " + this.diameterCm + " см.");
            return;
        }

        this.diameterCm = diameterCm;
    }

    public boolean hasLiner() {
        return hasLiner;
    }

    public void setHasLiner(boolean hasLiner) {
        this.hasLiner = hasLiner;
    }

    public double getLinerPricePerSquareMeter() {
        return linerPricePerSquareMeter;
    }

    public void setLinerPricePerSquareMeter(double price) {
        if (!Double.isFinite(price) || price <= 0) {
            System.out.println("цена должна быть положительной. "
                    + "Сохранено значение " + this.price + " см.");
            return;
        }
    }

    @Override
    public String getName() {
        return "Цветочная корзинка";
    }

    @Override
    public double getAreaSquareMeters() {
        double diameterMeters = diameterCm / 100.0;
        double radiusMeters = diameterMeters / 2.0;
        return Math.PI * radiusMeters * radiusMeters;
    }

    public double getLinerCost() {
        if (hasLiner) {
            return getAreaSquareMeters() * linerPricePerSquareMeter;
        }
        return 0;
    }

    @Override
    public double getCost() {
        return getUnitPrice() + getLinerCost();
    }

    @Override
    public String getMaterialInfo() {
        String info = String.format(
                "материал: %s, диаметр дна: %.1f см, цена корзинки: %.2f руб.",
                material, diameterCm, getUnitPrice()
        );

        if (hasLiner) {
            return info + String.format(
                    ", круглая подкладка: %.4f м? за %.2f руб.",
                    getAreaSquareMeters(), getLinerCost()
            );
        }

        return info + ", без подкладки";
    }
}