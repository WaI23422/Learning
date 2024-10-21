package Exercise2_3_4.Polymorphism.Shape;
import static net.mindview.util.Print.*;

public class Triangle extends Shape {
    public void draw() { print("Triangle @Overide Shape draw(): Triangle.draw()"); }
    public void erase() { print("Triangle @Overide Shape erase(): Triangle.erase()"); }
}
