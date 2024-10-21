package Exercise2_3_4.Polymorphism.Shape;
import static net.mindview.util.Print.*;

public class Rectangle extends Shape{
    public void draw() { print("Rectangle @Overide Shape draw(): Rectangle.draw()"); }
    public void erase() { print("Rectangle @Overide Shape erase(): Rectangle.erase()"); } 
}
