// Write a program that demonstrates that, no matter how many objects
// you create of a particular class, there is only one instance of a particular static field in that
// class. 

/**
* Insert a list:
* <ol>
* <li> Item eight
* </ol>
*/

public class Exercise8 {
    static int staticValue = 10;
    public static void main(String[] args) {
        System.out.println("// Exercise 8 Result //");

        int object1 = staticValue;
        int object2 = staticValue;

        System.out.println("Instance object 1: "+ object1);
        System.out.println("Instance object 2: "+ object2);

        System.out.println("----------------------------------------------------");
    }
}
