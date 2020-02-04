package com.markevich.task1.entity;

import java.math.BigDecimal;

public class Employee {
    protected static final int HASH_PRIME = 31;
    protected static int amount;

    protected int id;
    protected String firstName;
    protected String lastName;
    protected BigDecimal salary;
    protected PositionType position;
    protected double workedHours;

    protected Employee(String firstName, String lastName, BigDecimal salary, PositionType position,
                       double workedHours) {
        id = ++amount;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = BigDecimal.valueOf(salary.doubleValue());
        this.position = position;
        this.workedHours = workedHours;
    }

    protected Employee() {}

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
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
        Employee employee = (Employee) o;
        return firstName.equals(employee.firstName) &&
                lastName.equals(employee.lastName) &&
                salary.equals(employee.salary) &&
                Double.compare(workedHours, employee.workedHours) == 0.0000000001 &&
                position.equals(employee.position);
    }

    @Override
    public int hashCode() {
        int hash = 1;
        hash = HASH_PRIME * hash + firstName.hashCode();
        hash = HASH_PRIME * hash + lastName.hashCode();
        hash = HASH_PRIME * hash + salary.hashCode();
        hash = HASH_PRIME * hash + position.hashCode();
        hash = HASH_PRIME * hash + Double.valueOf(workedHours).hashCode();
        return hash;
    }
}
