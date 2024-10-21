package BetterCodeAnswer.Medium.Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/count-nice-pairs-in-an-array/">1814.Count Nice Pairs in an Array</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>You are given an array <code>nums</code> that consists of non-negative integers. Let us define <code>rev(x)</code> as the reverse of the non-negative integer <code>x</code>. For example, <code>rev(123) = 321</code>, and <code>rev(120) = 21</code>. A pair of indices <code>(i, j)</code> is <strong>nice</strong> if it satisfies all of the following conditions:</p>

<ul>
	<li><code>0 &lt;= i &lt; j &lt; nums.length</code></li>
	<li><code>nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])</code></li>
</ul>

<p>Return <em>the number of nice pairs of indices</em>. Since that number can be too large, return it <strong>modulo</strong> <code>10<sup>9</sup> + 7</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [42,11,1,97]
<strong>Output:</strong> 2
<strong>Explanation:</strong> The two pairs are:
 - (0,3) : 42 + rev(97) = 42 + 79 = 121, 97 + rev(42) = 97 + 24 = 121.
 - (1,2) : 11 + rev(1) = 11 + 1 = 12, 1 + rev(11) = 1 + 11 = 12.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [13,10,35,24,76]
<strong>Output:</strong> 4
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
</ul>
</div></div>
 */
public class CountNicePairsInAnArray {
    public static void main(String[] args) {
        int[][] tests = {
            {42,11,1,97},
            {13,10,35,24,76}
        };

        for (int[] nums : tests) {
            System.out.println(new CountNicePairsInAnArray_Solution().countNicePairs(nums));
        }
    }
}

/**
 * <h1 id="approach">Approach</h1>
 * <ol>
<li>Define a helper function <code>reverse</code> to reverse a given number.</li>
<li>Modify the input array nums by replacing each element with nums[i] - reverse(nums[i]).</li>
<li>Sort the modified nums array.</li>
<li>Iterate through the sorted array and count the occurrences of each unique difference.</li>
<li>Use the formula n * (n-1) / 2 to calculate the number of pairs for each unique difference, where n is the count of occurrences.</li>
<li>Sum up the results for all unique differences to get the total count of nice pairs.</li>
<li>Return the result modulo 10^9 + 7.</li>
</ol>
 */
class CountNicePairsInAnArray_Solution {

    int reverse(int num) {
        int rev = 0;
        while(num>0){
            rev = rev*10 + num%10;
            num/=10;
        }
        return rev;
    }

    // 19 ms 54.4 MB
    public int countNicePairs(int[] nums) {
        final int mod = 1000000007;
        
        int len = nums.length;
        for(int i=0;i<len;i++) nums[i] = nums[i] - reverse(nums[i]);
        Arrays.sort(nums);
        long res = 0;
        for(int i=0;i<len-1;i++) {
            long cont = 1;
            while(i<len-1 && nums[i]==nums[i+1]) {
                cont++;
                i++;
            }
            res = (res%mod + (cont*(cont-1))/2)%mod;
        }
        return (int) res%mod;
    }
}

// 30 ms 52.4 MB
class CountNicePairsInAnArray_Solution2 {
    public int countNicePairs(int[] nums) {
        int ans=0, mod=(int)1e9+7;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int val = nums[i] - rev(nums[i]);
            int count=map.getOrDefault(val,0);
            ans = (ans+count)%mod;
            map.put(val,count+1);
        }
        System.gc();
        return ans;
    }
    private int rev(int num){
        int newNum=0;
        while(num>0){
            int rem=num%10;
            num/=10;
            newNum*=10;
            newNum+=rem;
        }
        return newNum;
    }
}