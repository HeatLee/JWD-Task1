package com.markevich.task1.entity;

import java.math.BigDecimal;

public class Employee {
    protected static final int HASH_PRIME = 31;

    protected String firstName;
    protected String lastName;
    protected BigDecimal salary;

    protected Employee(String firstName, String lastName, BigDecimal salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = BigDecimal.valueOf(salary.doubleValue());
    }

    protected Employee() {}

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return firstName.equals(employee.firstName) &&
                lastName.equals(employee.lastName) &&
                salary.equals(employee.salary);
    }

    @Override
    public int hashCode() {
        int hash = 1;
        hash = HASH_PRIME * hash + firstName.hashCode();
        hash = HASH_PRIME * hash + lastName.hashCode();
        hash = HASH_PRIME * hash + salary.hashCode();
        return hash;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                '}';
    }
}
