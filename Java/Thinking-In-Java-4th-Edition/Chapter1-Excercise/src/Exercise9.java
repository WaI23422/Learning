// Write a program that demonstrates that autoboxing works for all the
// primitive types and their wrappers. 


/**
* Insert a list:
* <ol>
* <li> Item nine
* </ol>
*/

public class Exercise9 {
    
    static Integer boxedInteger = 10; 
    static Double boxedDouble = 3.14; 
    static Boolean boxedBoolean = true; 
    static Character boxedCharacter = 'c'; 
    static Byte boxedByte = 10; 
    static Short boxedShort = 10; 
    static Long boxedLong = 10l; 
    static Float boxedFloat = 3.14f; 
    public static void main(String[] args) {
        System.out.println("// Exercise 9 Result //");

        System.out.println("Autoboxing of Integer: "+ boxedInteger); 
        System.out.println("Autoboxing of Double: "+ boxedDouble); 
        System.out.println("Autoboxing of Boolean: "+ boxedBoolean); 
        System.out.println("Autoboxing of Character: "+ boxedCharacter);
        System.out.println("Autoboxing of Byte: "+ boxedByte); 
        System.out.println("Autoboxing of Short: "+ boxedShort); 
        System.out.println("Autoboxing of Long: "+ boxedLong); 
        System.out.println("Autoboxing of Float: "+ boxedFloat); 

        System.out.println("----------------------------------------------------");
    }
}
