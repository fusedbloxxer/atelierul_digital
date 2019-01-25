package com.company;

public class Main {

    public enum Planet {
        MERCURY (3.303e+23, 2.439e6),
        VENUS   (4.869e+24, 6.0618e6),
        EARTH   (5.976e+24, 6.37814e6),
        MARS    (6.421e+23, 3.3972e6);

        public final double mass;
        public final double radius;
        Planet(double mass, double radius) {
            this.mass = mass;
            this.radius = radius;
        }
    }
    public static void main(String[] args) {
        int f = 5;
        SmallA smallA = new SmallA.Builder(1)
                .build();

        System.out.println(smallA.Xbox);

        // Enums
        System.out.println("The mass of the Earth is " + Planet.EARTH.mass);

        // Anonymous Class
        Button a = new Button() {

            @Override
            public void clickButton() {
                System.out.println("Clicked");
            }
            @Override
            public void hoverButton() {
                System.out.println("Hovering");
            }

            @Override
            public void releaseButton() {
                System.out.println("Released");
            }

            @Override
            public void holdButton() {
                System.out.println("Holding");
            }
        };

        a.clickButton();
        a.holdButton();
        a.hoverButton();
        a.releaseButton();
    }
}
interface Button {
    void clickButton();
    void hoverButton();
    void releaseButton();
    void holdButton();
}
class BigA {
    private static boolean imPrivate = true;
}
class SmallA {
    private SmallA(Builder builder) {
        this.PC = builder.PC;
        this.Xbox = builder.Xbox;
    }

    int PC;
    int Xbox;

    static class Builder {
        int PC;

        public Builder setXbox(int xbox) {
            Xbox = xbox;
            return this;
        }

        int Xbox;
        Builder(int PC) { this.PC = PC; }

        SmallA build() {
            return new SmallA(this);
        }
    }
}
class EagerSingleton {
    private static final EagerSingleton eagerInstance = new EagerSingleton();
    private EagerSingleton() {}
    public static EagerSingleton getInstance() {
        return eagerInstance;
    }
}
class LazySingleTon {
    private static LazySingleTon Instance;
    private LazySingleTon() {}
    public static LazySingleTon getInstance() {
        if(Instance == null) {
            Instance = new LazySingleTon();
        }
        return Instance;
    }
}
class ThreadSafeSingleton {
    private static ThreadSafeSingleton Instance;
    private ThreadSafeSingleton() {}
    public static ThreadSafeSingleton getInstance() {
        if(Instance == null) {
            synchronized (ThreadSafeSingleton.class) {
                if(Instance == null) {
                    Instance = new ThreadSafeSingleton();
                }
            }
        }
        return Instance;
    }
}
class BillPughSingleton {
    private BillPughSingleton() {}
    private static class Helper {
        private static final BillPughSingleton Instance = new BillPughSingleton();
    }
    public static BillPughSingleton getInstance() {
        return Helper.Instance;
    }
}
enum EnumSingleton{
    Instance;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    int value;

}