package ezhikov.lr5.ex1;

import java.util.Objects;

/**
 * Класс линейного уравнения
 */
public class LinearEquation extends MathExpression {
    /**
     * Коэффициент a
     */
    private final double a;

    /**
     * Коэффициент b
     */
    private final double b;

    public LinearEquation(double a, double b) {
        super("Linear", "ax + b = 0");
        if (a == 0) {
            throw new IllegalArgumentException("Коэффициент 'a' не может быть равен 0");
        }
        this.a = a;
        this.b = b;
    }

    @Override
    public Solution solve() {
        return new Solution(-b / a);
    }

    @Override
    public String toString() {
        return String.format("%sx + %s = 0", a, b);
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        LinearEquation that = (LinearEquation) obj;
        return Double.compare(that.a, a) == 0 && Double.compare(that.b, b) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), a, b);
    }
}
