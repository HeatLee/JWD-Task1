package com.markevich.task1.comparator.employee;

import com.markevich.task1.entity.Employee;

import java.util.Comparator;

public class EmployeeComparatorByFirstName implements Comparator<Employee> {
    @Override
    public int compare(Employee employee1, Employee employee2) {
        return employee1.getFirstName().compareTo(employee2.getFirstName());
    }
}
