package xyz.prohinig;

import xyz.prohinig.users.User;
import xyz.prohinig.users.UserManager;

import java.util.Collection;

public class InputExecutor {

    // there is a dependency to the userManager, so it has to be part of the input executor
    private final UserManager userManager;

    // passing a "dependency" in the constructor == "Dependency Injection"
    // instantiating dependencies inside a class is in general BAD
    // important to be able to define which instance is used
    public InputExecutor(UserManager userManager) {
        this.userManager = userManager;
    }

    public boolean shouldStop(String input) {
        return input.equals("STOP");
    }

    public boolean isInputValid(String input) {
        String[] userInputArray = input.split(",");

        if (userInputArray.length < 4) {
            System.out.println("Incorrect input. Please use the format: OPERATION,username,firstname,lastname");
            return false;
        }

        // trim removes whitespaces at the beginning and end of string
        String operation = userInputArray[0].trim();
        UserOperation userOperation = UserOperation.fromInput(operation);

        if (userOperation == null) {
            System.out.println(
                    String.format("Incorrect input for OPERATION: %s. Possible values: %s, %s", operation,
                            UserOperation.ADD, UserOperation.REMOVE));
            return false;
        }

        String username = userInputArray[1].trim();

        if (isUsernameInUse(username, userManager)) {
            System.out.println("Username already in use");
            return false;
        }

        return true;
    }

    public void execute(String input) {
        String[] userInputArray = input.split(",");

        // trim removes whitespaces at the beginning and end of string
        String operation = userInputArray[0].trim();
        UserOperation userOperation = UserOperation.fromInput(operation);

        String username = userInputArray[1].trim();
        String firstname = userInputArray[2].trim();
        String lastname = userInputArray[3].trim();

        executeUserOperation(userOperation, new User(username, firstname, lastname));
    }

    private boolean isUsernameInUse(String username, UserManager userManager) {
        Collection<String> usedUsernames = userManager.getAllUsedUsernames();

        return usedUsernames.contains(username);
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
