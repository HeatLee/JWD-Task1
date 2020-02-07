package com.markevich.task1.entity.qa;

import com.markevich.task1.entity.MainSkill;

public enum  QATools implements MainSkill {
    SELENIUM("Selenium"), SEKULI("Sekuli"), APPIUM("Appium"),
    JMETER("Jmeter"), JUNIT("JUnit");
    private String formatName;

    QATools(String formatName) {
        this.formatName = formatName;
    }

    @Override
    public String toString() {
        return formatName;
    }
}
