package ezhikov.lr5.ex1;

import java.util.Objects;

/**
 * Класс квадратичного выражения
 */
public class QuadraticEquation extends MathExpression {
    /**
     * Коэффициент a
     */
    private final double a;

    /**
     * Коэффициент b
     */
    private final double b;

    /**
     * Коэффициент c
     */
    private final double c;

    /**
     * Дискриминант
     */
    private final double discriminant;

    public QuadraticEquation(double a, double b, double c) {
        super("Quadratic", "ax^2 + bx + c = 0");

        if (a == 0) {
            throw new IllegalArgumentException("Коэффициент 'a' не может быть равен 0");
        }
        this.a = a;
        this.b = b;
        this.c = c;
        this.discriminant = calculateDiscriminant();
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    private double calculateDiscriminant() {
        return b * b - 4 * a * c;
    }

    /**
     * Решить квадратичное уравнение
     */
    @Override
    public Solution solve() {
        if (discriminant > 0) {
            double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            return new Solution(x1, x2);
        } else if (discriminant == 0) {
            double x = -b / (2 * a);
            return new Solution(x);
        } else {
            return new Solution();
        }
    }

    @Override
    public String toString() {
        return String.format("%sx^2 + %sx + %s = 0", a, b, c);
    }


    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        QuadraticEquation that = (QuadraticEquation) obj;
        return Double.compare(that.a, a) == 0 && Double.compare(that.b, b) == 0 && Double.compare(that.c, c) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), a, b, c);
    }
}
