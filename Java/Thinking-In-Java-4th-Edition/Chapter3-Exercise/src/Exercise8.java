// Create a switch statement that prints a message for each case, and put
// the switch inside a for loop that tries each case. Put a break after each case and test it,
// then remove the breaks and see what happens. 

public class Exercise8 {
    public static void main(String[] args) {
        System.out.println("Exercise 8 Result: ");
        
        for (int i = 0; i < 3; i++) {
            switch (i) {
                // If don't have break-statement case gonna go through every case 
                // until it meet a break statement.
                case 1:
                    System.out.println(i);
                    break;
                case 2:
                    System.out.println(i);
                    break;
                default:
                    System.out.println(0);
                    break;
            }
        }

        System.out.println("----------------------------------------------------");
    }
}
