import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Лабораторная работа №2
 * Вариант №2
 * <p>
 * Написать консольную утилиту, обрабатывающую ввод пользователя
 * и дополнительные ключи. Проект упаковать в jar-файл, написать bat-файл для запуска.
 * Утилита tail выводит несколько (по умолчанию 10) последних строк из файла.
 * Формат использования: tail [-n] file
 * <p>
 * Ключ -n <количество строк> (или просто <количество строк> ) позволяет изменить количе-
 * ство выводимых строк.
 * </p>
 * Пример использования:
 * tail -n 20 app.log
 * <p>
 * 2
 * </p>
 * Крощенко А.А., Современные платформы программирования, ЛР2, 2019
 * <p>
 * tail 20 app.log
 * Выводит 20 последних строк из файла app.log.
 * </p>
 * Для решения задачи подойдет класс java.io.RandomAccessFile, реализующий произвольный до-
 * ступ к файлу (чтение и запись с любой позиции в файле).
 */
public class Task2 {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Формат использования: tail [-n] file");
            return;
        }

        int numLines = 10; // Количество строк по умолчанию

        // Обработка аргументов
        if (args[0].equals("-n")) {
            try {
                numLines = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                System.out.println("Некорректное значение для количества строк.");
                return;
            }
        }
        else {
            try {
                numLines = Integer.parseInt(args[0]);
            } catch (NumberFormatException ignored) {}
        }

        String filePath = args[args.length - 1];

        try {
            try (RandomAccessFile file = new RandomAccessFile(filePath, "r")) {
                long length = file.length();
                long position = length - 1;
                int linesToPrint = numLines;

                StringBuilder result = new StringBuilder();

                while (position >= 0 && linesToPrint > 0) {
                    file.seek(position);
                    char currentChar = (char) file.read();

                    if (currentChar == '\n') {
                        linesToPrint--;
                    }

                    result.insert(0, currentChar);
                    position--;
                }

                System.out.print(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
