package ezhikov.lr8.test;

import ezhikov.lr8.EquationUtils;
import ezhikov.lr8.MathExpressionException;
import ezhikov.lr8.QuadraticEquation;

import java.util.ArrayList;
import java.util.List;

/**
 * Вызываем и тестируем статические утилитный класс
 */
public class EquationUtilsTest {
    public static void main(String[] args) throws MathExpressionException {
        List<QuadraticEquation> equations = new ArrayList<>();
        equations.add(new QuadraticEquation(1, -3, 2));
        equations.add(new QuadraticEquation(2, 5, -3));
        equations.add(new QuadraticEquation(0.5, 2, 1));

        EquationUtils.sortEquations(equations);

        for (QuadraticEquation eq : equations) {
            System.out.println(eq);
        }
    }
}
