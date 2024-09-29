package ezhikov.lr1;

import java.util.Scanner;

/**
 * Задание 2
 * <p>
 * Вычислить математическую функцию для заданного с консоли значения x.
 * <p>
 * Исходные данные:
 * Найти значение функции y = arccos(x) + arcsin(2x) + arctan(3x) при данном значении x.
 */
public class Ex2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double x = scanner.nextDouble();

        double y = Math.acos(x) + Math.asin(2 * x) + Math.atan(3 * x);

        System.out.printf("y = %s rad", y);
    }
}
