package sortingAlgorithms;

public class ShakerSorting {
    private int comparisons;
    private int swaps;

    public void sort(int[] array) {
        comparisons = 0;
        swaps = 0;
        boolean flag = true;
        int left = 0;
        int right = array.length - 1;

        while (flag) {
            flag = false;

            // Проход слева направо
            for (int i = left; i < right; i++) {
                comparisons++;
                if (array[i] > array[i + 1]) {
                    swaps++;
                    // Обмен значениями
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    flag = true;
                }
            }
            right--;

            // Проход справа налево
            for (int i = right; i > left; i--) {
                comparisons++;
                if (array[i] < array[i - 1]) {
                    swaps++;
                    // Обмен значениями
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                    flag = true;
                }
            }
            left++;
        }
    }

    public int getComparisons() {
        return comparisons;
    }

    public int getSwaps() {
        return swaps;
    }
}
