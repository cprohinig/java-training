package xyz.prohinig.users;

import java.util.Objects;

public class User {

    private String username;

    // protected, subclasses in any package can access
    protected String firstname;
    // no modifier == package private, subclasses in same package can access
    String lastname;

    public User(String username, String firstname, String lastname) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public void setUsername(String username) {
        this.username = username;
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

    @Override
    public boolean equals(Object o) {
        // if objects are the same instance they are always equal
        if (this == o) {
            return true;
        }
        // if the other object is null they are not equal, as 'this' is not null
        // if the classes of the objects don't match they are not equal
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        // we have to cast so concrete class fields are available
        // String firstname = o.firstname;
        // cast other object to User
        User user = (User) o;

        // username was specified as non null, so equals can be used
        return username.equals(user.username) &&
                // Objects.equals can handle null values
                Objects.equals(firstname, user.firstname) &&
                Objects.equals(lastname, user.lastname);
    }


    // hashCode can be used to create an integer that will always be the same if fields are the same
    // important for hashset, hashmap
    @Override
    public int hashCode() {
        return Objects.hash(username, firstname, lastname);
    }

    @Override
    public String toString() {
        return "User[" +
                "username='" + username + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ']';
    }
}
