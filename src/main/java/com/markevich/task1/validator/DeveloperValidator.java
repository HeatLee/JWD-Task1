package com.markevich.task1.validator;

import com.markevich.task1.entity.Developer;

public class DeveloperValidator {
    public static boolean validate(Developer developer) {
        return EmployeeValidator.validate(developer) && developer.getMainLanguage() != null;
    }
}
