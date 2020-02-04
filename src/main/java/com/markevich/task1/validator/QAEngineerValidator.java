package com.markevich.task1.validator;

import com.markevich.task1.entity.QAEngineer;

public class QAEngineerValidator {
    public static boolean validate(QAEngineer engineer) {
        return EmployeeValidator.validate(engineer) && engineer.getMainTestingTool() != null;
    }
}
