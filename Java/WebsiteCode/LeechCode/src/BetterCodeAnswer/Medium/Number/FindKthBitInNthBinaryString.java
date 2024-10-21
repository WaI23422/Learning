package BetterCodeAnswer.Medium.Number;

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

// 0ms 40.82MB
class FindKthBitInNthBinaryString_Solution {

    public char findKthBit(int n, int k) {
        // Base case: for S1, return '0'
        if (n == 1) return '0';

        // Calculate the length of Sn
        int len = 1 << n; // Equivalent to 2^n

        // If k is in the first half of the string, recurse with n-1
        if (k < len / 2) {
            return findKthBit(n - 1, k);
        }
        // If k is exactly in the middle, return '1'
        else if (k == len / 2) {
            return '1';
        }
        // If k is in the second half of the string
        else {
            // Find the corresponding bit in the first half and invert it
            char correspondingBit = findKthBit(n - 1, len - k);
            return (correspondingBit == '0') ? '1' : '0';
        }
    }
}

// 0ms 40.52MB
class FindKthBitInNthBinaryString_Solution1 {
    public char findKthBit(int n, int k) {
        int cc=solve(n,k);
        return cc==0?'0':'1';
    }
    public static int solve(int n,int k){
        if(n==1||k==1){
            return 0;
        }
        int len=(int)Math.pow(2,n)-1;
        int mid=((len)/2);
        if(mid==k-1){
            return 1;
        }
        if(k-1<mid){
            return solve(n-1,k);
        }
        else{
            return solve(n-1,len-k+1)==1?0:1;
        }
    }
}

// 0ms 40.65MB
class FindKthBitInNthBinaryString_Solution2 {

    public char findKthBit(int n, int k) {
        // Find the position of the rightmost set bit in k
        // This helps determine which "section" of the string we're in
        int positionInSection = k & -k;

        // Determine if k is in the inverted part of the string
        // This checks if the bit to the left of the rightmost set bit is 1
        boolean isInInvertedPart = (((k / positionInSection) >> 1) & 1) == 1;

        // Determine if the original bit (before any inversion) would be 1
        // This is true if k is even (i.e., its least significant bit is 0)
        boolean originalBitIsOne = (k & 1) == 0;

        if (isInInvertedPart) {
            // If we're in the inverted part, we need to flip the bit
            return originalBitIsOne ? '0' : '1';
        } else {
            // If we're not in the inverted part, return the original bit
            return originalBitIsOne ? '1' : '0';
        }
    }
}

// 0ms 40.23MB
class FindKthBitInNthBinaryString_Solution3 {

    public char findKthBit(int n, int k) {
        int invertCount = 0;
        int len = (1 << n) - 1; // Length of Sn is 2^n - 1

        while (k > 1) {
            // If k is in the middle, return based on inversion count
            if (k == len / 2 + 1) {
                return invertCount % 2 == 0 ? '1' : '0';
            }

            // If k is in the second half, invert and mirror
            if (k > len / 2) {
                k = len + 1 - k; // Mirror position
                invertCount++; // Increment inversion count
            }

            len /= 2; // Reduce length for next iteration
        }

        // For the first position, return based on inversion count
        return invertCount % 2 == 0 ? '0' : '1';
    }
}