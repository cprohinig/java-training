package xyz.prohinig.input;

import org.junit.jupiter.api.Test;
import xyz.prohinig.UserOperation;

import static org.junit.jupiter.api.Assertions.*;

class ValidatedInputTest {

    @Test
    void invalid_returnsInstanceWithNullFieldsAndValidFlagSetToFalse() {
        ValidatedInput input = ValidatedInput.invalid();

        assertNull(input.getUsername());
        assertNull(input.getFirstname());
        assertNull(input.getLastname());
        assertNull(input.getUserOperation());
        assertFalse(input.isValid(), "Expected input isValid to return false but was " + input.isValid());
    }

    @Test
    void valid_returnsExpectedInstanceWithValidFlagSetToTrue() {
        String username = "user,,,";
        String firstname = "firs819234981234t";
        String lastname = "las012340123401234-t";
        UserOperation userOperation = UserOperation.ADD;

        ValidatedInput input = ValidatedInput.valid(username, firstname, lastname, userOperation);

        assertEquals(username, input.getUsername());
        assertEquals(firstname, input.getFirstname());
        assertEquals(lastname, input.getLastname());
        assertEquals(userOperation, input.getUserOperation());
        assertTrue(input.isValid());
    }
}