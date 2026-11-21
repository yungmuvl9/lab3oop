package task2flower;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class FlowerShop {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Bouquet bouquet = new Bouquet();
        while (true) {
            System.out.println("\n1 Ч добавить цветы");
            System.out.println("2 Ч добавить аксессуар");
            System.out.println("3 Ч показать букет и стоимость");
            System.out.println("4 Ч удалить цветок");
            System.out.println("5 Ч удалить аксессуар");
            System.out.println("6 Ч отсортировать цветы по свежести");
            System.out.println("7 Ч найти цветы по длине стебл€");
            System.out.println("0 Ч завершить заказ");

            int choice = readMenuChoice("¬аш выбор: ", 0, 7);
            switch (choice) {
                case 1:
                    addFlowers(bouquet);
                    break;
                case 2:
                    addAccessory(bouquet);
                    break;
                case 3:
                    System.out.println(bouquet);
                    break;
                case 4:
                    System.out.println(bouquet);
                    int flowerNumber = readAnyInt("Ќомер цветка: ");
                    if (bouquet.removeFlower(flowerNumber)) {
                        System.out.println("÷веток удалЄн.");
                        System.out.println(bouquet);
                    } else {
                        System.out.println("÷ветка с таким номером нет.");
                    }
                    break;
                case 5:
                    System.out.println(bouquet);
                    int accessoryNumber = readAnyInt("Ќомер аксессуара: ");
                    if (bouquet.removeAccessory(accessoryNumber)) {
                        System.out.println("јксессуар удалЄн.");
                        System.out.println(bouquet);
                    } else {
                        System.out.println("јксессуара с таким номером нет.");
                    }
                    break;
                case 6:
                    bouquet.sortByFreshness();
                    System.out.println("Ѕукет после сортировки по свежести:");
                    System.out.println(bouquet);
                    break;
                case 7:
                    findFlowers(bouquet);
                    break;
                case 0:
                    System.out.println("»тоговый состав заказа:");
                    System.out.println(bouquet);
                    return;
            }
        }
    }

    private static void addFlowers(Bouquet bouquet) {
        System.out.println("\n1 Ч роза");
        System.out.println("2 Ч тюльпан");
        System.out.println("3 Ч лили€");
        System.out.println("4 Ч хризантема");
        int type = readMenuChoice("¬ыберите вид цветка: ", 1, 4);

        int quantity = readAnyInt("—колько таких цветов? ");
        if (quantity <= 0) {
            System.out.println(" оличество должно быть больше нул€. ”становлено значение по умолчанию: 1.");
            quantity = 1;
        }

        String color = readLine("÷вет: ");
        double price = readDouble("Ѕазова€ цена одного цветка в рубл€х: ");
        int days = readAnyInt("ƒней после срезки: ");
        int length = readAnyInt("ƒлина стебл€ в см: ");

        // ѕервый цветок провер€ет и корректирует данные один раз
        Flower first = createFlower(type, color, price, days, length);
        if (!bouquet.addFlower(first)) {
            System.out.println("÷веты этой партии ув€ли. ѕарти€ не добавлена.");
            return;
        }

        // ќстальные создаютс€ уже с проверенными значени€ми, чтобы не дублировать предупреждени€
        for (int i = 1; i < quantity; i++) {
            Flower copy = createFlower(
                    type,
                    first.getColor(),
                    first.getPrice(),
                    first.getDaysAfterCut(),
                    first.getStemLength()
            );
            bouquet.addFlower(copy);
        }

        System.out.println("ƒобавлено цветов: " + quantity);
        System.out.printf("—тоимость букета: %.2f руб.%n", bouquet.getCost());
    }

    private static Flower createFlower(int type, String color, double price, int days, int length) {
        switch (type) {
            case 1:
                return new Rose(color, price, days, length);
            case 2:
                return new Tulip(color, price, days, length);
            case 3:
                return new Lily(color, price, days, length);
            default:
                return new Chrysanthemum(color, price, days, length);
        }
    }

    private static void addAccessory(Bouquet bouquet) {
        System.out.println("\n1 Ч лента");
        System.out.println("2 Ч обЄртка");
        System.out.println("3 Ч корзинка");
        int type = readMenuChoice("¬ыберите аксессуар: ", 1, 3);
        String color = readLine("÷вет аксессуара: ");

        Accessory accessory;
        switch (type) {
            case 1: {
                double length = readDouble("ƒлина ленты в см: ");
                double tariff = readDouble("÷ена за метр ленты: ");
                accessory = new Lenta(color, length, tariff);
                break;
            }
            case 2: {
                double length = readDouble("ƒлина листа в см: ");
                double width = readDouble("Ўирина листа в см: ");
                double tariff = readDouble("÷ена за квадратный метр обЄртки: ");
                accessory = new Obertka(color, length, width, tariff);
                break;
            }
            default: {
                System.out.println("1 Ч пластикова€ корзинка");
                System.out.println("2 Ч плетЄна€ корзинка из лозы");
                int materialChoice = readMenuChoice("¬ыберите материал: ", 1, 2);
                String material = (materialChoice == 1) ? "пластик" : "лоза";
                double diameter = readDouble("ƒиаметр круглого дна в см: ");
                double price = readDouble("÷ена одной корзинки: ");
                int answer = readMenuChoice("ƒобавить подкладку? 1 Ч да, 0 Ч нет: ", 0, 1);
                boolean hasLiner = (answer == 1);
                double linerTariff = 0;
                if (hasLiner) {
                    linerTariff = readDouble("÷ена за квадратный метр подкладки: ");
                }
                accessory = new Korzinka(color, material, diameter, price, hasLiner, linerTariff);
                break;
            }
        }

        if (bouquet.addAccessory(accessory)) {
            System.out.println("ƒобавлено: " + accessory);
        }
    }

    private static void findFlowers(Bouquet bouquet) {
        int min = readAnyInt("ћинимальна€ длина стебл€ в см: ");
        int max = readAnyInt("ћаксимальна€ длина стебл€ в см: ");
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

    private static String readLine(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    private static int readMenuChoice(String message, int min, int max) {
        while (true) {
            int value = readAnyInt(message);
            if (value >= min && value <= max) {
                return value;
            }
            System.out.println("¬ведите число от " + min + " до " + max + ".");
        }
    }

    private static int readAnyInt(String message) {
        while (true) {
            System.out.print(message);
            String text = scanner.nextLine().trim();
            try {
                return Integer.parseInt(text);
            } catch (NumberFormatException e) {
                System.out.println("¬ведите целое число.");
            }
        }
    }

    private static double readDouble(String message) {
        while (true) {
            System.out.print(message);
            String text = scanner.nextLine().trim().replace(',', '.');
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
}