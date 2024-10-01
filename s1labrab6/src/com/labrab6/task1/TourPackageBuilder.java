package com.labrab6.task1;

@SuppressWarnings("FieldMayBeFinal")
public class TourPackageBuilder implements TourBuilder
{
    private Tour tour;

    public TourPackageBuilder()
    {
        tour = new Tour();
    }

    @Override
    public void buildTransport()
    {
        tour.setTransport("Авиабилеты");
    }

    @Override
    public void buildAccommodation()
    {
        tour.setAccommodation("Отель 4 звезды");
    }

    @Override
    public void buildMeals()
    {
        tour.setMeals("Завтрак включен");
    }

    @Override
    public void buildActivities()
    {
        tour.setActivities("Посещение музеев, экскурсии");
    }

    @Override
    public Tour getTour()
    {
        return tour;
    }
}
