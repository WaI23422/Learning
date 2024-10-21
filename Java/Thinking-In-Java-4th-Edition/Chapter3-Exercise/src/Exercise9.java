// A Fibonacci sequence is the sequence of numbers 1, 1, 2, 3, 5, 8, 13, 21,
// 34, and so on, where each number (from the third on) is the sum of the previous two. Create
// a method that takes an integer as an argument and displays that many Fibonacci numbers
// starting from the beginning, e.g., If you run java Fibonacci 5 (where Fibonacci is the
// name of the class) the output will be: 1, 1, 2, 3, 5. 
class myCal{
    public static void Fibonacci(int numbPresent){
        String res = "1";
        int sum = 0;
        int firstNumb = 0;
        int secondNumb = 1;

        for (int i = 1; i < numbPresent; i++) {
            sum = firstNumb + secondNumb;
            res = res + ", " + sum;

            firstNumb = secondNumb;
            secondNumb = sum;
        }

        System.out.println(res);
    }
}

public class Exercise9 {
    public static void main(String[] args) {
        System.out.println("Exercise 9 Result: ");

        myCal.Fibonacci(1);

        System.out.println("----------------------------------------------------");
    }
}
