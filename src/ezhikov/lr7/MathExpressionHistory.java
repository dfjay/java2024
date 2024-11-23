package ezhikov.lr7;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс для работы с историей запросов
 */
public class MathExpressionHistory {
    /**
     * Выражения
     */
    private final List<MathExpression> expressions;

    /**
     * Вместимость истории
     */
    private final int capacity;

    public MathExpressionHistory(int capacity) {
        this.capacity = capacity;
        this.expressions = new ArrayList<>(capacity);
    }

    /**
     * Добавить новое уравнение в историю
     */
    public void add(MathExpression equation) {
        if (expressions.size() >= capacity) expressions.removeFirst();

        expressions.add(equation);
    }

    /**
     * Решить все выражения из истории
     */
    public void solveAll() {
        for (MathExpression expression : expressions) {
            System.out.println("Решение выражения: " + expression);
            System.out.println(expression.solve());
            System.out.println();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("История вычислений (последние " + capacity + " уравнений):\n");
        if (expressions.isEmpty()) {
            sb.append("История пуста");
        } else {
            for (MathExpression equation : expressions) {
                sb.append(equation).append("\n");
            }
        }

        return sb.toString();
    }
}
