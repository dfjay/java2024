package ezhikov.lr1;

import java.util.Scanner;

/**
 * Задание 3
 * <p>
 * Выполнить задание на использование условного оператора if.
 * <p>
 * Исходные данные:
 * Даны три числа. Найти среднее из них (то есть число, расположенное между наименьшим и наибольшим).
 */
public class Ex3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Первое число: ");
        double a = scanner.nextDouble();
        System.out.print("Второе число: ");
        double b = scanner.nextDouble();
        System.out.print("Третье число: ");
        double c = scanner.nextDouble();

        double middle;
        if ((a >= b && a <= c) || (a <= b && a >= c)) {
            middle = a;
        } else if ((b >= a && b <= c) || (b <= a && b >= c)) {
            middle = b;
        } else {
            middle = c;
        }

        System.out.printf("Среднее число: %s", middle);
    }
}
