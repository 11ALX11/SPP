package SPP.s2labrab1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Вариант 2 <br>
 * Напишите программу, которая вводит строку текста,
 * разбивает ее на лексемы выводит лексемы в обратном порядке.
 */
public class Task1
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите текст: ");
        String inputText = scanner.nextLine();
        scanner.close();

        String[] lexemes = inputText.split(" ");

        String result = String.join(" ", Arrays.stream(lexemes).toList().reversed());

        System.out.println(result);
    }
}
