package com.sinaukoding.absence.dao;

import com.sinaukoding.absence.entity.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class EmployeeDAO extends BaseDAO<Employee> {
    @Override
    public List<Predicate> predicates(Employee param, CriteriaBuilder builder, Root<Employee> root, boolean isCount){
        List<Predicate> predicates = super.predicates(param, builder, root,isCount);

        if (param != null){
            if (param.getStatus() != null){
                predicates.add(builder.like(root.get("status"), "%" + param.getStatus() + "%"));
            }
        }

        if (param != null){
            if (param.getNip() != null){
                predicates.add(builder.like(root.get("nip"), "%" + param.getNip() + "%"));
            }
        }

        if (!isCount){
            root.fetch("user", JoinType.INNER).fetch("bank", JoinType.INNER);
            root.fetch("user", JoinType.INNER).fetch("company", JoinType.INNER);
            root.fetch("user", JoinType.INNER).fetch("division", JoinType.INNER);
            root.fetch("user", JoinType.INNER).fetch("position", JoinType.INNER);
        }

        return predicates;
    }
}
