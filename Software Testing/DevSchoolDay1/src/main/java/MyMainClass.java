package main.java;

public class MyMainClass {
    public static void main(String[] args) throws InvalidDocumentException {
        System.out.println("Hello Dev School Ing!");


        User myLocalUser;
        User myExpatUser;

        myLocalUser = new LocalUser();

        myLocalUser.setName("Andi");
        myLocalUser.setAge(32);
        ((LocalUser)myLocalUser).setCiSeries("RX");
        ((LocalUser)myLocalUser).setCiNumber(123456);

        System.out.println("User has document" + myLocalUser.getDocument());
        ((LocalUser) myLocalUser).setDocument("RX123456");
        // ((LocalUser) myLocalUser).setDocument("R1234567");
//        myExpatUser = new ExpatUser();
    }
}