package xyz.prohinig;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import xyz.prohinig.input.InputExecutor;
import xyz.prohinig.input.ValidatedInput;
import xyz.prohinig.users.UserManager;
import xyz.prohinig.users.UserManagerWithForEachAndSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserManager userManager = new UserManagerWithForEachAndSet();
//        InputExecutor inputExecutor = new InputExecutor(userManager);
        InputExecutor inputExecutor = new InputExecutor(null);

        // guava immutable collections
//        List<String> someStringList = ImmutableList.of("someString", "someOtherString", "string", "bla");
//        List<String> initializedList = Lists.newArrayList("asdf", "asdfasd", "ADSfasdf", "Adsffadsasedf");
//        initializedList.add("asdfasdf");
//        Sets.newHashSet();
//        Maps.newLinkedHashMap();

        while (scanner.hasNext()) {
            String userInput = scanner.nextLine();

            if (inputExecutor.shouldStop(userInput)) {
                break;
            }

            ValidatedInput validatedInput = inputExecutor.validateInput(null);
//            ValidatedInput validatedInput = inputExecutor.validateInput(userInput);
            inputExecutor.executeIfValid(validatedInput);
        }

        System.out.println(userManager.getUsers());
    }
}
