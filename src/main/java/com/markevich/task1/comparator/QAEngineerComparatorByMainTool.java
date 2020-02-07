package com.markevich.task1.comparator;

import com.markevich.task1.entity.qa.QAEngineer;

import java.util.Comparator;

public class QAEngineerComparatorByMainTool implements Comparator<QAEngineer> {
    @Override
    public int compare(QAEngineer o1, QAEngineer o2) {
        return o1.getMainTestingTool().compareTo(o2.getMainTestingTool());
    }
}
