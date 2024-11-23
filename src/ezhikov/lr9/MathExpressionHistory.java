package ezhikov.lr9;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Класс для работы с историей запросов
 */
public class MathExpressionHistory<T extends MathExpression> {
    /**
     * Выражения
     * Для ЛР8 как раз таки тут уже использовалась коллекция, а не массив.
     * Для ЛР9 тут использовался ArrayList, но как видно в методе [add], мы удаляем элементы из начала,
     * что вызывает сдвиг всех элементов в случае ArrayList. Для оптимизации можно поменять на LinkedList.
     */
    private final List<T> expressions = new LinkedList<>();

    /**
     * Кеш решений уравнений
     */
    private final Map<T, Solution> solutionCache = new HashMap<>();

    /**
     * Вместимость истории
     */
    private final int capacity;

    public MathExpressionHistory(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Добавить новое уравнение в историю
     */
    public void add(T equation) {
        if (expressions.size() >= capacity) {
            T removedExpression = expressions.removeFirst();
            solutionCache.remove(removedExpression);
        }

        expressions.add(equation);
    }

    /**
     * Получить решение из кеша или вычислить его
     */
    private Solution getSolution(T expression) {
        if (!solutionCache.containsKey(expression)) {
            Solution solution = expression.solve();
            solutionCache.put(expression, solution);
            return solution;
        } else {
            return solutionCache.get(expression);
        }
    }

    /**
     * Решить все выражения из истории
     */
    public void solveAll() {
        for (T expression : expressions) {
            System.out.println("Решение выражения: " + expression);
            System.out.println(getSolution(expression));
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
