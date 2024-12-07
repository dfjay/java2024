package ezhikov.lr6.ex1;

/**
 * Математическое уравнение
 */
public abstract class MathExpression {
    /**
     * Название уравнения
     */
    protected final String name;

    /**
     * Описание уравнения
     */
    protected final String description;

    protected MathExpression(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Решить уравнение
     */
    public abstract Solution solve();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MathExpression that = (MathExpression) obj;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
