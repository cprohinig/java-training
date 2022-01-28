package xyz.prohinig;

import xyz.prohinig.users.User;

public class Admin extends User {
    // Admin will always be admin
    private final boolean isAdmin = true;

    public Admin(String username, String firstname, String lastname) {
        // calls parent construcotr -> constructor of User
        super(username, firstname, lastname);
    }

    public void modifyName() {
        // lastname is package private and admin is not in same package
//        lastname = lastname + " ";
        // firstname is protected and can be accessed from any subclass
        firstname = firstname + " ";

    }
}
