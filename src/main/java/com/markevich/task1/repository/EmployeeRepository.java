package com.markevich.task1.repository;

import com.markevich.task1.entity.Employee;
import com.markevich.task1.repository.specification.EmployeeSpecification;

import java.util.List;

public interface EmployeeRepository {

    void addEmployee(Employee employee);

    void addAllEmployees(List<Employee> employees);

    List<Employee> matches(EmployeeSpecification specification);
}
