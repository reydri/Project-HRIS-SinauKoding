package com.sinaukoding.absence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "division")
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
