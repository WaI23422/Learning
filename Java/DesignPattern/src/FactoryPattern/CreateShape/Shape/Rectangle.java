package FactoryPattern.CreateShape.Shape;

import FactoryPattern.CreateShape.Shape.Interface.Shape;

public class Rectangle implements Shape {

   @Override
   public void draw() {
      System.out.println("Inside Rectangle::draw() method.");
   }
}