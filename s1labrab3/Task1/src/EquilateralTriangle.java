/** Равносторонний треугольник, заданный длинами сторон
 * Предусмотреть возможность определения площади и периметра,
 * а так же логический метод, определяющий существует или такой треугольник.
 * Конструктор должен позволить создавать объекты с начальной инициализацией.
 * Реализовать метод equals, выполняющий сравнение объектов данного типа.
 */
public class EquilateralTriangle
{
    private double sideLength;

    /** Конструктор с параметром */
    public EquilateralTriangle(double sideLength)
    {
        this.sideLength = sideLength;
    }

    /** Метод для определения существования треугольника */
    public boolean isTriangleValid()
    {
        return sideLength > 0;  // Треугольник существует, если длина стороны положительна
    }

    /** Метод для вычисления периметра */
    public double calculatePerimeter()
    {
        if (isTriangleValid()) {
            return 3 * sideLength;
        } else {
            return 0;  // Возвращаем 0, если треугольник не существует
        }
    }

    /** Метод для вычисления площади */
    public double calculateArea()
    {
        if (isTriangleValid()) {
            // Формула площади равностороннего треугольника
            return (Math.sqrt(3) / 4) * Math.pow(sideLength, 2);
        } else {
            return 0;  // Возвращаем 0, если треугольник не существует
        }
    }

    public double getSideLength()
    {
        return sideLength;
    }

    public void setSideLength(double sideLength)
    {
        this.sideLength = sideLength;
    }

    @Override
    public String toString()
    {
        return "EquilateralTriangle{" +
                "sideLength=" + sideLength +
                '}';
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        EquilateralTriangle that = (EquilateralTriangle) obj;
        return Double.compare(that.sideLength, sideLength) == 0;
    }
}
