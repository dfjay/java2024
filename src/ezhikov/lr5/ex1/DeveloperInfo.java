package ezhikov.lr5.ex1;

/**
 * Информация о разработчике
 *
 * @param name  имя разработчика
 * @param group учебная группа
 * @param year  год обучения
 */
public record DeveloperInfo(
        String name,
        String group,
        String year
) {
    public DeveloperInfo() {
        this("Павел Ежиков", "РИМ-140970", "2024");
    }

    @Override
    public String toString() {
        return String.format("""
                        Информация о разработчике:
                        Разработчик: %s
                        Группа: %s
                        Год разработки: %s""",
                name, group, year);
    }
}
