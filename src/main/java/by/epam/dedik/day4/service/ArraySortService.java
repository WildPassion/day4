package by.epam.dedik.day4.service;

import by.epam.dedik.day4.entity.ArrayShell;
import by.epam.dedik.day4.exception.ArrayException;

public class ArraySortService {
    public void quickSort(ArrayShell arrayShell) throws ArrayException {
        if (arrayShell != null) {
            quickSort(arrayShell, 0, arrayShell.size() - 1);
        }
    }

    public void mergeSort(ArrayShell arrayShell) throws ArrayException {
        if (arrayShell != null) {
            mergeSort(arrayShell, 0, arrayShell.size() - 1);
        }
    }

    public void heapSort(ArrayShell arrayShell) throws ArrayException {
        if (arrayShell != null) {
            int size = arrayShell.size();
            for (int i = size / 2; i >= 0; i--) {
                heapify(arrayShell, size, i);
            }

            for (int i = size - 1; i >= 0; i--) {
                arrayShell.swap(0, i);
                heapify(arrayShell, i, 0);
            }
        }
    }

    private void quickSort(ArrayShell arrayShell, int left, int right) throws ArrayException {
        if (left < right) {
            int pi = partition(arrayShell, left, right);

            quickSort(arrayShell, left, pi);
            quickSort(arrayShell, pi + 1, right);
        }
    }

    private void mergeSort(ArrayShell arrayShell, int left, int right) throws ArrayException {
        if (left < right) {
            int middle = (left + right) / 2;

            mergeSort(arrayShell, left, middle);
            mergeSort(arrayShell, middle + 1, right);

            merge(arrayShell, left, middle, right);
        }
    }

    private int partition(ArrayShell arrayShell, int left, int right) throws ArrayException {
        int pivot = arrayShell.getElement(left);
        int i = left - 1;
        int j = right + 1;

        while (true) {
            do {
                i++;
            } while (arrayShell.getElement(i) < pivot);

            do {
                j--;
            } while (arrayShell.getElement(j) > pivot);

            if (i >= j) {
                return j;
            }
            arrayShell.swap(i, j);
        }
    }

    private void heapify(ArrayShell arrayShell, int size, int i) throws ArrayException {
        int root = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && arrayShell.getElement(left) > arrayShell.getElement(root)) {
            root = left;
        }

        if (right < size && arrayShell.getElement(right) > arrayShell.getElement(root)) {
            root = right;
        }

        if (root != i) {
            arrayShell.swap(i, root);
            heapify(arrayShell, size, root);
        }
    }


    private void merge(ArrayShell arrayShell, int left, int middle, int right) throws ArrayException {
        int[] leftArray = new int[middle - left + 1];
        int[] rightArray = new int[right - middle];

        for (int i = 0; i < leftArray.length; i++) {
            leftArray[i] = arrayShell.getElement(left + i);
        }
        for (int i = 0; i < rightArray.length; i++) {
            rightArray[i] = arrayShell.getElement(middle + 1 + i);
        }

        int i = 0;
        int j = 0;
        int k = left;

        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] < rightArray[j]) {
                arrayShell.replaceElement(leftArray[i], k);
                i++;
            } else {
                arrayShell.replaceElement(rightArray[j], k);
                j++;
            }
            k++;
        }

        while (i < leftArray.length) {
            arrayShell.replaceElement(leftArray[i], k);
            i++;
            k++;
        }

        while (j < rightArray.length) {
            arrayShell.replaceElement(rightArray[j], k);
            j++;
            k++;
        }
    }
}
