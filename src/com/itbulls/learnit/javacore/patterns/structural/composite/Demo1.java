package com.itbulls.learnit.javacore.patterns.structural.composite;

import java.awt.*;
import java.util.Iterator;

public class Demo1 {
    public static void main(String[] args) {

        CompoundShape compoundShape =  new CompoundShape(
                        new Circle(110, 110, 50, Color.RED),
                        new Dot(160, 160, Color.RED),
                        new Circle(220,220,50,Color.cyan)

         );

        CompoundShape compoundShape1 = new CompoundShape( new Rectangle (1,1,1,1,Color.cyan), new CompoundShape( compoundShape));
        Iterator<Shape> iterator1 = compoundShape1.createIterator();
         while (iterator1.hasNext()){
             Shape shape = iterator1.next();
             if (shape !=null)
                 System.out.println(shape.getX() + "," + shape.getY());

         }

    }
}
