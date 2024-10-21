import static net.mindview.util.Print.*;
/**
 * <html>
 *     <head>
 *         <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *     </head>
 *     <body>
 *         Exercise 2:  Inherit a new class from class Detergent. Override scrub( ) and add a new method called sterilize( ).  
 *      </body>
 * </html>
 */
public class Exercise2{
    public static void main(String[] args) {
        System.out.println("Exercise 2 Result: ");

        Tide.main(args);

        System.out.println("----------------------------------------------------");
    }
}

class Cleanser {
    private String s = "Cleanser";
    public void append(String a) { s += a; }
    public void dilute() { append(" dilute()"); }
    public void apply() { append(" apply()"); }
    public void scrub() { append(" scrub()"); }
    public String toString() { return s; }
    public static void main(String[] args) {
        Cleanser x = new Cleanser();
        x.dilute(); x.apply(); x.scrub();
        print(x);
    }
}
class Detergent extends Cleanser {
    // Change a method:
    public void scrub() {
        append(" Detergent.scrub()");
        super.scrub(); // Call base-class version
    }
    public void foam() { append(" foam()"); }
    // Test the new class:
    public static void main(String[] args) {
        Detergent x = new Detergent();
        x.dilute();
        x.apply();
        x.scrub();
        x.foam();
        print(x);
        print("Testing base class:");
        Cleanser.main(args);
    }
} 

class Tide extends Detergent {
    @Override 
    public void scrub() {
        append(" Tide.Detergent.scrub()");
    }

    public void sterilize( ) { append(" sterilize( ) "); }

    public static void main(String[] args) {
        Tide x = new Tide();
        
        x.dilute();
        x.apply();
        x.scrub();
        x.scrub();
        x.foam();
        x.sterilize();
        print(x);
        print("Testign Detergent class:");
        Detergent.main(args);
        print("Testing base class:");
        Cleanser.main(args);
    }
    
}