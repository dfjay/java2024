package ezhikov.lr1;

import java.util.Scanner;

/**
 * Задание 4
 * <p>
 * Выбрать формулу для некоторых расчетов из любой предметной области. Разработать программу, которая содержит следующие блоки:
 * приглашение для пользователя, что данная программа выполняет
 * приглашение для пользователя ввести необходимы для расчета данные
 * валидация введенных данных, в случае недопустимых значений вывести сообщение об ошибке и прекратить дальнейшее выполнение программы;
 * выполнения расчета по заданной формуле;
 * вывод на консоль для пользователя результатов расчетов.
 * <p>
 * Возьмем формулу решения квадратного уравнения ax^2 + bx + c = 0
 */
public class Ex4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Эта программа решает квадратное уравнение вида ax^2 + bx + c = 0");
        System.out.println("Введите коэффициенты a, b и c:");

        System.out.print("Введите коэффициент a: ");
        if (!scanner.hasNextDouble()) {
            System.out.println("Ошибка: введено некорректное значение для коэффициента a.");
            return;
        }
        double a = scanner.nextDouble();
        if (a == 0) {
            System.out.println("Ошибка: коэффициент 'a' не может быть равен 0.");
            return;
        }

        System.out.print("Введите коэффициент b: ");
        if (!scanner.hasNextDouble()) {
            System.out.println("Ошибка: введено некорректное значение для коэффициента b.");
            return;
        }
        double b = scanner.nextDouble();

        System.out.print("Введите коэффициент c: ");
        if (!scanner.hasNextDouble()) {
            System.out.println("Ошибка: введено некорректное значение для коэффициента c.");
            return;
        }
        double c = scanner.nextDouble();

        double discriminant = b * b - 4 * a * c;

        System.out.println("Результаты:");
        if (discriminant > 0) {
            double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.printf("""
                    Уравнение имеет два корня:
                    x1 = %s
                    x2 = %s
                    """, x1, x2);
        } else if (discriminant == 0) {
            double x = -b / (2 * a);
            System.out.printf("""
                    Уравнение имеет один корень:
                    x = %s
                    """, x);
        } else {
            System.out.println("Уравнение не имеет действительных корней.");
        }
    }
}
