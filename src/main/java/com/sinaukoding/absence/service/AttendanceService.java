package com.sinaukoding.absence.service;

import com.sinaukoding.absence.entity.Attendance;
import com.sinaukoding.absence.dao.BaseDAO;
import com.sinaukoding.absence.dao.AttendanceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;


@Service
public class AttendanceService extends BaseService<Attendance> {

    @Autowired
    private AttendanceDAO dao;

    @Override
    protected BaseDAO<Attendance> getDAO() {
        return dao;
    }

    @Transactional
    public Attendance save(Attendance entity){
        entity.setDate(new Date());
        entity.setStartTime(new Date());

        return dao.save(entity);
    }

    @Transactional
    public Attendance update(Attendance entity){
        if (entity.getId() != null){
            Attendance reference = getDAO().findReference(entity.getId());

            reference.setEndTime(entity.getEndTime() != null
                    ? entity.getEndTime()
                    : new Date());

            entity.setDate(reference.getDate());
            entity.setStartTime(reference.getStartTime());
            entity.setEndTime(reference.getEndTime());

            return entity;
        }

        return null;
    }

    @Transactional
    public Collection<Attendance> findByDate(Attendance entity, Date startDate, Date endDate){
        Collection<Attendance> result = dao.findByDate(entity, startDate, endDate);
        return result.size() > 0 ? result : new ArrayList<>();
    }
}