package ezhikov.lr3;

import java.util.Scanner;

/**
 * Задание 3
 * <p>
 * 8. Дан массив A размера N. Сформировать новый массив B того же размера по следующему правилу:
 * элемент BK равен сумме элементов массива A с номерами от K до N.
 * Реализовать в виде отдельного статического метода.
 */
public class Ex3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }

        int[] B = new int[N];

        for (int k = 0; k < N; k++) {
            int sum = 0;
            for (int i = k; i < N; i++) {
                sum += A[i];
            }
            B[k] = sum;
        }

        for (int value : B) {
            System.out.print(value + " ");
        }
    }
}
