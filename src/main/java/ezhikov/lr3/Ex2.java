package ezhikov.lr3;

import java.util.Scanner;

/**
 * Задание 2
 * <p>
 * 8. Дан массив размера N. Найти количество участков, на которых его элементы монотонно возрастают.
 */
public class Ex2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }

        int count = 0;
        boolean isIncreasing = false;

        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                if (!isIncreasing) {
                    count++;
                    isIncreasing = true;
                }
            } else {
                isIncreasing = false;
            }
        }

        System.out.println(count);
    }
}
