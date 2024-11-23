package ezhikov.lr8;

import java.util.Collections;
import java.util.List;

/**
 * Утилиты для работы с уравнениями
 */
public class EquationUtils {
    /**
     * Обобщенный статический метод для сортировки списка уравнений
     *
     * @param equations список уравнений
     * @param <T>       тип уравнения, реализующего Comparable
     */
    public static <T extends Comparable<T>> void sortEquations(List<T> equations) {
        Collections.sort(equations);
    }
}
