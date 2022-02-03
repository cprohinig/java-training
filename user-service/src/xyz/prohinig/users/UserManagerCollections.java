package xyz.prohinig.users;

import java.util.*;

public class UserManagerCollections {

    // collection is the most general class for collections
    //    private Collection<User> users = new ArrayList<>();
    // List is more specific than Collection
//    private List<User> users = new ArrayList<>();

    // important difference to array -> we don't have to specify size
    // internally the arraylist uses an array
    // important characteristic of List: it is ordered
//    private ArrayList<User> users = new ArrayList<>();

    // there are different implementations of List
    // finding, removing in lists is slow
//    private List<User> users = new LinkedList<>();
    private Collection<User> users = new LinkedList<>();
    // (!) List/Collections do consume more memory = space than arrays

    // Sets are different to Lists
    // they do not ensure any order of elements
    // sets cannot contain the same element twice
    // hashcode + equals are important to determine if elements are equal
    // finding by a specific property is slow
    // removing from Set is very fast
//    private Collection<User> users = new HashSet<>();

    // Maps allow fast access by a given property
    // Map<Key, Value> needs 2 types
    // finding/removing by key is very fast
    private Map<String, User> usersByUsernameMap = new HashMap<>();
    private Map<User, User> userByHimselfMap = new HashMap<>();

    public UserManagerCollections() {
    }

    // signature is equal (name + parameters), which is why this is not possible
//    public UserManager() {
//        this.users = null;
//    }

    // overload constructor
    public UserManagerCollections(List<User> users) {
        this.users = users;
    }

    public User getUserByUsername(String username) {
        for (User user : users) {
            System.out.println("Checking if this is the correct user");
            if (user.getUsername().equals(username)) {
                return user;
            }
        }

        return null;
    }

    public User getUserByUsernameFast(String username) {
        return usersByUsernameMap.get(username);
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
        usersByUsernameMap.put(user.getUsername(), user);
        userByHimselfMap.put(user, user);
    }

    public void removeUser(User user) {
        users.remove(user);
        usersByUsernameMap.remove(user.getUsername());
        userByHimselfMap.remove(user);

    }
}
