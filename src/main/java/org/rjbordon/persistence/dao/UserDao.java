package org.rjbordon.persistence.dao;

import org.rjbordon.persistence.model.User;

/**
 * Created by rjbordon on 7/18/14.
 */
public interface UserDao {
    public void saveOrUpdate(User user);
    public User getUserById(int id);
    public User getUserByName(String name);
}
