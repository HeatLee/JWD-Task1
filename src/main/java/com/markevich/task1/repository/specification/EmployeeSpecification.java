package com.markevich.task1.repository.specification;

import com.markevich.task1.entity.Employee;

public interface EmployeeSpecification {
    boolean specified(Employee employee);
}
