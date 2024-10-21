package Exercise1_5;

public class Tricycle extends Cycle{
    public Tricycle() {}

    @Override
    public void draw() {
        System.out.println("Draw a Tricycle");
    }

    public void ride(Cycle c) {
        c.draw();
        c.wheels(3);
    }
}
