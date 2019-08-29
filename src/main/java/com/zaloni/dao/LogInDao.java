package com.zaloni.dao;

import com.zaloni.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LogInDao implements ILoginDao {

    @Autowired
    private SessionFactory sessionFactory;

    public User getUserDetails(int userId){

        return (User) sessionFactory.getCurrentSession().get(User.class,userId);
    }
}
