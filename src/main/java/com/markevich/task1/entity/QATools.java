package com.markevich.task1.entity;

public enum  QATools {
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
