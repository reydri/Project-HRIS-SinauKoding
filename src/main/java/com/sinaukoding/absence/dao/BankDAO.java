package com.sinaukoding.absence.dao;

import com.sinaukoding.absence.entity.Bank;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class BankDAO extends BaseDAO<Bank> {
    @Override
    public List<Predicate> predicates(Bank param, CriteriaBuilder builder, Root<Bank> root, boolean isCount){
        List<Predicate> predicates = super.predicates(param, builder, root,isCount);

        if (param != null){
            if (param.getName() != null){
                predicates.add(builder.like(root.get("name"), "%" + param.getName() + "%"));
            }
        }

        return predicates;
    }
}
