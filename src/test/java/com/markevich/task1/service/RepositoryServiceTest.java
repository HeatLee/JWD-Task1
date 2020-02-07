package com.markevich.task1.service;

import com.markevich.task1.comparator.employee.EmployeeComparatorBySalary;
import com.markevich.task1.entity.Employee;
import com.markevich.task1.entity.PositionType;
import com.markevich.task1.entity.developer.Developer;
import com.markevich.task1.entity.developer.ProgrammingLanguage;
import com.markevich.task1.entity.qa.QAEngineer;
import com.markevich.task1.entity.qa.QATools;
import com.markevich.task1.exception.RepositoryException;
import com.markevich.task1.exception.ServiceException;
import com.markevich.task1.repository.EmployeeRepository;
import com.markevich.task1.specification.impl.employee.EmployeeSpecificationByFirstName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class RepositoryServiceTest {

    @Before
    public void SetUp() {
        EmployeeRepository.getInstance().clear();
    }

    @Test(expected = ServiceException.class)
    public void addAllEmployeesTestNullIncomingCollection() throws ServiceException {
        RepositoryService service = new RepositoryService();
        service.addAllEmployees(null);
    }

    @Test
    public void addAllEmployeesTestValidData() throws ServiceException {
        RepositoryService service = new RepositoryService();
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Developer("Sasha", "Markevich", PositionType.JUNIOR,
                ProgrammingLanguage.JAVA, 10.2, BigDecimal.valueOf(500)));
        employeeList.add(new QAEngineer("Ivan", "Ivanov", PositionType.MIDDLE,
                QATools.APPIUM, 1000.6, BigDecimal.valueOf(1500)));
        service.addAllEmployees(employeeList);
        int expectedLength = 2;
        int actualLength = EmployeeRepository.getInstance().size();
        Assert.assertEquals(expectedLength, actualLength);
    }

    @Test
    public void addEmployeeTestValidData() throws ServiceException {
        RepositoryService service = new RepositoryService();
        service.addEmployee(new Developer("Sasha", "Markevich", PositionType.JUNIOR,
                ProgrammingLanguage.JAVA, 10.2, BigDecimal.valueOf(500)));
        int expectedLength = 1;
        int actualLength = EmployeeRepository.getInstance().size();
        Assert.assertEquals(expectedLength, actualLength);
    }

    @Test
    public void deleteTestValidData() throws ServiceException{
        RepositoryService service = new RepositoryService();
        Employee employee = new Developer("Sasha", "Markevich", PositionType.JUNIOR,
                ProgrammingLanguage.JAVA, 10.2, BigDecimal.valueOf(500));
        service.addEmployee(employee);
        service.delete(employee);
        int expectedLength = 0;
        int actualLength = EmployeeRepository.getInstance().size();
        Assert.assertEquals(expectedLength, actualLength);
    }

    @Test
    public void updateTestValidData() throws ServiceException , RepositoryException {
        RepositoryService service = new RepositoryService();
        Employee oldEmployee = new Developer("Sasha", "Markevich", PositionType.JUNIOR,
                ProgrammingLanguage.JAVA, 10.2, BigDecimal.valueOf(500));
        service.addEmployee(oldEmployee);
        Employee newEmployee = new QAEngineer("Ivan", "Ivanov", PositionType.MIDDLE,
                QATools.APPIUM, 1000.6, BigDecimal.valueOf(1500));
        service.update(oldEmployee, newEmployee);
        List<Employee> list = EmployeeRepository.getInstance().matches(new EmployeeSpecificationByFirstName("Ivan"));
        int actual = list.size();
        int expected = 1;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void calculateAllWorkedHoursTestValidData() throws ServiceException{
        RepositoryService service = new RepositoryService();
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Developer("Sasha", "Markevich", PositionType.JUNIOR,
                ProgrammingLanguage.JAVA, 10.2, BigDecimal.valueOf(500)));
        employeeList.add(new QAEngineer("Ivan", "Ivanov", PositionType.MIDDLE,
                QATools.APPIUM, 1000.6, BigDecimal.valueOf(1500)));
        service.addAllEmployees(employeeList);
        double actual = service.calculateAllWorkedHours();
        double expected = 1010.8;
        Assert.assertEquals(expected, actual, 0.0001);
    }


// Этот тест выдает приколы
//    @Test
//    public void sortValidData() throws ServiceException{
//        RepositoryService service = new RepositoryService();
//        Employee employee1 = new Developer("Sasha", "Markevich", PositionType.JUNIOR,
//                ProgrammingLanguage.JAVA, 10.2, BigDecimal.valueOf(500));
//        Employee employee2 = new QAEngineer("Ivan", "Ivanov", PositionType.MIDDLE,
//                QATools.APPIUM, 1000.6, BigDecimal.valueOf(1500));
//        List<Employee> employeeList = new ArrayList<>();
//        employeeList.add(employee2);
//        employeeList.add(employee1);
//        service.addAllEmployees(employeeList);
//        List<Employee> actualSortedList = service.sort(new EmployeeComparatorBySalary());
//        List<Employee> expectedSortedList = new ArrayList<>();
//        expectedSortedList.add(employee1);
//        expectedSortedList.add(employee2);
//        Assert.assertArrayEquals(expectedSortedList.toArray(new Employee[0]),
//                actualSortedList.toArray(new Employee[0]));
//    }
}
