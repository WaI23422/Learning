package BetterCodeAnswer.Easy.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/third-maximum-number/">414. Third Maximum Number</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given an integer array <code>nums</code>, return <em>the <strong>third distinct maximum</strong> number in this array. If the third maximum does not exist, return the <strong>maximum</strong> number</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [3,2,1]
<strong>Output:</strong> 1
<strong>Explanation:</strong>
The first distinct maximum is 3.
The second distinct maximum is 2.
The third distinct maximum is 1.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [1,2]
<strong>Output:</strong> 2
<strong>Explanation:</strong>
The first distinct maximum is 2.
The second distinct maximum is 1.
The third distinct maximum does not exist, so the maximum (2) is returned instead.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> nums = [2,2,3,1]
<strong>Output:</strong> 1
<strong>Explanation:</strong>
The first distinct maximum is 3.
The second distinct maximum is 2 (both 2's are counted together since they have the same value).
The third distinct maximum is 1.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
	<li><code>-2<sup>31</sup> &lt;= nums[i] &lt;= 2<sup>31</sup> - 1</code></li>
</ul>

<p>&nbsp;</p>
<strong>Follow up:</strong> Can you find an <code>O(n)</code> solution?</div>
 */
public class ThirdMaximumNumber {
    public static void main(String[] args) {
        int[][] tests = {
            {3,2,1},
            {1,2},
            {2,2,3,1}
        };

        for (int[] nums : tests) {
            System.out.println(new ThirdMaximumNumber_Solution().thirdMax(nums));   
        }
    }
}

// 1 ms 42.9 MB
class ThirdMaximumNumber_Solution {
    public int thirdMax(int[] nums) {
        long max1=Long.MIN_VALUE;
        long max2=Long.MIN_VALUE;
        long max3=Long.MIN_VALUE;
        for(int num : nums){
            if(num>max1){
                max3 = max2;
                max2 = max1;
                max1 = num;
            }else if(max1>num && num>max2){
                max3 = max2;
                max2 = num;
            }else if(max2>num && num>max3){
                max3=num;
            }
        }
        return max3 != Long.MIN_VALUE ? (int) max3 : (int) max1;
    }
}

// 0 ms 42.9 MB
class ThirdMaximumNumber_Solution1 {
    public int thirdMax(int[] nums) {
       long max = Long.MIN_VALUE;
       long secondMax = Long.MIN_VALUE;
       long thirdMax = Long.MIN_VALUE;

       for (int i = 0; i < nums.length; i++) {

           if (nums[i] > thirdMax 
               && nums[i]!= max 
               && nums[i]!= secondMax) {

               if (nums[i] >= secondMax) {

                   if (nums[i] >= max) {
                       
                       thirdMax = secondMax;
                       secondMax = max;
                       max = nums[i];
                       continue;
                   }

                   thirdMax = secondMax;
                   secondMax = nums[i];
                   continue;
               }

               if (nums[i] > thirdMax) thirdMax = nums[i];
           }
       }

       return thirdMax == Long.MIN_VALUE ? (int) max : (int) thirdMax;
   }
}