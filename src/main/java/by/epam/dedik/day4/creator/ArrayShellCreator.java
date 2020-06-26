package by.epam.dedik.day4.creator;

import by.epam.dedik.day4.entity.ArrayShell;
import by.epam.dedik.day4.exception.ArrayException;
import by.epam.dedik.day4.parser.ArrayParser;
import by.epam.dedik.day4.reader.ArrayReader;

import java.util.Random;
import java.util.Scanner;

public class ArrayShellCreator {
    private static final int MAX_ELEMENT = 1000;

    private Random generator = new Random();
    private ArrayReader reader = new ArrayReader();
    private ArrayParser parser = new ArrayParser();


    public ArrayShell createFromFile(String filename) throws ArrayException {
        int[] array = parser.toArray(reader.readFromFile(filename));

        return new ArrayShell(array);
    }

    public ArrayShell createRandom(int size) {
        ArrayShell arrayShell = new ArrayShell();
        int i = 0;
        while (i < size) {
            arrayShell.addElement(generator.nextInt(MAX_ELEMENT));
            i++;
        }
        return arrayShell;
    }

    public ArrayShell createFromConsole() throws ArrayException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write array elements with delimiter \" \"");
        int[] array = parser.toArray(scanner.next());

        return new ArrayShell(array);
    }

}
