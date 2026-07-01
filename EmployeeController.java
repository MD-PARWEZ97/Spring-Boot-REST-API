package com.jbm.spring_boot_crud_mysql.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jbm.spring_boot_crud_mysql.dao.EmployeeDao;
import com.jbm.spring_boot_crud_mysql.entity.Employee;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.jbm.spring_boot_crud_mysql.dto.EmployeeDto;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
@Tag(name="Employee-Controller" , description = "This Controller responsible to handle employee related operation")
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    // today date
    @GetMapping("/todayDate")
    public String getTodayDate() {
        return "today date = " + LocalDate.now();
    }

    // add integer value
    @PostMapping("/add/{a}/{b}")
    public int add(@PathVariable Integer a,
                   @PathVariable Integer b) {
        return a + b;
    }
    
    
 // single object create
    @Operation(summary = "save employee data in database",description = " This API is used to save employee data in database")
    @PostMapping("/saveEmolyeeDto")
    public ResponseEntity<?> r(@RequestBody @Valid EmployeeDto emplyeeDto) {

        Employee employee = new Employee();
        employee.setId(emplyeeDto.getId());
        employee.setName(emplyeeDto.getName());
        employee.setEmail(emplyeeDto.getEmail());
        employee.setDepartment(emplyeeDto.getDepartment());

        HashMap<String, Object> response = new HashMap<>();

        Employee employee2 = employeeDao.saveEmployeeDao(employee);

        if (employee2 != null) {
            response.put("message", "employee saved successfully");
            response.put("employee", employee2);
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "employee not saved");
            return ResponseEntity.ok(response);
        }
    }

 // multiple object create
    @PostMapping("/saveMultipleEmployeeDto")
    public ResponseEntity<?> saveMultipleEmployeeDtoController(@RequestBody @Valid  List<EmployeeDto> employeeDto) {

        List<Employee> employees = employeeDto.stream()
                .map(dto -> new Employee(
                        dto.getId(),
                        dto.getName(),
                        dto.getEmail(),
                        dto.getDepartment()))
                .toList();
        employeeDao.saveAllEmployeeDao(employees);

        System.out.println(employeeDto);

        return ResponseEntity.ok("Employee saved succesfully");
    }

    // get employee by id
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getEmployeeById(
            @PathVariable Integer id) {

        Employee employee = employeeDao.getEmployeeByIdDao(id);

        if (employee != null) {
            return ResponseEntity.ok(employee);
        } else {
            throw new EntityNotFoundException(
                    "Employee not found with id = " + id);
        }
    }
    
   
}
