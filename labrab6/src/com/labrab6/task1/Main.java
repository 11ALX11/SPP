package com.labrab6.task1;

/**
 * Реализовать фрагмент программной системы, используя выбранный паттерн (Строитель).
 * Реализовать все необходимые дополнительные классы.
 * <p>
 * Проект «Туристическое бюро». Реализовать возможность выбора программы тура (проезд,
 * проживание, питание, посещение музеев, выставок, экскурсии и т.д.). Должна формироваться
 * итоговая стоимость заказа.
 */
public class Main
{
    public static void main(String[] args)
    {
        TourBuilder tourBuilder = new TourPackageBuilder();
        TourDirector tourDirector = new TourDirector(tourBuilder);
        Tour tour = tourDirector.createTour();
        tour.showTourDetails();
    }
}
