package xyz.prohinig;

import xyz.prohinig.users.User;
import xyz.prohinig.users.UserManager;
import xyz.prohinig.users.UserManagerWithForEachAndSet;

import java.util.Collection;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UserManager userManager = new UserManagerWithForEachAndSet();

        while (scanner.hasNext()) {
            String userInput = scanner.nextLine();

            if (userInput.equals("STOP")) {
                break;
            }

            String[] userInputArray = userInput.split(",");

            if (userInputArray.length < 4) {
                System.out.println("Incorrect input. Please use the format: OPERATION,username,firstname,lastname");
                continue;
            }

            // trim removes whitespaces at the beginning and end of string
            String operation = userInputArray[0].trim();
            UserOperation userOperation = getUserOperationFromString(operation);
            if (userOperation == null) {
                System.out.println(
                        String.format("Incorrect input for OPERATION: %s. Possible values: %s, %s", operation,
                                UserOperation.ADD, UserOperation.REMOVE));
                continue;
            }

            String username = userInputArray[1].trim();
            String firstname = userInputArray[2].trim();
            String lastname = userInputArray[3].trim();

            if (isUsernameInUse(username, userManager)) {
                System.out.println("Username already in use");
                continue;
            }

            executeUserOperation(userManager, userOperation, new User(username, firstname, lastname));
        }

        System.out.println(userManager.getUsers());
    }

    private static boolean isUsernameInUse(String username, UserManager userManager) {
        Collection<String> usedUsernames = userManager.getAllUsedUsernames();

        return usedUsernames.contains(username);
    }

    private static UserOperation getUserOperationFromString(String userOperationString) {
        return switch (userOperationString) {
            case "ADD" -> UserOperation.ADD;
            case "REMOVE" -> UserOperation.REMOVE;
            default -> null;
        };
    }

    private static void executeUserOperation(
            UserManager userManager,
            UserOperation userOperation,
            User user) {
        switch (userOperation) {
            case ADD:
                userManager.addUser(user);
                break;
            case REMOVE:
                userManager.removeUser(user);
                break;
        }
    }
}
