package com.labrab6.task1;

/**
 * Реализовать фрагмент программной системы, используя выбранный паттерн (Компоновщик).
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
        // Создаем компоненты
        TourComponent transportation = new Transportation(100.0);
        TourComponent accommodation = new Accommodation(200.0);
        TourComponent meals = new Meals(50.0);
        TourComponent museumVisits = new MuseumVisits(30.0);
        TourComponent excursions = new Excursions(80.0);

        // Создаем группу компонентов и добавляем в нее компоненты
        TourPackage tourPackage = new TourPackage();
        tourPackage.addComponent(transportation);
        tourPackage.addComponent(accommodation);
        tourPackage.addComponent(meals);
        tourPackage.addComponent(museumVisits);
        tourPackage.addComponent(excursions);

        // Рассчитываем итоговую стоимость заказа
        double totalCost = tourPackage.calculateCost();
        System.out.println("Итоговая стоимость заказа: " + totalCost);
    }
}
