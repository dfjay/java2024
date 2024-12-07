package ezhikov.lr10;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Класс для работы с историей запросов
 */
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class MathExpressionHistory<T extends MathExpression> {
    /**
     * Выражения
     * Для ЛР8 как раз таки тут уже использовалась коллекция, а не массив.
     * Для ЛР9 тут использовался ArrayList, но как видно в методе [add], мы удаляем элементы из начала,
     * что вызывает сдвиг всех элементов в случае ArrayList. Для оптимизации можно поменять на LinkedList.
     */
    List<T> expressions = new LinkedList<>();

    /**
     * Кеш решений уравнений
     */
    Map<T, Solution> solutionCache = new HashMap<>();

    /**
     * Вместимость истории
     */
    int capacity;

    ObjectMapper objectMapper = new ObjectMapper();

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
     * Сохранить историю в файл
     */
    public void saveHistoryToFile(String filename) throws IOException {
        String json = objectMapper.writeValueAsString(expressions);
        FileUtils.writeStringToFile(new File(filename), json, StandardCharsets.UTF_8);
    }

    /**
     * Получить историю из файла
     */
    public void loadHistoryFromFile(String filename) throws IOException {
        String json = FileUtils.readFileToString(new File(filename), StandardCharsets.UTF_8);
        List<T> loadedExpressions = objectMapper.readValue(json, new TypeReference<>() {});
        expressions.clear();
        expressions.addAll(loadedExpressions);
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
