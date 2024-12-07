# Система решения математических уравнений

## Описание предметной области
Система предназначена для решения линейных и квадратных математических уравнений.
Позволяет хранить историю вычислений.

## Основные сущности
- **MathExpression** - абстрактный класс для всех математических выражений
- **LinearEquation** - линейные уравнения ax + b = 0
- **QuadraticEquation** - квадратные уравнения ax^2 + bx + c = 0
- **MathExpressionHistory** - история решенных выражений
- **DeveloperInfo** - информация о разработчике
- **ProgramInfo** - информация о программе
- **Solution** - представление результата вычисления

```mermaid
classDiagram
    %% Какое-то абстрактное математическое выражение
    class MathExpression {
        <<abstract>>
        #name: String
        #description: String
        +solve() Solution
        +toString() String
        +equals(Object) boolean
    }

    %% Квадратное уравнение
    class QuadraticEquation {
        -a: double
        -b: double
        -c: double
        -discriminant: double
        +getA() double
        +getB() double
        +getC() double
        +solve() Solution
    }

    %% Линейное уравнение
    class LinearEquation {
        -a: double
        -b: double
        +getA() double
        +getB() double
        +solve() Solution
    }

    %% История решения математических выражений
    class MathExpressionHistory {
        -expressions: List~MathExpression~
        -capacity: int
        +add(MathExpression)
        +solveAll()
    }

    MathExpression <|-- QuadraticEquation : наследует
    MathExpression <|-- LinearEquation : наследует
    MathExpression <-- MathExpressionHistory : использует
```