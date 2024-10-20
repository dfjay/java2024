package ezhikov.lr2;

import java.util.Scanner;

/**
 * Задание 2
 * <p>
 * 8. Дано вещественное число X и целое число N (> 0). Найти значение выражения:
 */
public class Ex2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите вещественное число X: ");
        double x = scanner.nextDouble();

        System.out.println("Введите целое число N (> 0): ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Ошибка: N должно быть больше 0");
            return;
        }

        double result = 1;
        double term = 1;

        for (int i = 1; i <= n; i++) {
            term *= -1 * x * x / (2 * i * (2 * i - 1));
            result += term;
        }

        System.out.printf("cos(%f) ~ %f", x, result);
    }
}
