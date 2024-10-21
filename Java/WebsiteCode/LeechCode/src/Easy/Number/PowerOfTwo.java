package Easy.Number;

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

// 0 ms 40.8 MB
class PowerOfTwo_Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {return false;}
        while (n>1) {
            if (n%2==1) { return false;}
            n/=2;
        }
        
        return true;
    }
}