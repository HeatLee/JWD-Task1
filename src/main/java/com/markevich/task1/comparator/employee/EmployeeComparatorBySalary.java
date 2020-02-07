package com.markevich.task1.comparator.employee;

import com.markevich.task1.entity.Employee;

import java.util.Comparator;

public class EmployeeComparatorBySalary implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getSalary().compareTo(o2.getSalary());
    }
}
