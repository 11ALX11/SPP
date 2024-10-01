/**
 * Задание 2. Реализовать агрегирование.
 * При создании класса агрегируемый класс объявляется как атрибут
 * (локальная переменная, параметр метода).
 * Включить в каждый класс 2-3 метода на выбор.
 * Продемонстрировать использование разработанных классов.
 * <p>
 * Создать класс Абзац, используя класс Строка.
 */
public class Task2
{
    public static void main(String[] args)
    {
        Paragraph paragraph = new Paragraph();

        CustomString string1 = new CustomString("First string.");
        CustomString string2 = new CustomString("Second string.");
        CustomString string3 = new CustomString("Third string.");

        paragraph.addString(string1);
        paragraph.addString(string2);
        paragraph.addString(string3);

        paragraph.printParagraph();
    }
}
