package com.labrab6.task3;

import com.labrab6.task2.Directory;
import com.labrab6.task2.File;
import com.labrab6.task2.FileSystemComponent;

/**
 * Реализовать фрагмент программной системы, используя выбранный паттерн (Итератор).
 * Реализовать все необходимые дополнительные классы.
 * <br>
 * Реализовать вывод ФС из 2-й группы заданий.
 * Вывод файлов/директорий должен осуществляться в случайном порядке.
 * Вывести основные атрибуты каждого файла/директории.
 */
public class Main
{
    public static void main(String[] args)
    {
        // Создаем файлы
        FileSystemComponent file1 = new File("file1.txt", 100);
        FileSystemComponent file2 = new File("file2.txt", 200);
        FileSystemComponent file3 = new File("file3.txt", 150);

        // Создаем директории
        Directory directory1 = new Directory("Directory 1");
        Directory directory2 = new Directory("Directory 2");

        // Добавляем файлы в первую директорию
        directory1.addComponent(file1);
        directory1.addComponent(file2);

        // Добавляем файлы во вторую директорию
        directory2.addComponent(file3);

        // Добавляем вторую директорию в первую
        directory1.addComponent(directory2);

        // Создаем итератор
        RandomFileSystemComponentIterator iterator = new RandomFileSystemComponentIterator(directory1);

        // Выводим информацию о файловой системе
        while (iterator.hasNext()) {
            FileSystemComponent component = iterator.next();
            component.displayInfo();
        }

    }
}
