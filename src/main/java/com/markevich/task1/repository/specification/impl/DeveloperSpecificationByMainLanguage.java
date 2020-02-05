package com.markevich.task1.repository.specification.impl;

import com.markevich.task1.entity.Developer;
import com.markevich.task1.entity.Employee;
import com.markevich.task1.entity.ProgrammingLanguage;
import com.markevich.task1.repository.specification.EmployeeSpecification;

public class DeveloperSpecificationByMainLanguage implements EmployeeSpecification {
    private ProgrammingLanguage specifiedMainLanguage;

    public DeveloperSpecificationByMainLanguage(ProgrammingLanguage specifiedMainLanguage) {
        this.specifiedMainLanguage = specifiedMainLanguage;
    }

    @Override
    public boolean specified(Employee employee) {
        Developer developer = (Developer) employee;
        return developer.getMainLanguage().equals(specifiedMainLanguage);
    }
}
