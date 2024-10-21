package Exercise9_12;

public class Mouse extends Rodent{
    public Mouse() {
        System.out.println("Create Mouse");
    }

    public void move() {
        System.out.println("Into Hiding.");
    }

    public void gnaw() {
        System.out.println("Into the wall.");
    }

    // 12: Adding dispose:
    public void dispose() {
        super.dispose();
        System.out.println("Dispose of Mouse");
    }
}
