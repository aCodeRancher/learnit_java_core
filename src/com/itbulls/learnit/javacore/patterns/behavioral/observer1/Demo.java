package com.itbulls.learnit.javacore.patterns.behavioral.observer1;

public class Demo {

    public static void main (String... args){
         OnlineStore storeObervable = new OnlineStore();
         B2BCustomer b2BCustomer = new B2BCustomer();
         B2CCustomer b2CCustomer = new B2CCustomer();
         storeObervable.addPropertyChangeListener(b2BCustomer);
         storeObervable.addPropertyChangeListener(b2CCustomer);
         System.out.println("Before store updates....");
         System.out.println("B2BCustomer's inventory arrived yet ? " + b2BCustomer.isGoodsArrived());
         System.out.println("B2CCustomer's inventory arrived yet ? " + b2CCustomer.isGoodsArrived());
         storeObervable.update(true);
         System.out.println("After store updates....");
         System.out.println("B2BCustomer's inventory arrived yet ?" + b2BCustomer.isGoodsArrived());
         System.out.println("B2CCustomer's inventory arrived yet ?" +b2CCustomer.isGoodsArrived());

    }
}
