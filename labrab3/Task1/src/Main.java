/** Вариант 2
 * Реализовать простой класс.
 Требования к выполнению
 • Реализовать пользовательский класс по варианту.
 • Создать другой класс с методом main, в котором будут находится примеры использования
 пользовательского класса.
 Для каждого класса
 • Создать поля классов
 • Создать методы классов
 • Добавьте необходимые get и set методы (по необходимости)
 • Укажите соответствующие модификаторы видимости
 • Добавьте конструкторы
 • Переопределить методы toString() и equals()
 */
public class Main
{
    public static void main(String[] args)
    {
        EquilateralTriangle triangle1 = new EquilateralTriangle(5.0);
        System.out.println("Triangle 1: " + triangle1);
        System.out.println("Perimeter: " + triangle1.calculatePerimeter());
        System.out.println("Area: " + triangle1.calculateArea());

        EquilateralTriangle triangle2 = new EquilateralTriangle(7.5);
        System.out.println("Triangle 2: " + triangle2);
        System.out.println("Is Triangle 2 valid triangle? " + triangle2.isTriangleValid());

        // Проверка равенства объектов
        System.out.println("Are triangles equal? " + triangle1.equals(triangle2));

        EquilateralTriangle triangle3 = new EquilateralTriangle(7.5);
        System.out.println("Triangle 3: " + triangle3);

        System.out.println("Are triangles (2 and 3) equal? " + triangle2.equals(triangle3));
    }
}