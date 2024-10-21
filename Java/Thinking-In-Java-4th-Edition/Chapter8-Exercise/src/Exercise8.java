/**
 * <html>
 *     <head>
 *         <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *     </head>
 *     <body>
 *         Exercise 8: In polymorphism.Sandwich.java, create an interface called FastFood (with appropriate methods) and change Sandwich so that it also implements FastFood
 *      </body>
 * </html>
 */
public class Exercise8 {
    private Bread b = new Bread();
    private Cheese c = new Cheese();
    private Lettuce l = new Lettuce();

    public Exercise8() { System.out.println("Sandwich()"); }
    public static void main(String[] args) { 
        System.out.println("Exercise 8 Result: ");

        Exercise8 sandwich = new Exercise8();
        Sandwich sandwich2 = new Sandwich();

        sandwich2.sandwichIsDone();

        System.out.println("----------------------------------------------------");
    }
}

interface FastFood {
    void sandwichIsDone();
}

class Sandwich implements FastFood {
    public void sandwichIsDone() {
        System.out.println("Your sandwich is ready!");
    }
}

class Meal {
    Meal() { System.out.println("Meal()"); }
}

class Bread {
    Bread() { System.out.println("Bread()"); }
}

class Cheese {
    Cheese() { System.out.println("Cheese()"); }
}

class Lettuce {
    Lettuce() { System.out.println("Lettuce()"); }
}

class Lunch extends Meal {
    Lunch() { System.out.println("Lunch()"); }
}

class PortableLunch extends Lunch {
    PortableLunch() { System.out.println("PortableLunch()");}
}