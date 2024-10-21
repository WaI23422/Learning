// Modify Exercise 1 so that the program exits by using the break keyword
// at value 99. Try using return instead. 

public class Exercise7 {
    public static void main(String[] args) {
        System.out.println("Exercise 7 Result: ");

        for (int i = 0; i < 100; i++) {
            System.out.println(i+1);
            if (i == 98) {
                break;
            }
        }

        for (int i = 0; i < 100; i++) {
            System.out.println(i+1);
            if (i == 98) {
                return ;
            }
        }
        
        System.out.println("----------------------------------------------------");
    }
}
