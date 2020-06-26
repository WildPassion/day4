package epam.dedik.day4.validator;

import by.epam.dedik.day4.validator.NumberValidator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class NumberValidatorTest {
    private NumberValidator validator;

    @BeforeClass
    public void setValidator() {
        validator = new NumberValidator();
    }

    @Test
    public void isInteger_integer_true() {
        assertTrue(validator.isInteger("-1000"));
    }

    @Test
    public void isInteger_bigNumber_false() {
        assertFalse(validator.isInteger("10000000000"));
    }

    @Test
    public void isInteger_notNumber_false() {
        assertFalse(validator.isInteger("1000q"));
    }
}
