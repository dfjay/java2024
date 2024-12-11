package ezhikov.lr11;

import java.util.Random;
import java.util.function.*;

public class Ex1 {
    public static void main(String[] args) {
        // 1. Predicate<Integer> -> IntPredicate: Проверяем, что четное
        IntPredicate isEven = (int num) -> num % 2 == 0;
        System.out.println(isEven.test(5));
        System.out.println(isEven.test(10));

        // 2. Function<T, T> -> UnaryOperator<T>: Конвертим в верхний регистр
        UnaryOperator<String> toUpperCase = (String s) -> s.toUpperCase();
        System.out.println(toUpperCase.apply("Иван"));
        System.out.println(toUpperCase.apply("Петр"));

        // 3. Consumer: Принтим сообщение
        Consumer<String> greet = (String name) -> System.out.println("Привет, " + name + "!");
        greet.accept("Иван");
        greet.accept("Петр");

        // 4. Supplier<Integer> -> IntSupplier: Генерируем случайное число
        IntSupplier randomIntSupplier = () -> new Random().nextInt(100);
        System.out.println(randomIntSupplier.getAsInt());
        System.out.println(randomIntSupplier.getAsInt());

        // 5. BinaryOperator<Integer> -> IntBinaryOperator: Складываем 2 числа
        IntBinaryOperator add = Integer::sum;
        System.out.println(add.applyAsInt(5, 10));
        System.out.println(add.applyAsInt(20, 30));

        // 6. BiFunction<T, T, T> -> BinaryOperator<T>: Складываем 2 строки разделенных пробелом
        BinaryOperator<String> concatWithSpace = (String s1, String s2) -> s1 + " " + s2;
        System.out.println(concatWithSpace.apply("Привет", "Мир"));
        System.out.println(concatWithSpace.apply("Пока", "Мир"));
    }
}
