package com.itbulls.learnit.javacore.patterns.structural.composite;

import java.awt.*;
import java.util.Iterator;

public interface Shape {
    public int getX();
    public int getY();
    public int getWidth();
    public int getHeight();
    public void move(int x, int y);
    public Boolean isInsideBounds(int x, int y);
    public void select();
    public void unSelect();
    public Boolean isSelected();
    public void paint(Graphics graphics);
    public Iterator<Shape> createIterator();
}
