package ezhikov.lr10.test;

import ezhikov.lr10.MathExpressionException;
import ezhikov.lr10.MathExpressionHistory;
import ezhikov.lr10.QuadraticEquation;

/**
 * Вызываем и тестируем историю с использованием обобщений
 */
public class MathExpressionHistoryTest {
    public static void main(String[] args) throws MathExpressionException {
        MathExpressionHistory<QuadraticEquation> quadraticHistory = new MathExpressionHistory<>(5);

        quadraticHistory.add(new QuadraticEquation(1, -3, 2));
        quadraticHistory.add(new QuadraticEquation(1, 2, 1));
        quadraticHistory.add(new QuadraticEquation(1, 0, -4));

        quadraticHistory.solveAll();

        System.out.println(quadraticHistory);
    }
}
