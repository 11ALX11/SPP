public class Administrator
{
    public void blockCreditCard(CreditCard card)
    {
        card.setBlocked(true);
        System.out.println("Блокировка кредитной карты " + card.getCardNumber() + " администратором");
    }
}
