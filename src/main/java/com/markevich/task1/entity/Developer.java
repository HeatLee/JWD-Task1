package com.markevich.task1.entity;

import java.util.Objects;

public class Developer extends Programmer {
    private ProgrammingLanguage mainLanguage;

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
                "mainLanguage=" + mainLanguage +
                ", position=" + position +
                ", workedHours=" + workedHours +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                '}';
    }
}
