// Create a class called Dog containing two Strings: name and says. In
// main( ), create two dog objects with names “spot” (who says, “Ruff!”) and “scruffy” (who
// says, “Wurf!”). Then display their names and what they say. 
class Dog {
    String name;
    String says;
}

public class Exercise5 {
    public static void main(String[] args) {
        System.out.println("Exercise 5 Result: ");
        Dog dog1 = new Dog();
        dog1.name = "spot";
        dog1.says = "Ruff!";
        
        Dog dog2 = new Dog();
        dog2.name = "scruffy";
        dog2.says = "Wurf!";

        System.out.println("First Dog Name: "+dog1.name + "| says: "+dog1.says);
        System.out.println("First Dog Name: "+dog2.name + "| says: "+dog2.says);
        
        System.out.println("----------------------------------------------------");
    }
}
