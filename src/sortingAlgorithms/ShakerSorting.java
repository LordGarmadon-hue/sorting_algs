package sortingAlgorithms;

public class ShakerSorting {
    private int comparisons;
    private int swaps;

    public void sort(int[] array) {
        comparisons = 0;
        swaps = 0;

        for (int i = 0; i < array.length / 2; i++) {
            boolean swapped = false;

            // Проход слева направо
            for (int j = i; j < array.length - i - 1; j++) {
                comparisons++;
                if (array[j] > array[j + 1]) {
                    // Поменяйте элементы
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    swapped = true;
                    swaps++;
                }
            }

            // Проход справа налево
            for (int j = array.length - i - 1; j > i; j--) {
                comparisons++;
                if (array[j] < array[j - 1]) {
                    // Поменяйте элементы
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;

                    swapped = true;
                    swaps++;
                }
            }

            // Если не было перестановок в этом проходе, массив отсортирован
            if (!swapped) {
                break;
            }
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public int getComparisons() {
        return comparisons;
    }

    public int getSwaps() {
        return swaps;
    }
}
