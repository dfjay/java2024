package ezhikov.lr7;

/**
 * Результат вычисления квадратичного уравнения
 */
public class Solution {
    private final double x1;
    private final double x2;

    public Solution(double x1, double x2) {
        this.x1 = x1;
        this.x2 = x2;
    }

    public Solution(double x) {
        x1 = x;
        x2 = x;
    }

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
