package com.company;

import javax.sound.midi.Soundbank;
import java.lang.reflect.Field;

public class CodeChallengeOOP {
    private CodeChallengeOOP() {
    }

    public static void main(String... args) throws CloneNotSupportedException, CardNotFoundException, WrongPasswordException {
        // Builder Pattern
        Human human = new Human.HumanBuilder("ok", 3)
                .setHobby("Playing Dota 2")
                .setSex("Masculine")
                .setID(123512)
                .create();

        // Prototype Pattern
        Human humanClone = human.clone();
        humanClone.setAge(33);
        printHumans(human, humanClone);

        // Adapter Pattern
        HeadPhones headPhones = new IphoneHeadPhones();
        Xbox xbox = new Xbox();
        xbox.setSoundPort(new XboxSoundAdapter(headPhones).receiveSound());

        // Proxy Pattern
        human.setCard(new Card(245, 223));
        ATMProxy atmProxy = new ATMProxy(human);
        human.setCash(atmProxy.extractMoney(25, 223));

        System.out.println("Hello !");
    }

    static class SingletonHelper {
        private static final CodeChallengeOOP INSTANCE = new CodeChallengeOOP();
    }

    public static CodeChallengeOOP getInstance() {
        return SingletonHelper.INSTANCE;
    }

    private static void printHumans(Human... humans) {
        for (Human human : humans) {
            System.out.println(human.toString());
        }
    }
}

class Xbox {
    SoundPort soundPort;

    public void setSoundPort(SoundPort soundPort) {
        this.soundPort = soundPort;
    }
}

class Headphones {
    SoundJack soundJack;
    MicrophoneJack microphoneJack;
}

class XboxSoundAdapter {
    HeadPhones headPhones;

    XboxSoundAdapter(HeadPhones headPhones) {
        this.headPhones = headPhones;
    }

    SoundPort receiveSound() {
        return new SoundPort(headPhones.soundJack, headPhones.microphoneJack);
    }
}

interface Port {

}

class SoundPort implements Port {
    MicrophoneJack microphoneJack;
    SoundJack soundJack;

    SoundPort(SoundJack soundJack, MicrophoneJack microphoneJack) {
        this.soundJack = soundJack;
        this.microphoneJack = microphoneJack;
    }
}

interface Jack {

}

interface SoundJack extends Jack {

}

interface MicrophoneJack extends Jack {

}

class HeadPhones {
    MicrophoneJack microphoneJack;
    SoundJack soundJack;
}

class IphoneHeadPhones extends HeadPhones {

}

interface ATM {
    float extractMoney(float sum, int password) throws WrongPasswordException, CardNotFoundException;
}

abstract class INGATM implements ATM {
    float moneyAvailable;

    void decreaseMoney(float sum) {
        moneyAvailable -= sum;
    }
}

class ATMProxy extends INGATM {
    Human human;

    ATMProxy(Human human) {
        this.human = human;
    }

    @Override
    public float extractMoney(float sum, int password) throws WrongPasswordException, CardNotFoundException {
        if (isCardValid() && isPasswordValid(password)) {
            System.out.println("Card and password are valid.");
            if (sum > moneyAvailable) {
                decreaseMoney(moneyAvailable);
                return moneyAvailable;
            } else {
                decreaseMoney(sum);
                return sum;
            }
        }
        return 0;
    }

    private boolean isCardValid() throws CardNotFoundException {
        if (human.getCard().ID >= 100 && human.getCard().ID < 10000) {
            return true;
        }
        throw new CardNotFoundException("Card not found in database.");
    }

    private boolean isPasswordValid(int password) throws WrongPasswordException {
        if (human.getCard().password == password) {
            return true;
        }
        throw new WrongPasswordException("Wrong password entered.");
    }
}

class WrongPasswordException extends Exception {
    WrongPasswordException(String message) {
        System.out.println(message);
    }
}

class CardNotFoundException extends Exception {
    CardNotFoundException(String message) {
        System.out.println(message);
    }
}

class Card {
    int ID;
    int password;

    Card(int ID, int password) {
        this.ID = ID;
        this.password = password;
    }
}

class Human implements Cloneable {
    private String name;
    private String hobby;
    private String sex;
    private float cash;
    private Card card;
    private int age;
    private int ID;

    Human(HumanBuilder builder) {
        this.hobby = builder.hobby;
        this.name = builder.name;
        this.card = builder.card;
        this.sex = builder.sex;
        this.age = builder.age;
        this.ID = builder.ID;
    }

    @Override
    public Human clone() throws CloneNotSupportedException {
        return (Human) super.clone();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Field field : this.getClass().getDeclaredFields()) {
            try {
                stringBuilder.append(field.getName() + ": " + field.get(this) + "\n");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return stringBuilder.toString();
    }

    public float getCash() {
        return cash;
    }

    public void setCash(float cash) {
        this.cash = cash;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Card getCard() {
        return card;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public static class HumanBuilder {
        private String name;
        private String hobby;
        private String sex;
        private float cash;
        private Card card;
        private int age;
        private int ID;

        HumanBuilder(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public HumanBuilder setCash(float cash) {
            this.cash = cash;
            return this;
        }

        public HumanBuilder setCard(Card card) {
            this.card = card;
            return this;
        }

        public HumanBuilder setHobby(String hobby) {
            this.hobby = hobby;
            return this;
        }

        public HumanBuilder setSex(String sex) {
            this.sex = sex;
            return this;
        }

        public HumanBuilder setID(int ID) {
            this.ID = ID;
            return this;
        }

        public Human create() {
            return new Human(this);
        }
    }
}
