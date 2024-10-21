package Easy.Arrays;


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

// 0 ms 49.1 MB
class ReverseString_Solution {
    public void reverseString(char[] s) {
        int left = 0, right= s.length-1;

        while (left < right) {
            char replace = s[left];
            s[left++] = s[right];
            s[right--] = replace;
        }
    }
}
