package com.sinaukoding.absence.service;

import com.sinaukoding.absence.entity.User;
import com.sinaukoding.absence.dao.BaseDAO;
import com.sinaukoding.absence.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService extends BaseService<User> {

    @Autowired
    private UserDAO dao;

    @Override
    protected BaseDAO<User> getDAO() {
        return dao;
    }
}
