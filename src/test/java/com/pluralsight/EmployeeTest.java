package com.pluralsight;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
    @Test
    void punchOutShouldCalculateWorkedHours() {

        // arrange
        Employee e = new Employee(12345678910L, "Walen", "Software", 25.00, 0);

        // act
        e.punchIn(10);
        e.punchOut(14);
        // assert
        assertEquals(4.0, e.getRegularHours(), 0.001); //delta is the error margin and 4.0 is the expected
    }


    @Test
    void punchInTwiceShouldNotResetStartTime() {

        // arrange
        Employee e = new Employee(12345678910L, "Walen", "Software", 25.00, 0);

        // act
        e.punchIn(10);
        e.punchIn(12);
        e.punchOut(14);
    // assert
        assertEquals(4.0, e.getRegularHours(), 0.001); //delta is the error margin and 4.0 is the expected
    }

    @Test
    void punchOutWithoutPunchInShouldNotAddHours()  {
    // arrange
        Employee e = new Employee(12345678910L, "Walen", "Software", 25.00, 0);
    // act
        e.punchOut(14);
    // assert
        assertEquals(0.0, e.getRegularHours(), 0.001);
    }
}