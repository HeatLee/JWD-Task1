package com.markevich.task1.comparator;

import com.markevich.task1.entity.developer.Developer;

import java.util.Comparator;

public class DeveloperComparatorByMainLanguage implements Comparator<Developer> {
    @Override
    public int compare(Developer o1, Developer o2) {
        return o1.getMainLanguage().compareTo(o2.getMainLanguage());
    }
}
