package xyz.prohinig;

import java.util.Scanner;

public class InputOutput {
    public static void main(String[] args) {
        // output
        System.out.println("Hello, World!");
        System.out.println(12);
        System.out.println(true);

        // format - include placeholders and replace. %s another string
        System.out.printf("Hello, %s !!!!", "World");

        // new line character
        System.out.print("\n");

        String formattedString = String.format("Hello, %s !!!", "World");
        System.out.println(formattedString);

        // input
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String anotherInput = scanner.next();
        int intInput = scanner.nextInt();
        double doubleInput = scanner.nextDouble();

        System.out.println("someString " + anotherInput + " " + intInput * 3 + " " + (doubleInput + 10));
    }
}
