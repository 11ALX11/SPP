/**
 * Задание 3.
 * Построить модель программной системы с применением отношений
 * (обобщения, агрегации, ассоциации, реализации) между классами.
 * Задать атрибуты и методы классов.
 * Реализовать (если необходимо) дополнительные классы.
 * Продемонстрировать работу разработанной системы.
 * <p>
 * Система Платежи.
 * Клиент имеет Счет в банке и Кредитную Карту (КК).
 * Клиент может оплатить Заказ, сделать платеж на другой Счет,
 * заблокировать КК и аннулировать Счет.
 * Администратор может заблокировать КК за превышение кредита.
 */
public class Task3
{
    public static void main(String[] args)
    {
        Client client = new Client("Иванов", 30, "ул. Пушкина, д.10");

        Account account = new Account("1234567890", 1000.0);
        client.setAccount(account);

        CreditCard creditCard = new CreditCard("9876543210", account, 5000.0);
        client.setCreditCard(creditCard);

        Order order = new Order("Z123", 500.0);

        client.payOrder(order);
        client.payOrder(order);

        Account otherAccount = new Account("0987654321", 2000.0);
        client.makePayment(otherAccount, 300.0);
        client.makePayment(otherAccount, 300.0);

        Administrator administrator = new Administrator();
        administrator.blockCreditCard(creditCard);

        client.payOrder(order);

        client.blockCreditCard();

        client.cancelAccount();
        client.payOrder(order);
    }
}
