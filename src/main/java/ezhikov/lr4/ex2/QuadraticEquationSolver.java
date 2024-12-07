package ezhikov.lr4.ex2;

import java.util.Scanner;

/**
 * Базовый класс программы по решению квадратичного уравнения
 */
public class QuadraticEquationSolver {
    private final Scanner scanner = new Scanner(System.in);
    private final EquationHistory history = new EquationHistory(10);
    private final ProgramInfo programInfo = new ProgramInfo();
    private final DeveloperInfo developerInfo = new DeveloperInfo();

    public void run() {
        boolean running = true;
        while (running) {
            printMenu();
            int choice = getValidIntInput("Выберите действие: ", 1, 5);
            switch (choice) {
                case 1 -> solveEquation();
                case 2 -> System.out.println(programInfo);
                case 3 -> System.out.println(developerInfo);
                case 4 -> System.out.println(history);
                case 5 -> running = false;
            }
        }
        System.out.println("Программа завершена.");
    }

    private void printMenu() {
        System.out.println("""
                Главное меню:
                1. Решить квадратное уравнение
                2. Информация о программе
                3. Информация о разработчике
                4. История вычислений
                5. Выход""");
    }

    private void solveEquation() {
        System.out.println("Решение квадратного уравнения ax^2 + bx + c = 0");

        try {
            double a = getValidDoubleInput("Введите коэффициент a: ");
            double b = getValidDoubleInput("Введите коэффициент b: ");
            double c = getValidDoubleInput("Введите коэффициент c: ");

            QuadraticEquation equation = new QuadraticEquation(a, b, c);
            history.add(equation);

            System.out.println("Результаты:");
            System.out.println(equation.solve());
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private double getValidDoubleInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                return scanner.nextDouble();
            } else {
                System.out.println("Ошибка: введите число.");
                scanner.next();
            }
        }
    }

    private int getValidIntInput(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.println("Ошибка: введите число от " + min + " до " + max + ".");
            } else {
                System.out.println("Ошибка: введите целое число.");
                scanner.next();
            }
        }
    }

    public static void main(String[] args) {
        new QuadraticEquationSolver().run();
    }
}
