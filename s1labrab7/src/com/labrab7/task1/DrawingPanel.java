package com.labrab7.task1;

import javax.swing.*;
import java.awt.*;
import java.util.List;

@SuppressWarnings("FieldMayBeFinal")
class DrawingPanel extends JPanel
{
    private List<Point> points;
    private Rectangle rectangle;

    public DrawingPanel(List<Point> points, Rectangle rectangle) {
        this.points = points;
        this.rectangle = rectangle;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Рисование прямоугольника
        g.drawRect(
                rectangle.getTopLeft().getX(),
                rectangle.getTopLeft().getY(),
                rectangle.getBottomRight().getX() - rectangle.getTopLeft().getX(),
                rectangle.getBottomRight().getY() - rectangle.getTopLeft().getY()
        );

        // Рисование точек
        for (Point point : points) {
            int x = point.getX();
            int y = point.getY();
            g.fillOval(x - 2, y - 2, 5, 5);
        }
    }
}