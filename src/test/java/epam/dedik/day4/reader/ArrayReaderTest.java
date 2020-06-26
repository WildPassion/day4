package epam.dedik.day4.reader;

import by.epam.dedik.day4.reader.ArrayReader;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ArrayReaderTest {
    private ArrayReader reader;

    @BeforeClass
    private void setUp() {
        reader = new ArrayReader();
    }

    @Test
    public void readFromFile_data() {
        System.out.println(reader.readFromFile());
        Assert.assertNotNull(reader.readFromFile());
    }
}
