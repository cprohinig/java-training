package xyz.prohinig.users;

import java.util.Collection;

// interface is used to define an "interface" that consumers interact with
public interface UserManager {

    User getUserByUsername(String username);

    Collection<User> getUsersByFirstname(String firstname);

    Collection<User> getUsersByName(String firstname, String lastname);

    Collection<String> getAllUsedUsernames();

    Collection<User> getUsers();

    void addUser(User user);

    void removeUser(User user);
}
