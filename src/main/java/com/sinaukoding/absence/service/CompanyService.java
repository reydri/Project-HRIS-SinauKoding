package com.sinaukoding.absence.service;

import com.sinaukoding.absence.entity.Company;
import com.sinaukoding.absence.dao.BaseDAO;
import com.sinaukoding.absence.dao.CompanyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService extends BaseService<Company> {

    @Autowired
    private CompanyDAO dao;

    @Override
    protected BaseDAO<Company> getDAO() {
        return dao;
    }

    public Company findByName(Company param) {
        return dao.findByName(param);
    }
}
