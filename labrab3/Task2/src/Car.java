import java.util.Scanner;

/** О каждом автомобиле (Car) содержится следующая информация:
 * • id;
 * • Марка;
 * • Модель;
 * • Год выпуска;
 * • Цвет;
 * • Цена;
 * • Регистрационный номер;
 * • Номер машины.
 * • ФИО лица, взявшего на прокат (при наличии);
 * • Номер паспорта лица-арендатора (при наличии).
 */
public class Car
{
    private final int id;

    /**
     * Марка
     */
    private final String brand;

    /**
     * Модель
     */
    private final String model;

    /**
     *  Год выпуска
     */
    private final int year;

    /**
     * Цвет
     */
    private final String color;

    /**
     * Цена
     */
    private final double price;

    /**
     * Регистрационный номер
     */
    private final String registrationNumber;

    /**
     * Номер машины
     */
    private final String carNumber;

    /**
     * ФИО лица, взявшего на прокат (при наличии)
     */
    private String renterName;

    /**
     * Номер паспорта лица-арендатора (при наличии)
     */
    private String renterPassport;

    public Car(String fileLine) {
        Scanner scanner = new Scanner(fileLine);

        this.id = scanner.nextInt();
        this.brand = scanner.next();
        this.model = scanner.next();
        this.year = scanner.nextInt();
        this.color = scanner.next();
        this.price = scanner.nextDouble();
        this.registrationNumber = scanner.next();
        this.carNumber = scanner.next();

        if (scanner.hasNext()) {
            this.renterName = scanner.next();
            this.renterPassport = scanner.next();
        }

        scanner.close();
    }

    public String getCarInfo()
    {
        StringBuilder carInfo = new StringBuilder();
        carInfo.append("ID: ").append(id)
                .append("\tBrand: ").append(brand)
                .append("\tModel: ").append(model)
                .append("\tYear: ").append(year)
                .append("\tColor: ").append(color)
                .append("\tPrice: $").append(price)
                .append("\tRegistration Number: ").append(registrationNumber)
                .append("\tCar Number: ").append(carNumber);

        // Добавляем опциональные атрибуты, если они присутствуют
        if (renterName != null)
        {
            carInfo.append("\tRenter Name: ").append(renterName);
        }

        if (renterPassport != null)
        {
            carInfo.append("\tRenter Passport: ").append(renterPassport);
        }

        return carInfo.toString();
    }

    public String getCarsRenterInfo()
    {
        StringBuilder renterInfo = new StringBuilder();

        if (renterName != null)
        {
            renterInfo.append("Renter Name: ").append(renterName);
        }

        if (renterPassport != null)
        {
            renterInfo.append("\tRenter Passport: ").append(renterPassport);
        }

        return renterInfo.toString();
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public String getRenterName() {
        return renterName;
    }

}
