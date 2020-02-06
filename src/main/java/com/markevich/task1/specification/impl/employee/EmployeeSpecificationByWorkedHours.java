package com.markevich.task1.specification.impl.employee;

import com.markevich.task1.entity.Employee;
import com.markevich.task1.specification.EmployeeSpecification;

public class EmployeeSpecificationByWorkedHours implements EmployeeSpecification {
    private double specifiedWorkedHours;

    public EmployeeSpecificationByWorkedHours(double specifiedWorkedHours) {
        this.specifiedWorkedHours = specifiedWorkedHours;
    }

    @Override
    public boolean specified(Employee employee) {
        return Double.compare(specifiedWorkedHours, employee.getWorkedHours()) == 0;
    }
}
