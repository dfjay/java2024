package ezhikov.lr3;

import java.util.Scanner;

/**
 * Задание 1
 * <p>
 * 8. Дан массив A размера N. Вывести его элементы в следующем порядке:
 * A1, An, A2, An-1...
 */
public class Ex1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }

        int n = A.length;
        for (int i = 0; i < (n + 1) / 2; i++) {
            System.out.print(A[i] + " ");

            if (i != n - 1 - i && i < n - 1 - i) {
                System.out.print(A[n - 1 - i] + " ");
            }
        }
    }
}
