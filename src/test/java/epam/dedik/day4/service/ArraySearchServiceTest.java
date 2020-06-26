package epam.dedik.day4.service;

import by.epam.dedik.day4.entity.ArrayShell;
import by.epam.dedik.day4.exception.ArrayException;
import by.epam.dedik.day4.service.ArraySearchService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ArraySearchServiceTest {
    private ArraySearchService service;

    @BeforeClass
    public void setUp() {
        service = new ArraySearchService();
    }

    @Test
    public void binarySearch_sortedArray_index() throws ArrayException {
        ArrayShell arrayShell = new ArrayShell(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
        int actual = service.binarySearch(arrayShell, 0);
        int expected = 0;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void binarySearch_emptyArray_negativeIndex() throws ArrayException {
        ArrayShell arrayShell = new ArrayShell();
        int actual = service.binarySearch(arrayShell, 0);
        int expected = -1;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void binarySearch_nullArray_negativeIndex() throws ArrayException {
        ArrayShell arrayShell = null;
        int actual = service.binarySearch(arrayShell, 0);
        int expected = -1;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void min_arrayShell_minValue() throws ArrayException {
        ArrayShell arrayShell = new ArrayShell(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
        int actual = service.min(arrayShell);
        int expected = 0;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void max_arrayShell_maxValue() throws ArrayException {
        ArrayShell arrayShell = new ArrayShell(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
        int actual = service.max(arrayShell);
        int expected = 9;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void simpleNumbers_arrayShell_simpleNumbers() throws ArrayException {
        ArrayShell arrayShell = new ArrayShell(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
        ArrayShell actual = service.simpleNumbers(arrayShell);
        ArrayShell expected = new ArrayShell(new int[]{2, 3, 5, 7});
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void fibonacciNumbers_arrayShell_fibonacciNumbers() throws ArrayException {
        ArrayShell arrayShell = new ArrayShell(new int[]{1, 1, 2, 3, 5, 8, 13, 21, 34});
        ArrayShell actual = service.fibonacciNumbers(arrayShell);
        ArrayShell expected = new ArrayShell(new int[]{1, 1, 2, 3, 5, 8, 13, 21, 34});
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void threeDigitNoDuplicateNumbers_arrayShell_threeDigitNoDuplicateNumbers() throws ArrayException {
        ArrayShell arrayShell = new ArrayShell(new int[]{1, 11, 2, 333, 526, 8, 139, 201, 344});
        ArrayShell actual = service.threeDigitNoDuplicateNumbers(arrayShell);
        ArrayShell expected = new ArrayShell(new int[]{526, 139, 201});
        Assert.assertEquals(actual, expected);
    }
}
