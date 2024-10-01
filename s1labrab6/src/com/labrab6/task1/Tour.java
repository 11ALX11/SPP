package com.labrab6.task1;

public class Tour
{
    private String transport;
    private String accommodation;
    private String meals;
    private String activities;

    public void setTransport(String transport)
    {
        this.transport = transport;
    }

    public void setAccommodation(String accommodation)
    {
        this.accommodation = accommodation;
    }

    public void setMeals(String meals)
    {
        this.meals = meals;
    }

    public void setActivities(String activities)
    {
        this.activities = activities;
    }

    public void showTourDetails()
    {
        System.out.println("Детали тура:");
        System.out.println("Транспорт: " + transport);
        System.out.println("Проживание: " + accommodation);
        System.out.println("Питание: " + meals);
        System.out.println("Активности: " + activities);
    }
}
