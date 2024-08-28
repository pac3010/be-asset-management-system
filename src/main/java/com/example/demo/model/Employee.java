package com.example.demo.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_m_employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "manager_id", referencedColumnName = "id")
    @Nullable
    private Employee manager;

    @Column
    private String firstname;

    @Column
    @Nullable
    private String middlename;

    @Column
    private String lastname;

    @Column
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate dob;

    @Column
    private Integer gender;

    @Column
    private String email;

    @Column
    private String phone;

    @Column
    private String address;

    @OneToOne(mappedBy = "employee")
    @JsonIgnore
    private User user;

    public Employee() {
    }

    public Employee(Integer id, Department department, Role role, Employee manager, String firstname, String middlename,
            String lastname, LocalDate dob, Integer gender, String email, String phone, String address) {
        this.id = id;
        this.department = department;
        this.role = role;
        this.manager = manager;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.dob = dob;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User getUsers() {
        return user;
    }

    public void setUsers(User user) {
        this.user = user;
    }

    

}
