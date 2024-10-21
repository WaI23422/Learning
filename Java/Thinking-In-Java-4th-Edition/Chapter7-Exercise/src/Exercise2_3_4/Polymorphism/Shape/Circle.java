package Exercise2_3_4.Polymorphism.Shape;
import static net.mindview.util.Print.*; 

public class Circle extends Shape{
    public void draw() { print("Circle @Overide Shape draw(): Circle.draw()"); }
    public void erase() { print("Circle @Overide Shape erase(): Circle.erase()"); } 
}
