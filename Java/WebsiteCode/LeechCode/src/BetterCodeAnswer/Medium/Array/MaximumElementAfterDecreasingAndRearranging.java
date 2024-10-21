package BetterCodeAnswer.Medium.Array;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/maximum-element-after-decreasing-and-rearranging/">1846.Maximum Element After Decreasing and Rearranging</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>You are given an array of positive integers <code>arr</code>. Perform some operations (possibly none) on <code>arr</code> so that it satisfies these conditions:</p>

<ul>
	<li>The value of the <strong>first</strong> element in <code>arr</code> must be <code>1</code>.</li>
	<li>The absolute difference between any 2 adjacent elements must be <strong>less than or equal to </strong><code>1</code>. In other words, <code>abs(arr[i] - arr[i - 1]) &lt;= 1</code> for each <code>i</code> where <code>1 &lt;= i &lt; arr.length</code> (<strong>0-indexed</strong>). <code>abs(x)</code> is the absolute value of <code>x</code>.</li>
</ul>

<p>There are 2 types of operations that you can perform any number of times:</p>

<ul>
	<li><strong>Decrease</strong> the value of any element of <code>arr</code> to a <strong>smaller positive integer</strong>.</li>
	<li><strong>Rearrange</strong> the elements of <code>arr</code> to be in any order.</li>
</ul>

<p>Return <em>the <strong>maximum</strong> possible value of an element in </em><code>arr</code><em> after performing the operations to satisfy the conditions</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> arr = [2,2,1,2,1]
<strong>Output:</strong> 2
<strong>Explanation:</strong> 
We can satisfy the conditions by rearranging <code>arr</code> so it becomes <code>[1,2,2,2,1]</code>.
The largest element in <code>arr</code> is 2.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> arr = [100,1,1000]
<strong>Output:</strong> 3
<strong>Explanation:</strong> 
One possible way to satisfy the conditions is by doing the following:
1. Rearrange <code>arr</code> so it becomes <code>[1,100,1000]</code>.
2. Decrease the value of the second element to 2.
3. Decrease the value of the third element to 3.
Now <code>arr = [1,2,3], which </code>satisfies the conditions.
The largest element in <code>arr is 3.</code>
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> arr = [1,2,3,4,5]
<strong>Output:</strong> 5
<strong>Explanation:</strong> The array already satisfies the conditions, and the largest element is 5.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= arr.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= arr[i] &lt;= 10<sup>9</sup></code></li>
</ul>
</div></div> 
 */
public class MaximumElementAfterDecreasingAndRearranging {
    public static void main(String[] args) {
        int[][] tests = {
            {2,2,1,2,1},
            {100,1,1000},
            {1,2,3,4,5}
        };

        for (int[] arr : tests) {
            System.out.println(new MaximumElementAfterDecreasingAndRearranging_Solution().maximumElementAfterDecrementingAndRearranging(arr));
        }
    }
}

class MaximumElementAfterDecreasingAndRearranging_Solution {
    // 3 ms 57.7 MB
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int l = arr.length;
        int[] counter = new int[l];

        for(int i=0;i<l;i++){
            ++counter[Math.min(arr[i]-1,l-1)];
        }
        
        int ans = 1;
        
        for (int i = 1; i < l; i++){
            ans = Math.min(i+1, ans + counter[i]);
        }

        return ans;
    }
}