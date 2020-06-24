package by.epam.dedik.day4.service;

import by.epam.dedik.day4.entity.ArrayShell;
import by.epam.dedik.day4.exception.ArrayException;

public class ArraySearchService {
    public ArrayShell threeDigitNoDuplicateNumbers(ArrayShell arrayShell) throws ArrayException {
        ArrayShell fibonacciNumbers = new ArrayShell();
        for (int i = 0; i < arrayShell.size(); i++) {
            if (isThreeDigitNoDuplicateNumber(arrayShell.getElement(i))) {
                fibonacciNumbers.addElement(arrayShell.getElement(i));
            }
        }
        return fibonacciNumbers;
    }

    public ArrayShell fibonacciNumbers(ArrayShell arrayShell) throws ArrayException {
        ArrayShell fibonacciNumbers = new ArrayShell();
        for (int i = 0; i < arrayShell.size(); i++) {
            if (isFibonacci(arrayShell.getElement(i))) {
                fibonacciNumbers.addElement(arrayShell.getElement(i));
            }
        }
        return fibonacciNumbers;
    }

    public ArrayShell simpleNumbers(ArrayShell arrayShell) throws ArrayException {
        ArrayShell simpleNumbers = new ArrayShell();
        for (int i = 0; i < arrayShell.size(); i++) {
            if (isSimple(arrayShell.getElement(i))) {
                simpleNumbers.addElement(arrayShell.getElement(i));
            }
        }
        return simpleNumbers;
    }

    public int max(ArrayShell arrayShell) throws ArrayException {
        int max = arrayShell.getElement(0);
        for (int i = 0; i < arrayShell.size(); i++) {
            if (max < arrayShell.getElement(i)) {
                max = arrayShell.getElement(i);
            }
        }
        return max;
    }

    public int min(ArrayShell arrayShell) throws ArrayException {
        int min = arrayShell.getElement(0);
        for (int i = 0; i < arrayShell.size(); i++) {
            if (min > arrayShell.getElement(i)) {
                min = arrayShell.getElement(i);
            }
        }
        return min;
    }

    public int binarySearch(ArrayShell array, int key) throws ArrayException {
        return isSorted(array) ? binarySearch(array, key, 0, array.size() - 1) : -1;
    }

    private boolean isThreeDigitNoDuplicateNumber(int number) {
        boolean result = false;
        if (number > 99 && number < 1000) {
            int firstRemainder = number / 100;
            int secondRemainder = number / 10 % 10;
            int thirdRemainder = number % 10;
            result = firstRemainder != secondRemainder &&
                    firstRemainder != thirdRemainder &&
                    secondRemainder != thirdRemainder;
        }
        return result;
    }

    private boolean isFibonacci(int number) {
        double first = 5 * Math.pow(number, 2) - 4;
        double second = 5 * Math.pow(number, 2) + 4;
        double firstSqrt = Math.sqrt(first);
        double secondSqrt = Math.sqrt(second);
        return Math.pow(firstSqrt, 2) == first || Math.pow(secondSqrt, 2) == second;
    }

    private boolean isSimple(int number) {
        number = Math.abs(number);
        if (number < 2) {
            return false;
        }
        int sqrt = (int) Math.sqrt(number);
        for (int i = 2; i <= sqrt; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private boolean isSorted(ArrayShell arrayShell) throws ArrayException {
        boolean result = true;
        for (int i = 0; i < arrayShell.size() - 1; i++) {
            if (arrayShell.getElement(i) > arrayShell.getElement(i + 1)) {
                result = false;
            }
        }
        return result;
    }

    private int binarySearch(ArrayShell sortedArray, int key, int low, int high) throws ArrayException {
        int middle = (low + high) / 2;

        if (high < low) {
            return -1;
        }

        if (key == sortedArray.getElement(middle)) {
            return middle;
        } else if (key < sortedArray.getElement(middle)) {
            return binarySearch(
                    sortedArray, key, low, middle - 1);
        } else {
            return binarySearch(
                    sortedArray, key, middle + 1, high);
        }
    }
}
