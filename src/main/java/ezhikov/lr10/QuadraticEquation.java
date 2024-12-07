package ezhikov.lr10;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.Objects;

/**
 * Класс квадратичного выражения
 */
@Getter
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class QuadraticEquation extends MathExpression implements Comparable<QuadraticEquation>, Cloneable {
    /**
     * Коэффициент a
     */
    double a;

    /**
     * Коэффициент b
     */
    double b;

    /**
     * Коэффициент c
     */
    double c;

    /**
     * Дискриминант
     */
    double discriminant;

    public QuadraticEquation(double a, double b, double c) throws MathExpressionException {
        super("Quadratic", "ax^2 + bx + c = 0");

        if (a == 0) {
            throw new MathExpressionException("Коэффициент 'a' не может быть равен 0");
        }
        this.a = a;
        this.b = b;
        this.c = c;
        this.discriminant = calculateDiscriminant();
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

    @Override
    public int compareTo(QuadraticEquation o) {
        int compareA = Double.compare(this.a, o.a);
        if (compareA != 0) {
            return compareA;
        }
        int compareB = Double.compare(this.b, o.b);
        if (compareB != 0) {
            return compareB;
        }
        return Double.compare(this.c, o.c);
    }

    @Override
    protected Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
