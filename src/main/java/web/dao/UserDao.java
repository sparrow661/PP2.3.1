package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);

    void updateUser(int id, String name, String surName, String email);

    void removeUser(int id);

    User getUserById(int id);

    List<User> listUsers();
}
