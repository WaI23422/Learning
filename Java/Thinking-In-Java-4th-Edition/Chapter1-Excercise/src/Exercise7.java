// Turn the Incrementable code fragments into a working program

/**
* Insert a list:
* <ol>
* <li> Item seven
* </ol>
*/

class StaticTest {
    static int i = 0;
} 

class Incrementable {
    static void increment() { 
        StaticTest.i++; 
    }
}

public class Exercise7 {
    public static void main(String[] args) {
        System.out.println("// Exercise 7 Result //");
        Incrementable.increment();

        System.out.println("Increst :"+ StaticTest.i);

        System.out.println("----------------------------------------------------");
    }
}
