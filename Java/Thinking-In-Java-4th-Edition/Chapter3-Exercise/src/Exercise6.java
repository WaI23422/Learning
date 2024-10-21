// Modify the two test( ) methods in the previous two programs so that
// they take two extra arguments, begin and end, and so that testval is tested to see if it is
// within the range between (and including) begin and end. 


public class Exercise6 {
    // Test1 method:
    static int result = 0;
    static void test1(int testval, int target, int begin, int end) {
        if(testval > target){
            result = +1;
        }
        else if(testval < target){
            result = -1;
        }
        else{
            result = 0; // Match
        }

        if (result == 0 && testval >= begin && testval <= end ) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    } 
    // Test2 method:
    static int test2(int testval, int target, int begin, int end) {
        if(testval == target && testval >= begin && testval <= end){
            return +1;
        } else{
            return 0; // Match
        }
    } 
    public static void main(String[] args) {
        System.out.println("Exercise 6 Result: ");

        test1(1, 2, 0, 2);

        System.out.println(test2(1, 2, 0, 2));

        System.out.println("----------------------------------------------------");
    }
}
