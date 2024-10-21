package Exercise1;

abstract class Rodent {

    abstract void move();
    abstract void eat();
    abstract void sleep();

}

class Mouse extends Rodent {
    @Override void eat() {System.out.println("Mouse EATING");}
    @Override void move() {System.out.println("Mouse MOVING");}
    @Override void sleep() {System.out.println("Mouse SLEEPING");}
}

class Gerbil extends Rodent {
    @Override void eat() { System.out.println("Gerbil EATING"); }
    @Override void move() { System.out.println("Gerbil MOVING"); }
    @Override void sleep() { System.out.println("Gerbil SLEEPING"); }
}

class Hamster extends Rodent {
    @Override void eat() { System.out.println("Rodent EATING"); }
    @Override void move() { System.out.println("Rodent MOVING"); }
    @Override void sleep() { System.out.println("Rodent SLEEPING"); }
}

public class AbstracRodent {
    public static void main(String[] args) {
        Rodent[] animals = {
            new Mouse(),
            new Gerbil(),
            new Hamster()
        };

        for (Rodent rodent : animals) {
            rodent.move();
            rodent.eat();
            rodent.sleep();
        }
    }
}

