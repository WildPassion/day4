package epam.dedik.day4.service;

import by.epam.dedik.day4.entity.ArrayShell;
import by.epam.dedik.day4.exception.ArrayException;
import by.epam.dedik.day4.service.ArraySortService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ArraySortServiceTest {
    private ArraySortService sortService;

    @BeforeClass
    public void setUp() {
        sortService = new ArraySortService();
    }

    @Test
    public void quickSort_unsortedArray_sortedArray() throws ArrayException {
        ArrayShell actual = new ArrayShell(new int[]{2, 7, 9, 6, 8, 3, 1, 5, 4, 0});
        sortService.quickSort(actual);
        ArrayShell expected = new ArrayShell(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void heapSort_unsortedArray_sortedArray() throws ArrayException {
        ArrayShell actual = new ArrayShell(new int[]{2, 7, 9, 6, 8, 3, 1, 5, 4, 0});
        sortService.heapSort(actual);
        ArrayShell expected = new ArrayShell(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void mergeSort() throws ArrayException {
        ArrayShell actual = new ArrayShell(new int[]{2, 7, 9, 6, 8, 3, 1, 5, 4, 0});
        sortService.mergeSort(actual);
        ArrayShell expected = new ArrayShell(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
        Assert.assertEquals(actual, expected);
    }
}
