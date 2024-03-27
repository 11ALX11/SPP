package com.labrab6.task1;

@SuppressWarnings("FieldMayBeFinal")
class MuseumVisits implements TourComponent {
    private double cost;

    public MuseumVisits(double cost) {
        this.cost = cost;
    }

    @Override
    public double calculateCost() {
        return cost;
    }
}
