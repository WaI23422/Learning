package Exercise15.Polymorphism;
import static net.mindview.util.Print.*;

class Glyph {
    void draw() { print("Glyph.draw()"); }
    Glyph() {
        print("Glyph() before draw()");
        draw();
        print("Glyph() after draw()");
    }
}

class RoundGlyph extends Glyph {
    private int radius = 1;
    RoundGlyph(int r) {
        radius = r;
        print("RoundGlyph.RoundGlyph(), radius = " + radius);
    }
    void draw() {
        print("RoundGlyph.draw(), radius = " + radius);
    }
}

class RectangularGlyph extends Glyph{
    private int width = 2;
    private int length = 3;

    public RectangularGlyph(int width, int length) {
        this.width = width;
        this.length = length;
        System.out.println("RectangleGlyph.draw(), width = " + this.width);
        System.out.println("RectangleGlyph.draw(), length = " + this.length);
    }

    public void draw() {
        System.out.println("RectangleGlyph.draw(), width = " + width);
        System.out.println("RectangleGlyph.draw(), length = " + length);
    }
}

public class PolyConstructors {
    public static void main(String[] args) { 
        new RoundGlyph(5); 
        new RectangularGlyph(4, 5);
    }
}
