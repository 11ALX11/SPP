package com.labrab6.task1;

@SuppressWarnings("FieldMayBeFinal")
class Accommodation implements TourComponent {
    private double cost;

    public Accommodation(double cost) {
        this.cost = cost;
    }

    @Override
    public double calculateCost() {
        return cost;
    }
}
