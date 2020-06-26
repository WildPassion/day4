package by.epam.dedik.day4.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;

public class ArrayReader {
    private static final String FILE_PATH = "data.txt";

    public String readFromFile() {
        String data;
        try (FileReader fileReader = new FileReader(getClass().getClassLoader().getResource(FILE_PATH).getFile());
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            data = bufferedReader.lines().collect(Collectors.joining(" "));
        } catch (NullPointerException | IOException e) {
            throw new RuntimeException("Can not find file " + FILE_PATH, e);
        }
        return data;
    }
}
