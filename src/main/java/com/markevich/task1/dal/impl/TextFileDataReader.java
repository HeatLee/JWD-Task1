package com.markevich.task1.dal.impl;

import com.markevich.task1.dal.DataReader;
import com.markevich.task1.dal.util.Converter;
import com.markevich.task1.entity.Employee;
import com.markevich.task1.exception.DataAccessException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextFileDataReader implements DataReader {
    private String filePath;

    public TextFileDataReader(String filePath) {
        this.filePath = filePath;
    }


    @Override
    public List<Employee> readAll() {
        List<Employee> list = new ArrayList<>();
        try {
            File file = checkFile();
            list = readAll(file);
        } catch (DataAccessException e) {
            //todo log
        }
        return list;
    }

    private File checkFile() throws DataAccessException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new DataAccessException("Data source do not exist in given directory.");
            //todo log
        }
        return file;
    }

    private List<Employee> readAll(File file) throws DataAccessException {
        List<Employee> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Employee e = Converter.parseToObject(line);
                if (e != null) {
                    list.add(e);
                }
            }
        } catch (IOException e) {
            throw new DataAccessException("Data source problems", e);
            //todo log
        }
        return list;
    }
}
