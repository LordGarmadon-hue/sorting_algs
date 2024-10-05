package sortingAlgorithms;

public class InsertsSorting {
    private int comparisons;
    private int swaps;

    public void sort(int[] array) {
        comparisons = 0;
        swaps = 0;
        int j;
        for (int i = 1; i < array.length; i++) {
            //сохраняем ссылку на индекс предыдущего элемента
            int swap = array[i];
            comparisons++;
            for (j = i; j > 0 && swap < array[j - 1]; j--) {
                comparisons++;
                //элементы отсортированного сегмента перемещаем вперёд, если они больше элемента для вставки
                array[j] = array[j - 1];
                swaps++;
            }
            array[j] = swap;
            swaps++;
        }
    }



    public int getComparisons() {
        return comparisons;
    }

    public int getSwaps() {
        return swaps;
    }
}
