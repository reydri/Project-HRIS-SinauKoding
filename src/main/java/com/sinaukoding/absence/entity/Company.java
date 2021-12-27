package com.sinaukoding.absence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "company")
@SQLDelete(sql = "UPDATE company SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@Setter
@Getter
@NoArgsConstructor
public class Company extends BaseEntity<Company> {

    private static final long serialVersionUID = 8259783968288047896L;

    @Column(name = "address", columnDefinition = "VARCHAR(100)")
    private String address;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "name", columnDefinition = "VARCHAR(100)")
    private String name;

    @Column(name = "phone", columnDefinition = "VARCHAR(30)")
    private String phone;
}
