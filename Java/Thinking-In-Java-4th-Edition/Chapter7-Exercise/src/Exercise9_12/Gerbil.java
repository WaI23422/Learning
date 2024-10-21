package Exercise9_12;

public class Gerbil extends Rodent {

    public Gerbil() {
        System.out.println("Create Gerbil");
    }

    public void move() {
        System.out.println("To the pellet dish");
    }

    public void gnaw() {
        System.out.println("Into the pellets.");
    }

    // 12: Adding dispose:
    public void dispose() {
        super.dispose();
        System.out.println("Dispose of Gerbil");
    }
}