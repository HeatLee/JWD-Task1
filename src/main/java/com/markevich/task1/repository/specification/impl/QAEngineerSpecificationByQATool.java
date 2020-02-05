package com.markevich.task1.repository.specification.impl;

import com.markevich.task1.entity.Employee;
import com.markevich.task1.entity.QAEngineer;
import com.markevich.task1.entity.QATools;
import com.markevich.task1.repository.specification.EmployeeSpecification;

public class QAEngineerSpecificationByQATool implements EmployeeSpecification {
    private QATools specifiedMainTool;

    public QAEngineerSpecificationByQATool(QATools specifiedMainTool) {
        this.specifiedMainTool = specifiedMainTool;
    }

    @Override
    public boolean specified(Employee employee) {
        QAEngineer engineer = (QAEngineer) employee;
        return engineer.getMainTestingTool().equals(specifiedMainTool);
    }
}