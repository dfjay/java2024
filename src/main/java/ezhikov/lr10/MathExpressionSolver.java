package ezhikov.lr10;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.io.IOException;
import java.util.Scanner;

/**
 * Базовый класс программы по решению квадратичного уравнения
 */
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class MathExpressionSolver {
    Scanner scanner = new Scanner(System.in);
    MathExpressionHistory<MathExpression> history = new MathExpressionHistory<>(10);
    ProgramInfo programInfo = new ProgramInfo();
    DeveloperInfo developerInfo = new DeveloperInfo();

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
                case 6 -> saveHistoryToFile();
                case 7 -> loadHistoryFromFile();
                case 8 -> running = false;
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
                6. Сохранить историю в файл
                7. Загрузить историю из файла
                8. Выход
                """);
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

    private void saveHistoryToFile() {
        System.out.print("Введите имя файла для сохранения истории: ");
        String filename = scanner.next();
        try {
            history.saveHistoryToFile(filename);
            System.out.println("История успешно сохранена в файл " + filename);
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении истории: " + e.getMessage());
        }
    }

    private void loadHistoryFromFile() {
        System.out.print("Введите имя файла для загрузки истории: ");
        String filename = scanner.next();
        try {
            history.loadHistoryFromFile(filename);
            System.out.println("История успешно загружена из файла " + filename);
        } catch (IOException e) {
            System.out.println("Ошибка при загрузке истории: " + e.getMessage());
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
