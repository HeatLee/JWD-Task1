package com.markevich.task1.repository;

import com.markevich.task1.entity.Employee;
import com.markevich.task1.specification.EmployeeSpecification;

import java.util.Collection;
import java.util.List;

public interface EmployeeRepository {

    void addEmployee(Employee employee);

    void addAllEmployees(Collection<Employee> employees);

    void delete(Employee employee);

    void update(Employee oldEmployee, Employee newEmployee);

    List<Employee> matches(EmployeeSpecification specification);
}
