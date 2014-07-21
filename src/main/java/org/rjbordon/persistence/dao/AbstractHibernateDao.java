package org.rjbordon.persistence.dao;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by rjbordon on 7/18/14.
 */
public abstract class AbstractHibernateDao {

    @Autowired
    private SessionFactory _sessionFactory;

    protected Session getCurrentSession(){
        return _sessionFactory.getCurrentSession();
    }
}
