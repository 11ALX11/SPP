package com.labrab6.task1;

@SuppressWarnings("FieldMayBeFinal")
class Excursions implements TourComponent {
    private double cost;

    public Excursions(double cost) {
        this.cost = cost;
    }

    @Override
    public double calculateCost() {
        return cost;
    }
}
