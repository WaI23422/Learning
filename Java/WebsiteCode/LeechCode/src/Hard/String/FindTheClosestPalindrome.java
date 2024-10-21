package Hard.String;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/find-the-closest-palindrome/">564. Find the Closest Palindrome</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given a string <code>n</code> representing an integer, return <em>the closest integer (not including itself), which is a palindrome</em>. If there is a tie, return <em><strong>the smaller one</strong></em>.</p>
 * 
 * <p>The closest is defined as the absolute difference minimized between two integers.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> n = "123"
 * <strong>Output:</strong> "121"
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> n = "1"
 * <strong>Output:</strong> "0"
 * <strong>Explanation:</strong> 0 and 2 are the closest palindromes but we return the smallest which is 0.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= n.length &lt;= 18</code></li>
 * 	<li><code>n</code> consists of only digits.</li>
 * 	<li><code>n</code> does not have leading zeros.</li>
 * 	<li><code>n</code> is representing an integer in the range <code>[1, 10<sup>18</sup> - 1]</code>.</li>
 * </ul>
 * </div>
 */
public class FindTheClosestPalindrome {
    public static void main(String[] args) {
        String[] tests = {
            "121"
        };

        for (String n : tests) {
            System.out.println(new FindTheClosestPalindrome_Solution().nearestPalindromic(n));
        }
    }
}

// 2ms 41.49MB
class FindTheClosestPalindrome_Solution {
    public String nearestPalindromic(String n) {
        long ip = Long.valueOf(n);
        long small = smallest(String.valueOf(ip-1));
        long large = larger(String.valueOf(ip+1));
        if(large - ip < ip - small) return String.valueOf(large);
        else return String.valueOf(small);
        
    }

    private long larger(String n) {
        char[] data = n.toCharArray();
        int start = 0;
        int end = data.length-1;
        while(start < end) {
            while(data[start] != data[end]) {
                incrementNumber(data,end);
            }
            start++;
            end--;
        }
        return Long.parseLong(String.valueOf(data));
    }

    private long smallest(String n) {
        char[] data = n.toCharArray();
        int start = 0;
        int end = data.length-1;
        while(start < end) {
            while(data[start] != data[end]) {
                decrementNumber(data, end);
                if(data[0] == '0') return Long.parseLong(String.valueOf(data));
            }
            start++;
            end--;
        }
        return Long.parseLong(String.valueOf(data));
    }

    private void decrementNumber(char[] data, int i) {
        while(data[i] == '0') {
            data[i] = '9';
            i--;
        }
        data[i]--;
    }

    private void incrementNumber(char[] data, int i) {
        while(data[i] == '9') {
            data[i] = '0';
            i--;
        }
        data[i]++;
    }
}