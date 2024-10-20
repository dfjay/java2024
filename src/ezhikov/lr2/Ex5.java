package ezhikov.lr2;

import java.util.Scanner;

/**
 * Доработать программу:
 * 	добавить главное меню программы, основанное на цикле while, в котором есть как минимум:
 * o	выполнить расчет (созвучно смыслу программы)
 * o	информация о программе
 * o	информация о разработчике
 * o	выход из программы
 * 	при вводе неправильных данных предлагать пользователю повторить ввод, пока не будут получены верные данные или не получена команда на выход из программы
 * 	произвести декомпозицию исходной программы, реализовав статические методы для отдельных ее частей
 */
public class Ex5 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            printMenu();
            int choice = getValidIntInput("Выберите действие: ", 1, 4);
            switch (choice) {
                case 1 -> solveQuadraticEquation();
                case 2 -> showProgramInfo();
                case 3 -> showDeveloperInfo();
                case 4 -> running = false;
            }
        }
        System.out.println("Программа завершена.");
    }

    private static void printMenu() {
        System.out.println("Главное меню:");
        System.out.println("1. Решить квадратное уравнение");
        System.out.println("2. Информация о программе");
        System.out.println("3. Информация о разработчике");
        System.out.println("4. Выход");
    }

    private static void solveQuadraticEquation() {
        System.out.println("Решение квадратного уравнения ax^2 + bx + c = 0");
        if (!scanner.hasNextDouble()) {
            System.out.println("Ошибка: введено некорректное значение для коэффициента a.");
            return;
        }
        double a = scanner.nextDouble();
        if (a == 0) {
            System.out.println("Ошибка: коэффициент 'a' не может быть равен 0.");
            return;
        }

        System.out.print("Введите коэффициент b: ");
        if (!scanner.hasNextDouble()) {
            System.out.println("Ошибка: введено некорректное значение для коэффициента b.");
            return;
        }
        double b = scanner.nextDouble();

        System.out.print("Введите коэффициент c: ");
        if (!scanner.hasNextDouble()) {
            System.out.println("Ошибка: введено некорректное значение для коэффициента c.");
            return;
        }
        double c = scanner.nextDouble();

        double discriminant = b * b - 4 * a * c;

        System.out.println("Результаты:");
        if (discriminant > 0) {
            double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.printf("""
                    Уравнение имеет два корня:
                    x1 = %s
                    x2 = %s
                    """, x1, x2);
        } else if (discriminant == 0) {
            double x = -b / (2 * a);
            System.out.printf("""
                    Уравнение имеет один корень:
                    x = %s
                    """, x);
        } else {
            System.out.println("Уравнение не имеет действительных корней.");
        }
    }

    private static void showProgramInfo() {
        System.out.println("Информация о программе:");
        System.out.println("Эта программа решает квадратное уравнение вида ax^2 + bx + c = 0");
        System.out.println("Версия: 1.0");
    }

    private static void showDeveloperInfo() {
        System.out.println("Информация о разработчике:");
        System.out.println("Разработчик: Павел Ежиков");
        System.out.println("Группа: РИМ-140970");
        System.out.println("Год разработки: 2024");
    }

    private static int getValidIntInput(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                if (value >= min && value <= max) {
                    return value;
                } else {
                    System.out.println("Ошибка: введите число от " + min + " до " + max + ".");
                }
            } else {
                System.out.println("Ошибка: введите целое число.");
                scanner.next();
            }
        }
    }
}
