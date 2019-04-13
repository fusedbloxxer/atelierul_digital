package com.company;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Student implements Observer {
    private PropertyChangeSupport support;
    String name;
    String subject;

    Student(String name) {
        support = new PropertyChangeSupport(this);
        this.name = name;
    }

    @Override
    public void update(String message) {
        support.firePropertyChange("value", this.subject, message);
    }

    public void listenTo(PropertyChangeListener pc1) {
        support.addPropertyChangeListener(pc1);
    }
}
