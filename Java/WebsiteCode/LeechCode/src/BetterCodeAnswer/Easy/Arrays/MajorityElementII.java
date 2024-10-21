package BetterCodeAnswer.Easy.Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/majority-element-ii/">229.Majority Element II</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>Given an integer array of size <code>n</code>, find all elements that appear more than <code>⌊ n/3 ⌋</code> times.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [3,2,3]
<strong>Output:</strong> [3]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [1]
<strong>Output:</strong> [1]
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> nums = [1,2]
<strong>Output:</strong> [1,2]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong> Could you solve the problem in linear time and in <code>O(1)</code> space?</p>
</div></div>
 */
public class MajorityElementII {
    public static void main(String[] args) {
        int[] nums = {1,2};

        MajorityElementII_Solution answer = new MajorityElementII_Solution();

        System.out.println(answer.majorityElement(nums));
    }
}

class MajorityElementII_Solution {
    // 0 ms
    // 46.6 MB
    List<Integer> resp = new ArrayList<>();
    int pivot = 0;
    public List<Integer> majorityElement(int[] nums) {
        int len = nums.length;
        pivot = len/3;
        quickSort(nums, 0 , nums.length-1);
        return resp;
    }
    
    public void quickSort(int[] nums, int start, int end) {
        if(end-start < pivot) {
            return;
        }
        int left = start;
        int right = end;
        int i = start+1;
         while (right >= i) {
            if (nums[left] > nums[i]) {
                swap(nums, left, i);
                i++;
                left++;
            } else if (nums[left] < nums[i]) {
                if (nums[i] > nums[right]) {
                    swap(nums, i, right);
                }
                right--;
            } else {
                i++;
            }
        }
        if(right-left >= pivot) {
            resp.add(nums[right]);
        }
        quickSort(nums, start, left-1);
        quickSort(nums, right+1, end);
        
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}