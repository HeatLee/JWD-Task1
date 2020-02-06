package com.markevich.task1.specification.impl.employee;

import com.markevich.task1.entity.Employee;
import com.markevich.task1.specification.EmployeeSpecification;

import java.math.BigDecimal;

public class EmployeeSpecificationBySalary implements EmployeeSpecification {
    private BigDecimal specifiedSalary;

    public EmployeeSpecificationBySalary(BigDecimal specifiedSalary) {
        this.specifiedSalary = BigDecimal.valueOf(specifiedSalary.doubleValue());
    }

    @Override
    public boolean specified(Employee employee) {
        return employee.getSalary().equals(specifiedSalary);
    }
}
