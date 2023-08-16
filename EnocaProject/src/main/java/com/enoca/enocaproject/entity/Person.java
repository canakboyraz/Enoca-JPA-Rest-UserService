package com.enoca.enocaproject.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personId;

    @NotEmpty
    @NotNull
    private String name;
    @NotEmpty
    @NotNull
    private String surname;

    private String department;

    @ManyToMany
    List<Company> personCompany;
}
