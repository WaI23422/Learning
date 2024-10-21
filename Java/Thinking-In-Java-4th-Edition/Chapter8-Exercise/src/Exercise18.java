/**
 * <html>
 *     <head>
 *         <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *     </head>
 *     <body>
 *         Exercise 18: Create a Cycle interface, with implementations Unicycle, Bicycle and Tricycle. Create factories for each type of Cycle, and code that uses these factories.
 *      </body>
 * </html>
 */
public class Exercise18 {
    static void testRide(CycleFactory f) {
        Cycle c = f.getCycle();
        c.ride();
    }

    public static void main(String[] args) {
        System.out.println("Exercise 18 Result: ");

        testRide(new UnicycleFactory());
        testRide(new BicycleFactory());
        testRide(new TricycleFactory());

        System.out.println("----------------------------------------------------");
    }
}

interface Cycle {
    int wheels();
    void ride();
}

class Unicycle implements Cycle {
    public int wheels() { return 1; }
    public void ride() { System.out.println("Unicycle.ride() on " + wheels() + " wheel(s)"); }
}

class Bicycle implements Cycle {
    public int wheels() { return 2; }
    public void ride() { System.out.println("Bicycle.ride() on " + wheels() + " wheel(s)"); }
}

class Tricycle implements Cycle {
    public int wheels() { return 3; }
    public void ride() { System.out.println("Tricycle.ride() on " + wheels() + " wheel(s)"); }
}

interface CycleFactory {
    Cycle getCycle();
}

class UnicycleFactory implements CycleFactory {
    public Cycle getCycle() {return new Unicycle(); }
}

class BicycleFactory implements CycleFactory {
    public Cycle getCycle() {return new Bicycle(); }
}

class TricycleFactory implements CycleFactory {
    public Cycle getCycle() {return new Tricycle(); }
}
