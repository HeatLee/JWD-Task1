package com.markevich.task1.repository.specification.impl;

import com.markevich.task1.entity.Employee;
import com.markevich.task1.entity.PositionType;
import com.markevich.task1.repository.specification.EmployeeSpecification;

public class EmployeeSpecificationByPosition implements EmployeeSpecification {
    private PositionType specifiedPosition;

    public EmployeeSpecificationByPosition(PositionType specifiedPosition) {
        this.specifiedPosition = specifiedPosition;
    }

    @Override
    public boolean specified(Employee employee) {
        return employee.getPosition().equals(specifiedPosition);
    }
}
