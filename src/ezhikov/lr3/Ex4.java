package ezhikov.lr3;

import java.util.Scanner;

/**
 * Задание 4
 * <p>
 * 8. Дана квадратная матрица A порядка M (M — нечетное число).
 * Начиная с элемента A1,1 и перемещаясь по часовой стрелке, вывести все ее элементы по спирали:
 * первая строка, последний столбец, последняя строка в обратном порядке, первый столбец в обратном порядке,
 * оставшиеся элементы второй строки и т. д.; последним выводится центральный элемент матрицы.
 */
public class Ex4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int M = scanner.nextInt();
        int[][] A = new int[M][M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                A[i][j] = scanner.nextInt();
            }
        }

        int rowStart = 0;
        int rowEnd = M - 1;
        int colStart = 0;
        int colEnd = M - 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int j = colStart; j <= colEnd; j++) {
                System.out.print(A[rowStart][j] + " ");
            }
            rowStart++;

            // Правый столбец сверху вниз
            for (int i = rowStart; i <= rowEnd; i++) {
                System.out.print(A[i][colEnd] + " ");
            }
            colEnd--;

            if (rowStart <= rowEnd) {
                // Нижняя строка справа налево
                for (int j = colEnd; j >= colStart; j--) {
                    System.out.print(A[rowEnd][j] + " ");
                }
                rowEnd--;
            }

            if (colStart <= colEnd) {
                // Левый столбец снизу вверх
                for (int i = rowEnd; i >= rowStart; i--) {
                    System.out.print(A[i][colStart] + " ");
                }
                colStart++;
            }
        }
    }
}
