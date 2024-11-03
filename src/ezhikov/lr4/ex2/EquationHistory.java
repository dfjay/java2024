package ezhikov.lr4.ex2;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс для работы с историей запросов
 */
public class EquationHistory {
    /**
     * Выражения
     */
    private final List<QuadraticEquation> equations;

    /**
     * Вместимость истории
     */
    private final int capacity;

    public EquationHistory(int capacity) {
        this.capacity = capacity;
        this.equations = new ArrayList<>(capacity);
    }

    /**
     * Добавить новое уравнение в историю
     */
    public void add(QuadraticEquation equation) {
        if (equations.size() >= capacity) equations.removeFirst();

        equations.add(equation);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("История вычислений (последние " + capacity + " уравнений):\n");
        if (equations.isEmpty()) {
            sb.append("История пуста");
        } else {
            for (QuadraticEquation equation : equations) {
                sb.append(equation).append("\n");
            }
        }

        return sb.toString();
    }
}
