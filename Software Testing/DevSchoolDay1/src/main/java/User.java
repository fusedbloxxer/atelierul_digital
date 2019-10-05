package main.java;

public abstract class User {
    private String name, document;

    private int age;

//    public User(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", document='" + document + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public abstract String getDocument();
}
