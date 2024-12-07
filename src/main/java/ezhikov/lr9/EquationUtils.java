package ezhikov.lr9;

import java.util.Collections;
import java.util.List;

/**
 * Утилиты для работы с уравнениями
 */
public class EquationUtils {
    private EquationUtils() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Обобщенный статический метод для сортировки списка уравнений
     *
     * @param equations список уравнений
     */
    public static <T extends Comparable<T>> void sortEquations(List<T> equations) {
        Collections.sort(equations);
    }
}
