package com.example.demo.model.dto;
import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;

public class RegistrationDTO {
    private Integer department_id;
    private String firstname;
    private String middlename;
    private String lastname;
    private Integer gender;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dob;
    private String phone;
    private String address;
    private String email;
    private String password;


    public RegistrationDTO() {
    }


    public Integer getDepartment_id() {
        return department_id;
    }


    public void setDepartment_id(Integer department_id) {
        this.department_id = department_id;
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


    public Integer getGender() {
        return gender;
    }


    public void setGender(Integer gender) {
        this.gender = gender;
    }


    public LocalDate getDob() {
        return dob;
    }


    public void setDob(LocalDate dob) {
        this.dob = dob;
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


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


}
