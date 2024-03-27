package Dao;

import Model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static List<User> userList;

    public UserDao() {
        userList = new ArrayList<>();
    }

    private static class Holder {
        private static UserDao instance = new UserDao();
    }

    public static UserDao getInstance() {
        return Holder.instance;
    }

    public void addUser(User user) {
        userList.add(user);
    }
    public List<User> getUserList() {
        return userList;
    }
}
