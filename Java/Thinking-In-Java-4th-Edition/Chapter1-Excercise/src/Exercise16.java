//In the Initialization & Cleanup chapter, locate the Overloading.java
//example and add Javadoc documentation. Extract this comment documentation into an
//HTML file using Javadoc and view it with your Web browser.
/** My brain hurt
 * Displays a string and today’s date.
 * @author Me
 * @author Still Me
 * @version 1.0 
 */

class Tree {
    /**
     * The height of the tree.
     */
    int height;
    /**
     * Constructs a new tree seedling.
     */
    Tree() {
        System.out.println("Planting a seedling");
        height = 0;
    }
    /**
     * Constructs a new tree with the specified height.
     *
     * @param initialHeight The initial height of the tree.
     */
    Tree(int initialHeight) {
        height = initialHeight;
        System.out.println("Creating new Tree that is " +
        height + " feet tall"); 
    }
    /**
     * Prints information about the tree.
     */   
    void info() {
        System.out.println("Tree is " + height + " feet tall");
    }
    /**
     * Prints information about the tree, with a prefix.
     *
     * @param s The prefix to print.
     */
    void info(String s) {
        System.out.println(s + ": Tree is " + height + " feet tall");
    }
} 

/**
 * This class demonstrates the use of method overloading.
 */
class Overloading {
    /**
     * The main method.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        for(int i = 0; i < 5; i++) {
            Tree t = new Tree(i);
            t.info();
            t.info("overloaded method");
        }
        // Overloaded constructor:
        new Tree();
    }
} 

public class Exercise16 {
    public static void main(String[] args) {
        System.out.println("// Exercise 16 Result //");

        System.out.println("Done");

        System.out.println("----------------------------------------------------");
    }
}
