// Write a program that prints three arguments taken from the command
// line. To do this, you’ll need to index into the command-line array of Strings. 

/**
* Insert a list:
* <ol>
* <li> Item ten
* </ol>
*/

public class Exercise10 {
    public static void main(String[] args) {
        System.out.println("// Exercise 10 Result //");

        try {
            System.out.println("the first argument is : " + args[0]);
            System.out.println("the second argument is : " + args[1]);
            System.out.println("the third argument is : " + args[2]);
        } catch (Exception e) {
            System.out.println("the first argument is : " + null);
            System.out.println("the second argument is : " + null);
            System.out.println("the third argument is : " + null);
        }

        System.out.println("----------------------------------------------------");
    }
}
