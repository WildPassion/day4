package by.epam.dedik.day4.service;

import by.epam.dedik.day4.entity.ComparisonRule;
import by.epam.dedik.day4.entity.MatrixSortType;
import by.epam.dedik.day4.exception.ArrayException;

public class MatrixSortService {
    public void sort(int[][] matrix, ComparisonRule rule, MatrixSortType type) throws ArrayException {
        if (matrix == null || type == null || rule == null) {
            throw new ArrayException("Incorrect input data");
        }
        int[] attribute = type.getSortType().calculateUtilArray(matrix);
        int size = attribute.length;
        for (int i = 0; i < size; i++) {
            for (int j = 1; j < size - i; j++) {
                if (rule.getComparison().compare(attribute[j], attribute[j - 1])) {
                    swap(matrix, j, j - 1);
                    swap(attribute, j, j - 1);
                }
            }
        }
    }


    private void swap(int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    private void swap(int[][] matrix, int firstIndex, int secondIndex) {
        int[] temp = matrix[firstIndex];
        matrix[firstIndex] = matrix[secondIndex];
        matrix[secondIndex] = temp;
    }
}
