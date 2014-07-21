package org.rjbordon.persistence.dao.impl;

import org.rjbordon.persistence.dao.AbstractHibernateDao;
import org.rjbordon.persistence.dao.UserDao;
import org.rjbordon.persistence.model.User;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

/**
 * Created by rjbordon on 7/18/14.
 */
@Repository
@Transactional
public class UserHibernateDao extends AbstractHibernateDao implements UserDao {

    @Override
    public void saveOrUpdate(User user) {
        this.getCurrentSession().saveOrUpdate(user);
    }

    @Override
    public User getUserById(int id) {
        return (User)this.getCurrentSession().get(User.class, id);
    }

    @Override
    public User getUserByName(String name) {
        return (User)this.getCurrentSession().getNamedQuery("User_getByName").setString("aName", name).uniqueResult();
    }
}