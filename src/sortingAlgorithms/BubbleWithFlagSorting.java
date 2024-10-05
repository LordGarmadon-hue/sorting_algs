package sortingAlgorithms;

public class BubbleWithFlagSorting {
    private int comparisons;
    private int swaps;
    public void sort(int[] array) {
        comparisons = 0;
        swaps = 0;
        for (int i = 0; i < array.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                comparisons++;
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

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

    public int getComparisons() {
        return comparisons;
    }

    public int getSwaps() {
        return swaps;
    }
}
