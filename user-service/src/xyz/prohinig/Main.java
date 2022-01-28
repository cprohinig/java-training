package xyz.prohinig;

import xyz.prohinig.users.User;
import xyz.prohinig.users.UserManager;

public class Main {

    public static void main(String[] args) {
        // write your code here
        User user = new User("username", "firstname", "lastname");
        User secondUser = new User("username", "firstname", "lastname");

        UserManager userManager = new UserManager();

        // same string always equal hashcode
//        System.out.println("string1".hashCode() + ", " + "string1".hashCode());
        System.out.println(areUsersEqual(user, secondUser));

//        printUser(user);
    }

    private static boolean areUsersEqual(User firstUser, User secondUser) {
        if (firstUser == null && secondUser == null) {
            return true;
        }
        if (firstUser == null) {
            return false;
        }

        return firstUser.equals(secondUser);
    }

    private static void printUser(User user) {
        System.out.println(user.toString());
    }
}
