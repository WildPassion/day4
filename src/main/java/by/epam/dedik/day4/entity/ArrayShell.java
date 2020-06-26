package by.epam.dedik.day4.entity;

import by.epam.dedik.day4.exception.ArrayException;

import java.util.ArrayList;
import java.util.StringJoiner;

public class ArrayShell {
    private static final int DEFAULT_CAPACITY = 10;
    private static final int MIN_ARRAY_LENGTH = 2;

    private int[] array;
    private int size;

    public ArrayShell() {
        array = new int[DEFAULT_CAPACITY];
    }

    public ArrayShell(int[] array) throws ArrayException {
        if (array == null) {
            throw new ArrayException("Can not create with null array");
        } else if (array.length < MIN_ARRAY_LENGTH) {
            throw new ArrayException("Degenerate array");
        } else {
            this.array = array;
            size = array.length;
        }
    }

    public void addElement(int element) {
        if (size >= array.length) {
            expansion();
        }
        array[size++] = element;
    }

    public int getElement(int index) throws ArrayException {
        if (index >= 0 && index < size) {
            return array[index];
        } else {
            throw new ArrayException("Can not get element by index " + index);
        }
    }

    public int size() {
        return size;
    }

    public boolean removeElement(int index) {
        boolean result = false;
        new ArrayList<Integer>().trimToSize();
        if (index >= 0 && index < size) {
            int remainder = size - index - 1;
            if (remainder > 0) {
                System.arraycopy(array, index + 1, array, index, remainder);
            }
            array[--size] = 0;
            result = true;
        }
        return result;
    }

    public void trimToSize() {
        if (size == 0) {
            array = new int[DEFAULT_CAPACITY];
        } else {
            int[] copy = new int[size];
            System.arraycopy(array, 0, copy, 0, size);
            array = copy;
        }
    }

    public boolean replaceElement(int element, int index) {
        boolean result = false;
        if (index >= 0 && index < size) {
            array[index] = element;
            result = true;
        }
        return result;
    }

    public boolean swap(int firstIndex, int secondIndex) {
        boolean result = false;
        if (firstIndex >= 0 && secondIndex >= 0 &&
                firstIndex < size && secondIndex < size) {
            int temp = array[firstIndex];
            array[firstIndex] = array[secondIndex];
            array[secondIndex] = temp;
            result = true;
        }
        return result;
    }

    public void reverse() {
        for (int i = 0; i < size / 2; i++) {
            int temp = array[i];
            array[i] = array[size - i - 1];
            array[size - i - 1] = temp;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArrayShell that = (ArrayShell) o;

        if (array == that.array) return true;
        if (size != that.size) return false;

        for (int i = 0; i < size; i++) {
            if (array[i] != that.array[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        if (array == null) return 0;

        int result = 1;
        for (int element : array) {
            result = 31 * result + element;
        }

        return result;
    }

    @Override
    public String toString() {
        if (array == null) return "null";
        if (array.length - 1 == -1) return "[]";

        StringBuilder builder = new StringBuilder("[");
        int i = 0;
        while (i != size) {
            builder.append(array[i]);
            if (i != size - 1) {
                builder.append(", ");
            }
            i++;
        }
        builder.append(']');

        return new StringJoiner(", ", ArrayShell.class.getSimpleName() + "[", "]")
                .add("array=" + builder.toString())
                .toString();
    }

    private void expansion() {
        int[] copy = new int[size * 2];
        System.arraycopy(array, 0, copy, 0, size);
        array = copy;
    }
}
