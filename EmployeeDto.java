package com.jbm.spring_boot_crud_mysql.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Schema(description = "Employee data transfer Object 1 used this class to validate JSON data coming from client")
public class EmployeeDto {

    // ⚠ If ID is auto-generated in DB,
    // do NOT make it mandatory during create
    @Positive(message = "Id should be positive")
    private Integer id;

    @NotBlank(message = "Name should not be blank")
    @Size(min = 2, max = 20, message = "Name should be between 2 and 20 characters")
    private String name;
    
    
    @Schema(description = "Eamil Should be valid",example ="john@gmail.com")
    @Email(message = "Email format is invalid")
    @NotBlank(message = "Email should not be blank")
    private String email;

    @NotBlank(message = "Department should not be blank")
    private String department;

    public EmployeeDto() {
    }

    // Getters & Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "EmployeeDto [id=" + id +
                ", name=" + name +
                ", email=" + email +
                ", department=" + department + "]";
    }
}
