package sortingAlgorithms;

public class ShellSorting {
    private int comparisons;
    private int swaps;

    public void sort(int[] array) {
        comparisons = 0;
        swaps = 0;
        int gap = array.length / 2;

        while (gap > 0) {
            for (int i = gap; i < array.length; i++) {
                // Текущий элемент
                int current = array[i];
                int j = i;

                comparisons++;
                while (j >= gap && array[j - gap] > current) {
                    array[j] = array[j - gap];
                    j -= gap;
                    swaps++;
                }

                array[j] = current;
            }

            gap /= 2;
        }
    }

    public int getComparisons() {
        return comparisons;
    }

    public int getSwaps() {
        return swaps;
    }
}
