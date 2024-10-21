
class MyClass1 {
    private String stringRef1 = "This is a string reference initialized at the point of definition.";

    public MyClass1() {
        // The stringRef1 reference is already initialized.
    }

    public void printStringRef1() {
        System.out.println(stringRef1);
    }
}

class MyClass2 {
    private String stringRef2;

    public MyClass2() {
        stringRef2 = "This is a string reference initialized by the constructor.";
    }

    public void printStringRef2() {
        System.out.println(stringRef2);
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
 *              <li>Exercise 2: Create a class with a String field that is initialized at the point of definition, and another one that is initialized by the constructor. What is the difference between the two approaches?
 *              </li>
 *          </ol>
 *      </body>
 * </html>
 */
public class Exercise2 {
    public static void main(String[] args) {
        System.out.println("Exercise 2 Result: ");
        
        MyClass1 myClass1 = new MyClass1();
        MyClass2 myClass2 = new MyClass2();

        myClass1.printStringRef1();
        myClass2.printStringRef2();

        System.out.println("----------------------------------------------------");
    }
}
