package xyz.prohinig.input;

import xyz.prohinig.UserOperation;

public class ValidatedInput {
    private final String username;
    private final String firstname;
    private final String lastname;
    private final UserOperation userOperation;
    private final boolean isValid;

    private ValidatedInput(String username, String firstname, String lastname, UserOperation userOperation, boolean isValid) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.userOperation = userOperation;
        this.isValid = isValid;
    }

    static ValidatedInput invalid() {
        return new ValidatedInput(null, null, null, null, false);
    }

    static ValidatedInput valid(String username, String firstname, String lastname, UserOperation userOperation) {
        return new ValidatedInput(username, firstname, lastname, userOperation, true);
    }

    public String getUsername() {
        return username;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public UserOperation getUserOperation() {
        return userOperation;
    }

    public boolean isValid() {
        return isValid;
    }
}
