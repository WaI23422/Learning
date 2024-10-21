package Medium.Number;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/find-kth-bit-in-nth-binary-string/">1545. Find Kth Bit in Nth Binary String</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>Given two positive integers <code>n</code> and <code>k</code>, the binary string <code>S<sub>n</sub></code> is formed as follows:</p>
 * 
 * <ul>
 * 	<li><code>S<sub>1</sub> = "0"</code></li>
 * 	<li><code>S<sub>i</sub> = S<sub>i - 1</sub> + "1" + reverse(invert(S<sub>i - 1</sub>))</code> for <code>i &gt; 1</code></li>
 * </ul>
 * 
 * <p>Where <code>+</code> denotes the concatenation operation, <code>reverse(x)</code> returns the reversed string <code>x</code>, and <code>invert(x)</code> inverts all the bits in <code>x</code> (<code>0</code> changes to <code>1</code> and <code>1</code> changes to <code>0</code>).</p>
 * 
 * <p>For example, the first four strings in the above sequence are:</p>
 * 
 * <ul>
 * 	<li><code>S<sub>1 </sub>= "0"</code></li>
 * 	<li><code>S<sub>2 </sub>= "0<strong>1</strong>1"</code></li>
 * 	<li><code>S<sub>3 </sub>= "011<strong>1</strong>001"</code></li>
 * 	<li><code>S<sub>4</sub> = "0111001<strong>1</strong>0110001"</code></li>
 * </ul>
 * 
 * <p>Return <em>the</em> <code>k<sup>th</sup></code> <em>bit</em> <em>in</em> <code>S<sub>n</sub></code>. It is guaranteed that <code>k</code> is valid for the given <code>n</code>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> n = 3, k = 1
 * <strong>Output:</strong> "0"
 * <strong>Explanation:</strong> S<sub>3</sub> is "<strong><u>0</u></strong>111001".
 * The 1<sup>st</sup> bit is "0".
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> n = 4, k = 11
 * <strong>Output:</strong> "1"
 * <strong>Explanation:</strong> S<sub>4</sub> is "0111001101<strong><u>1</u></strong>0001".
 * The 11<sup>th</sup> bit is "1".
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= n &lt;= 20</code></li>
 * 	<li><code>1 &lt;= k &lt;= 2<sup>n</sup> - 1</code></li>
 * </ul>
 * </div></div>
 */
public class FindKthBitInNthBinaryString {
    public static void main(String[] args) {
        int[][] tests = {
            {3,5},
            {4,11},
            {3,1}
        };

        for (int[] test : tests) {
            int n = test[0],
                k = test[1];

            System.out.println(new FindKthBitInNthBinaryString_Solution().findKthBit(n, k));
        }
    }
}

// Brute-Force: 111ms 47.05MB
class FindKthBitInNthBinaryString_Solution {
    public char findKthBit(int n, int k) {
        StringBuilder str = new StringBuilder("0");
    
        for (int i = 1; i < n; i++) {
            StringBuilder inverse_str = inverse(str);
            str.append('1').append(inverse_str.reverse());
        }

        return str.charAt(k-1);
    }

    private StringBuilder inverse(StringBuilder str) {
        int len = str.length();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < len;i++) {
            if (str.charAt(i) == '1') {
                temp.append('0');
            } else {
                temp.append('1');
            }
        }
        return temp;
    }
}