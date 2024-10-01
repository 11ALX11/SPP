/** Variant 2*/
public class Main {
    /**
     * @param args целые числа для последовательности задачи 1
     */
    public static void main(String[] args) {
        int[] exampleSequence = convertArgsToSequence(args);

        Task1.exec(exampleSequence);
        Task2.exec();
        Task3.exec();
    }

    public static int[] convertArgsToSequence(String[] args) {
        if (args.length == 0) {
            return new int[0];
        }

        int[] sequence = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            try {
                sequence[i] = Integer.parseInt(args[i]);
            } catch (NumberFormatException e) {
                System.err.println("Invalid input: " + args[i] + " is not a valid integer.");
                return new int[0];
            }
        }

        return sequence;
    }
}
