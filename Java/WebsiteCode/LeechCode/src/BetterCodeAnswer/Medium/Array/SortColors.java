package BetterCodeAnswer.Medium.Array;

import java.util.Arrays;

// import java.util.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/sort-colors/">75. Sort Colors</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given an array <code>nums</code> with <code>n</code> objects colored red, white, or blue, sort them <strong><a href="https://en.wikipedia.org/wiki/In-place_algorithm" target="_blank">in-place</a> </strong>so that objects of the same color are adjacent, with the colors in the order red, white, and blue.</p>
 * 
 * <p>We will use the integers <code>0</code>, <code>1</code>, and <code>2</code> to represent the color red, white, and blue, respectively.</p>
 * 
 * <p>You must solve this problem without using the library's sort function.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [2,0,2,1,1,0]
 * <strong>Output:</strong> [0,0,1,1,2,2]
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [2,0,1]
 * <strong>Output:</strong> [0,1,2]
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>n == nums.length</code></li>
 * 	<li><code>1 &lt;= n &lt;= 300</code></li>
 * 	<li><code>nums[i]</code> is either <code>0</code>, <code>1</code>, or <code>2</code>.</li>
 * </ul>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Follow up:</strong>&nbsp;Could you come up with a one-pass algorithm using only&nbsp;constant extra space?</p>
 * </div>
 */
public class SortColors {
    public static void main(String[] args) {
        int[][] tests = {
            {2,0,2,1,1,0},
            {0,1,2}
        };

        for (int[] nums : tests) {
            new SortColors_Solution().sortColors(nums);

            System.out.println(Arrays.toString(nums));
        }
    }
}

// 0 ms 41.79 MB
class SortColors_Solution {
    public void sortColors(int[] nums) {
       int t=0,k=nums.length-1;
       for(int i=0;i<nums.length;){
         if(nums[i]==0&&i!=t){
            int temp=nums[t];
            nums[t]=nums[i];
            nums[i]=temp;
            t++;
         }
         else if(k>i&&nums[i]==2){
            int temp=nums[k];
            nums[k]=nums[i];
            nums[i]=temp;
            k--;
         }
         else{
            i++;
         }
       } 
    }
}