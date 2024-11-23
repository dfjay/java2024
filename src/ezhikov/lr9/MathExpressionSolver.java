package ezhikov.lr9;

import java.util.Scanner;

/**
 * Базовый класс программы по решению квадратичного уравнения
 */
public class MathExpressionSolver {
    private final Scanner scanner = new Scanner(System.in);
    private final MathExpressionHistory<MathExpression> history = new MathExpressionHistory<>(10);
    private final ProgramInfo programInfo = new ProgramInfo();
    private final DeveloperInfo developerInfo = new DeveloperInfo();

    public void run() {
        boolean running = true;
        while (running) {
            printMenu();
            int choice = getValidIntInput("Выберите действие: ", 1, 6);
            switch (choice) {
                case 1 -> solveQuadraticEquation();
                case 2 -> solveLinearEquation();
                case 3 -> System.out.println(programInfo);
                case 4 -> System.out.println(developerInfo);
                case 5 -> {
                    System.out.println("\nРешение всех выражений в истории:");
                    history.solveAll();
                }
                case 6 -> running = false;
            }
        }
        System.out.println("Программа завершена.");
    }

    private void printMenu() {
        System.out.println("""
                Главное меню:
                1. Решить квадратное уравнение
                2. Решить линейное уравнение
                3. Информация о программе
                4. Информация о разработчике
                5. Решить все выражения из истории
                6. Выход""");
    }

    private void solveQuadraticEquation() {
        System.out.println("Решение квадратного уравнения ax^2 + bx + c = 0");
        try {
            double a = getValidDoubleInput("Введите коэффициент a: ");
            double b = getValidDoubleInput("Введите коэффициент b: ");
            double c = getValidDoubleInput("Введите коэффициент c: ");

            QuadraticEquation equation = new QuadraticEquation(a, b, c);
            history.add(equation);

            System.out.println("Результаты:");
            System.out.println(equation.solve());
        } catch (MathExpressionException e) {
            System.out.println("Ошибка в уравнении: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Произошла непредвиденная ошибка: " + e.getMessage());
        }
    }

    private void solveLinearEquation() {
        System.out.println("Решение линейного уравнения ax + b = 0");
        try {
            double a = getValidDoubleInput("Введите коэффициент a: ");
            double b = getValidDoubleInput("Введите коэффициент b: ");

            LinearEquation equation = new LinearEquation(a, b);
            history.add(equation);

            System.out.println("Результаты:");
            System.out.println(equation.solve());
        } catch (MathExpressionException e) {
            System.out.println("Ошибка в уравнении: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Произошла непредвиденная ошибка: " + e.getMessage());
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
        new MathExpressionSolver().run();
    }
}
