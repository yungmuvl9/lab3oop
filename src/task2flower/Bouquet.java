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

        for (int i = 0; i < flowers.size(); i++) {
            total += flowers.get(i).getCost();
        }

        for (int i = 0; i < accessories.size(); i++) {
            total += accessories.get(i).getCost();
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

        for (int i = 0; i < flowers.size(); i++) {
            Flower flower = flowers.get(i);
            int length = flower.getStemLength();

            if (length >= min && length <= max) {
                found.add(flower);
            }
        }

        return found;
    }

    public void print() {
        System.out.println("\nЦветы:");
        if (flowers.isEmpty()) {
            System.out.println("Цветов пока нет.");
        }
        for (int i = 0; i < flowers.size(); i++) {
            System.out.println((i + 1) + ". " + flowers.get(i));
        }

        System.out.println("Аксессуары:");
        if (accessories.isEmpty()) {
            System.out.println("Аксессуаров пока нет.");
        }
        for (int i = 0; i < accessories.size(); i++) {
            System.out.println((i + 1) + ". " + accessories.get(i));
        }

        System.out.printf("Стоимость букета: %.2f руб.%n", getCost());
    }
}