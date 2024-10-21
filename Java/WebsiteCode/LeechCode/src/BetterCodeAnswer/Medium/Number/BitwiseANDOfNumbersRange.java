package BetterCodeAnswer.Medium.Number;

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

// 3ms 43.9 MB
class BitwiseANDOfNumbersRange_Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int count=0;
        while(left!=right){
            left>>=1;
            right>>=1;
            count++;
        }
        return left<<=count;
    }
}