package com.jbm.spring_boot_crud_mysql.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbm.spring_boot_crud_mysql.entity.Employee;
import com.jbm.spring_boot_crud_mysql.repository.EmployeeRepository;

@Repository
public class EmployeeDao {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Save single employee
    public Employee saveEmployeeDao(Employee employee) {
        return employeeRepository.saveAndFlush(employee);
    }

    // Get employee by ID
    public Employee getEmployeeByIdDao(int id) {
        Optional<Employee> optional = employeeRepository.findById(id);

        if(optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }

    // Save multiple employees
    public List<Employee> saveAllEmployeeDao(List<Employee> employees) {
        return employeeRepository.saveAllAndFlush(employees);
    }
    
}
