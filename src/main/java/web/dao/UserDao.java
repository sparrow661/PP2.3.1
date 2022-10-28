package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.List;

public interface UserDao {
    public List<User> getAllUsers();
    public User getUserById(int id);
    public void saveUser(User user);
    public void updateUser(User user);
    public void deleteUser(int id);
}

