package com.labrab7.task2;

import javax.swing.*;
import java.awt.*;

/**
 * Вариант №2: <strong>Н-фрактал</strong> <hr>
 * Реализовать построение заданного типа фрактала по варианту.
 * Везде, где это необходимо, предусмотреть ввод параметров, влияющих на внешний вид фрактала.
 * Н-фрактал
 */
public class Main extends JFrame
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> new Main(args));
    }

    public Main(String[] args)
    {
        setTitle("H-Fractal");
        setSize(600, 615);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        int recursionDepth = Integer.parseInt(args[0]); // глубина рекурсии

        FractalPanel fractalPanel = new FractalPanel(recursionDepth);
        fractalPanel.setBackground(Color.BLACK);
        getContentPane().add(fractalPanel);

        setVisible(true);
    }
}
