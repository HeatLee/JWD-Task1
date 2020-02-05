package com.markevich.task1.repository.impl;

import com.markevich.task1.entity.Developer;
import com.markevich.task1.entity.Employee;
import com.markevich.task1.entity.QAEngineer;
import com.markevich.task1.repository.EmployeeRepository;
import com.markevich.task1.repository.specification.EmployeeSpecification;
import com.markevich.task1.validator.DeveloperValidator;
import com.markevich.task1.validator.EmployeeValidator;
import com.markevich.task1.validator.QAEngineerValidator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    private Set<Employee> employeesSet = new HashSet<>();

    public EmployeeRepositoryImpl() {
    }

    public EmployeeRepositoryImpl(List<Employee> list) {
        employeesSet.addAll(list);
    }

    @Override
    public void addEmployee(Employee employee) {
        add(employee);
    }

    @Override
    public void addAllEmployees(List<Employee> employees) {
        for (Employee employee : employees) {
            if (employee != null) {
                add(employee);
            }
        }
    }

    @Override
    public void delete(Employee employee) {
        if (employee != null) {
            employeesSet.remove(employee);
        }
    }

    @Override
    public void update(Employee oldEmployee, Employee newEmployee) {
        if (newEmployee == null || oldEmployee == null) {
            return;
        }
        if (employeesSet.remove(oldEmployee)) {
            add(newEmployee);
        }
    }

    @Override
    public List<Employee> matches(EmployeeSpecification specification) {
        List<Employee> result = new ArrayList<>();
        for (Employee e : employeesSet) {
            if (specification.specified(e)) {
                result.add(e);
            }
        }
        return result;
    }

    private void add(Employee employee) {
        if (employee instanceof Developer && DeveloperValidator.validate((Developer) employee)) {
            employeesSet.add(employee);
        } else if (employee instanceof QAEngineer && QAEngineerValidator.validate((QAEngineer) employee)) {
            employeesSet.add(employee);
        } else {
            if (EmployeeValidator.validate(employee)) {
                employeesSet.add(employee);
            }
        }
    }
}
