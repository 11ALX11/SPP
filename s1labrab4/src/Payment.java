import java.util.ArrayList;
import java.util.List;

/**
 * Задание 1. Реализовать указанный класс,
 * включив в него вспомогательный внутренний класс или классы.
 * Реализовать 2-3 метода (на выбор).
 * Продемонстрировать использование реализованных классов.
 * <p>
 * Создать класс Payment (покупка) с внутренним классом,
 * с помощью объектов которого можно сформировать покупку из нескольких товаров.
 */
@SuppressWarnings("FieldMayBeFinal")
public class Payment {
    private List<Item> items;

    public Payment() {
        items = new ArrayList<>();
    }

    public void addItem(String name, double price) {
        Item item = new Item(name, price);
        items.add(item);
    }

    public double getTotalAmount() {
        double total = 0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public void printItems() {
        for (Item item : items) {
            System.out.println(item.getName() + ": " + item.getPrice());
        }
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    private class Item {
        private String name;
        private double price;

        public Item(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }
    }
}
