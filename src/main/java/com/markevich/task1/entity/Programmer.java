package com.markevich.task1.entity;

import java.math.BigDecimal;

public class Programmer extends Employee{
    protected PositionType position;
    protected double workedHours;

    protected Programmer(){}

    protected Programmer(String firstName, String lastName, BigDecimal salary, PositionType position,
                         double workedHours) {
        super(firstName, lastName, salary);
        this.position = position;
        this.workedHours = workedHours;
    }

    public PositionType getPosition() {
        return position;
    }

    public void setPosition(PositionType position) {
        this.position = position;
    }

    public double getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(double workedHours) {
        this.workedHours = workedHours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Programmer that = (Programmer) o;
        return Double.compare(that.workedHours, workedHours) == 0 &&
                position == that.position;
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        hash = HASH_PRIME * hash + position.hashCode();
        hash = HASH_PRIME * hash + Double.valueOf(workedHours).hashCode();
        return hash;
    }
}
