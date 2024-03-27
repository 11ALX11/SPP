package com.labrab6.task1;

@SuppressWarnings("FieldMayBeFinal")
class Transportation implements TourComponent
{
    private double cost;

    public Transportation(double cost)
    {
        this.cost = cost;
    }

    @Override
    public double calculateCost()
    {
        return cost;
    }
}
