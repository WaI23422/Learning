package Easy.Number;

/**
 * 
 */
public class NumberOfOneBits {
    public static void main(String[] args) {
        int[] tests = {
            // 1, 
            // 2,
            // 3,
            // 16,
            120
        };

        for (int n : tests) {
            System.out.println(new NumberOfOneBits_Solution().hammingWeight(n));
        }
    }
}

class NumberOfOneBits_Solution2 {
    // Error in Leet
    public int hammingWeight(int n) {
        return n==0 ? 0 : (n&1) + hammingWeight(n>>1);
    }
}

class NumberOfOneBits_Solution {
    // Time Limit Exceed
    public int hammingWeight(int n) {
        int res = 0;

        while (n!= 0){
            res += n&1;
            n >>= 1;
        }
        
        return res;
    }
}