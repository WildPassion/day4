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
    public void readFromFile_filename_data() {
        String filename = "data.txt";
        Assert.assertNotNull(reader.readFromFile(filename));
    }

    @Test(expectedExceptions = RuntimeException.class, expectedExceptionsMessageRegExp = "Can not find file .+")
    public void readFromFile_incorrectFilename_runtimeException() {
        String filename = "dat.txt";
        reader.readFromFile(filename);
    }
}
