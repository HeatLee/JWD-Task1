package com.markevich.task1.specification.impl.employee;

import com.markevich.task1.entity.Employee;
import com.markevich.task1.specification.EmployeeSpecification;

public class EmployeeSpecificationByLastName implements EmployeeSpecification {
    private String specifiedLastName;

    public EmployeeSpecificationByLastName(String specifiedLastName) {
        this.specifiedLastName = specifiedLastName;
    }

    @Override
    public boolean specified(Employee employee) {
        return employee.getLastName().equals(specifiedLastName);
    }
}
