package com.markevich.task1.specification.impl.employee;

import com.markevich.task1.entity.Employee;
import com.markevich.task1.specification.EmployeeSpecification;

public class EmployeeSpecificationByAll implements EmployeeSpecification {
    @Override
    public boolean specified(Employee employee) {
        return true;
    }
}
