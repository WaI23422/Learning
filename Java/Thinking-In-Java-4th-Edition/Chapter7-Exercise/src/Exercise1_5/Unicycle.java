package Exercise1_5;

public class Unicycle extends Cycle {
    public Unicycle() {}

    @Override
    public void draw() { 
        System.out.println("Draw a Unicycle");
    }

    public void ride(Cycle c) {
        c.draw();
        c.wheels(1);
    }

    public void balance() {
        System.out.println("Unicycle Balance");
    }
}
