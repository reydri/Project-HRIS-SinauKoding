package com.sinaukoding.absence.service;

import com.sinaukoding.absence.entity.Bank;
import com.sinaukoding.absence.dao.BaseDAO;
import com.sinaukoding.absence.dao.BankDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankService extends BaseService<Bank> {

    @Autowired
    private BankDAO dao;

    @Override
    protected BaseDAO<Bank> getDAO() {
        return dao;
    }

    public Bank findByName(Bank param) {
        return dao.findByName(param);
    }
}
