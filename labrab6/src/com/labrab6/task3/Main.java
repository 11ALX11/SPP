package com.labrab6.task3;

/**
 * Реализовать фрагмент программной системы, используя выбранный паттерн (Компоновщик).
 * Реализовать все необходимые дополнительные классы.
 * <p>
 * Реализовать вывод ФС из 2-й группы заданий.
 * Вывод файлов/директорий должен осуществляться в случайном порядке.
 * Вывести основные атрибуты каждого файла/директории.
 */
public class Main
{
    public static void main(String[] args)
    {
        // Создаем файлы
        FileSystemComponentTask3 file1 = new FileTask3("file1.txt", 100);
        FileSystemComponentTask3 file2 = new FileTask3("file2.txt", 200);
        FileSystemComponentTask3 file3 = new FileTask3("file3.txt", 150);

        // Создаем директории
        DirectoryTask3 directory1 = new DirectoryTask3("Directory 1");
        DirectoryTask3 directory2 = new DirectoryTask3("Directory 2");

        // Добавляем файлы в первую директорию
        directory1.addComponent(file1);
        directory1.addComponent(file2);

        // Добавляем файлы во вторую директорию
        directory2.addComponent(file3);

        // Добавляем вторую директорию в первую
        directory1.addComponent(directory2);

        // Выводим информацию о файловой системе
        directory1.displayInfo();
    }
}
