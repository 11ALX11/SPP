package com.labrab6.task1;

@SuppressWarnings("FieldMayBeFinal")
public class TourDirector
{
    private TourBuilder tourBuilder;

    public TourDirector(TourBuilder tourBuilder)
    {
        this.tourBuilder = tourBuilder;
    }

    public Tour createTour()
    {
        tourBuilder.buildTransport();
        tourBuilder.buildAccommodation();
        tourBuilder.buildMeals();
        tourBuilder.buildActivities();
        return tourBuilder.getTour();
    }
}
