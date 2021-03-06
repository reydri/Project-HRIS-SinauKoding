package com.sinaukoding.absence.service;

import com.sinaukoding.absence.AbsenceApplication;
import com.sinaukoding.absence.entity.Employee;
import com.sinaukoding.absence.dao.BaseDAO;
import com.sinaukoding.absence.dao.EmployeeDAO;
import com.sinaukoding.absence.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


@Service
public class EmployeeService extends BaseService<Employee> {

    @Autowired
    private EmployeeDAO dao;

    @Override
    protected BaseDAO<Employee> getDAO() {
        return dao;
    }

    @Transactional
    public Employee save(Employee entity){
        entity.setStartDate(new Date());
        entity.setUser(AbsenceApplication.getCurrentUser());

        return dao.save(entity);
    }

    @Transactional
    public Employee update(Employee entity) {
        if (entity.getId() != null) {
            Employee reference = getDAO().findReference(entity.getId());

            reference.setNip(entity.getNip() != null
                    ? entity.getNip()
                    : reference.getNip());

            entity.setNip(reference.getNip());

            return entity;
        }

        return null;
    }

    @Transactional
    public void inactiveStatus(Employee entity) {
        if (entity.getId() != null) {
            Employee reference = getDAO().findReference(entity.getId());

            reference.setEndDate(entity.getEndDate() != null
                    ? entity.getEndDate()
                    : new Date());

            reference.setStatus(reference.getStatus().equals(Employee.StatusEmployee.ACTIVE)
                    ? Employee.StatusEmployee.INACTIVE
                    : reference.getStatus());
        }
    }

    public Employee findByUserId(User param) {
        return dao.findByUserId(param);
    }
}