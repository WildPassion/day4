package epam.dedik.day4.service;

import by.epam.dedik.day4.entity.ComparisonRule;
import by.epam.dedik.day4.entity.MatrixSortType;
import by.epam.dedik.day4.exception.ArrayException;
import by.epam.dedik.day4.service.MatrixSortService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class MatrixSortServiceTest {
    private MatrixSortService service;

    public MatrixSortServiceTest() {
    }

    @BeforeClass
    public void setService() {
        service = new MatrixSortService();
    }

    @DataProvider
    public Object[][] getData() {
        return new Object[][]{{new int[][]{
                {3, 4, 5, 8, 9, 5},//34
                {56, 6, 7},//69
                {9, 8, 5, 8},//30
                {8, 7, 52}}}};//67
    }

    @Test(dataProvider = "getData")
    public void sort_jaggedArray_sortAscendingByAmount(Object[][] data) throws ArrayException {
        int[][] actual = (int[][]) data[0];
        System.out.println(Arrays.deepToString(actual));
        ComparisonRule rule = ComparisonRule.ASCENDING;
        MatrixSortType type = MatrixSortType.AMOUNT;
        int[][] expected = new int[][]{
                {9, 8, 5, 8},//30
                {3, 4, 5, 8, 9, 5},//34
                {8, 7, 52},//67
                {56, 6, 7}//69
        };
        service.sort(actual, rule, type);
        System.out.println(Arrays.deepToString(actual));
        Assert.assertTrue(isEquals(actual, expected));
    }

    @Test(dataProvider = "getData")
    public void sort_jaggedArray_sortDescendingByAmount(Object[][] data) throws ArrayException {
        int[][] actual = (int[][]) data[0];
        ComparisonRule rule = ComparisonRule.DESCENDING;
        MatrixSortType type = MatrixSortType.AMOUNT;
        int[][] expected = new int[][]{
                {56, 6, 7},//69
                {8, 7, 52},//67
                {3, 4, 5, 8, 9, 5},//34
                {9, 8, 5, 8}//30
        };
        service.sort(actual, rule, type);
        Assert.assertTrue(isEquals(actual, expected));
    }

    @Test(dataProvider = "getData")
    public void sort_jaggedArray_sortAscendingByMax(Object[][] data) throws ArrayException {
        int[][] actual = (int[][]) data[0];
        ComparisonRule rule = ComparisonRule.ASCENDING;
        MatrixSortType type = MatrixSortType.MAX;
        int[][] expected = new int[][]{
                {3, 4, 5, 8, 9, 5},
                {9, 8, 5, 8},
                {8, 7, 52},
                {56, 6, 7}
        };
        service.sort(actual, rule, type);
        Assert.assertTrue(isEquals(actual, expected));
    }

    @Test(dataProvider = "getData")
    public void sort_jaggedArray_sortDescendingByMax(Object[][] data) throws ArrayException {
        int[][] actual = (int[][]) data[0];
        ComparisonRule rule = ComparisonRule.DESCENDING;
        MatrixSortType type = MatrixSortType.MAX;
        int[][] expected = new int[][]{
                {56, 6, 7},
                {8, 7, 52},
                {3, 4, 5, 8, 9, 5},
                {9, 8, 5, 8}
        };
        service.sort(actual, rule, type);
        Assert.assertTrue(isEquals(actual, expected));
    }

    @Test(dataProvider = "getData")
    public void sort_jaggedArray_sortAscendingByMin(Object[][] data) throws ArrayException {
        int[][] actual = (int[][]) data[0];
        ComparisonRule rule = ComparisonRule.ASCENDING;
        MatrixSortType type = MatrixSortType.MIN;
        int[][] expected = new int[][]{
                {3, 4, 5, 8, 9, 5},
                {9, 8, 5, 8},
                {56, 6, 7},
                {8, 7, 52}
        };
        service.sort(actual, rule, type);
        Assert.assertTrue(isEquals(actual, expected));
    }

    @Test(dataProvider = "getData")
    public void sort_jaggedArray_sortDescendingByMin(Object[][] data) throws ArrayException {
        int[][] actual = (int[][]) data[0];
        ComparisonRule rule = ComparisonRule.DESCENDING;
        MatrixSortType type = MatrixSortType.MIN;
        int[][] expected = new int[][]{
                {8, 7, 52},
                {56, 6, 7},
                {9, 8, 5, 8},
                {3, 4, 5, 8, 9, 5}
        };
        service.sort(actual, rule, type);
        Assert.assertTrue(isEquals(actual, expected));
    }

    @Test(expectedExceptions = ArrayException.class, expectedExceptionsMessageRegExp = "Degenerate array")
    public void sort_emptyMatrix_arrayException() throws ArrayException {
        int[][] actual = new int[][]{{}, {}, {}};
        ComparisonRule rule = ComparisonRule.DESCENDING;
        MatrixSortType type = MatrixSortType.MIN;
        int[][] expected = new int[][]{
                {8, 7, 52},
                {56, 6, 7},
                {9, 8, 5, 8},
                {3, 4, 5, 8, 9, 5}
        };
        service.sort(actual, rule, type);
    }

    @Test(expectedExceptions = ArrayException.class, expectedExceptionsMessageRegExp = "Incorrect input data")
    public void sort_nullMatrix_arrayException() throws ArrayException {
        int[][] actual = null;
        ComparisonRule rule = ComparisonRule.DESCENDING;
        MatrixSortType type = MatrixSortType.MIN;
        int[][] expected = new int[][]{
                {8, 7, 52},
                {56, 6, 7},
                {9, 8, 5, 8},
                {3, 4, 5, 8, 9, 5}
        };
        service.sort(actual, rule, type);
    }

    private boolean isEquals(int[][] first, int[][] second) {
        for (int i = 0; i < first.length; i++) {
            if (!Arrays.equals(first[i], second[i])) return false;
        }
        return true;
    }
}
