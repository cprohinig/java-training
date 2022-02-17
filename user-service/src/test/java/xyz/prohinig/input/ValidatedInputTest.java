package xyz.prohinig.input;

import org.junit.jupiter.api.Test;

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
}