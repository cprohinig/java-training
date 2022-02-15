package xyz.prohinig;

import xyz.prohinig.input.InputExecutor;
import xyz.prohinig.input.ValidatedInput;
import xyz.prohinig.users.UserManager;
import xyz.prohinig.users.UserManagerWithForEachAndSet;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserManager userManager = new UserManagerWithForEachAndSet();
        InputExecutor inputExecutor = new InputExecutor(userManager);

        while (scanner.hasNext()) {
            String userInput = scanner.nextLine();

            if (inputExecutor.shouldStop(userInput)) {
                break;
            }

            ValidatedInput validatedInput = inputExecutor.validateInput(userInput);
            inputExecutor.executeIfValid(validatedInput);
        }

        System.out.println(userManager.getUsers());
    }
}
