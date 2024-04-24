package com.labrab7.task1;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Вариант №2 <hr>
 * Реализовать соответствующие классы, указанные в задании;
 * Организовать ввод параметров для создания объектов (можно использовать файлы);
 * Осуществить визуализацию графических примитивов, решить поставленную задачу
 * <hr>
 * Определить класс Rectangle и класс Point. Объявить массив из n объектов класса Point.
 * Написать функцию, определяющую, какая из точек лежит снаружи, а какая – внутри прямоугольника.
 */
public class Main
{
    public static void main(String[] args)
    {
        List<Point> points = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("task1_input.txt")))
        {
            // Чтение координат верхнего левого и нижнего правого углов прямоугольника
            String line = reader.readLine();
            String[] rectangleCoords = line.split(" ");
            int rectangleX1 = Integer.parseInt(rectangleCoords[0]);
            int rectangleY1 = Integer.parseInt(rectangleCoords[1]);
            int rectangleX2 = Integer.parseInt(rectangleCoords[2]);
            int rectangleY2 = Integer.parseInt(rectangleCoords[3]);
            Rectangle rectangle = new Rectangle(new Point(rectangleX1, rectangleY1), new Point(rectangleX2, rectangleY2));

            // Чтение количества точек
            line = reader.readLine();
            int n = Integer.parseInt(line);

            // Чтение координат точек
            for (int i = 0; i < n; i++)
            {
                line = reader.readLine();
                String[] pointCoords = line.split(" ");
                int pointX = Integer.parseInt(pointCoords[0]);
                int pointY = Integer.parseInt(pointCoords[1]);
                points.add(new Point(pointX, pointY));
            }

            for (Point point : points)
            {
                if (rectangle.containsPoint(point))
                {
                    System.out.println("Точка " + point + " находится внутри прямоугольника.");
                } else
                {
                    System.out.println("Точка " + point + " находится снаружи прямоугольника.");
                }
            }

            // Рисование
            SwingUtilities.invokeLater(() -> {
                JFrame frame = new JFrame("Drawing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                DrawingPanel panel = new DrawingPanel(points, rectangle);
                panel.setPreferredSize(new Dimension(800, 600));

                frame.getContentPane().add(panel);
                frame.pack();
                frame.setVisible(true);
            });

        } catch (IOException e)
        {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}
