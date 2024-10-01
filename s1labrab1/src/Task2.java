import java.util.Scanner;

public class Task2 {

    /** Написать функцию, выполняющую указанную операцию над массивом. Использовать только
     * базовые возможности языка, без привлечения специализированных функций для обработки коллекций.
     * Ввод массивов выполнять из командной строки.
     */
    public static void exec() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int size = scanner.nextInt();

        double[] array = new double[size];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextDouble();
        }

        reverse(array);

        System.out.println("Reversed array:");
        for (double element : array) {
            System.out.print(element + " ");
        }
		System.out.println();
    }

    /** Напишите метод reverse(double[] array),
     * который меняет порядок элементов в массиве на обратный.
     *
     * @param array массив элементов, в котором порядок элементов нужно менять
     */
    public static void reverse(double[] array) {
        int start = 0;
        int end = array.length - 1;

        while (start < end) {
            double temp = array[start];
            array[start] = array[end];
            array[end] = temp;

            start++;
            end--;
        }
    }
}
