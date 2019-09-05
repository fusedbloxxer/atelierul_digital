package com.company;

interface Event {
    void start();
    void stop();
}

class ActionEvent implements Event {

    @Override
    public void start() {
        
    }

    @Override
    public void stop() {

    }
}

class EventHandler<T extends Event> {
    private void sendMessage(String message) {
    }
}

interface Time {
    void tick();
}

interface Work extends Time, Event {

}

class GameWorks implements Work {

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void tick() {

    }
}