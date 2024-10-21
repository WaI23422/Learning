package Hard.String;

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

// @see BetterCodeAnswer.Hard.String.StringCompressionII.java
class StringCompressionII_Solution {
    public int getLengthOfOptimalCompression(String s, int k) {
        return 0;
    }
}
