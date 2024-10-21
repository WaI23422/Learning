package Exercise9_12;

public class Rodent {
    private int refcount = 0;
    private static long counter = 0;

    public Rodent() {
        counter++;
        System.out.println("Create Rodent " +counter );
    }

    public void move() {}

    public void gnaw() {}

    // 12: Adding dispose:
    public void dispose() {
        System.out.println("Dispose of Rodent");
        refcount--;
    }

}
