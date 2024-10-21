class Dog1{
    public void bark(String name, int age){
        System.out.println("Bark");
    }

    public void bark(int age, String name){
        System.out.println("Howling");
    }
}
/**
 * <html>
 *     <head>
 *         <style TYPE="text/css">
 *              li {margin-bottom:2em;}
 *         </style>
 *     </head>
 *     <body>
 *         <ol>
 *              <li>Exercise 6: Modify the previous exercise so that two of the overloaded methods have two arguments (of two different types), but in reversed order relative to each other. Verify that this works.
 *              </li>
 *          </ol>
 *      </body>
 * </html>
 */
public class Exercise6 {
    public static void main(String[] args) {
        System.out.println("Exercise 6 Result: ");
        
        Dog1 dog = new Dog1();
        dog.bark(0, "0");
        dog.bark("0", 0);

        System.out.println("----------------------------------------------------");
    }
}
