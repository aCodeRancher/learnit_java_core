package com.itbulls.learnit.javacore.patterns.structural.flyweight;

import java.awt.*;
import java.util.List;

@FunctionalInterface
public interface DrawObject<T> {

    void draw(Graphics g, List<T> objects);

}
