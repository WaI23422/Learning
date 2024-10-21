// Modify the previous exercise so that the values of the data in DataOnly
// are assigned to and printed in main( ). 

/**
* Insert a list:
* <ol>
* <li> Item five
* </ol>
*/

public class Exercise5 {
    public static void main(String[] args) {
        System.out.println("// Exercise 5 Result //");

        DataOnly DATA = new DataOnly();

        DATA.i = 23;
        System.out.println("Integer: "+ DATA.i);
        
        DATA.d = 23.0;
        System.out.println("Double: "+DATA.d);

        DATA.b = true;
        System.out.println("Boolean: "+ DATA.b);

        System.out.println("----------------------------------------------------");
    }
}
