package task2flower;

public class Korzinka extends Upakovka {
    private double diameterCm = 30.0;
    private boolean hasLiner;
    private double linerPricePerSquareMeter = 100.0;
    private String material = "пластик";

    public Korzinka(String color, String material, double diameterCm,
                  double basketPrice, boolean hasLiner,
                  double linerPricePerSquareMeter) {
        super(color, basketPrice);
        setMaterial(material);
        setDiameterCm(diameterCm);
        setHasLiner(hasLiner);
        if (hasLiner) {
            setLinerPricePerSquareMeter(linerPricePerSquareMeter);
        }
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        if (material == null || material.trim().isEmpty()) {
            System.out.println("Материал не может быть пустым. Установлено значение по умолчанию: " + this.material);
            return;
        }
        this.material = material.trim();
    }

    public double getDiameterCm() {
        return diameterCm;
    }

    public void setDiameterCm(double diameterCm) {
        if (!Double.isFinite(diameterCm) || diameterCm <= 0) {
            System.out.println("Диаметр должен быть больше нуля. Установлено значение по умолчанию: " + this.diameterCm + " см.");
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
        if (!Double.isFinite(price) || price < 0) {
            System.out.println("Цена подкладки не может быть отрицательной. Установлено значение по умолчанию: " + this.linerPricePerSquareMeter + " руб.");
            return;
        }
        this.linerPricePerSquareMeter = price;
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
                    ", круглая подкладка: %.4f м^2 за %.2f руб.",
                    getAreaSquareMeters(), getLinerCost()
            );
        }
        return info + ", без подкладки";
    }
}