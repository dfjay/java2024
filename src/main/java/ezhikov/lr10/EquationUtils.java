package ezhikov.lr10;

import lombok.experimental.UtilityClass;

import java.util.Collections;
import java.util.List;

/**
 * Утилиты для работы с уравнениями
 */
@UtilityClass
public class EquationUtils {
    /**
     * Обобщенный статический метод для сортировки списка уравнений
     *
     * @param equations список уравнений
     */
    public <T extends Comparable<T>> void sortEquations(List<T> equations) {
        Collections.sort(equations);
    }
}
