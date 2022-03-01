package xyz.prohinig.users;

import java.util.Collection;
import java.util.HashSet;

public class UserManagerWithForEachAndSet implements UserManager {

    private final Collection<User> userCollection = new HashSet<>();

    @Override
    public User getUserByUsername(String username) {
        for (User user : userCollection) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }

        return null;
    }

    @Override
    public Collection<User> getUsersByFirstname(String firstname) {
        Collection<User> usersByFirstnameResult = new HashSet<>();

        for (User user : userCollection) {
            if (user.getFirstname().equals(firstname)) {
                usersByFirstnameResult.add(user);
            }
        }

        return usersByFirstnameResult;
    }

    @Override
    public Collection<User> getUsersByName(String firstname, String lastname) {
        Collection<User> usersByFirstnameResult = new HashSet<>();

        for (User user : userCollection) {
            if (user.getFirstname().equals(firstname) &&
                    user.getLastname().equals(lastname)) {
                usersByFirstnameResult.add(user);
            }
        }

        return usersByFirstnameResult;
    }

    @Override
    public boolean isUsernameInUse(String username) {
        for (User user : userCollection) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Collection<User> getUsers() {
        return userCollection;
    }

    @Override
    public void addUser(User user) {
        userCollection.add(user);
    }

    @Override
    public void removeUser(User user) {
        userCollection.remove(user);
    }
}
