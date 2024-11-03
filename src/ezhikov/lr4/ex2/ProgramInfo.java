package ezhikov.lr4.ex2;

/**
 * Информация о программе
 *
 * @param version     версия
 * @param description описание
 */
public record ProgramInfo(
        String version,
        String description
) {
    public ProgramInfo() {
        this("1.2", "Эта программа решает квадратное уравнение вида ax^2 + bx + c = 0");
    }

    @Override
    public String toString() {
        return String.format("""
                        Информация о программе:
                        %s
                        Версия: %s""",
                description, version);
    }
}
