package org.geektimes.projects.user.service;

import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.repository.DatabaseUserRepository;
import org.geektimes.projects.user.repository.UserRepository;
import org.geektimes.projects.user.sql.DBConnectionManager;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author molly
 * @date 2021/3/3 11:02 下午
 */
public class DatabaseUserService implements UserService{

    private UserRepository userRepository;

    public DatabaseUserService() {
        DBConnectionManager dbConnectionManager = new DBConnectionManager();
        this.userRepository = new DatabaseUserRepository(dbConnectionManager);
    }

    @Override
    public boolean register(User user) {
        return userRepository.save(user);
    }

    @Override
    public boolean deregister(User user) {
        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public User queryUserById(Long id) {
        return null;
    }

    @Override
    public User queryUserByNameAndPassword(String name, String password) {
        return userRepository.getByNameAndPassword(name,password);
    }
}
