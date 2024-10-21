package Exercise1_5;

public class Cycle {
    public Cycle() {}

    public void draw() {
        System.out.println("Draw a Cycle");
    }

    public void wheels(int i ) {
        System.out.println("Number of wheels: "+ i);
    }

    public void ride(Cycle c) {
        c.draw();
        c.wheels(0);
    }
}
