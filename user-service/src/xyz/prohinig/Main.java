package xyz.prohinig;

import xyz.prohinig.users.User;
import xyz.prohinig.users.UserManager;

import java.util.Collection;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserManager userManager = new UserManager();

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

            if(isUsernameInUse(username, userManager)) {
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
        switch (userOperationString) {
            case "ADD":
                return UserOperation.ADD;
            case "REMOVE":
                return UserOperation.REMOVE;
            default:
                return null;
        }
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
