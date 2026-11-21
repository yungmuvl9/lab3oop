package task2flower;

import java.util.ArrayList;

public class Bouquet {
    private final ArrayList<Flower> flowers = new ArrayList<>();
    private final ArrayList<Accessory> accessories = new ArrayList<>();

    public boolean addAccessory(Accessory accessory) {
        if (accessory == null) {
            return false;
        }
        accessories.add(accessory);
        return true;
    }

    public boolean addFlower(Flower flower) {
        if (flower == null || flower.getFreshness() == 0) {
            return false;
        }
        flowers.add(flower);
        return true;
    }

    public boolean removeFlower(int number) {
        if (number < 1 || number > flowers.size()) {
            return false;
        }
        flowers.remove(number - 1);
        return true;
    }

    public boolean removeAccessory(int number) {
        if (number < 1 || number > accessories.size()) {
            return false;
        }
        accessories.remove(number - 1);
        return true;
    }

    public double getCost() {
        double total = 0;
        for (Flower flower : flowers) {
            total += flower.getCost();
        }
        for (Accessory accessory : accessories) {
            total += accessory.getCost();
        }
        return total;
    }

    public void sortByFreshness() {
        for (int i = 0; i < flowers.size() - 1; i++) {
            for (int j = 0; j < flowers.size() - 1 - i; j++) {
                Flower left = flowers.get(j);
                Flower right = flowers.get(j + 1);
                if (left.getFreshness() < right.getFreshness()) {
                    flowers.set(j, right);
                    flowers.set(j + 1, left);
                }
            }
        }
    }

    public ArrayList<Flower> findByStemLength(int min, int max) {
        ArrayList<Flower> found = new ArrayList<>();
        if (min < 0 || min > max) {
            return found;
        }
        for (Flower flower : flowers) {
            int length = flower.getStemLength();
            if (length >= min && length <= max) {
                found.add(flower);
            }
        }
        return found;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nЦветы:\n");
        if (flowers.isEmpty()) {
            sb.append("Цветов пока нет.\n");
        } else {
            for (int i = 0; i < flowers.size(); i++) {
                sb.append(i + 1).append(". ").append(flowers.get(i)).append("\n");
            }
        }

        sb.append("Аксессуары:\n");
        if (accessories.isEmpty()) {
            sb.append("Аксессуаров пока нет.\n");
        } else {
            for (int i = 0; i < accessories.size(); i++) {
                sb.append(i + 1).append(". ").append(accessories.get(i)).append("\n");
            }
        }

        sb.append(String.format("Стоимость букета: %.2f руб.", getCost()));
        return sb.toString();
    }
}