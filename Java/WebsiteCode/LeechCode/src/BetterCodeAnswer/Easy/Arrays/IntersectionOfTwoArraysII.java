package BetterCodeAnswer.Easy.Arrays;

import java.util.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/intersection-of-two-arrays-ii/">350. Intersection of Two Arrays II</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given two integer arrays <code>nums1</code> and <code>nums2</code>, return <em>an array of their intersection</em>. Each element in the result must appear as many times as it shows in both arrays and you may return the result in <strong>any order</strong>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums1 = [1,2,2,1], nums2 = [2,2]
<strong>Output:</strong> [2,2]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums1 = [4,9,5], nums2 = [9,4,9,8,4]
<strong>Output:</strong> [4,9]
<strong>Explanation:</strong> [9,4] is also accepted.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums1.length, nums2.length &lt;= 1000</code></li>
	<li><code>0 &lt;= nums1[i], nums2[i] &lt;= 1000</code></li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong></p>

<ul>
	<li>What if the given array is already sorted? How would you optimize your algorithm?</li>
	<li>What if <code>nums1</code>'s size is small compared to <code>nums2</code>'s size? Which algorithm is better?</li>
	<li>What if elements of <code>nums2</code> are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?</li>
</ul>
</div>
 */
public class IntersectionOfTwoArraysII {
    public static void main(String[] args) {
        
    }
}

// 0 ms 43.2 MB
class IntersectionOfTwoArraysII_Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int arr[] = new int[1001];
        int result[] = new int[1001];
        for(int a : nums1){
            arr[a]++;
        }

        int index =0;
        for(int a : nums2){
            if(arr[a]!=0){
                result[index++]=a;
                arr[a]--;
            }
        }

        return Arrays.copyOf(result, index);
    }
}