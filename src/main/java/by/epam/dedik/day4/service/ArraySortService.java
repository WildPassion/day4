package by.epam.dedik.day4.service;

import by.epam.dedik.day4.exception.ArrayException;
import by.epam.dedik.day4.entity.ArrayShell;

public class ArraySortService {
    public void quickSort(ArrayShell arrayShell, int low, int high) throws ArrayException {
        if (low < high) {
            int pi = partition(arrayShell, low, high);

            quickSort(arrayShell, low, pi);
            quickSort(arrayShell, pi + 1, high);
        }
    }

    public void heapSort(ArrayShell arrayShell) throws ArrayException {
        int n = arrayShell.size();

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arrayShell, n, i);

        // One by one extract an element from heap
        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end
            arrayShell.swapElements(0, i);

            // call max heapify on the reduced heap
            heapify(arrayShell, i, 0);
        }
    }

    private int partition(ArrayShell arrayShell, int low, int high) throws ArrayException {
        int pivot = arrayShell.getElement(low);
        int i = low - 1;
        int j = high + 1;

        while (true) {
            // Find leftmost element greater
            // than or equal to pivot
            do {
                i++;
            } while (arrayShell.getElement(i) < pivot);

            // Find rightmost element smaller
            // than or equal to pivot
            do {
                j--;
            } while (arrayShell.getElement(j) > pivot);

            // If two pointers met.
            if (i >= j)
                return j;
            arrayShell.swapElements(i, j);
        }
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    private void heapify(ArrayShell arrayShell, int n, int i) throws ArrayException {
        int largest = i;  // Initialize largest as root
        int l = 2 * i + 1;  // left = 2*i + 1
        int r = 2 * i + 2;  // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arrayShell.getElement(l) > arrayShell.getElement(largest))
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arrayShell.getElement(r) > arrayShell.getElement(largest))
            largest = r;

        // If largest is not root
        if (largest != i) {
            arrayShell.swapElements(i, largest);

            // Recursively heapify the affected sub-tree
            heapify(arrayShell, n, largest);
        }
    }
}
