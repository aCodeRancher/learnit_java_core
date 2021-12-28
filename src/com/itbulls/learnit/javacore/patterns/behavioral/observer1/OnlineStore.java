package com.itbulls.learnit.javacore.patterns.behavioral.observer1;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class OnlineStore {

    private boolean isGoodsArrived;

    private PropertyChangeSupport propertyChangeSupport;

    public OnlineStore(){
        propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl){
        propertyChangeSupport.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl){
        propertyChangeSupport.removePropertyChangeListener(pcl);
    }
    public void update(boolean status){
        propertyChangeSupport.firePropertyChange("isGoodsArrived",  isGoodsArrived, status);
        isGoodsArrived = status;
    }
}
