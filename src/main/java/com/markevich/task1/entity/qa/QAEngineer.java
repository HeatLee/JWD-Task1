package com.markevich.task1.entity.qa;

import com.markevich.task1.entity.Employee;
import com.markevich.task1.entity.PositionType;

import java.math.BigDecimal;

public class QAEngineer extends Employee {
    private QATools mainTestingTool;

    public QAEngineer(String firstName, String lastName, PositionType position, QATools mainTestingTool,
                      double workHours, BigDecimal salary){
        super(firstName, lastName, salary, position, workHours);
        this.mainTestingTool = mainTestingTool;
    }

    public QAEngineer(QAEngineer qaEngineer) {
        this.firstName = qaEngineer.firstName;
        this.lastName = qaEngineer.lastName;
        this.position = qaEngineer.position;
        this.salary = qaEngineer.salary;
        this.workedHours = qaEngineer.workedHours;
        this.mainTestingTool = qaEngineer.mainTestingTool;
    }

    public QATools getMainTestingTool() {
        return mainTestingTool;
    }

    public void setMainTestingTool(QATools mainTestingTool) {
        this.mainTestingTool = mainTestingTool;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        QAEngineer that = (QAEngineer) o;
        return mainTestingTool == that.mainTestingTool;
    }

    @Override
    public int hashCode() {
        return super.hashCode() * HASH_PRIME + mainTestingTool.hashCode();
    }

    @Override
    public String toString() {
        return "QAEngineer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position=" + position +
                ", mainTestingTool=" + mainTestingTool +
                ", workedHours=" + workedHours +
                ", salary=" + salary +
                '}';
    }
}
