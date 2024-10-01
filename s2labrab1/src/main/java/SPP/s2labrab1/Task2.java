package SPP.s2labrab1;

/**
 * Вариант 2 — tail
 * <br>
 * Реализовать на Java следующую консольную утилиту.
 * <br>
 * • Проект упаковать в один Jar с запуском в один клик.
 * <br>
 * • Предоставить .bat файл запуска.
 * <hr>
 * Утилита tail выводит несколько (по умолчанию 10) последних строк из файла.
 * <br>
 * Формат использования
 * <br>
 * tail [-n] file
 * <br>
 * Ключ -n <количество строк> (или просто -<количество строк>) позволяет изменить
 * количество выводимых строк.
 * <br>
 * Пример использования
 * <br>
 * tail n -20 app.log
 * <br>
 * tail -20 app.log
 * <br>
 * Выводит 20 последних строк из файла app.log.
 * <hr>
 * Для решения задачи подойдет класс java.io.RandomAccessFile,
 * реализующий произвольный доступ к файлу (чтение и запись с любой позиции в файле).
 */
public class Task2
{
    public static void main(String[] args)
    {
        System.out.println("Hello world!");
    }
}