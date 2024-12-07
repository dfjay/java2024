package ezhikov.lr8;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс для работы с историей запросов
 */
public class MathExpressionHistory<T extends MathExpression>{
    /**
     * Выражения
     * Для ЛР8 как раз таки тут уже использовалась коллекция, а не массив
     */
    private final List<T> expressions;

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
    public void add(T equation) {
        if (expressions.size() >= capacity) expressions.removeFirst();

        expressions.add(equation);
    }

    /**
     * Решить все выражения из истории
     */
    public void solveAll() {
        for (T expression : expressions) {
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
            for (T equation : expressions) {
                sb.append(equation).append("\n");
            }
        }

        return sb.toString();
    }
}
