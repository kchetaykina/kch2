import java.io.*;

public class Main {

    public static void main(String[] args) {
        File file = new File("numbers.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            String[] numbers = line.split(" ");
            int[] intNumbers = new int[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                intNumbers[i] = Integer.parseInt(numbers[i]);
            }
            br.close();

            int min = _min(intNumbers);
            int max = _max(intNumbers);
            int sum = _sum(intNumbers);
            int mult = _mult(intNumbers);

            System.out.println("Минимальное: " + min);
            System.out.println("Максимальное: " + max);
            System.out.println("Сумма: " + sum);
            System.out.println("Произведение: " + mult);


        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода");
        }
    }
//поиск минимального числа
    public static int _min(int[] numbers) {
        int min = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        return min;
    }
//поиск максимального числа
    public static int _max(int[] numbers) {
        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }
//нахождение суммы
    public static int _sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
//нахождение произведения
    public static int _mult(int[] numbers) {
        int mult = 1;
        for (int number : numbers) {
            mult *= number;
        }
        return mult;
    }
}