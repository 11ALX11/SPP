package com.labrab6.task1;

public interface TourBuilder
{
    void buildTransport();

    void buildAccommodation();

    void buildMeals();

    void buildActivities();

    Tour getTour();
}
