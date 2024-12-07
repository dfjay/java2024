package ezhikov.lr4.ex1;

public class Matrix {
    private final double[][] matrix;

    public Matrix(double[][] matrix) {
        this.matrix = matrix;
    }

    /**
     * Количество элементов
     */
    public int getElementCount() {
        return matrix.length * matrix[0].length;
    }

    /**
     * Сумма всех элементов
     */
    public double getSum() {
        double sum = 0;
        for (double[] row : matrix) {
            for (double element : row) {
                sum += element;
            }
        }
        return sum;
    }

    /**
     * Умножить матрицу на число
     */
    public void multiplyByNumber(double number) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] *= number;
            }
        }
    }

    /**
     * Добавить ко всем элементам число
     */
    public void addNumber(double number) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] += number;
            }
        }
    }

    /**
     * Вывести матрицу
     */
    public void print() {
        for (double[] row : matrix) {
            for (double element : row) {
                System.out.printf("%s ", element);
            }
            System.out.println();
        }
        System.out.println();
    }
}
