package arrayGenerate;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class ArrayGenerator {
    private static final Random random = new Random();

    public static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1000); // случайные числа от 0 до 999
        }
        return array;
    }

    public static int[] generateSortedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        return array;
    }

    public static int[] generateReverseSortedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = size - i - 1;
        }
        return array;
    }

    public static int[] generateEntropyArray(int size, double entropy) {
        int[] array = generateSortedArray(size);
        int numberOfElementsToShuffle = (int) (size * (1 - entropy));
        for (int i = 0; i < numberOfElementsToShuffle; i++) {
            int index1 = random.nextInt(size);
            int index2 = random.nextInt(size);
            swap(array, index1, index2);
        }
        return array;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void writeArrayToFile(int[] array, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (int num : array) {
                writer.write(num + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void generateAndSaveArrays() {
        // Генерация и запись массивов
        int[][] sizes = {{100, 1}, {1000, 1}, {10000, 1}};
        String[] types = {"random", "reverse", "entropy"};

        for (int[] sizeInfo : sizes) {
            int size = sizeInfo[0];
            for (String type : types) {
                for (int i = 0; i < sizeInfo[1]; i++) {
                    int[] array;
                    if (type.equals("random")) {
                        array = generateRandomArray(size);
                    } else if (type.equals("reverse")) {
                        array = generateReverseSortedArray(size);
                    } else { // entropy
                        array = generateEntropyArray(size, 0.9);
                    }
                    writeArrayToFile(array, String.format("%d_%s_%d.txt", size, type, i + 1));
                }
            }
        }
    }
}
