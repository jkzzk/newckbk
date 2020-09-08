package com.imust.newckbk.utils;

public class FileAuxiliary {
    private String originalName;
    private String newName;
    private String relativePath;
    private String absolutePath;

    public FileAuxiliary() {}

    public FileAuxiliary(String originalName, String newName, String relativePath, String absolutePath) {
        this.originalName = originalName;
        this.newName      = newName;
        this.relativePath = relativePath;
        this.absolutePath = absolutePath;
    }

    public String getAbsolutePath() {
        return absolutePath;
    }

    public void setAbsolutePath(String absolutePath) {
        this.absolutePath = absolutePath;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getRelativePath() {
        return relativePath;
    }

    public void setRelativePath(String relativePath) {
        this.relativePath = relativePath;
    }
}



