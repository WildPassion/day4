package by.epam.dedik.day4.entity;

import by.epam.dedik.day4.exception.ArrayException;
import by.epam.dedik.day4.service.SortType;

public enum MatrixSortType {
    AMOUNT(new SortType() {
        public int[] calculateUtilArray(int[][] matrix) throws ArrayException {
            if (matrix == null) {
                return new int[]{};
            }

            int[] amountInRows = new int[matrix.length];
            for (int i = 0; i < matrix.length; i++) {
                amountInRows[i] = amount(matrix[i]);
            }
            return amountInRows;
        }

        private int amount(int[] array) throws ArrayException {
            if (array == null || array.length <= 0) {
                throw new ArrayException("Degenerate array");
            }

            int amount = 0;
            for (int value : array) {
                amount += value;
            }
            return amount;
        }
    }),
    MAX(new SortType() {
        public int[] calculateUtilArray(int[][] matrix) throws ArrayException {
            if (matrix == null) {
                return new int[]{};
            }

            int[] maxInRows = new int[matrix.length];
            for (int i = 0; i < matrix.length; i++) {
                maxInRows[i] = max(matrix[i]);
            }
            return maxInRows;
        }

        private int max(int[] array) throws ArrayException {
            if (array == null || array.length <= 0) {
                throw new ArrayException("Degenerate array");
            }

            int max = array[0];
            for (int value : array) {
                if (max < value) {
                    max = value;
                }
            }
            return max;
        }
    }),
    MIN(new SortType() {
        public int[] calculateUtilArray(int[][] matrix) throws ArrayException {
            if (matrix == null) {
                return new int[]{};
            }

            int[] minInRows = new int[matrix.length];
            for (int i = 0; i < matrix.length; i++) {
                minInRows[i] = min(matrix[i]);
            }
            return minInRows;
        }

        private int min(int[] array) throws ArrayException {
            if (array == null || array.length <= 0) {
                throw new ArrayException("Degenerate array");
            }

            int min = array[0];
            for (int value : array) {
                if (min > value) {
                    min = value;
                }
            }
            return min;
        }
    });

    private SortType sortType;

    MatrixSortType(SortType sortType) {
        this.sortType = sortType;
    }

    public SortType getSortType() {
        return sortType;
    }
}
