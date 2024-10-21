// Following Exercise 5, create a new Dog reference and assign it to spot’s
// object. Test for comparison using == and equals( ) for all references. 

class AnotherDog {
    String name;
    String says;
}
public class Exercise6 {
    public static void main(String[] args) {
        System.out.println("Exercise 6 Result: ");
        AnotherDog dog1 = new AnotherDog();
        AnotherDog dog2 = new AnotherDog();
        dog1.name = dog2.name = "spot";
        dog1.says = dog2.says = "Ruff!";
        
        System.out.println("Check equal of two references: ");
        System.out.println("Compare using '==' : " + (dog1==dog2));

        System.out.println("Compare using 'equals()' : " + dog1.equals(dog2));

        System.out.println("The result is false. This is because the default behavior of equals( ) is to compare references.");
        System.out.println("----------------------------------------------------");
    }
}
