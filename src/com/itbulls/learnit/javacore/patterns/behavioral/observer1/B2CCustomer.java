package com.itbulls.learnit.javacore.patterns.behavioral.observer1;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class B2CCustomer extends Customer implements PropertyChangeListener {

    public void propertyChange(PropertyChangeEvent event){

        setGoodsArrived((Boolean)event.getNewValue());
        System.out.println("Goods arrived to the store. Make your B2C order now");
    }
}
