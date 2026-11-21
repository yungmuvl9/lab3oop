package task2flower;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class FlowerShop {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Bouquet bouquet = new Bouquet();

        while (true) {
            System.out.println("1 Ч добавить цветы");
            System.out.println("2 Ч добавить аксессуар");
            System.out.println("3 Ч показать букет и стоимость");
            System.out.println("4 Ч удалить цветок");
            System.out.println("5 Ч удалить аксессуар");
            System.out.println("6 Ч отсортировать цветы по свежести");
            System.out.println("7 Ч найти цветы по длне стеб€");
            System.out.println("0 Ч завершить заказ");

            int choice = readInt("¬аш выбор: ", 0, 7);

            switch (choice) {
                case 1:
                    addFlowers(bouquet);
                    break;

                case 2:
                    addAccessory(bouquet);
                    break;

                case 3:
                    bouquet.print();
                    break;

                case 4:
                    bouquet.print();
                    int flowerNumber = readInt(
                            "Ќомер цветка: ", 1, Integer.MAX_VALUE
                    );

                    if (bouquet.removeFlower(flowerNumber)) {
                        System.out.println("÷веток удалЄн.");
                        bouquet.print();
                    } else {
                        System.out.println("÷ветка с таким номером нет.");
                    }
                    break;

                case 5:
                    bouquet.print();
                    int accessoryNumber = readInt(
                            "Ќомер аксессуара: ", 1, Integer.MAX_VALUE
                    );

                    if (bouquet.removeAccessory(accessoryNumber)) {
                        System.out.println("јксессуар удалЄн.");
                        bouquet.print();
                    } else {
                        System.out.println("јксессуара с таким номером нет.");
                    }
                    break;

                case 6:
                    bouquet.sortByFreshness();
                    System.out.println("Ѕукет после сортировки по свежести:");
                    bouquet.print();
                    break;

                case 7:
                    findFlowers(bouquet);
                    break;

                case 0:
                    System.out.println("»тоговый состав заказа:");
                    bouquet.print();
                    return;
            }
        }
    }

    private static void addFlowers(Bouquet bouquet) {
        System.out.println("\n1 Ч роза");
        System.out.println("2 Ч тюльпан");
        System.out.println("3 Ч лили€");
        System.out.println("4 Ч хризантема");

        int type = readInt("¬ыберите вид цветка: ", 1, 4);
        int quantity = readInt("—колько таких цветов? ", 1, Integer.MAX_VALUE);

        String color = readText("÷вет: ");
        double price = readPrice("Ѕазова€ цена одного цветка в рубл€х: ");
        int days = readInt("ƒней после срезки: ", 0, Integer.MAX_VALUE);
        int length = readInt("ƒлина стебл€ в см: ", 1, Integer.MAX_VALUE);

        for (int i = 0; i < quantity; i++) {
            Flower flower;

            switch (type) {
                case 1:
                    flower = new Rose(color, price, days, length);
                    break;
                case 2:
                    flower = new Tulip(color, price, days, length);
                    break;
                case 3:
                    flower = new Lily(color, price, days, length);
                    break;
                default:
                    flower = new Chrysanthemum(color, price, days, length);
                    break;
            }

            if (!bouquet.addFlower(flower)) {
                System.out.println("÷веты этой партии ув€ли. ѕарти€ не добавлена.");
                return;
            }
        }

        System.out.println("ƒобавлено цветов: " + quantity);
        System.out.printf("—тоимость букета: %.2f руб.%n", bouquet.getCost());
    }

    private static void addAccessory(Bouquet bouquet) {
        System.out.println("\n1 Ч лента");
        System.out.println("2 Ч обЄртка");
        System.out.println("3 Ч корзинка");

        int type = readInt("¬ыберите аксессуар: ", 1, 3);
        String color = readText("÷вет аксессуара: ");

        Accessory accessory;

        switch (type) {
            case 1: {
                double length = readSize("ƒлина ленты в см: ");
                double tariff = readPrice("÷ена за метр ленты: ");

                accessory = new Lenta(color, length, tariff);
                break;
            }

            case 2: {
                double length = readSize("ƒлина листа в см: ");
                double width = readSize("Ўирина листа в см: ");
                double tariff = readPrice("÷ена за квадратный метр обЄртки: ");

                accessory = new Obertka(color, length, width, tariff);
                break;
            }

            default: {
                System.out.println("1 Ч пластикова€ корзинка");
                System.out.println("2 Ч плетЄна€ корзинка из лозы");

                int materialChoice = readInt("¬ыберите материал: ", 1, 2);

                String material;
                if (materialChoice == 1) {
                    material = "пластик";
                } else {
                    material = "лоза";
                }

                double diameter = readSize("ƒиаметр круглого дна в см: ");
                double price = readPrice("÷ена одной корзинки: ");

                int answer = readInt("ƒобавить подкладку? 1 Ч да, 0 Ч нет: ", 0, 1);
                boolean hasLiner = answer == 1;

                double linerTariff = 0;
                if (hasLiner) {
                    linerTariff = readPrice("÷ена за квадратный метр подкладки: ");
                }

                accessory = new Korzinka(
                        color, material, diameter, price, hasLiner, linerTariff
                );
                break;
            }
        }

        if (bouquet.addAccessory(accessory)) {
            System.out.println("ƒобавлено: " + accessory);
        }
    }

    private static void findFlowers(Bouquet bouquet) {
        int min = readInt("ћинимальна€ длина стебл€ в см: ", 0, Integer.MAX_VALUE);
        int max = readInt("ћаксимальна€ длина стебл€ в см: ", min, Integer.MAX_VALUE);

        ArrayList<Flower> found = bouquet.findByStemLength(min, max);

        if (found.isEmpty()) {
            System.out.println("ѕодход€щих цветов нет.");
            return;
        }

        System.out.println("Ќайдено цветов: " + found.size());
        for (int i = 0; i < found.size(); i++) {
            System.out.println((i + 1) + ". " + found.get(i));
        }
    }

    private static String readText(String message) {
        while (true) {
            System.out.print(message);
            String text = scanner.nextLine().trim();

            if (!text.isEmpty()) {
                return text;
            }

            System.out.println("¬ведите значение.");
        }
    }

    private static int readInt(String message, int min, int max) {
        while (true) {
            String text = readText(message);
            try (Scanner input = new Scanner(text)) {
                if (input.hasNextInt()) {
                    int value = input.nextInt();

                    if (!input.hasNext() && value >= min && value <= max) {
                        return value;
                    }
                }
            }

            if (max == Integer.MAX_VALUE) {
                System.out.println("¬ведите целое число не меньше " + min + ".");
            } else {
                System.out.println("¬ведите целое число от " + min + " до " + max + ".");
            }
        }
    }

    private static double readDouble(String message) {
        while (true) {
            String text = readText(message).replace(',', '.');

            try (Scanner input = new Scanner(text)) {
                input.useLocale(Locale.US);

                if (input.hasNextDouble()) {
                    double value = input.nextDouble();

                    if (!input.hasNext() && Double.isFinite(value)) {
                        return value;
                    }
                }
            }

            System.out.println("¬ведите число, например 30 или 12,5.");
        }
    }

    private static double readSize(String message) {
        double size = readDouble(message);

        while (size <= 0) {
            System.out.println("–азмер должен быть больше нул€.");
            size = readDouble(message);
        }

        return size;
    }

    private static double readPrice(String message) {
        double price = readDouble(message);

        while (price < 0) {
            System.out.println("÷ена не может быть отрицательной.");
            price = readDouble(message);
        }

        return price;
    }
}