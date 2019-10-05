package com.company;

public class CommandFactory {
    private static CommandFactory ourInstance = new CommandFactory();

    public static CommandFactory getInstance() {
        return ourInstance;
    }

    private CommandFactory() {}

    public static Command getCommand(String type) {
        if("ls".equals(type)) {
            return listCommand.getInstance();
        }
        return null;
    }
}
