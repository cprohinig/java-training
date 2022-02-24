package xyz.prohinig.input;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import xyz.prohinig.users.User;
import xyz.prohinig.users.UserManager;
import xyz.prohinig.users.UserManagerWithForEachAndSet;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class InputExecutorTest {

    // could lead to problems as all tests share the same instance and dependency
    // could lead to previous test methods affecting tests executed afterwards
//    private InputExecutor inputExecutor = new InputExecutor(new UserManagerWithForEachAndSet());

    private UserManager userManager;
    private InputExecutor inputExecutor;

    private InputExecutor inputExecutorWithMock;

    @Mock
    private UserManager userManagerMock;

    @BeforeEach
    void setUp() {
        userManager = new UserManagerWithForEachAndSet();
        inputExecutor = new InputExecutor(userManager);
        inputExecutorWithMock = new InputExecutor(userManagerMock);
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

    @Test
    void validateInput_returnsInvalidInputWhenUserOperationCannotBeParsed() {
        ValidatedInput result = inputExecutor.validateInput("1,1,1,1");

        assertEquals(ValidatedInput.invalid(), result);
    }

    @Test
    void validateInput_returnsInvalidInputWhenUsernameIsInUse() {
        // preferred structure for tests with dependencies

        // given
        String usedUserName = "username2";
        // implicitly we are testing the usermanager because we just know that we are calling
        // isUsernameInUse but depend on it returning true after adding this user
        userManager.addUser(new User(usedUserName, "", ""));

        // when
        ValidatedInput result = inputExecutor.validateInput("ADD," + usedUserName + ",1,1");

        // then
        assertEquals(ValidatedInput.invalid(), result);
    }

    @Test
    void validateInput_returnsInvalidInputWhenUsernameIsInUseWithMock() {
        // given
        String usedUserName = "username";
        when(userManagerMock.isUsernameInUse(usedUserName)).thenReturn(true);

        // when
        ValidatedInput result = inputExecutorWithMock.validateInput("ADD," + usedUserName + ",1,1");

        // then
        assertEquals(ValidatedInput.invalid(), result);
    }
}