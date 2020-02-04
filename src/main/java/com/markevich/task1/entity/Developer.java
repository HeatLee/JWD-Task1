package com.markevich.task1.entity;

import java.math.BigDecimal;

public class Developer extends Programmer {

    private ProgrammingLanguage mainLanguage;

    public Developer(String firstName, String lastName, PositionType position, ProgrammingLanguage mainLanguage,
                     double workHours, BigDecimal salary){
        super(firstName, lastName, salary, position, workHours);
        this.mainLanguage = mainLanguage;
    }

    public ProgrammingLanguage getMainLanguage() {
        return mainLanguage;
    }

    public void setMainLanguage(ProgrammingLanguage mainLanguage) {
        this.mainLanguage = mainLanguage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Developer developer = (Developer) o;
        return mainLanguage == developer.mainLanguage;
    }

    @Override
    public int hashCode() {
        return  super.hashCode() * HASH_PRIME + mainLanguage.hashCode();
    }

    @Override
    public String toString() {
        return "Developer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position=" + position +
                ", mainLanguage=" + mainLanguage +
                ", workedHours=" + workedHours +
                ", salary=" + salary +
                '}';
    }
}
