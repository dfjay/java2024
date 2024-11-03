package ezhikov.lr4.ex1;

/**
 * 8. Описать класс Matrix. Поля: двумерный массив double (ссылка передается в конструктор).
 * Методы: количество элементов в массиве, сумма всех элементов, умножить матрицу на число,
 * добавить ко всем элементам число
 */
public class Ex1 {
    public static void main(String[] args) {
        double[][] testArray = {
                {1.0, 2.0, 3.0},
                {4.0, 5.0, 6.0},
                {7.0, 8.0, 9.0}
        };

        Matrix matrix = new Matrix(testArray);

        System.out.println("Исходная матрица:");
        matrix.print();

        System.out.println("Количество элементов: " + matrix.getElementCount());
        System.out.println("Сумма всех элементов: " + matrix.getSum());

        System.out.println("Умножение матрицы на 2:");
        matrix.multiplyByNumber(2);
        matrix.print();

        System.out.println("Добавление 1 ко всем элементам:");
        matrix.addNumber(1);
        matrix.print();
    }
}
