package com.sinaukoding.absence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "division")
@SQLDelete(sql = "UPDATE division SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@Setter
@Getter
@NoArgsConstructor
public class Division extends BaseEntity<Division> {

    private static final long serialVersionUID = -981111697155833591L;

    @Column(name = "name")
    private String name;

    @Column(name = "note", columnDefinition = "TEXT")
    private String note;
}
