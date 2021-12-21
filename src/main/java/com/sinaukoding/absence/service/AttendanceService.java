package com.sinaukoding.absence.service;

import com.sinaukoding.absence.entity.Attendance;
import com.sinaukoding.absence.dao.BaseDAO;
import com.sinaukoding.absence.dao.AttendanceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AttendanceService extends BaseService<Attendance> {

    @Autowired
    private AttendanceDAO dao;

    @Override
    protected BaseDAO<Attendance> getDAO() {
        return dao;
    }
}
