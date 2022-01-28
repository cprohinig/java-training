package xyz.prohinig;

public class VariableExercise {

    public static void main(String[] args) {
        // primitive types

        // 1 byte -> 8 bit -> 2^8 = 256 => -2^7 - (2^7 - 1)
        byte myByte = 127;
        byte myNegativeByte = -128;
        // 2 byte
        short myShort = 32767;
        // 4 byte
        int myInt = 32;
        // 8 byte
        long myLong = 9_223_372_036_854_775_807L;
        long myLongWithoutSeparators = 9223372036854775807L;

        // 4 byte - 6-7 decimal digits
        float myFloat = 5.99f;
        // 8 byte - up to 15 decimal digits
        double myDouble = 5.99;

        // 2 bytes
        char myLetter = 'D';
        char myLetterAscii = 65, anotherAsciiLetter = 66;

        // true | false
        // 1 bit
        // 0 | 1
        boolean myBoolean = true;

        // non-primitive types
        // text
        String myText = "Hello!";
        String nullText = null;
        // string as char[]
        char[] greetingCharArray = new char[]{'H', 'e', 'l', 'l', 'o', '!'};
        String greetingString = String.copyValueOf(greetingCharArray);
        char[] greetingStringCopy = greetingString.toCharArray();

        Byte myByteObject = myByte;
        int myByteAsInt = myByteObject.intValue();
        myByteObject = null;

        Integer integerObject = 12;
        Character myCharacterObject = myLetter;
        Boolean myBooleanObject = Boolean.TRUE;

        // general on variables
        // declare without assignment
        int i;
        int j, k;

        // direct assignment
        int directlyAssigned = 99;

        // assign variable
        i = 13;
        j = 14;
        k = 15;

        final int variableThatCannotBeModified = 13;
        final int variableThatWillBeAssignedLater;

        variableThatWillBeAssignedLater = 15;

        System.out.println(greetingString);
        System.out.println(myText);
    }
}
