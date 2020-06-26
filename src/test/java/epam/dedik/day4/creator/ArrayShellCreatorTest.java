package epam.dedik.day4.creator;

import by.epam.dedik.day4.creator.ArrayShellCreator;
import by.epam.dedik.day4.entity.ArrayShell;
import by.epam.dedik.day4.exception.ArrayException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.fail;

public class ArrayShellCreatorTest {
    private ArrayShellCreator creator;

    @BeforeClass
    public void setCreator() {
        creator = new ArrayShellCreator();
    }

    @Test
    public void createFromFile_filename_arrayShell() {
        String filename = "data.txt";
        try {
            ArrayShell actual = creator.createFromFile(filename);
            ArrayShell expected = new ArrayShell(new int[]{123, 4, 6});
            Assert.assertEquals(actual, expected);
        } catch (ArrayException e) {
            fail("Array size must be more than 1");
        }
    }

    @Test
    public void createRandom_size_arrayShell() {
        int size = 5;
        int actual = creator.createRandom(size).size();
        int expected = 5;
        Assert.assertEquals(actual, expected);
    }
}
