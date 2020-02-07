package com.markevich.task1.factory;

import com.markevich.task1.entity.Employee;
import com.markevich.task1.entity.PositionType;
import com.markevich.task1.entity.developer.Developer;
import com.markevich.task1.entity.developer.ProgrammingLanguage;
import com.markevich.task1.entity.qa.QAEngineer;
import com.markevich.task1.entity.qa.QATools;
import com.markevich.task1.validator.DeveloperValidator;
import com.markevich.task1.validator.QAEngineerValidator;

import java.math.BigDecimal;

public enum  FactoryImpl implements Factory {
    INSTANCE;
    private static final int FIRST_NAME_INFO_INDEX = 1;
    private static final int LAST_NAME_INFO_INDEX = 2;
    private static final int POSITION_INFO_INDEX = 3;
    private static final int MAIN_SKILL_INFO_INDEX = 4;
    private static final int WORK_HOURS_INFO_INDEX = 5;
    private static final int SALARY_INFO_INDEX = 6;
    private static final int VALID_LENGTH = 7;

    public static Factory getInstance() {
        return INSTANCE;
    }

    @Override
    public Developer createDeveloper(String[] fields) {
        Developer developer = null;
        if (fields != null && fields.length == VALID_LENGTH) {
            developer = new Developer(fields[FIRST_NAME_INFO_INDEX], fields[LAST_NAME_INFO_INDEX],
                    PositionType.valueOf(fields[POSITION_INFO_INDEX]),
                    ProgrammingLanguage.valueOf(fields[MAIN_SKILL_INFO_INDEX]),
                    Double.parseDouble(fields[WORK_HOURS_INFO_INDEX]),
                    new BigDecimal(fields[SALARY_INFO_INDEX]));
        }
        if (!DeveloperValidator.validate(developer)) {
            developer = null;
        }
        return developer;
    }

    @Override
    public QAEngineer createQAEngineer(String[] fields) {
        QAEngineer engineer = null;
        if (fields != null && fields.length == VALID_LENGTH) {
            engineer = new QAEngineer(fields[FIRST_NAME_INFO_INDEX], fields[LAST_NAME_INFO_INDEX],
                    PositionType.valueOf(fields[POSITION_INFO_INDEX]),
                    QATools.valueOf(fields[MAIN_SKILL_INFO_INDEX]),
                    Double.parseDouble(fields[WORK_HOURS_INFO_INDEX]),
                    new BigDecimal(fields[SALARY_INFO_INDEX]));
        }
        if (!QAEngineerValidator.validate(engineer)) {
            engineer = null;
        }
        return engineer;
    }
}
