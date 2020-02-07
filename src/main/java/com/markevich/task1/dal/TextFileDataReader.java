package com.markevich.task1.dal;

import com.markevich.task1.entity.Employee;
import com.markevich.task1.exception.DataAccessException;
import com.markevich.task1.factory.FactoryImpl;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextFileDataReader implements DataReader {
    private static final String DEVELOPER_EMPLOYEE = "Developer";
    private static final String QA_ENGINEER_EMPLOYEE = "QAEngineer";
    private static final int EMPLOYEE_TYPE_INFO = 0;
    private static final String REGEX = "\\|";
    private static final Logger LOGGER = Logger.getLogger(TextFileDataReader.class);

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
            LOGGER.log(Level.WARN, e);
        }
        return list;
    }

    private File checkFile() throws DataAccessException {
        File file = new File(filePath);
        if (!file.exists()) {
            LOGGER.log(Level.TRACE, "Data source do not exist");
            throw new DataAccessException("Data source do not exist in given directory.");
        }
        return file;
    }

    private List<Employee> readAll(File file) throws DataAccessException {
        List<Employee> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(REGEX);
                Employee e;
                switch (fields[EMPLOYEE_TYPE_INFO]) {
                    case DEVELOPER_EMPLOYEE:
                        e = FactoryImpl.getInstance().createDeveloper(fields);
                        break;
                    case QA_ENGINEER_EMPLOYEE:
                        e = FactoryImpl.getInstance().createQAEngineer(fields);
                        break;
                    default:
                        e = null;
                }
                if (e != null) {
                    list.add(e);
                }
            }
        } catch (IOException e) {
            LOGGER.log(Level.WARN, e);
            throw new DataAccessException("Data source problems", e);
        }
        return list;
    }
}
