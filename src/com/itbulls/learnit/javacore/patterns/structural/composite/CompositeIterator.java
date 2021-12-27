package com.itbulls.learnit.javacore.patterns.structural.composite;

import java.util.Iterator;
import java.util.Stack;

public class CompositeIterator implements Iterator<Shape> {

    Stack<Iterator> stack = new Stack();

    public CompositeIterator(Iterator<Shape> iterator){
           stack.push(iterator);
    }

    public boolean hasNext(){
        if(stack.empty()){
            return false;
        }
        else{
              Iterator iterator = stack.peek();
             if(!iterator.hasNext()){
                  stack.pop();
                  return hasNext();
             }
             else{
                 return true;
           }
        }
    }

    public Shape next(){
         if (hasNext()){
              Iterator<Shape> iterator = stack.peek();
               Shape shape = iterator.next();
               if ( shape instanceof CompoundShape ) {
                   Iterator<Shape> shapeIterator = shape.createIterator();
                   stack.push(shapeIterator);
                   return null;
               }

          return shape;
         }
         else{
              return null;
         }
    }
}
