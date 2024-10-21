package Medium.Array;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/">1442. Count Triplets That Can Form Two Arrays of Equal XOR</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given an array of integers <code>arr</code>.</p>
 * 
 * <p>We want to select three indices <code>i</code>, <code>j</code> and <code>k</code> where <code>(0 &lt;= i &lt; j &lt;= k &lt; arr.length)</code>.</p>
 * 
 * <p>Let's define <code>a</code> and <code>b</code> as follows:</p>
 * 
 * <ul>
 * 	<li><code>a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]</code></li>
 * 	<li><code>b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]</code></li>
 * </ul>
 * 
 * <p>Note that <strong>^</strong> denotes the <strong>bitwise-xor</strong> operation.</p>
 * 
 * <p>Return <em>the number of triplets</em> (<code>i</code>, <code>j</code> and <code>k</code>) Where <code>a == b</code>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> arr = [2,3,1,6,7]
 * <strong>Output:</strong> 4
 * <strong>Explanation:</strong> The triplets are (0,1,2), (0,2,2), (2,3,4) and (2,4,4)
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> arr = [1,1,1,1,1]
 * <strong>Output:</strong> 10
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= arr.length &lt;= 300</code></li>
 * 	<li><code>1 &lt;= arr[i] &lt;= 10<sup>8</sup></code></li>
 * </ul>
 * </div>
 */
public class CountTripletsThatCanFormTwoArraysOfEqualXOR {
    public static void main(String[] args) {
        int[][] tests = {
            {2,3,1,6,7}
        };

        for (int[] arr : tests) {
            System.out.println(new CountTripletsThatCanFormTwoArraysOfEqualXOR_Solution().countTriplets(arr));
        }
    }
}


// 1 ms 40.6 MB
class CountTripletsThatCanFormTwoArraysOfEqualXOR_Solution {
    public int countTriplets(int[] nums) {
       
        int count = 0;
  
        for(int i = 0; i < nums.length; i++){
            int xor = 0;
            for(int j = i; j < nums.length; j++){
                xor ^= nums[j];
                if(xor == 0) count += (j - i);
            }
        }
        
        return count;
    }
}