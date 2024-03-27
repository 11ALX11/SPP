package com.labrab6.task1;

@SuppressWarnings("FieldMayBeFinal")
class Meals implements TourComponent {
    private double cost;

    public Meals(double cost) {
        this.cost = cost;
    }

    @Override
    public double calculateCost() {
        return cost;
    }
}
