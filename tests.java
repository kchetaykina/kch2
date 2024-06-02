import org.junit.Test;
import static org.junit.Assert.*;
import java.io.FileNotFoundException;
import java.util.Random;
public class tests {

    int[] data = {10, 20, 30, 40, 50};

    @Test
    public void testMin() throws FileNotFoundException {
        int min = Main._min(data);
        assertEquals(10, min);
    }

    @Test
    public void testMax() throws FileNotFoundException {
        int max = Main._max(data);
        assertEquals(50, max);
    }

    @Test
    public void testSum() throws FileNotFoundException {
        int sum = Main._sum(data);
        assertEquals(150, sum);
    }

    @Test
    public void testMult() throws FileNotFoundException {
        int mult = Main._mult(data);
        assertEquals(12000000, mult);
    }

    private static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1000);
        }
        return array;
    }

    int[] dataBigArray = generateRandomArray(1000000);

    @Test
    public void testMinPerformance() {
        long startTime = System.nanoTime();
        Main._min(dataBigArray);
        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1_000_000_000.0;
        System.out.println("min " + duration + " seconds");
    }

    @Test
    public void testMaxPerformance() {
        long startTime = System.nanoTime();
        Main._max(dataBigArray);
        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1_000_000_000.0;
        System.out.println("max " + duration + " seconds");
    }

    @Test
    public void testSumPerformance() {
        long startTime = System.nanoTime();
        Main._sum(dataBigArray);
        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1_000_000_000.0;
        System.out.println("sum " + duration + " seconds");
    }

    @Test
    public void testMultPerformance() {
        long startTime = System.nanoTime();
        Main._mult(dataBigArray);
        long endTime = System.nanoTime();
        double duration = (endTime - startTime) / 1_000_000_000.0;
        System.out.println("mult " + duration + " seconds");
    }
    @Test
    public void TimeOutMaxTest() {
        long startTime = System.currentTimeMillis();
        Main._max(dataBigArray);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        assertTrue(duration <= 15);
    }

    @Test
    public void TimeOutMinTest() {
        long startTime = System.currentTimeMillis();
        Main._min(dataBigArray);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        assertTrue(duration <= 15);
    }

    @Test
    public void TimeOutSumTest() {
        long startTime = System.currentTimeMillis();
        Main._sum(dataBigArray);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        assertTrue(duration <= 15);
    }

    @Test
    public void TimeOutMultTest() {
        long startTime = System.currentTimeMillis();
        Main._mult(dataBigArray);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        assertTrue(duration <= 15);
    }

    @Test
    public void testNullPointerException() {
        boolean isNullPointerExceptionThrown = false;
        try {
            Main._sum(null);
        } catch (NullPointerException e) {
            isNullPointerExceptionThrown = true;
        }
        assertTrue(isNullPointerExceptionThrown);
    }

}