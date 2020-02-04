package com.markevich.task1.dal.util;

import com.markevich.task1.entity.*;
import com.markevich.task1.validator.DeveloperValidator;
import com.markevich.task1.validator.QAEngineerValidator;

import java.math.BigDecimal;

public class Converter {
    private static final String REGEX = "\\|";
    private static final int VALID_LENGTH = 7;
    private static final String DEVELOPER_EMPLOYEE = "Developer";
    private static final String QA_ENGINEER_EMPLOYEE = "QAEngineer";
    private static final int FIRST_NAME_INFO_INDEX = 1;
    private static final int LAST_NAME_INFO_INDEX = 2;
    private static final int POSITION_INFO_INDEX = 3;
    private static final int MAIN_SKILL_INFO_INDEX = 4;
    private static final int WORK_HOURS_INFO_INDEX = 5;
    private static final int SALARY_INFO_INDEX = 6;
    private static final int EMPLOYEE_TYPE_INFO = 0;

    public static Employee parseToObject(String data) {
        Employee employee = null;
        if (data != null) {
            String[] fields = data.split(REGEX);
            if (fields.length == VALID_LENGTH) {
                employee = createObject(fields);
            }
        }
        return employee;
    }

    private static Employee createObject(String[] fields) {
        Employee employee = null;
        if (fields[EMPLOYEE_TYPE_INFO].equals(DEVELOPER_EMPLOYEE)) {
            employee = new Developer(fields[FIRST_NAME_INFO_INDEX], fields[LAST_NAME_INFO_INDEX],
                    PositionType.valueOf(fields[POSITION_INFO_INDEX]),
                    ProgrammingLanguage.valueOf(fields[MAIN_SKILL_INFO_INDEX]),
                    Double.parseDouble(fields[WORK_HOURS_INFO_INDEX]),
                    new BigDecimal(fields[SALARY_INFO_INDEX]));
            if (!DeveloperValidator.validate((Developer) employee)) {
                employee = null;
            }
        } else if (fields[EMPLOYEE_TYPE_INFO].equals(QA_ENGINEER_EMPLOYEE)) {
            employee = new QAEngineer(fields[FIRST_NAME_INFO_INDEX], fields[LAST_NAME_INFO_INDEX],
                    PositionType.valueOf(fields[POSITION_INFO_INDEX]),
                    QATools.valueOf(fields[MAIN_SKILL_INFO_INDEX]),
                    Double.parseDouble(fields[WORK_HOURS_INFO_INDEX]),
                    new BigDecimal(fields[SALARY_INFO_INDEX]));
            if (!QAEngineerValidator.validate((QAEngineer) employee)) {
                employee = null;
            }
        }
        return employee;
    }
}
