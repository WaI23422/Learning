package Medium.Array;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/check-if-array-pairs-are-divisible-by-k/">1497. Check If Array Pairs Are Divisible by k</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given an array of integers <code>arr</code> of even length <code>n</code> and an integer <code>k</code>.</p>
 * 
 * <p>We want to divide the array into exactly <code>n / 2</code> pairs such that the sum of each pair is divisible by <code>k</code>.</p>
 * 
 * <p>Return <code>true</code><em> If you can find a way to do that or </em><code>false</code><em> otherwise</em>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> arr = [1,2,3,4,5,10,6,7,8,9], k = 5
 * <strong>Output:</strong> true
 * <strong>Explanation:</strong> Pairs are (1,9),(2,8),(3,7),(4,6) and (5,10).
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> arr = [1,2,3,4,5,6], k = 7
 * <strong>Output:</strong> true
 * <strong>Explanation:</strong> Pairs are (1,6),(2,5) and(3,4).
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> arr = [1,2,3,4,5,6], k = 10
 * <strong>Output:</strong> false
 * <strong>Explanation:</strong> You can try all possible pairs to see that there is no way to divide arr into 3 pairs each with sum divisible by 10.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>arr.length == n</code></li>
 * 	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>n</code> is even.</li>
 * 	<li><code>-10<sup>9</sup> &lt;= arr[i] &lt;= 10<sup>9</sup></code></li>
 * 	<li><code>1 &lt;= k &lt;= 10<sup>5</sup></code></li>
 * </ul>
 * </div>
 */
public class CheckIfArrayPairsAreDivisibleByK {
    public static void main(String[] args) {
        int[][][] tests = {
            {
                {-1,-1,-1,-1,2,2,-2,-2},
                {3}
            },
            {
                {-1,1,-2,2,-3,3,-4,4},
                {5}
            },
            {
                {1,2,3,4,5,10,6,7,8,9},
                {5}
            }
        };

        for (int[][] test : tests) {
            int arr[] = test[0],
                k = test[1][0];

            System.out.println(new CheckIfArrayPairsAreDivisibleByK_Solution().canArrange(arr, k));
        }
    }
}

// 5ms 56.97MB -> 4ms 56.27MB
class CheckIfArrayPairsAreDivisibleByK_Solution {
    public boolean canArrange(int[] arr, int k) {
        int mod[] = new int[k];
        for (int num : arr) {
            mod[((num % k) + k) % k]++;
        }

        if (
            mod[0]%2 == 1 
            // || (k/2 == 0 && mod[k/2]%2 == 1)
        ) {return false;}
        
        for (int i = 1; i < (k+1)/2; i++) {
            if (mod[i] != mod[k-i]) {return false;}
        }

        return true;
    }
}