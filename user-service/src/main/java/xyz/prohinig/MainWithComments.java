package xyz.prohinig;

import xyz.prohinig.users.User;
import xyz.prohinig.users.UserManagerWithStreamsAndList;

public class MainWithComments {

    public static void main(String[] args) {
        // write your code here
        User user = new User("username", "firstname", "lastname");
        User secondUser = new User("secondusername", "firstname", "lastname");
        Admin admin = new Admin("adminuser", "firstname", "lastname");

        UserManagerWithStreamsAndList userManager = new UserManagerWithStreamsAndList();
        userManager.addUser(admin);

        userManager.addUser(user);
        // we can add Admin as it just extends User
        userManager.addUser(secondUser);

//        userManager.removeUser(secondUser);
//        UserManager userManagerWithList = new UserManager(new ArrayList<>());

        // we can only use collection interface as the method defines it as such
//        Collection<User> users = userManager.getUsers();

        System.out.println(userManager.getUserByUsername("secondusername"));
//        System.out.println(userManager.getUserByUsernameFast("secondusername"));

        // same string always equal hashcode
//        System.out.println("string1".hashCode() + ", " + "string1".hashCode());
//        System.out.println(areUsersEqual(user, secondUser));

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
