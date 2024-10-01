package com.labrab7.task1;

@SuppressWarnings("FieldMayBeFinal")
public class Rectangle
{
    private Point topLeft;
    private Point bottomRight;

    public Rectangle(Point topLeft, Point bottomRight)
    {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    public Point getTopLeft()
    {
        return topLeft;
    }

    public Point getBottomRight()
    {
        return bottomRight;
    }

    public boolean containsPoint(Point point)
    {
        int x = point.getX();
        int y = point.getY();

        int topLeftX = topLeft.getX();
        int topLeftY = topLeft.getY();
        int bottomRightX = bottomRight.getX();
        int bottomRightY = bottomRight.getY();

        return x >= topLeftX && x <= bottomRightX && y >= topLeftY && y <= bottomRightY;
    }
}
