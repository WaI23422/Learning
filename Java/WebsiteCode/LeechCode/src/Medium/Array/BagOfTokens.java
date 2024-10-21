package Medium.Array;

import java.util.Arrays;

public class BagOfTokens {
    public static void main(String[] args) {
        int[][][] tests = {
            {{100,200,300,400},{200}},
            {{100},{50}},
            {{200,100,300,100,50},{50}},
            {{71,55,82},{54}}
        };

        for (int[][] test : tests) {
            int[] tokens = test[0];
            int power = test[1][0]; 

            System.out.println(new BagOfTokens_Solution().bagOfTokensScore(tokens, power));;
        }
    }
}

// 2 ms 42.7 MB
class BagOfTokens_Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);

        int left = 0, 
            right = tokens.length-1, 
            max = 0;
        
        while (left <= right) {
            if (power >= tokens[left]) {
                max++;
                power -= tokens[left++];
            } else {
                if (right - left > 1 && max > 0) {
                    max--;
                    power += tokens[right--];
                } else {
                    return max;
                }
            }
        }

        return max;
    }
}