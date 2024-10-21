package BetterCodeAnswer.Easy.Number;

public class PowerOfTwo {
    public static void main(String[] args) {
        int[] tests = {
            1,
            -3,
            16,
            5,
            -2,
            0
        };

        for (int n : tests) {
            System.out.println(new PowerOfTwo_Solution().isPowerOfTwo(n));
        }
    }   
}

class PowerOfTwo_Solution {
    public boolean isPowerOfTwo(int n) {
        return (n<=0) ? false : (n&n-1) ==0;
    }
}