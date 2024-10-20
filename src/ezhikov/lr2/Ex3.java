package ezhikov.lr2;

import java.util.Scanner;

/**
 * Задание 3
 * <p>
 * Дано целое число N (> 0).
 * Используя операции деления нацело и взятия остатка от деления, найти количество и сумму его цифр.
 */
public class Ex3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите целое число N (> 0): ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("N должно быть больше 0");
            return;
        }

        int count = 0;
        int sum = 0;
        int number = n;

        while (number > 0) {
            int digit = number % 10;
            count++;
            sum += digit;
            number /= 10;
        }

        System.out.println("Количество цифр: " + count);
        System.out.println("Сумма цифр: " + sum);
    }
}
