/**
 * Задание 1. Реализовать указанный класс,
 * включив в него вспомогательный внутренний класс или классы.
 * Реализовать 2-3 метода (на выбор).
 * Продемонстрировать использование реализованных классов.
 * <p>
 * Создать класс Payment (покупка) с внутренним классом,
 * с помощью объектов которого можно сформировать покупку из нескольких товаров.
 */
public class Task1
{
    public static void main(String[] args)
    {
        Payment payment = new Payment();

        payment.addItem("Товар 1", 10.0);
        payment.addItem("Товар 2", 20.0);
        payment.addItem("Товар 3", 30.0);

        payment.printItems();

        double totalAmount = payment.getTotalAmount();
        System.out.println("Общая стоимость: " + totalAmount);
    }
}
