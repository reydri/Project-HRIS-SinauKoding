package com.sinaukoding.absence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "bank")
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
