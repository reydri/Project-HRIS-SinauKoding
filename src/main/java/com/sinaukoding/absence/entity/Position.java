package com.sinaukoding.absence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "position")
@SQLDelete(sql = "UPDATE position SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@Setter
@Getter
@NoArgsConstructor
public class Position extends BaseEntity<Position> {

    private static final long serialVersionUID = 2643306262391939319L;

    @Column(name = "name")
    private String name;

    @Column(name = "note", columnDefinition = "TEXT")
    private String note;
}
