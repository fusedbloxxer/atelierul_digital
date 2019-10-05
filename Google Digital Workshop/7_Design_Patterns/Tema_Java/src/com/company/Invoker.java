package com.company;

import java.util.ArrayList;
import java.util.List;

public class Invoker {
    private static Invoker ourInstance = new Invoker();
    private List<Command> commandList = new ArrayList<>();

    public static Invoker getInstance() {
        return ourInstance;
    }

    private Invoker() {
    }

    public void takeCommand(Command command) {
        commandList.add(command);
    }

    public void executeCommands() {
        for(Command command: commandList) {
            command.execute();
        }
        commandList.clear();
    }
}
