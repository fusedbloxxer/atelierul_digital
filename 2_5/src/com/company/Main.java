package com.company;

import java.io.*;
import java.time.Duration;
import java.time.Instant;

public class Main {

    private static void CopyBinary1(String readFile, String writeFile) throws Exception
    {
        FileInputStream finput=new FileInputStream(readFile);
        FileOutputStream foutput=new FileOutputStream(writeFile);

        int b;
        while((b=finput.read())!=-1)
            foutput.write(b);

        finput.close();
        foutput.close();
    }

    private static void CopyBinary2(String readFile, String writeFile) throws Exception
    {
        BufferedInputStream finput=new BufferedInputStream(new FileInputStream(readFile));
        BufferedOutputStream foutput=new BufferedOutputStream(new FileOutputStream(writeFile));

        int b;
        while((b=finput.read())!=-1)
            foutput.write(b);

        finput.close();
        foutput.close();
    }

    public static void main(String[] args) {

        try
        {

            Instant start= Instant.now();
            CopyBinary1("date.in","date.out");
            Instant stop =Instant.now();
            System.out.println("Duration: "+ Duration.between(start,stop));

            start=Instant.now();
            CopyBinary2("date.in","date.out");
            stop=Instant.now();

            System.out.println("Duration: "+ Duration.between(start,stop));
        }
        catch(Exception ex)
        {
            Throwable[] exceptions=ex.getSuppressed();
            StackTraceElement[] elements=ex.getStackTrace();

            System.err.println("Exception: "+ ex.getMessage() +"\nStackTraceElements: ");
            for(StackTraceElement currentElement: elements)
                System.err.println("Method(" + currentElement.getLineNumber() + "): " + currentElement.getMethodName()+"()");

            if(exceptions.length>0)
            {
                for(Throwable currentThrow:exceptions)
                    System.err.println("Exception Message: " + currentThrow.getMessage() + " Cause: " + currentThrow.getCause());
            }
        }

    }
}
