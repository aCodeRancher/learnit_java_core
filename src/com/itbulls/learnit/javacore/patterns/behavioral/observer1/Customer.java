package com.itbulls.learnit.javacore.patterns.behavioral.observer1;

public class Customer {
    private boolean isGoodsArrived = false;

    public boolean isGoodsArrived() {

        return isGoodsArrived;
    }

    public void setGoodsArrived(boolean goodsArrived) {
        isGoodsArrived = goodsArrived;
    }
}
