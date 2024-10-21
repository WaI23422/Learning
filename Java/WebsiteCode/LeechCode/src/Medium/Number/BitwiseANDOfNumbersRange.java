package Medium.Number;

public class BitwiseANDOfNumbersRange {
    public static void main(String[] args) {
        int[][] tests = {
            {5,7},
            {0,0},
            {1,2147483647}
        };

        for (int[] test : tests) {
            int left = test[0], right = test[1];

            System.out.println(new BitwiseANDOfNumbersRange_Solution().rangeBitwiseAnd(left, right));
        }
    }
}

// Time Limit Exceed
class BitwiseANDOfNumbersRange_Solution {
    public int rangeBitwiseAnd(int left, int right) {
        for (int i = left; i < right; i++) {left &= i;}

        return left;
    }
}

// 3 ms 43.3 MB
class BitwiseANDOfNumbersRange_Solution2 {
    public int rangeBitwiseAnd(int left, int right) {
        while(right > left) {right &= (right-1);}

        return right;
    }
}