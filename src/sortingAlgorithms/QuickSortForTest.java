package sortingAlgorithms;

public class QuickSortForTest {

    private int comparisons;
    private int swaps;

    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int low, int high) {
        //завершить,если массив пуст или уже нечего делить
        if (array.length == 0 || low >= high) return;

        //выбираем опорный элемент
        int middle = low + (high - low) / 2;
        int border = array[middle];

        //разделияем на подмассивы и меняем местами
        int i = low, j = high;
        while (i <= j) {
            comparisons++;
            while (array[i] < border) i++;
            while (array[j] > border) j--;
            if (i <= j) {
                swaps++;
                int swap = array[i];
                array[i] = array[j];
                array[j] = swap;
                i++;
                j--;
            }
        }

        //рекурсия для сортировки левой и правой части
        if (low < j) quickSort(array, low, j);
        if (high > i) quickSort(array, i, high);
    }

    public int getComparisons() {
        return comparisons;
    }

    public int getSwaps() {
        return swaps;
    }

}
