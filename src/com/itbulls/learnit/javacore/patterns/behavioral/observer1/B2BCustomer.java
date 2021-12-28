package com.itbulls.learnit.javacore.patterns.behavioral.observer1;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class B2BCustomer  extends Customer implements   PropertyChangeListener {


    public void propertyChange(PropertyChangeEvent event){

        setGoodsArrived((Boolean)event.getNewValue());
        System.out.println("Goods arrived to the store. Make your B2B order now");
    }


}
