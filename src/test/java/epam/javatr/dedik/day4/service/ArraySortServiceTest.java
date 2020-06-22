package epam.javatr.dedik.day4.service;

import by.epam.javatr.dedik.day4.entity.ArrayShell;
import by.epam.javatr.dedik.day4.service.ArraySortService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ArraySortServiceTest {
    @Test
    public void quickSort_unsortedArray_sortedArray() {
        ArrayShell actual = new ArrayShell(new int[]{2, 7, 9, 6, 8, 3, 1, 5, 4, 0});
        ArraySortService.quickSort(actual, 0, actual.size() - 1);
        ArrayShell expected = new ArrayShell(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void heapsort_unsortedArray_sortedArray() {
        ArrayShell actual = new ArrayShell(new int[]{2, 7, 9, 6, 8, 3, 1, 5, 4, 0});
        ArraySortService.heapSort(actual);
        ArrayShell expected = new ArrayShell(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
        Assert.assertEquals(actual, expected);
    }
}
