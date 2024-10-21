package Exercise1_5;

public class Bicycle extends Cycle {
    public Bicycle() {}

    @Override
    public void draw() {
        System.out.println("Draw a Bicycle");
    }

    public void ride(Cycle c) {
        c.draw();
        c.wheels(2);
    }

    public void balance() {
        System.out.println("Bicycle Balance");
    }
}
