/**
 * <html>
 *     <head>
 *         <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *     </head>
 *     <body>
 *         Exercise 7: Change Exercise 9 in the Polymorphism chapter so that Rodent is an interface
 *      </body>
 * </html>
 */
public class Exercise7 {
    public static void main(String[] args) { 
        System.out.println("Exercise 7 Result: ");
        
        Rodent[] animals = {
            new Mouse(),
            new Gerbil(),
            new Hamster()
        };

        for (Rodent r : animals) {
            r.move();
            r.eat();
            r.sleep();
        }

        System.out.println("----------------------------------------------------");
    }
}

interface Rodent {
    void move();
    void eat();
    void sleep();
}

class Mouse implements Rodent {
    public void move() { System.out.println("Mouse moves"); }
    public void eat() { System.out.println("Mouse eats"); }
    public void sleep() { System.out.println("Mouse sleeps"); }
}

class Gerbil implements Rodent {
    public void move() { System.out.println("Gerbil moves"); }
    public void eat() { System.out.println("Gerbil eats"); }
    public void sleep() { System.out.println("Gerbil sleeps"); }
}

class Hamster implements Rodent {
    public void move() { System.out.println("Hamster moves"); }
    public void eat() { System.out.println("Hamster eats"); }
    public void sleep() { System.out.println("Hamster sleeps"); }
}
