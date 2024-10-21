package Exercise9_12;

public class Hamster extends Rodent{

    public Hamster() {
        System.out.println("Create Hamster");
    }

    public void move() {
        System.out.println("Threw the Habitrail");
    }

    public void gnaw() {
        System.out.println("Threw the plastic.");
    }

    // 12: Adding dispose:
    public void dispose() {
        super.dispose();
        System.out.println("Dispose of Hamster");
    }
}
