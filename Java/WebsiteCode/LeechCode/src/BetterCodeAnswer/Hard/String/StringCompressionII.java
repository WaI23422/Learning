package BetterCodeAnswer.Hard.String;

import java.util.Arrays;

public class StringCompressionII {
    public static void main(String[] args) {
        Object[][][] tests = {
            {{"aaabcccd"},{2}},
            {{"aabbaa"},{2}},
            {{"aaaaaaaaaaa"},{0}}
        }; 

        for (Object[][] test : tests) {
            String s  = test[0][0].toString();
            int k = Integer.parseInt(test[1][0].toString());

            System.out.println(new StringCompressionII_Solution().getLengthOfOptimalCompression(s, k));
        }
    }
}

// 24 ms 42.5 MB
class StringCompressionII_Solution {
    private int[][] dp;
    private char[] chars;
    private int n;
    
    public int getLengthOfOptimalCompression(String s, int k) {
        this.chars = s.toCharArray();
        this.n = s.length();
        this.dp = new int[n][k+1];
        for (int[] row: dp) {
            Arrays.fill(row, -1);
        }
        return dp(0, k);
    }
    
    private int dp(int i, int k) {
        if (k < 0) return n;
        if (n <= i + k) return 0;
        
        int result = dp[i][k];
        if (result != -1) return result; 
        result = dp(i + 1, k - 1);
        int length = 0, same = 0, diff = 0;
        
        for (int j=i; j < n && diff <= k; j++) {
            
            if (chars[j] == chars[i]) {
                same++;
                if (same <= 2 || same == 10 || same == 100) length++;
            } else {
                diff++; 
            }
            result = Math.min(result, length + dp(j + 1, k - diff)); 
        }
        dp[i][k] = result;
        return result;
    }
}