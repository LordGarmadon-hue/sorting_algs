package sortingAlgorithms;

public class HeapSort {

    private int comparisons;
    private int swaps;

    public void sort(int[] array) {
        int n = array.length;

        // Построение кучи
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        // Один за другим извлекаем элементы из кучи
        for (int i = n - 1; i > 0; i--) {
            swap(array, 0, i);
            heapify(array, i, 0);
        }
    }

    private void heapify(int[] array, int n, int i) {
        int largest = i; // Инициализация наибольшего элемента как корня
        int left = 2 * i + 1; // левый = 2*i + 1
        int right = 2 * i + 2; // правый = 2*i + 2

        if (left < n) {
            comparisons++;
            if (array[left] > array[largest]) {
                largest = left;
            }
        }

        if (right < n) {
            comparisons++;
            if (array[right] > array[largest]) {
                largest = right;
            }
        }

        // Если наибольший элемент не корень
        if (largest != i) {
            swap(array, i, largest);
            heapify(array, n, largest);
        }
    }

    private void swap(int[] array, int i, int j) {
        swaps++;
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
