package xyz.prohinig.input;

import xyz.prohinig.UserOperation;

public class ValidatedInput {
    private static final ValidatedInput INVALID_INPUT = new ValidatedInput(null, null, null, null, false);

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
        return INVALID_INPUT;
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

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        ValidatedInput that = (ValidatedInput) o;
//        return isValid == that.isValid && Objects.equals(username, that.username) && Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname) && userOperation == that.userOperation;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(username, firstname, lastname, userOperation, isValid);
//    }
}
