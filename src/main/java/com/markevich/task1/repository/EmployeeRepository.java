package com.markevich.task1.repository;

import com.markevich.task1.entity.Employee;
import com.markevich.task1.entity.developer.Developer;
import com.markevich.task1.entity.qa.QAEngineer;
import com.markevich.task1.exception.RepositoryException;
import com.markevich.task1.specification.EmployeeSpecification;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.omg.PortableInterceptor.LOCATION_FORWARD;

import java.nio.ReadOnlyBufferException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public enum EmployeeRepository{
    INSTANCE;

    private static final Logger LOGGER = Logger.getLogger(EmployeeRepository.class);

    private Set<Employee> employeesSet = new HashSet<>();

    public static EmployeeRepository getInstance() {
        return INSTANCE;
    }

    public int size() {
        return employeesSet.size();
    }

    public void addEmployee(Employee employee) throws RepositoryException {
        if (employee == null) {
            LOGGER.log(Level.WARN, "Null employee while adding");
            throw new RepositoryException("Invalid incoming parameter");
        }
        employeesSet.add(employee);
    }

    public void delete(Employee employee) throws RepositoryException{
        if (employee == null) {
            LOGGER.log(Level.WARN, "Null employee while deleting");
            throw new RepositoryException("Invalid incoming parameter");
        }
        employeesSet.remove(employee);
    }

    public void update(Employee oldEmployee, Employee newEmployee) throws RepositoryException{
        if (oldEmployee == null || newEmployee == null) {
            LOGGER.log(Level.WARN, "Null employee(s) while updating");
            throw new RepositoryException("Invalid incoming parameter(s)");
        }
        if (employeesSet.remove(oldEmployee)) {
            employeesSet.add(newEmployee);
        }
    }

    public void clear() {
        employeesSet = new HashSet<>();
    }

    public List<Employee> matches(EmployeeSpecification specification) throws RepositoryException{
        if (specification == null) {
            LOGGER.log(Level.WARN, "Null specification");
            throw new RepositoryException("Invalid incoming parameter");
        }
        List<Employee> result = new ArrayList<>();
        for (Employee e : employeesSet) {
            if (specification.specified(e)) {
                if (e instanceof Developer) {
                    result.add(new Developer((Developer) e));
                } else if (e instanceof QAEngineer) {
                    result.add(new QAEngineer((QAEngineer) e));
                }
            }
        }
        return result;
    }

}
