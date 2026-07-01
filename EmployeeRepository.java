package com.jbm.spring_boot_crud_mysql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jbm.spring_boot_crud_mysql.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	// select * from employee where name = name;
	List<Employee>findByEame(String name);
}

