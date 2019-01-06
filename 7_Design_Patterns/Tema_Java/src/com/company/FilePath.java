package com.company;

import java.nio.file.*;

public class FilePath {
    private static FilePath ourInstance = new FilePath();
    private Path path;
    private Boolean fullPath = false;

    public static FilePath getInstance() { return ourInstance; }

    private FilePath() { }

    public void setFullPath(Boolean fullPath) { this.fullPath = fullPath;}

    public void setPath(Path path) {
        this.path = path;
    }

    public Path getPath() { return this.path; }

    // Implementarea comenzilor
    void list() {

    }
}
