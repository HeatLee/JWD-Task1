package com.markevich.task1.repository;

import com.markevich.task1.entity.Employee;
import com.markevich.task1.entity.developer.Developer;
import com.markevich.task1.entity.qa.QAEngineer;
import com.markevich.task1.specification.EmployeeSpecification;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public enum EmployeeRepositoryImpl implements EmployeeRepository {
    INSTANCE;
    private Set<Employee> employeesSet = new HashSet<>();

    public static EmployeeRepository getInstance() {
        return INSTANCE;
    }

    @Override
    public void addEmployee(Employee employee) {
        if (employee != null) {
            employeesSet.add(employee);
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
        if (oldEmployee == null || newEmployee == null) {
            return;
        }
        if (employeesSet.remove(oldEmployee)) {
            employeesSet.add(newEmployee);
        }
    }

    @Override
    public List<Employee> matches(EmployeeSpecification specification) {
        List<Employee> result = new ArrayList<>();
        for (Employee e : employeesSet) {
            if (specification.specified(e)) {
                if (e instanceof Developer) {
                    result.add(new Developer((Developer) e));
                } else if (e instanceof QAEngineer) {
                    result.add(new QAEngineer((QAEngineer) e));
                }
            }
        }
        return result;
    }
}
