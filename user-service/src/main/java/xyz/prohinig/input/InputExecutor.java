package xyz.prohinig.input;

import com.google.common.annotations.VisibleForTesting;
import xyz.prohinig.UserOperation;
import xyz.prohinig.users.User;
import xyz.prohinig.users.UserManager;

import javax.annotation.CheckForNull;
import javax.annotation.ParametersAreNonnullByDefault;

import static java.util.Objects.requireNonNull;

@ParametersAreNonnullByDefault
public class InputExecutor {

    @VisibleForTesting
    static final String STOP_INPUT = "STOP";

    // there is a dependency to the userManager, so it has to be part of the input executor
    private final UserManager userManager;

    // passing a "dependency" in the constructor == "Dependency Injection"
    // instantiating dependencies inside a class is in general BAD
    // important to be able to define which instance is used
    public InputExecutor(UserManager userManager) {
        // enforce @ParametersAreNonnullByDefault
        this.userManager = requireNonNull(userManager, "userManager");
//        this.userManager = userManager;
//        this.userManager = userManager;
    }

    public boolean shouldStop(@CheckForNull String input) {
        return STOP_INPUT.equals(input);
    }

    public ValidatedInput validateInput(String input) {
        String[] userInputArray = input.split(",");

        if (userInputArray.length < 4) {
            System.out.println("Incorrect input. Please use the format: OPERATION,username,firstname,lastname");
            return ValidatedInput.invalid();
        }

        // trim removes whitespaces at the beginning and end of string
        String operation = userInputArray[0].trim();
        UserOperation userOperation = UserOperation.fromInput(operation);

        if (userOperation == null) {
            System.out.printf("Incorrect input for OPERATION: %s. Possible values: %s, %s%n", operation,
                    UserOperation.ADD, UserOperation.REMOVE);
            return ValidatedInput.invalid();
        }

        String username = userInputArray[1].trim();

        if (userManager.isUsernameInUse(username)) {
            System.out.println("Username already in use");
            return ValidatedInput.invalid();
        }

        String firstname = userInputArray[2].trim();
        String lastname = userInputArray[3].trim();

        return ValidatedInput.valid(username, firstname, lastname, userOperation);
    }

    public void executeIfValid(ValidatedInput validatedInput) {
        if (validatedInput.isValid()) {
            executeUserOperation(validatedInput.getUserOperation(),
                    new User(
                            validatedInput.getUsername(),
                            validatedInput.getFirstname(),
                            validatedInput.getLastname()
                    ));
        }
    }

    private void executeUserOperation(
            UserOperation userOperation,
            User user) {
        switch (userOperation) {
            case ADD -> userManager.addUser(user);
            case REMOVE -> userManager.removeUser(user);
        }
    }
}
