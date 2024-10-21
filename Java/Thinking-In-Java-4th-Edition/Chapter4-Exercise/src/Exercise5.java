class Dog{
    public void bark(){
        System.out.println("Bark");
    }

    public void bark(int i){
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
 *              <li>Exercise 5: Create a class called Dog with an overloaded bark( ) method. This method should be overloaded based on various primitive data types, and print different types of barking, howling, etc., depending on which overloaded version is called. Write a main( ) that calls all the different versions.
 *              </li>
 *          </ol>
 *      </body>
 * </html>
 */
public class Exercise5 {
    public static void main(String[] args) {
        System.out.println("Exercise 5 Result: ");

        Dog dog = new Dog();
        dog.bark();
        dog.bark(0);

        System.out.println("----------------------------------------------------");
    }
}
