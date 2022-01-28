package xyz.prohinig;

public class Operators {
    public static void main(String[] args) {
        // arithmetic
        // +
        int sum = 12 + 12;
        System.out.println(sum);

        String concatenatedString = "someString:" + " " + sum;
        System.out.println(concatenatedString);
        // -
        int myInteger = 12 - 2;
        double myDouble = 12.45 - 2.25;
        System.out.println(myInteger);

        // *
        int multipliedResult = myInteger * sum;
        System.out.println(multipliedResult);

        // /
        int divisionResult = sum / sum;
        System.out.println(divisionResult);

        // % - rest ganzzahliger division
        int moduloResult = sum % myInteger;
        System.out.println(moduloResult);
        boolean myIntegerIsEven = (myInteger % 2) == 0;

        // ++
        // equivalent to ++
        moduloResult = moduloResult + 1;

        // ++ after increments after reading variable value
        System.out.println(moduloResult++);

        // ++ before increments before reading variable value
        System.out.println(++moduloResult);

        // --
        // equivalent to --
        moduloResult = moduloResult - 1;

        // ++ after increments after reading variable value
        System.out.println(moduloResult--);

        // ++ before increments before reading variable value
        System.out.println(--moduloResult);

        // bitwise
        // | bitwise or
        byte byteValue = 12 | 4;
        // & bitwise and
        byte bitwiseAnd = 12 & 4;
        // ^
        int bitwiseNot = 12 ^ 4;
        // >>
        byte shiftRight = 12 >> 4;
        // <<
        int shiftLeft = 12 << 4;

        // assigment
        // =
        int regularAssignment = 12;
        // +=
        regularAssignment += regularAssignment;
        System.out.println(regularAssignment);
        // short form for
        regularAssignment = regularAssignment + regularAssignment;
        System.out.println(regularAssignment);

        // -=
        int whatIsSubtracted = 12;
        regularAssignment -= whatIsSubtracted;
        System.out.println(regularAssignment);
        // short form for
        regularAssignment = regularAssignment - whatIsSubtracted;
        System.out.println(regularAssignment);

        // *=
        // /=
        // %=
        // &=
        // |=
        // ^=
        // >>=
        // <<=

        // comparison
        // == compares for equality
        int firstValue = 12;
        int secondValue = 13;
        boolean areValuesEqual = firstValue == secondValue;
        System.out.println(areValuesEqual);
        secondValue--;
        areValuesEqual = firstValue == secondValue;
        System.out.println(areValuesEqual);

        // != compares if values are not equal
        boolean areValuesNotEqual = firstValue != secondValue;
        System.out.println(areValuesNotEqual);

        secondValue *= 12;
        areValuesNotEqual = firstValue != secondValue;
        System.out.println(areValuesNotEqual);

        // > compares if left value is larger than right value
        boolean isSecondValueLargerThanFirstValue = secondValue > firstValue;
        System.out.println(isSecondValueLargerThanFirstValue);

        boolean isFirstValueLargerThanSecondValue = firstValue > secondValue;
        System.out.println(isFirstValueLargerThanSecondValue);

        boolean testForEqualValuesGreater = 12 > 12;
        System.out.println("equal values: " + testForEqualValuesGreater);

        // < compares if left value is less than right value
        boolean isSecondValueLessThanFirstValue = secondValue < firstValue;
        System.out.println(isSecondValueLessThanFirstValue);

        boolean isFirstValueLessThanSecondValue = firstValue < secondValue;
        System.out.println(isFirstValueLessThanSecondValue);

        boolean testForEqualValues = 12 < 12;
        System.out.println("equal values: " + testForEqualValues);

        // >= compares if left value is greater than or equal to right value
        boolean isGreaterThanOrEqualWithEqualValues = 12 >= 12;
        boolean isGreaterThanOrEqualWithGreaterValue = 15 >= 12;
        boolean isGreaterThanOrEqualWithSmallerValue = 12 >= 15;

        System.out.println("equal values: " + isGreaterThanOrEqualWithEqualValues
                + " greater value: " + isGreaterThanOrEqualWithGreaterValue
                + " smaller value: " + isGreaterThanOrEqualWithSmallerValue);

        // <= compares if left value is less than or equal to right value
        boolean isLessThanOrEqualWithEqualValues = 12 <= 12;
        boolean isLessThanOrEqualWithSmallerValue = 12 <= 15;
        boolean isLessThanOrEqualWithGreaterValues = 15 <= 12;

        System.out.println("equal values: " + isLessThanOrEqualWithEqualValues
                + " smaller value: " + isLessThanOrEqualWithSmallerValue
                +  " greater value: " + isLessThanOrEqualWithGreaterValues);

        // logical
        // && logical and, checks if both supplied booleans are true.
        // true && true => true
        System.out.println("both values are true: " + (isLessThanOrEqualWithEqualValues && isLessThanOrEqualWithSmallerValue));
        // false && false => false
        System.out.println("both values are false: " + (isLessThanOrEqualWithGreaterValues && isGreaterThanOrEqualWithSmallerValue));
        // true && false => false
        System.out.println("left is true, right is false: " + (isLessThanOrEqualWithSmallerValue && isLessThanOrEqualWithGreaterValues));
        // false && true => false
        System.out.println("left is false, right is true: " + (isLessThanOrEqualWithGreaterValues && isLessThanOrEqualWithSmallerValue));

        // || logical or, checks if at least one of the supplied booleans is true.
        // true || true => true
        System.out.println("both values are true: " + (isLessThanOrEqualWithEqualValues && isLessThanOrEqualWithSmallerValue));
        // false || false => false
        System.out.println("both values are false: " + (isLessThanOrEqualWithGreaterValues && isGreaterThanOrEqualWithSmallerValue));
        // true || false => true
        System.out.println("left is true, right is false: " + (isLessThanOrEqualWithSmallerValue && isLessThanOrEqualWithGreaterValues));
        // false || true => true
        System.out.println("left is false, right is true: " + (isLessThanOrEqualWithGreaterValues && isLessThanOrEqualWithSmallerValue));

        // ! logical not, inverts the supplied boolean
        boolean trueBoolean = true;
        boolean notTrue = !true;
        boolean alsoNotTrue = !trueBoolean;

        System.out.println("before inverting: " + trueBoolean + ", not true: " + notTrue + ", inverted true boolean: " + alsoNotTrue);

        boolean complexBoolean = !(!(trueBoolean && notTrue) || false);
        System.out.println(complexBoolean);
    }
}
