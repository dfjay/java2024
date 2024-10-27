package ezhikov.lr3;

import java.util.Scanner;

/**
 * Задание 5. (продолжение работы над программой из л/р 2)
 * Доработать программу:
 * 	найти применение массивам:
 * o	для хранения параметров вычисления
 * o	для перемещения данных между статическими методами
 * o	пр.
 */
public class Ex5 {
    private static final Scanner scanner = new Scanner(System.in);
    private static final double[][] equationHistory = new double[10][3];
    private static int historyIndex = 0;

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            printMenu();
            int choice = getValidIntInput("Выберите действие: ", 1, 5);
            switch (choice) {
                case 1 -> solveQuadraticEquation();
                case 2 -> showProgramInfo();
                case 3 -> showDeveloperInfo();
                case 4 -> showHistory();
                case 5 -> running = false;
            }
        }
        System.out.println("Программа завершена.");
    }

    private static void printMenu() {
        System.out.println("Главное меню:");
        System.out.println("1. Решить квадратное уравнение");
        System.out.println("2. Информация о программе");
        System.out.println("3. Информация о разработчике");
        System.out.println("4. История вычислений");
        System.out.println("5. Выход");
    }

    private static void solveQuadraticEquation() {
        System.out.println("Решение квадратного уравнения ax^2 + bx + c = 0");

        System.out.print("Введите коэффициент a: ");
        if (!scanner.hasNextDouble()) {
            System.out.println("Ошибка: введено некорректное значение для коэффициента a.");
            scanner.next();
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
            scanner.next();
            return;
        }
        double b = scanner.nextDouble();

        System.out.print("Введите коэффициент c: ");
        if (!scanner.hasNextDouble()) {
            System.out.println("Ошибка: введено некорректное значение для коэффициента c.");
            scanner.next();
            return;
        }
        double c = scanner.nextDouble();

        saveToHistory(a, b, c);

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

    private static void saveToHistory(double a, double b, double c) {
        equationHistory[historyIndex][0] = a;
        equationHistory[historyIndex][1] = b;
        equationHistory[historyIndex][2] = c;
        historyIndex = (historyIndex + 1) % 10;
    }

    private static void showHistory() {
        System.out.println("История вычислений (последние 10 уравнений):");
        boolean hasHistory = false;
        for (double[] equation : equationHistory) {
            if (equation[0] != 0) {
                System.out.printf("%sx^2 + %sx + %s = 0\n", equation[0], equation[1], equation[2]);
                hasHistory = true;
            }
        }
        if (!hasHistory) {
            System.out.println("История пуста");
        }
    }

    private static void showProgramInfo() {
        System.out.println("Информация о программе:");
        System.out.println("Эта программа решает квадратное уравнение вида ax^2 + bx + c = 0");
        System.out.println("Версия: 1.1");
        System.out.println("Добавлена функция хранения истории вычислений");
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