package by.epam.javatr.dedik.day4.entity;

import java.util.StringJoiner;

public class ArrayShell {
    private int[] array;
    private int cursor = 0;

    public ArrayShell(int size) {
        array = new int[size];
    }

    public ArrayShell(int[] array) {
        this.array = array;
        cursor = array.length;
    }

    public boolean addElement(int element) {
        boolean result = false;
        if (hasPlace()) {
            array[cursor++] = element;
            result = true;
        }
        return result;
    }

    public int getElement(int number) {
        return array[number];
    }

    public int size() {
        return array.length;
    }

    public boolean removeElement(int number) {
        boolean result = false;
        if (number < cursor) {
            array[number] = 0;
            result = true;
        }
        return result;
    }

    public boolean replaceElement(int element, int number) {
        boolean result = false;
        if (number < cursor) {
            array[number] = element;
            result = true;
        }
        return result;
    }

    public boolean swapElements(int first, int second) {
        boolean result = false;
        if (first < cursor && second < cursor) {
            int temp = array[first];
            array[first] = array[second];
            array[second] = temp;
            result = true;
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArrayShell that = (ArrayShell) o;

        if (array == that.array) return true;
        if (array.length != that.array.length) return false;

        for (int i = 0; i < array.length; i++) {
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
        while (i != array.length) {
            builder.append(array[i]);
            if (i != array.length - 1) {
                builder.append(", ");
            }
            i++;
        }
        builder.append(']');

        return new StringJoiner(", ", ArrayShell.class.getSimpleName() + "[", "]")
                .add("array=" + builder.toString())
                .toString();
    }

    private boolean hasPlace() {
        return cursor < array.length;
    }
}
