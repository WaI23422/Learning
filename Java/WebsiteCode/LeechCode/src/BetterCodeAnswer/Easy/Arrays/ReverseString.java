package BetterCodeAnswer.Easy.Arrays;

import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) {
        char[][] tests = {
            {'h','e','l','l','o'},
            {'h','e','l','l','o','o'},
        };

        for (char[] s : tests) {
            new ReverseString_Solution().reverseString(s);
            System.out.println(Arrays.toString(s));
        }
    }   
}

// 0 ms 45.2 MB
class ReverseString_Solution {
    public void reverseString(char[] s) {
        char temp;
        for(int i = 0; i < s.length / 2; i++) {
            temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
    }
}