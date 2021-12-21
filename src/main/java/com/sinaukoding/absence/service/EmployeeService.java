package com.sinaukoding.absence.service;

import com.sinaukoding.absence.entity.Employee;
import com.sinaukoding.absence.dao.BaseDAO;
import com.sinaukoding.absence.dao.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeService extends BaseService<Employee> {

    @Autowired
    private EmployeeDAO dao;

    @Override
    protected BaseDAO<Employee> getDAO() {
        return dao;
    }
}
