package task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. квадрат разности");
        System.out.println("2. площадь квадрата");
        int choice = scanner.nextInt();

        Formula formula;

        switch (choice) {
            case 1:
                System.out.print("Введите a: ");
                double a = scanner.nextDouble();
                System.out.print("Введите b: ");
                double b = scanner.nextDouble();
                formula = new Algebr(a, b);
                break;

            case 2:
                System.out.print("Введите сторону квадрата: ");
                double side = scanner.nextDouble();
                formula = new Geometric(side);
                break;

            default:
                System.out.println("Нет такого пункта.");
                return;
        }

        formula.print();
    }
}