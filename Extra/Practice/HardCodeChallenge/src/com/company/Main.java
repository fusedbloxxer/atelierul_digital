package com.company;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final String LOCATION = "C:\\Users\\AnonymousClass\\WorkFolder\\GIT\\atelierul_digital\\Extra\\Practice\\HardCodeChallenge\\out.txt";

    public static void main(String[] args) {
        try {
            FileChannel fileChannel = FileChannel.open(Path.of(LOCATION), StandardOpenOption.WRITE);
            FileLock fileLock = fileChannel.lock(0, Long.MAX_VALUE, false);
            System.out.println("Lock obtained.");
            for (;;) {
                System.out.println(fileLock.isValid());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

@interface LogExecutionTime {

}

class PersonInvocationHandler implements InvocationHandler {
    private Person person;

    PersonInvocationHandler(Person person) {
        this.person = person;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent(LogExecutionTime.class)) {
            Instant start = Instant.now();
            method.invoke(proxy, args);
            Instant stop = Instant.now();

            return Duration.between(start, stop);
        }
        return null;
    }
}

interface IPerson {
    void walk();
    @LogExecutionTime void drink();

    String getName();
}

