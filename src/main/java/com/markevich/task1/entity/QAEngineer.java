package com.markevich.task1.entity;

import java.util.Objects;

public class QAEngineer extends Programmer {
    private QATools mainTestingTool;

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
                "mainTestingTool=" + mainTestingTool +
                ", position=" + position +
                ", workedHours=" + workedHours +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                '}';
    }
}
