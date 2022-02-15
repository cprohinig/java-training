package xyz.prohinig.users;

import java.util.*;
import java.util.stream.Collectors;

public class UserManagerWithStreamsAndList implements UserManager {

    private final Collection<User> users = new ArrayList<>();

    public UserManagerWithStreamsAndList() {
    }

    @Override
    public User getUserByUsername(String username) {
        return users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Collection<User> getUsersByFirstname(String firstname) {
        return users.stream()
                .filter(user -> user.getFirstname().equals(firstname))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<User> getUsersByName(String firstname, String lastname) {
        return users.stream()
                .filter(user -> user.getFirstname().equals(firstname))
                .filter(user -> user.getLastname().equals(lastname))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<String> getAllUsedUsernames() {
        return users.stream()
                .map(User::getUsername)
                .collect(Collectors.toSet());
    }

    @Override
    public Collection<User> getUsers() {
        return users;
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void removeUser(User user) {
        users.remove(user);
    }
}
