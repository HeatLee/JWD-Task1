package com.markevich.task1.specification.impl;

import com.markevich.task1.entity.Employee;
import com.markevich.task1.entity.qa.QAEngineer;
import com.markevich.task1.entity.qa.QATools;
import com.markevich.task1.specification.EmployeeSpecification;

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
