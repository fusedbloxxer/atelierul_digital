package com.company;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Ex2{
    static class Channel {
        volatile String message;//write happens-before read
        volatile boolean isChannelEmpty = true;//write happens-before read
        public String take() {//may cause duplicated or missed reads
            while (isChannelEmpty) { }
            isChannelEmpty = true;
            return message;
        }
        public void put(String message) {//writing 2 vars not in sync
            while (!isChannelEmpty) { }
            isChannelEmpty = false;
            this.message = message;
        }
    }
    public static void main(String[] args) {
        Channel c = new Channel();
        (new Thread(() -> { try {
            for(String m=c.take(); !m.equals("DONE"); m=c.take())
                System.out.println(m);
        } catch (Exception e) { }})).start();

        (new Thread(() -> { try {
            for(int i=1; i<=10; i++) c.put("hello" + i);
            c.put("DONE");
        } catch (Exception e) { }})).start();
    }
}

