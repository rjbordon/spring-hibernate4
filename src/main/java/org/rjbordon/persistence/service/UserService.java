package org.rjbordon.persistence.service;

import org.rjbordon.persistence.model.User;

/**
 * Created by rjbordon on 7/18/14.
 */
public interface UserService {
    void createUser(User user) throws ServiceException;
    User getById(int id);
    User getByName(String name);
    boolean validatePassword(String name, String password);
}
