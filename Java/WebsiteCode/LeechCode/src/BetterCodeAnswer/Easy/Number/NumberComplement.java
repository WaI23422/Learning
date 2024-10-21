package BetterCodeAnswer.Easy.Number;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/number-complement/">476. Number Complement</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>The <strong>complement</strong> of an integer is the integer you get when you flip all the <code>0</code>'s to <code>1</code>'s and all the <code>1</code>'s to <code>0</code>'s in its binary representation.</p>
 * 
 * <ul>
 * 	<li>For example, The integer <code>5</code> is <code>"101"</code> in binary and its <strong>complement</strong> is <code>"010"</code> which is the integer <code>2</code>.</li>
 * </ul>
 * 
 * <p>Given an integer <code>num</code>, return <em>its complement</em>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> num = 5
 * <strong>Output:</strong> 2
 * <strong>Explanation:</strong> The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> num = 1
 * <strong>Output:</strong> 0
 * <strong>Explanation:</strong> The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= num &lt; 2<sup>31</sup></code></li>
 * </ul>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Note:</strong> This question is the same as 1009: <a href="https://leetcode.com/problems/complement-of-base-10-integer/" target="_blank">https://leetcode.com/problems/complement-of-base-10-integer/</a></p>
 * </div>
 */
public class NumberComplement {
    public static void main(String[] args) {
        int[] tests = {
            5,
            1
        };

        for (int num : tests) {
            System.out.println(new NumberComplement_Solution().findComplement(num));
        }
    }
}

// 0 ms 40.5 MB
class NumberComplement_Solution {
    public int findComplement(int num) {
        int shift=0,ans=0;
        while((num>>shift)>0){
            if(((num>>shift)&1)==0){
                ans=ans+(1<<shift);
            }
            shift+=1;
        }
        return ans;
        
    }
}

// 1 ms 40 MB
class NumberComplement_Solution2 {
    public int findComplement(int num) {
        return Integer.valueOf(toComplementBinary(new StringBuilder(), num), 2);
    }

    public String toComplementBinary(StringBuilder binary, int n) {
        if (n == 0) return binary.reverse().toString();
        return toComplementBinary(binary.append((n%2)^1), n/2);
    }
}