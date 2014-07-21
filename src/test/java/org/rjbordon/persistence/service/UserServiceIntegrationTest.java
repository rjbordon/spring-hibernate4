package org.rjbordon.persistence.service;

import org.junit.runner.RunWith;
import org.rjbordon.spring.PersistenceXmlConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.junit.Test;
import org.rjbordon.persistence.model.User;
import org.springframework.util.Assert;
import java.util.UUID;

/**
 * Created by rjbordon on 7/18/14.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceXmlConfig.class }, loader = AnnotationConfigContextLoader.class)
public class UserServiceIntegrationTest {

    @Autowired
    private UserService _userService;

    @Test
    public final void createUserTest_getByName() throws ServiceException {
        // prepare
        String name = UUID.randomUUID().toString();
        User user = new User();
        user.setName(name);
        user.setPassword("pass123");

        // execute
        _userService.createUser(user);
        User actual = _userService.getByName(name);

        // assert
        Assert.notNull(actual);
        Assert.isTrue(actual.getId() > 0);
    }

    @Test
    public final void validatePasswordTest() throws ServiceException {
        // prepare
        String name = UUID.randomUUID().toString();
        String pass = UUID.randomUUID().toString();
        User user = new User();
        user.setName(name);
        user.setPassword(pass);

        // execute
        _userService.createUser(user);
        boolean actual = _userService.validatePassword(name, pass);

        // assert
        Assert.isTrue(actual);
    }

    @Test
    public final void validatePasswordTest_notValidPassword() throws ServiceException {
        // prepare
        String name = UUID.randomUUID().toString();
        User user = new User();
        user.setName(name);
        user.setPassword(UUID.randomUUID().toString());

        // execute
        _userService.createUser(user);
        boolean actual = _userService.validatePassword(name, UUID.randomUUID().toString());

        // assert
        Assert.isTrue(!actual);
    }

    @Test
    public final void getByIdTest() throws ServiceException {
        // prepare
        String name = UUID.randomUUID().toString();
        String pass = UUID.randomUUID().toString();
        User user = new User();
        user.setName(name);
        user.setPassword(pass);

        // execute
        _userService.createUser(user);
        User actual = _userService.getByName(name);

        // assert
        Assert.notNull(actual);
        User actual1 = _userService.getById(actual.getId());
        Assert.notNull(actual1);
        Assert.isTrue(actual.getName().equals(actual1.getName()));
    }
}