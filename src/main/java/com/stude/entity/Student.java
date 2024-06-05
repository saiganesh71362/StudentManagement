package com.stude.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "StudentInfo")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "StudentId")
    private Integer id;

    @NotNull(message = "Name Is Mandatory")
    @Size(min = 1, max = 20, message = "Name should not exceed 20 characters")
    @Column(name = "StudentName")
    private String name;

    @Email(message = "Email should be valid")
    @NotNull(message = "Email is mandatory")
    @Column(name = "StudentEmail", unique = true)
    private String email;

    @NotNull(message = "Contact Is Mandatory")
    @Column(name = "StudentContact", unique = true)
    private Long contact;

    @NotNull(message = "Address Is Mandatory")
    @Size(min = 1, max = 100, message = "Address Should Be Below 100 Characters")
    @Column(name = "StudentAddress")
    private String address;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "DepartmentId")
//    @JsonIgnore
    private Department department;
}
