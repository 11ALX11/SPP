import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

/** Автоматизированная система проката автомобилей
 * Составить программу, которая хранит и обрабатывает информацию о прокате автомобилей.
 * Программа должна обеспечить вывод списков:
 * • автомобилей;
 * • автомобилей заданной марки;
 * • автомобилей заданной модели, которые эксплуатируются больше n лет;
 * • автомобилей заданного года выпуска, цена которых больше указанной;
 * • автомобилей, взятых на прокат;
 * • автомобилей, взятых на прокат с выводом личной информации об арендаторах.
 */
class CarRentalSystem
{
    private final ArrayList<Car> carsList;

    public CarRentalSystem(String file)
    {
        this.carsList = new ArrayList<>();
        this.importCarsFromFile(file);
    }

    /** Метод для импорта списка автомобилей из файла */
    public void importCarsFromFile(String filePath)
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath)))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                Car newCar = new Car(line);
                carsList.add(newCar);
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /** @return список автомобилей как строку */
    public String getCars()
    {
        return getCars(carsList);
    }
    /** @return список автомобилей как строку */
    public String getCars(ArrayList<Car> carsListL)
    {
        StringBuilder carsInfo = new StringBuilder();
        for (Car car : carsListL) {
            carsInfo.append(car.getCarInfo()).append("\n");
        }
        return carsInfo.toString();
    }

    /** вывод списка автомобилей заданной марки */
    public String getCarsByBrand(String brand)
    {
        ArrayList<Car> filteredCars = new ArrayList<>();

        for (Car car : carsList) {
            if (car.getBrand().equalsIgnoreCase(brand)) {
                filteredCars.add(car);
            }
        }

        return getCars(filteredCars);
    }

    /** вывод списка автомобилей заданной модели, которые эксплуатируются больше n лет */
    public String getCarsByModelAndMoreThenNYears(String model, int n_years)
    {
        ArrayList<Car> filteredCars = new ArrayList<>();
        int year = LocalDateTime.now().getYear();

        for (Car car : carsList) {
            if (car.getModel().equalsIgnoreCase(model) && year - car.getYear() >= n_years) {
                filteredCars.add(car);
            }
        }

        return getCars(filteredCars);
    }

    /** вывод списка автомобилей заданного года выпуска, цена которых больше указанной*/
    public String getCarsByYearAndMoreThanNPrice(int year, double n_price)
    {
        ArrayList<Car> filteredCars = new ArrayList<>();

        for (Car car : carsList) {
            if (car.getYear() == year && car.getPrice() > n_price) {
                filteredCars.add(car);
            }
        }

        return getCars(filteredCars);
    }

    /** вывод списка автомобилей, взятых на прокат */
    public String getCarsThatAreRented()
    {
        ArrayList<Car> filteredCars = new ArrayList<>();

        for (Car car : carsList) {
            if (car.getRenterName() != null) {
                filteredCars.add(car);
            }
        }

        return getCars(filteredCars);
    }

    /** вывод списка автомобилей, взятых на прокат с выводом личной информации об арендаторах */
    public String getCarsRentersInfo()
    {
        ArrayList<Car> filteredCars = new ArrayList<>();

        for (Car car : carsList) {
            if (car.getRenterName() != null) {
                filteredCars.add(car);
            }
        }

        StringBuilder carsInfo = new StringBuilder();
        for (Car car : filteredCars) {
            carsInfo.append(car.getCarsRenterInfo()).append("\n");
        }

        return carsInfo.toString();
    }
}
