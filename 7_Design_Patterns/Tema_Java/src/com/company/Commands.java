package com.company;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

class listCommand implements Command{
    private FilePath filePath;
    private static listCommand ourInstance = new listCommand();

    public static listCommand getInstance() {
        return ourInstance;
    }

    private listCommand() {
        filePath = FilePath.getInstance();
    }

    public void setFilePath(FilePath filePath) {
        this.filePath = filePath;
    }

    public void execute() {
        if(filePath.getPath() == null) {
            filePath.setPath(Paths.get("D://"));
        } else if(Files.isDirectory(filePath.getPath())) {
            filePath.list();
        } else throw new Error("ls:" + filePath.getPath() + ": No such directory");
    }
}