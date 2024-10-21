//Run Documentation1.java, Documentation2.java, and
//Documentation3.java through Javadoc. Verify the resulting documentation with your
//Web browser. 

//: object/Documentation1.java
/** A class comment */
class Documentation1 {
    /** A field comment */
    public int i;
    /** A method comment */
    public void f() {}
} ///:~ 

//: object/Documentation2.java
/**
* <pre>
* System.out.println(new Date());
* </pre>
*/
///:~ 

//: object/Documentation3.java
/**
* You can <em>even</em> insert a list:
* <ol>
* <li> Item one
* <li> Item two
* <li> Item three
* </ol>
*/
///:~ 

public class Exercise13 {
    public static void main(String[] args) {
        System.out.println("// Exercise 13 Result //");

        System.out.println("Excute code in cmd: javadoc Exercise13.java");
        
        System.out.println("View result: C:\\Users\\ADMIN\\Documents\\Programming\\Java Code\\Excercise\\Chapter1-Excercise\\src\\Exercise13.html ");

        System.out.println("----------------------------------------------------");
    }
}
