// Turn the DataOnly code fragments into a program that compiles and
// runs.

/**
* Insert a list:
* <ol>
* <li> Item four
* </ol>
*/

class DataOnly {
    int i;
    double d;
    boolean b;
} 

public class Exercise4 {
    public static void main(String[] args) {
        System.out.println("// Exercise 4 Result //");

        DataOnly DATA = new DataOnly();

        DATA.i = 23;
        DATA.d = 23.0;
        DATA.b = true;

        System.out.println("Class run successfully");

        System.out.println("----------------------------------------------------");
    }
}
