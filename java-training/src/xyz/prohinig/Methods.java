package xyz.prohinig;

public class Methods {

    private int someCount = 0;

    public static void main(String[] args) {
//        Methods methods = new Methods();
//        methods.someMethod();

//        int someInteger = getSomeInteger();

        String joinedString = joinStringsTogether("first", "second", "third", "fourth");

        if (joinedString != null) {
            if (joinedString.equals("someString")) {
                System.out.println(joinedString);
            }
        }

        if ("someString".equals(joinedString)) {
            System.out.println(joinedString);
        }
    }

    protected static String joinStringsTogether(String firstPart, String secondPart, String thirdPart, String fourthPart) {
        return null;
    }

    private static int getSomeInteger() {
        return 12;
    }

    static String getAnotherString() {
        return "somethingElse";
    }

    public void someMethod() {
        someCount++;
    }
}
