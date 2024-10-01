package com.labrab7.task2;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("FieldMayBeFinal")
public class FractalPanel extends JPanel
{
    private int recursionDepth;
    private static Color[] colors = {
            Color.red, Color.blue, Color.green,
            Color.orange, Color.cyan, Color.gray
    };

    public FractalPanel(int recursionDepth)
    {
        super();
        this.recursionDepth = recursionDepth;
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        drawFractal(g, getWidth() / 2, getHeight() / 2, 140, 0);
    }

    private void drawFractal(Graphics g, int x, int y, int size, int depth)
    {
        if (depth >= recursionDepth) return;

        g.setColor(colors[depth % colors.length]);

        // рисуем основную фигуру
        g.drawLine(x - size, y, x + size, y);
        g.drawLine(x - size, y - size, x - size, y + size);
        g.drawLine(x + size, y - size, x + size, y + size);

        // рекурсивно рисуем дочерние фракталы
        drawFractal(g, x - size, y - size, size / 2, depth + 1);
        drawFractal(g, x + size, y - size, size / 2, depth + 1);
        drawFractal(g, x - size, y + size, size / 2, depth + 1);
        drawFractal(g, x + size, y + size, size / 2, depth + 1);
    }
}