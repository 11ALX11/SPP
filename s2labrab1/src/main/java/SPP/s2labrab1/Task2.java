package SPP.s2labrab1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

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
        int linesToRead = 0;
        String filename = null;

        boolean expectNumber = false;
        for (String arg : args)
        {
            if (arg.startsWith("-") || expectNumber)
            {
                String number = arg.substring(1);
                if (arg.startsWith("-n"))
                {
                    number = arg.substring(2);
                    if (number.equals(""))
                    {
                        expectNumber = true;
                        continue;
                    }
                }
                if (expectNumber)
                {
                    number = arg;
                    expectNumber = false;
                }

                try
                {
                    linesToRead = Integer.parseInt(number);
                } catch (NumberFormatException e)
                {
                    System.err.println("Неверный формат числа: " + number);
                    return;
                }
            } else
            {
                filename = arg;
            }
        }

        if (filename == null)
        {
            System.err.println("Не указан файл.");
            return;
        }
        if (linesToRead <= 0)
        {
            linesToRead = 10;
        }


        try (RandomAccessFile file = new RandomAccessFile(filename, "r"))
        {
            long pointer = file.length() - 1;
            int lineCount = 0;
            StringBuilder sb = new StringBuilder();

            while (pointer >= 0 && lineCount < linesToRead)
            {
                file.seek(pointer);
                char currentChar = (char) file.readByte();

                if (currentChar == '\n')
                {
                    lineCount++;
                    if (lineCount == linesToRead)
                    {
                        break;
                    }
                }

                sb.append(currentChar);
                pointer--;
            }

            System.out.print(sb.reverse());

        } catch (FileNotFoundException e)
        {
            System.err.println("404: Файл не найден.");
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
