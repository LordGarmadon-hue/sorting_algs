package sortingAlgorithms;

public class ShakerWithFlagSorting {
    private int comparisons;
    private int swaps;

    public void sort(int[] array) {
        comparisons = 0;
        swaps = 0;
        boolean swapped = true;
        int start = 0;
        int end = array.length - 1;

        while (swapped) {
            swapped = false;

            // Проход с начала в конец
            for (int i = start; i < end; i++) {
                comparisons++;
                if (array[i] > array[i + 1]) {
                    swaps++;
                    // Swap
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }
            end--;

            // Если не было обменов, выходим
            if (!swapped) break;

            swapped = false;

            // Проход с конца в начало
            for (int i = end; i > start; i--) {
                comparisons++;
                if (array[i] < array[i - 1]) {
                    swaps++;
                    // Swap
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                    swapped = true;
                }
            }
            start++;
        }
    }

    public int getComparisons() {
        return comparisons;
    }

    public int getSwaps() {
        return swaps;
    }
}
