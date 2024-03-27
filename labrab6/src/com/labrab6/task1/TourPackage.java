package com.labrab6.task1;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("FieldMayBeFinal")
class TourPackage implements TourComponent {
    private List<TourComponent> components = new ArrayList<>();

    public void addComponent(TourComponent component) {
        components.add(component);
    }

    public void removeComponent(TourComponent component) {
        components.remove(component);
    }

    @Override
    public double calculateCost() {
        double totalCost = 0.0;
        for (TourComponent component : components) {
            totalCost += component.calculateCost();
        }
        return totalCost;
    }
}
