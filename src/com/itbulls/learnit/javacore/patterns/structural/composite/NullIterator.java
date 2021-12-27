package com.itbulls.learnit.javacore.patterns.structural.composite;

import java.util.Iterator;

public class NullIterator implements Iterator<Shape> {

    public boolean hasNext(){
        return false;

    }

    public Shape next(){
        return null;
    }
}
