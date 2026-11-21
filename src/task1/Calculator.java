package task1;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Function[] functions = {new Square(), new CubeRoot(), new NaturalLog(), new Sin(), new Reciprocal()};

        System.out.println("Выберите функцию:");
        for (int i = 0; i < functions.length; i++) {
            System.out.println((i + 1) + ". " + functions[i].getName());
        }

        int number = scanner.nextInt();

        if (number < 1 || number > functions.length) {
            System.out.println("Нет функции с таким номером.");
            return;
        }

        Function selected = functions[number - 1];

        System.out.println("1. Вычислить в точке");
        System.out.println("2. Вычислить на интервале");
        int mode = scanner.nextInt();

        if (mode == 1) {
            System.out.print("Введите x: ");
            double x = scanner.nextDouble();

            if (selected.isDefined(x)) {
                double result = selected.calculate(x);

                if (Double.isFinite(result)) {
                    System.out.println("Результат: " + result);
                } else {
                    System.out.println("Результат не является конечным числом.");
                }
            } else {
                System.out.println("Функция не определена.");
            }
        } else if (mode == 2) {
            System.out.print("Начало интервала: ");
            double start = scanner.nextDouble();

            System.out.print("Конец интервала: ");
            double end = scanner.nextDouble();

            System.out.print("Шаг: ");
            double step = scanner.nextDouble();

            selected.calculateInterval(start, end, step);
        } else {
            System.out.println("Нет такого режима.");
        }
    }
}



