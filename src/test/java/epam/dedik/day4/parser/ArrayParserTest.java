package epam.dedik.day4.parser;

import by.epam.dedik.day4.parser.ArrayParser;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ArrayParserTest {
    private ArrayParser parser;

    @BeforeClass
    public void setParser() {
        parser = new ArrayParser();
    }

    @Test
    public void toArray_string_array() {
        String string = "qweqwqe 123 4 6 + +5";
        int[] actual = parser.toArray(string);
        int[] expected = new int[]{123, 4, 6};
        Assert.assertEquals(actual, expected);
    }
}
