package xyz.prohinig;

import java.util.*;

public class ControlStructures {
    public static void main(String[] args) {
        // if, elseif, else
        Scanner scanner = new Scanner(System.in);
//        int myInput = scanner.nextInt();
        int myInput = 6;
        boolean isEvenAndLargerThanTen;

        if (myInput % 2 == 0 && myInput > 10) {
//            System.out.println("in if");
            isEvenAndLargerThanTen = true;
        } else if (myInput % 2 == 0) {
//            System.out.println("in else if %2 == 0");
            isEvenAndLargerThanTen = false;
        } else if (myInput > 10) {
//            System.out.println("in else if > 10");
            isEvenAndLargerThanTen = false;
        } else {
//            System.out.println("in else");
            isEvenAndLargerThanTen = false;
        }

//        System.out.println("is even and larger than 10: " + isEvenAndLargerThanTen);

        // ternary operator
        String isEven = myInput % 2 == 0 ? "even" : "odd";

        String isEvenWithIf;
        if (myInput % 2 == 0) {
            isEvenWithIf = "even";
        } else {
            isEvenWithIf = "odd";
        }

//        System.out.println("with ternary: " + isEven + ", with if: " + isEvenWithIf);

//        String myStringInput = scanner.nextLine();
        String myStringInput = "test";

        // switch-case

        switch (myStringInput) {
            case "test":
//                System.out.println("string input is 'test'");
                break;
            case "test2":
//                System.out.println("string input is 'test2'");
                break;
            default:
//                System.out.println("string input did not match any case");
                break;
        }

        // --- loops

        // for
//        int i = scanner.nextInt();
        int i = 0;
//        int maxValue = scanner.nextInt();
        int maxValue = 0;

        for (; i <= maxValue; i++) {
//            System.out.println(i);
        }

        // foreach
        Set<String> stringList = new HashSet<>();
        stringList.add("string1");
        stringList.add("string2");
        stringList.add("string3");

        for (String string : stringList) {
            if (string.equals("string2")) {
                // stops the loop
                break;
            }
            if (string.equals("string1")) {
                // goes to next iteration
                continue;
            }
//            System.out.println(string);
        }

        // while
//        while (scanner.hasNext()) {
//            String input = scanner.next();
//            System.out.println(input);
//
//            if (input.equals("STOP")) {
//                break;
//            }
//        }

        boolean shouldContinue = true;
        int runs = 0;
        do {
            System.out.println("do-while");
            runs++;

            if (runs == 15) {
                shouldContinue = false;
            }
        } while (shouldContinue);
    }
}
