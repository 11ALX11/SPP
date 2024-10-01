import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Лабораторная работа №2
 * Вариант №2
 * Напишите программу, выполняющую чтение
 * текстовых данных из файла и их последующую обработку:
 * Напишите программу, которая читает текст построчно,
 * а затем разбивает каждую строку на лексемы и выводит их в обратном порядке.
 */
public class Task1 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Укажите путь к файлу в качестве аргумента программы.");
            return;
        }

        String filePath = args[0];

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line);
                String[] tokens = new String[tokenizer.countTokens()];

                int index = 0;
                while (tokenizer.hasMoreTokens()) {
                    tokens[index++] = tokenizer.nextToken();
                }

                for (int i = tokens.length - 1; i >= 0; i--) {
                    System.out.print(tokens[i] + " ");
                }

                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
