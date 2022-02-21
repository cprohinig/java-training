package xyz.prohinig.input;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import xyz.prohinig.users.UserManager;
import xyz.prohinig.users.UserManagerWithForEachAndSet;

import static org.junit.jupiter.api.Assertions.*;

class InputExecutorTest {

    private InputExecutor inputExecutor;

    @BeforeEach
    void setUp() {
        UserManager userManager = new UserManagerWithForEachAndSet();
        inputExecutor = new InputExecutor(userManager);
    }

    @Test
    void shouldStop_returnsTrueWhenInputEqualsSTOP() {
        boolean shouldStop = inputExecutor.shouldStop(InputExecutor.STOP_INPUT);

        assertTrue(shouldStop);
    }

    @ParameterizedTest
    @ValueSource(strings = {"asdf", "StOp", "stop", "ST0P", "   ", ""})
    void shouldStop_returnsFalseWhenInputDoesNotEqualSTOP(String input) {
        assertFalse(inputExecutor.shouldStop(input));
    }

    @Test
    void shouldStop_returnsFalseWhenInputIsNull() {
        assertFalse(inputExecutor.shouldStop(null));
    }

    @Test
    void validateInput_returnsInvalidInputWhenStringCannotBeSplitIn4Parts() {
        ValidatedInput result = inputExecutor.validateInput(",,");

        // equals method of class is used to compare
        // so if there is just the default equals, it will check for object reference
        assertEquals(ValidatedInput.invalid(), result);
    }
}