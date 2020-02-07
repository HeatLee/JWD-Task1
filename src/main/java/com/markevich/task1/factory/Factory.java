package com.markevich.task1.factory;

import com.markevich.task1.entity.developer.Developer;
import com.markevich.task1.entity.qa.QAEngineer;

public interface Factory {
    Developer createDeveloper(String[] fields);

    QAEngineer createQAEngineer(String[] fields);
}
