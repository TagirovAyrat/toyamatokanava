package ru.bugmakers.dto;

/**
 * Created by Ayrat on 13.10.2017.
 */
public class ReturnToConsole {

    private String fileName;

    public ReturnToConsole() {
    }

    public ReturnToConsole(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
