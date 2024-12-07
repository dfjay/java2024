package ezhikov.lr10;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * Результат вычисления квадратичного уравнения
 */
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Solution {
    double x1;
    double x2;

    /**
     * 1 корень
     */
    public Solution(double x) {
        x1 = x;
        x2 = x;
    }

    /**
     * Нет корней
     */
    public Solution() {
        x1 = 0;
        x2 = 0;
    }

    @Override
    public String toString() {
        if (x1 == 0 && x2 == 0) {
            return "Уравнение не имеет действительных корней.";
        }

        if (x1 == x2) {
            return String.format("""
                    Уравнение имеет один корень:
                    x = %s
                    """, x1);
        } else {
            return String.format("""
                    Уравнение имеет два корня:
                    x1 = %s
                    x2 = %s
                    """, x1, x2);
        }
    }
}
