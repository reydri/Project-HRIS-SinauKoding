package com.sinaukoding.absence.service;

import com.sinaukoding.absence.entity.Division;
import com.sinaukoding.absence.dao.BaseDAO;
import com.sinaukoding.absence.dao.DivisionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DivisionService extends BaseService<Division> {

    @Autowired
    private DivisionDAO dao;

    @Override
    protected BaseDAO<Division> getDAO() {
        return dao;
    }
}
