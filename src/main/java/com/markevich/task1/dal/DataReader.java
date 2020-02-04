package com.markevich.task1.dal;

import com.markevich.task1.entity.Employee;

import java.util.List;

public interface DataReader {
    List<Employee> readAll();
}
