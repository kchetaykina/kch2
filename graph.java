public class graph {

    public static void main(String[] args) {
        int[] sizes = {100, 1000, 10000, 100000, 1000000};
        double[] durations = new double[sizes.length];

        for (int i = 0; i < sizes.length; i++) {
            int[] dataArray = generateRandomArray(sizes[i]);

            long startTime = System.nanoTime();
            try {
                Main._mult(dataArray);
            } catch (NullPointerException e) {
                System.out.println("NullPointerException was thrown for size: " + sizes[i]);
            }
            long endTime = System.nanoTime();
            durations[i] = (endTime - startTime) / 1_000_000.0;
        }
        plotGraph(sizes, durations);
    }

    private static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * 1000);
        }
        return array;
    }

    private static void plotGraph(int[] sizes, double[] durations) {
        int maxStars = 50;
        double maxDuration = getMax(durations);

        for (int i = 0; i < sizes.length; i++) {
            int stars = (int) ((durations[i] / maxDuration) * maxStars);
            System.out.printf("%-10d | %s\n", sizes[i], "*".repeat(stars));
        }
    }

    private static double getMax(double[] array) {
        double max = array[0];
        for (double v : array) {
            if (v > max) {
                max = v;
            }
        }
        return max;
    }
}