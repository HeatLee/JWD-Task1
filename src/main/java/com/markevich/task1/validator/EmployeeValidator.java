package com.markevich.task1.validator;

import com.markevich.task1.entity.Employee;
import com.markevich.task1.entity.PositionType;

import java.math.BigDecimal;

public class EmployeeValidator {
    private static final String NULL_STRING = "NULL";

    public static boolean validate(Employee employee) {
        return employee != null &&  isValidName(employee.getFirstName()) && isValidName(employee.getLastName())
                && isValidPosition(employee.getPosition()) && isValidSalary(employee.getSalary())
                && isValidWorkHours(employee.getWorkedHours());
    }

    public static boolean isValidName(String name) {
        return name != null && name.length() > 0 && !NULL_STRING.equals(name.toUpperCase());
    }

    public static boolean isValidWorkHours(double workHours) {
        return workHours > 0;
    }

    public static boolean isValidPosition(PositionType position) {
        return position != null;
    }

    public static boolean isValidSalary(BigDecimal salary) {
        return salary != null && salary.doubleValue() > 0;
    }

}
