package com.sinaukoding.absence.service;

import com.sinaukoding.absence.entity.Position;
import com.sinaukoding.absence.dao.BaseDAO;
import com.sinaukoding.absence.dao.PositionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PositionService extends BaseService<Position> {

    @Autowired
    private PositionDAO dao;

    @Override
    protected BaseDAO<Position> getDAO() {
        return dao;
    }
}
