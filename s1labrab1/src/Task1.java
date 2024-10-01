public class Task1 {

    /** Для переданной в качестве параметра последовательности из N целых чисел написать утилиту:
     *
     *  Вывод максимального и минимального значения,
     *  а также суммы и произведения элементов последовательности
     *
     * @param sequence произвольная последовательность целых чисел
     */
    public static void exec(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            System.out.println("Sequence is empty");
            return;
        }

        int min = sequence[0];
        int max = sequence[0];
        int sum = 0;
        long product = 1;

        for (int num : sequence) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }

            sum += num;
            product *= num;
        }

        System.out.println("Minimum value: " + min);
        System.out.println("Maximum value: " + max);
        System.out.println("Sum of the sequence: " + sum);
        System.out.println("Product of the sequence: " + product);
    }

}
