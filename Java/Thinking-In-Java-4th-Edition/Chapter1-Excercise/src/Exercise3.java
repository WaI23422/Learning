// Find the code fragments involving ATypeName and turn them into a
// program that compiles and runs.

/**
* Insert a list:
* <ol>
* <li> Item three
* </ol>
*/

class ATypeName{
    int day;
    int month;
    int year;
}

public class Exercise3 {
    public static void main(String[] args) {
        System.out.println("// Exercise 3 Result //");

        ATypeName BirthDay = new ATypeName();

        BirthDay.day = 23;
        BirthDay.month = 4;
        BirthDay.year = 2002;

        System.out.println("Class run successfully");

        System.out.println("----------------------------------------------------");
    }
}
