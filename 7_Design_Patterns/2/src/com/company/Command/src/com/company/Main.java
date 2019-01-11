package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // shift f6
    // memoize
    static interface Command {
        void execute();
        void undo();
    }
    static class AprindeBec implements Command {
        @Override
        public void execute()
        {
            System.out.println("aprinde becul");
        }

        @Override
        public void undo() {
            System.out.println("undo aprind becul");
        }
    }
    static class StingeBec implements Command {
        @Override
        public void execute()
        {
            System.out.println("stinge becul");
        }

        @Override
        public void undo() {
            System.out.println("undo sting becul");
        }
    }

    static class Executor {
        static List<Command> commands = new ArrayList<>();
        public static void append(Command command) {
            commands.add(command);
            command.execute();
        }
        public static void undo(int nrOfCommandsToUndo) {
            for(int i = 1; i <= nrOfCommandsToUndo; i++) {
                commands.get(commands.size() - i);
            }
        }
    }

    static List<Command> commands = new ArrayList<>();
    public static void main(String[] args) {
	    AprindeBec b1 = new AprindeBec();
	    StingeBec b2 = new StingeBec();

	    Executor.append(b1);
	    Executor.append(b2);
    }
}
