package xyz.prohinig;

public enum UserOperation {
    ADD("ADD"),
    REMOVE("REMOVE");

    private final String input;

    UserOperation(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }

    public static UserOperation fromInput(String input) {
        // early return
        if (input == null) {
            return null;
        }

        for (UserOperation userOperation : UserOperation.values()) {
            // toUppercase transforms a string to all uppercase characters. e.g. reMoVe -> REMOVE
            if (userOperation.getInput().equals(input.toUpperCase())) {
                return userOperation;
            }
        }

        return null;
    }

    public static UserOperation fromInputWithoutEarlyReturn(String input) {
        if (input != null) {
            for (UserOperation userOperation : UserOperation.values()) {
                if (userOperation.getInput().equals(input)) {
                    return userOperation;
                }
            }

            return null;
        }

        return null;
    }
}
