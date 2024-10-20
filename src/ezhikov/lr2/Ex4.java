package ezhikov.lr2;

/**
 * Описать метод, принимающий число, и возвращающий
 * 1, если оно положительное,
 * 0, если оно само равно нулю,
 * -1, если оно отрицательное.
 */
public class Ex4 {
    public static void main(String[] args) {
        System.out.println("Знак числа 10: " + checkSign(10));
        System.out.println("Знак числа 0: " + checkSign(0));
        System.out.println("Знак числа -10: " + checkSign(-10));
    }

    /**
     * Определяет знак числа
     *
     * @param number число для проверки
     * @return 1, если число положительное,
     * 0, если число равно нулю,
     * -1, если число отрицательное
     */
    public static int checkSign(double number) {
        if (number > 0) {
            return 1;
        } else if (number < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}
