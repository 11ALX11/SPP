import java.util.Scanner;

public class Task3 {

    /** Решите задачу на обработку строк.
     * Ввод исходных строк выполнять из командной строки.
     *
     * Напишите метод boolean polindrome(String str) проверяющий, является ли строка палин-
     * дромом или нет. Палиндром – это такая строка, которая в прямом и обратном порядке читается
     * одинаково. Например: А лис, он умён – крыса сыр к нему носила.
     */
    public static void exec() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string to check for a palindrome:");
        String inputString = scanner.nextLine();

        boolean isPalindrome = polindrome(inputString);

        System.out.println(isPalindrome ? "It's a palindrome" : "It's not a palindrome");
    }

    /** Проверяющая, является ли строка палиндромом или нет.
     * Палиндром – это такая строка, которая в прямом и обратном порядке читается одинаково.
     * Например: А лис, он умён – крыса сыр к нему носила.
     * @param str строка для проверки на полиндром
     * @return true - если str полиндром
     */
    public static boolean polindrome(String str) {
        // Убираем все не буквы и заменяем в нижний регистр, конвертируем ё -> е
        String cleanStr = str
                .replaceAll("[^a-zA-Zа-яА-ЯёЁ]", "")
                .toLowerCase()
                .replace('ё', 'е');

        return cleanStr.contentEquals(new StringBuilder(cleanStr).reverse());
    }
}
