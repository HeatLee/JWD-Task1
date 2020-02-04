package com.markevich.task1.entity;

public enum ProgrammingLanguage{
    JAVA("Java"), SQL("SQL"), PYTHON("Python"), GOLANG("GOLang"),
    SCALA("Scala"), C("C"), C_SHARP("C#"), C_PLUS_PLUS("C++"),
    RUBY("Ruby"), JAVASCRIPT("JavaScript");

    private String formatName;

    ProgrammingLanguage(String formatName) {
        this.formatName = formatName;
    }

    @Override
    public String toString() {
        return formatName;
    }
}
