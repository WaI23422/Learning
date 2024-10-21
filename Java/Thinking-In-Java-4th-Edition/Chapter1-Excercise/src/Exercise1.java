// Create a class containing an int and a char that are not initialized, and
// print their values to verify that Java performs default initialization. 
/**
* Insert a list:
* <ol>
* <li> Item one
* </ol>
*/

class IntChar{
    int IntegerNumber;
    char Char;
}

public class Exercise1 {
    public static void main(String[] args) {
        System.out.println("----------------------------------------------------");
        System.out.println("// Exercise 1 Result //");

        IntChar ObjectTest = new IntChar();
        
        ObjectTest.IntegerNumber = 23;
        ObjectTest.Char = 'T';
        
        System.out.println("Class run successfully");

        System.out.println("----------------------------------------------------");
    }
}