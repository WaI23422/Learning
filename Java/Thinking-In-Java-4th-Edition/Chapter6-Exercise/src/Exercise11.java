/**
 * <html>
 *     <head>
 *         <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *     </head>
 *     <body>
 *         Exercise 11: Modify Detergent.java so that it uses delegation.
 *      </body>
 * </html>
 */
public class Exercise11 {
    public static void main(String[] args) {
        System.out.println("Exercise 11 Result: ");
        
        Detergent_11 detergent_11 = new Detergent_11();

        detergent_11.scrub();
        detergent_11.apply();
        detergent_11.dilute();
        detergent_11.foam();

        System.out.println(detergent_11.toString());

        System.out.println("----------------------------------------------------");
    }
}

class Detergent_11{
    Cleanser cleanser = new Cleanser();

    @Override
    public String toString() {
        return cleanser.toString();
    }

    public void append(String a) {
        cleanser.append(a);
    }

    public void scrub() {
        append(" Detergent.scrub()");
        cleanser.scrub();
    }

    public void apply() {
        cleanser.apply();
    }

    public void dilute() {
        cleanser.dilute();
    }

    public void foam() {
        append(" foam()");
    }
}