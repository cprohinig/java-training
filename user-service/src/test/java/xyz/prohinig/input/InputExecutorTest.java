package xyz.prohinig.input;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import xyz.prohinig.UserOperation;
import xyz.prohinig.users.UserManager;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class InputExecutorTest {
    public static final String USERNAME = "uname";
    public static final String FIRSTNAME = "firstname";
    public static final String LASTNAME = "lastname";
    public static final UserOperation USER_OPERATION_ADD = UserOperation.ADD;

    // could lead to problems as all tests share the same instance and dependency
    // could lead to previous test methods affecting tests executed afterwards
//    private InputExecutor inputExecutor = new InputExecutor(new UserManagerWithForEachAndSet());
//    private InputExecutor inputExecutor;

    // @Mock is used on a field to tell mockito to create a mock instance of this class
    @Mock
    private UserManager userManagerMock;

    // @InjectMocks is automatically creating an instance of the class and injecting all mocks previously created with @Mock
    @InjectMocks
    private InputExecutor inputExecutor;

    //    @BeforeEach
//    void setUp() {
//        inputExecutor = new InputExecutor(userManagerMock);
//    }

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
        // given
        // "stubbing" of methods is used to tell the mock instance how to behave when specifc methods are called
        // private methods cannot be stubbed
        // when no stubbing for a method is defined the "default" value is returned. false for boolean, null for any object, ...
        when(userManagerMock.isUsernameInUse(any())).thenReturn(true);

        // mock creation with mock method, very similar to instance obtained with @Mock annotation
//        User userMock = mock(User.class);
        // lenient makes mockito ignore unnecessary stubbings, very rarely using it is a good idea
//        lenient().when(userManagerMock.getUserByUsername(usedUserName)).thenReturn(userMock);

        // when
        ValidatedInput result = inputExecutor.validateInput("ADD," + USERNAME + ",1,1");

        // then
        assertEquals(ValidatedInput.invalid(), result);
        // verify is used that a mocks method was called with a given parameter
        verify(userManagerMock).isUsernameInUse(USERNAME);
    }

    @Test
    void validateInput_passesCorrectUsernameToUserManager() {
        // given
        String usedUserName = "username";

        // when
        inputExecutor.validateInput("ADD," + usedUserName + ",1,1");

        // then
        verify(userManagerMock).isUsernameInUse(usedUserName);
    }

    @Test
    void validateInput_returnsValidatedInputWhenValidInputIsPassed() {
        // given
        when(userManagerMock.isUsernameInUse(any())).thenReturn(false);
        // different values should be used for different parameters of same type
        String input = USER_OPERATION_ADD.getInput() + "," + USERNAME + "," + FIRSTNAME + "," + LASTNAME;

        // when
        ValidatedInput result = inputExecutor.validateInput(input);

        // then
        assertEquals(ValidatedInput.valid(USERNAME, FIRSTNAME, LASTNAME, USER_OPERATION_ADD), result);
    }

    @Test
    void validateInput_trimsAllPassedInput() {
        // given
        when(userManagerMock.isUsernameInUse(any())).thenReturn(false);
        // different values should be used for different parameters of same type
        String username = "   " + USERNAME + "   ";
        String firstname = FIRSTNAME + "   ";
        String lastname = "    " + LASTNAME;
        String userOperationInput = USER_OPERATION_ADD.getInput() + "                                   ";
        String input = userOperationInput + ","
                + username + ","
                + firstname + "," +
                lastname;
        // when
        ValidatedInput result = inputExecutor.validateInput(input);

        // then
        assertEquals(ValidatedInput.valid(USERNAME, FIRSTNAME, LASTNAME, USER_OPERATION_ADD), result);
    }
}