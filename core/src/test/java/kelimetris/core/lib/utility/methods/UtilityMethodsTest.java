package kelimetris.core.lib.utility.methods;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilityMethodsTest {
    @Test
    void getCurrentDateTest() {
        Assertions.assertEquals(UtilityMethods.getCurrentDate(), 20210510);
    }

    @Test
    void getCurrentTimeTest() {
        System.out.println(UtilityMethods.getCurrentTime());
    }

    @Test
    void dateToIntegerTest() {
        Assertions.assertEquals(UtilityMethods.dateToInteger("20210510"), 20210510);
    }
}