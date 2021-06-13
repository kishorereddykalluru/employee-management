package io.villageminds.employeemanagement.domain;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "address")
    private String address;

    public Employee(){}

    public Employee(String firstName, String lastName, String email, String address){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
    }
}
