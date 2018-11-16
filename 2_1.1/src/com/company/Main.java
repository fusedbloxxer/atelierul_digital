package com.company;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            if (1==1) throw new IOException("");
            if (1==2) throw new SQLException("");
        } catch (IOException | SQLException ex) {
            System.out.println(ex);
        }
    }
}

