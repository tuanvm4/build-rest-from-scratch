package com.example.tuanvm4rest.Entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.sql.Date;
import java.util.Objects;

@Entity
@Data
@Table(name = "customer_name", schema = "tuanvm_application", catalog = "develop")
public class CustomerNameEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    @Basic
    @Column(name = "status")
    private String status;
    @Basic
    @Column(name = "gender")
    private String gender;
    @Basic
    @Column(name = "value")
    private Long value;
}
