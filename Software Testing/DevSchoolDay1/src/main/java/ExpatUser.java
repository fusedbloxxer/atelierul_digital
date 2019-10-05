package main.java;

public class ExpatUser extends User {
    private int passportNumber;

    // TODO: with regex

    void test() {
        String str = "Hello";
        for (char ch : str.toCharArray()) {

        }
    }

    @Override
    public String getDocument() {
        return String.valueOf(passportNumber);
    }
}
