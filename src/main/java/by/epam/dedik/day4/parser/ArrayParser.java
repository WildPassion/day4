package by.epam.dedik.day4.parser;

import by.epam.dedik.day4.entity.ArrayShell;
import by.epam.dedik.day4.exception.ArrayException;
import by.epam.dedik.day4.validator.NumberValidator;

import java.util.regex.Pattern;

public class ArrayParser {
    private NumberValidator validator = new NumberValidator();

    public int[] toArray(String string) throws ArrayException {
        Pattern pattern = Pattern.compile(" ");
        String[] numbers = pattern.split(string);
        int arraySize = countNumbers(numbers);

        if (arraySize >= ArrayShell.MIN_ARRAY_LENGTH) {
            int[] array = new int[arraySize];

            for (int i = 0, j = 0; i < numbers.length; i++) {
                if (validator.isInteger(numbers[i])) {
                    array[j++] = Integer.parseInt(numbers[i]);
                }
            }
            return array;
        } else {
            throw new ArrayException("Degenerate array");
        }
    }

    private int countNumbers(String[] numbers) {
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (validator.isInteger(numbers[i])) {
                count++;
            }
        }
        return count;
    }
}
