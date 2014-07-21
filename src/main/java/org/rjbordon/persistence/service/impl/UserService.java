package org.rjbordon.persistence.service.impl;

import org.rjbordon.persistence.dao.UserDao;
import org.rjbordon.persistence.model.User;
import org.rjbordon.persistence.service.ServiceException;
import org.rjbordon.persistence.utils.PasswordHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * Created by rjbordon on 7/18/14.
 */
@Service
public class UserService implements org.rjbordon.persistence.service.UserService {

    @Autowired
    private UserDao _userDao;

    @Override
    public void createUser(User user) throws ServiceException {
        try {
            String hash = PasswordHash.createHash(user.getPassword());
            user.setPassword(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new ServiceException();
        } catch (InvalidKeySpecException e) {
            throw new ServiceException();
        }
        _userDao.saveOrUpdate(user);
    }

    @Override
    public User getById(int id) {
        return _userDao.getUserById(id);
    }

    @Override
    public User getByName(String name) {
        return _userDao.getUserByName(name);
    }

    @Override
    public boolean validatePassword(String name, String password) {
        boolean ret = false;
        User user = getByName(name);
        if (user != null){
            try {
                ret = PasswordHash.validatePassword(password, user.getPassword());
            } catch (NoSuchAlgorithmException e) {
                ret = false;
            } catch (InvalidKeySpecException e) {
                ret = false;
            }
        }
        
        return ret;
    }
}