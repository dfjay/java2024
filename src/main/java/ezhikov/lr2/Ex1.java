package ezhikov.lr2;

import java.util.Scanner;

/**
 * Задание 1
 * <p>
 * 8. Дано целое N. Посчитайте сумму следующего ряда (вещественное число):
 */
public class Ex1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        System.out.print("Введите целое положительное число N: ");
        if (N < 0) {
            System.out.println("N должно быть положительным числом.");
            return;
        }

        double sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += 1 / Math.sqrt(i);
        }

        System.out.printf("Сумма ряда для N = %d равна: %f", N, sum);
    }
}
