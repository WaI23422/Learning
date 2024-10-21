// Display the largest and smallest numbers for both float and double
// exponential notation.

public class Exercise9 {
    public static void main(String[] args) {
        System.out.println("Exercise 9 Result: ");
        
        float maxFloat = Float.MAX_VALUE;
        float minFloat = Float.MIN_VALUE;
        System.out.println("Float Largest Use Exponential Notation: "+ maxFloat);
        System.out.println("Float Smallest Use Exponential Notation: "+ minFloat);

        double maxDouble = Double.MAX_VALUE;
        double minDouble = Double.MIN_VALUE;
        
        System.out.println("Double Largest Use Exponential Notation: "+ maxDouble);
        System.out.println("Double Smallest Use Exponential Notation: "+ minDouble);

        System.out.println("----------------------------------------------------");
    }    
}
