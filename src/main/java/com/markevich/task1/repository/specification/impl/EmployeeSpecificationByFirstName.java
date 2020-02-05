package com.markevich.task1.repository.specification.impl;

import com.markevich.task1.entity.Employee;
import com.markevich.task1.repository.specification.EmployeeSpecification;

public class EmployeeSpecificationByFirstName implements EmployeeSpecification {
    private String specifiedFirstName;

    public EmployeeSpecificationByFirstName(String specifiedFirstName) {
        this.specifiedFirstName = specifiedFirstName;
    }

    @Override
    public boolean specified(Employee employee) {
        return employee.getFirstName().equals(specifiedFirstName);
    }
}
