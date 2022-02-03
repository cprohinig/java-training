package xyz.prohinig.users;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserManager {

    private final Collection<User> users = new ArrayList<>();

    public UserManager() {
    }

    public User getUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }

        return null;
    }

    public User getUserByUsernameUsingStreams(String username) {
        return users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }

    public Collection<User> getUsersByFirstname(String firstname) {
        Collection<User> usersResult = new ArrayList<>();

        for (User user: users) {
            if (user.getFirstname().equals(firstname)) {
                usersResult.add(user);
            }
        }

        return usersResult;
    }

    public Collection<User> getUsersByFirstnameUsingStreams(String firstname) {
        return users.stream()
                .filter(user -> user.getFirstname().equals(firstname))
                .collect(Collectors.toList());
    }

    public Collection<User> findUsersByName(String firstname, String lastname) {
        return users.stream()
//                .filter(user -> user.getFirstname().equals(firstname) && user.getLastname().equals(lastname))
                .filter(user -> user.getFirstname().equals(firstname))
                .filter(user -> user.getLastname().equals(lastname))
                .collect(Collectors.toList());
    }

    public Collection<String> getAllUsedUsernames() {
//        return getAllUsedUsernamesUsingForeach();
        return getAllUsedUsernamesUsingStreams();
    }

    private Collection<String> getAllUsedUsernamesUsingForeach() {
        Collection<String> allUsedUsernames = new HashSet<>();

        for (User user: users) {
            allUsedUsernames.add(user.getUsername());
        }

        return allUsedUsernames;
    }

    private Collection<String> getAllUsedUsernamesUsingStreams() {
        return users.stream()
//                .map(user -> user.getUsername())
                .map(User::getUsername)
                .collect(Collectors.toSet());
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }
}
