package com.sinaukoding.absence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "bank")
@SQLDelete(sql = "UPDATE bank SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@Setter
@Getter
@NoArgsConstructor
public class Bank extends BaseEntity<Bank> {

    private static final long serialVersionUID = 2683760267230820300L;

    @Column(name = "code", columnDefinition = "VARCHAR(10)")
    private String code;

    @Column(name = "name", columnDefinition = "VARCHAR(40)")
    private String name;

}
