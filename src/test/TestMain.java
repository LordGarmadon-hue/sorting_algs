package test;

import sortingAlgorithms.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public class TestMain {
    public static void main(String[] args) throws IOException {
        // Генерация и сохранение массивов
        // ArrayGenerator.generateAndSaveArrays();

        // Тестирование сортировок
        testSorting("100_random_1.txt");
        System.out.println();
        testSorting("100_reverse_1.txt");
        System.out.println();
        testSorting("100_entropy_1.txt");
        System.out.println();

        testSorting("1000_random_1.txt");
        System.out.println();
        testSorting("1000_reverse_1.txt");
        System.out.println();
        testSorting("1000_entropy_1.txt");
        System.out.println();

        testSorting("10000_random_1.txt");
        System.out.println();
        testSorting("10000_reverse_1.txt");
        System.out.println();
        testSorting("10000_entropy_1.txt");
    }

    private static void testSorting(String filename) throws IOException {
        System.out.println("Тестирование сортировки в файле: " + filename);

        String path = "" + filename;
        String content = Files.readString(new File(path).toPath());

        String[] numbersStr = content.split("\n");

        // Преобразование в массив целых чисел
        int[] originalArray = Arrays.stream(numbersStr)
                .mapToInt(Integer::parseInt)
                .toArray();

        testBubbleSort(originalArray.clone());
        testFlagBubbleSort(originalArray.clone());
        testInsertionSort(originalArray.clone());
        testShakerSort(originalArray.clone());
        testFlagShakerSort(originalArray.clone());
        testShellSort(originalArray.clone());
        testMergeSort(originalArray.clone());
    }

    // Сортировка пузырьком
    private static void testBubbleSort(int[] array) {
        BubbleSorting bubbleSorting = new BubbleSorting();
        bubbleSorting.sort(array);
        System.out.println("Сортировка пузырьком - Сравнения: " + bubbleSorting.getComparisons() +
                ", Перестановки: " + bubbleSorting.getSwaps());
        //System.out.println(Arrays.toString(array));
    }

    // Сортировка пузырьком с флагом
    private static void testFlagBubbleSort(int[] array) {
        BubbleWithFlagSorting bubbleWithFlagSorting = new BubbleWithFlagSorting();
        bubbleWithFlagSorting.sort(array);
        System.out.println("Сортировка пузырьком с флагом - Сравнения: " + bubbleWithFlagSorting.getComparisons() +
                ", Перестановки: " + bubbleWithFlagSorting.getSwaps());
        //System.out.println(Arrays.toString(array));
    }

    // Сортировка вставками
    private static void testInsertionSort(int[] array) {
        InsertsSorting insertsSorting = new InsertsSorting();
        insertsSorting.sort(array);
        System.out.println("Сортировка вставками - Сравнения: " + insertsSorting.getComparisons() +
                ", Перестановки: " + insertsSorting.getSwaps());
        //System.out.println(Arrays.toString(array));
    }

    // Шейкер
    private static void testShakerSort(int[] array) {
        ShakerSorting shakerSorting = new ShakerSorting();
        shakerSorting.sort(array);
        System.out.println("Шейкер - Сравнения: " + shakerSorting.getComparisons() +
                ", Перестановки: " + shakerSorting.getSwaps());
        //System.out.println(Arrays.toString(array));
    }

    // Шейкер с флагом
    private static void testFlagShakerSort(int[] array) {
        ShakerWithFlagSorting shakerSort = new ShakerWithFlagSorting();
        shakerSort.sort(array);
        System.out.println("Шейкер с флагом - Сравнения: " + shakerSort.getComparisons() +
                ", Перестановки: " + shakerSort.getSwaps());
        //System.out.println(Arrays.toString(array));
    }

    // Сортировка Шелла
    private static void testShellSort(int[] array) {
        ShellSorting shellSort = new ShellSorting();
        shellSort.sort(array);
        System.out.println("Сортировка Шелла - Сравнения: " + shellSort.getComparisons() +
                ", Перестановки: " + shellSort.getSwaps());
        //System.out.println(Arrays.toString(array));
    }

    // Сортировка слиянием
    private static void testMergeSort(int[] array) {
        MergeSorting mergeSort = new MergeSorting();
        mergeSort.sort(array);
        System.out.println("Сортировка слиянием - Сравнения: " + mergeSort.getComparisons() +
                ", Перестановки: " + mergeSort.getSwaps());
        //System.out.println(Arrays.toString(array));
    }
}
