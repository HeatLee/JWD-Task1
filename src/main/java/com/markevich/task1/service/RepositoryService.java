package com.markevich.task1.service;

import com.markevich.task1.entity.Employee;
import com.markevich.task1.entity.developer.Developer;
import com.markevich.task1.entity.qa.QAEngineer;
import com.markevich.task1.exception.RepositoryException;
import com.markevich.task1.exception.ServiceException;
import com.markevich.task1.repository.EmployeeRepository;
import com.markevich.task1.specification.impl.employee.EmployeeSpecificationByAll;
import com.markevich.task1.validator.DeveloperValidator;
import com.markevich.task1.validator.QAEngineerValidator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class RepositoryService {
    private static final Logger LOGGER = Logger.getLogger(RepositoryService.class);

    private boolean checkEntity(Employee employee) {
        if (employee instanceof Developer) {
            return DeveloperValidator.validate((Developer) employee);
        } else if (employee instanceof QAEngineer) {
            return QAEngineerValidator.validate((QAEngineer) employee);
        }
        return false;
    }

    public void addAllEmployees(Collection<Employee> employees) throws ServiceException{
        if (employees == null) {
            throw new ServiceException("Incoming collection of data does not exist");
        }
        try {
            LOGGER.log(Level.TRACE, "Start adding");
            for (Employee employee : employees) {
                LOGGER.log(Level.TRACE, "Checking employee");
                if (checkEntity(employee)) {
                    LOGGER.log(Level.TRACE, "Add new employee");
                    EmployeeRepository.getInstance().addEmployee(employee);
                } else {
                    LOGGER.log(Level.WARN, "Invalid parameters");
                }
            }
        } catch (RepositoryException e) {
            LOGGER.log(Level.WARN, e);
            throw new ServiceException(e);
        }
    }

    public void addEmployee(Employee employee) throws ServiceException {
        if (!checkEntity(employee)) {
            LOGGER.log(Level.WARN, "Invalid parameters while adding");
            throw new ServiceException("Invalid parameters in employee");
        }
        try {
            EmployeeRepository.getInstance().addEmployee(employee);
        } catch (RepositoryException e) {
            LOGGER.log(Level.WARN, e);
            throw new ServiceException(e);
        }
    }

    public void delete(Employee employee) throws ServiceException{
        try {
            LOGGER.log(Level.TRACE, "Check employee");
            if (checkEntity(employee)) {
                LOGGER.log(Level.TRACE, "Deleting");
                EmployeeRepository.getInstance().delete(employee);
            } else {
                LOGGER.log(Level.WARN, "Invalid parameters");
            }
        } catch (RepositoryException e) {
            LOGGER.log(Level.WARN, e);
            throw new ServiceException(e);
        }
    }

    public void update(Employee oldEmployee, Employee newEmployee) throws ServiceException{
        if (!checkEntity(oldEmployee)) {
            LOGGER.log(Level.WARN, "Wrong old employee parameters");
            return;
        }
        if (!checkEntity(newEmployee)) {
            LOGGER.log(Level.WARN, "Wrong new employee parameters");
            return;
        }
        try {
            EmployeeRepository.getInstance().update(oldEmployee, newEmployee);
        } catch (RepositoryException e) {
            LOGGER.log(Level.WARN, e);
            throw new ServiceException(e);
        }
    }

    public double calculateAllWorkedHours() throws ServiceException {
        try {
            List<Employee> employeeList = EmployeeRepository.getInstance().matches(new EmployeeSpecificationByAll());
            double result = 0;
            for (Employee employee :
                    employeeList) {
                result += employee.getWorkedHours();
            }
            return result;
        } catch (RepositoryException e) {
            LOGGER.log(Level.WARN, e);
            throw new ServiceException(e);
        }
    }

    public List<Employee> sort(Comparator<Employee> comparator) throws ServiceException{
        if (comparator == null) {
            LOGGER.log(Level.WARN, "Null comparator");
            throw new ServiceException("Invalid  parameter");
        }
        try {
            List<Employee> employeeList = EmployeeRepository.getInstance().matches(new EmployeeSpecificationByAll());
            LOGGER.log(Level.TRACE, "Start sorting");
            quickSort(employeeList, comparator, 0, employeeList.size()-1);
            LOGGER.log(Level.TRACE, "Sorting ends");
            return employeeList;
        } catch (RepositoryException e) {
            LOGGER.log(Level.WARN, e);
            throw new ServiceException(e);
        }
    }

    private void quickSort(List<Employee> array, Comparator<Employee> comparator, int low, int high) {
        if (array == null || array.size() == 0) {
            LOGGER.log(Level.WARN, "Index out of bounds");
            return;
        }
        if (low >= high) {
            LOGGER.log(Level.TRACE, "Ending");
            return;
        }
        int middle = low + (high - low) / 2;
        Employee pivot = array.get(middle);
        int i = low;
        int j = high;
        while (i <= j) {
            while (comparator.compare(array.get(i), pivot) < 0) {
                i++;
            }

            while (comparator.compare(array.get(j), pivot) > 0) {
                j--;
            }

            if (i <= j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }
        if (low < j) {
            LOGGER.log(Level.TRACE, "New step");
            quickSort(array, comparator, low, j);
        }

        if (high > i) {
            LOGGER.log(Level.TRACE, "New step");
            quickSort(array, comparator, i, high);
        }
    }

    private void swap(List<Employee> employees, int firstElementIndex, int secondElementIndex) {
        LOGGER.log(Level.TRACE, "Swap");
        Employee swap = employees.get(firstElementIndex);
        employees.set(firstElementIndex, employees.get(secondElementIndex));
        employees.set(secondElementIndex, swap);
    }


}
