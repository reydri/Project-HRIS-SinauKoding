package com.sinaukoding.absence.dao;

import com.sinaukoding.absence.entity.Attendance;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class AttendanceDAO extends BaseDAO<Attendance> {
    @Override
    public List<Predicate> predicates(Attendance param, CriteriaBuilder builder, Root<Attendance> root, boolean isCount){
        List<Predicate> predicates = super.predicates(param, builder, root,isCount);

        if(!isCount){
            root.fetch("employee", JoinType.INNER);
        }

        return predicates;
    }
}
