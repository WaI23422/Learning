package BetterCodeAnswer.Medium.Array;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/maximize-happiness-of-selected-children/">3075. Maximize Happiness of Selected Children</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given an array <code>happiness</code> of length <code>n</code>, and a <strong>positive</strong> integer <code>k</code>.</p>

<p>There are <code>n</code> children standing in a queue, where the <code>i<sup>th</sup></code> child has <strong>happiness value</strong> <code>happiness[i]</code>. You want to select <code>k</code> children from these <code>n</code> children in <code>k</code> turns.</p>

<p>In each turn, when you select a child, the <strong>happiness value</strong> of all the children that have <strong>not</strong> been selected till now decreases by <code>1</code>. Note that the happiness value <strong>cannot</strong> become negative and gets decremented <strong>only</strong> if it is positive.</p>

<p>Return <em>the <strong>maximum</strong> sum of the happiness values of the selected children you can achieve by selecting </em><code>k</code> <em>children</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> happiness = [1,2,3], k = 2
<strong>Output:</strong> 4
<strong>Explanation:</strong> We can pick 2 children in the following way:
- Pick the child with the happiness value == 3. The happiness value of the remaining children becomes [0,1].
- Pick the child with the happiness value == 1. The happiness value of the remaining child becomes [0]. Note that the happiness value cannot become less than 0.
The sum of the happiness values of the selected children is 3 + 1 = 4.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> happiness = [1,1,1,1], k = 2
<strong>Output:</strong> 1
<strong>Explanation:</strong> We can pick 2 children in the following way:
- Pick any child with the happiness value == 1. The happiness value of the remaining children becomes [0,0,0].
- Pick the child with the happiness value == 0. The happiness value of the remaining child becomes [0,0].
The sum of the happiness values of the selected children is 1 + 0 = 1.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> happiness = [2,3,4,5], k = 1
<strong>Output:</strong> 5
<strong>Explanation:</strong> We can pick 1 child in the following way:
- Pick the child with the happiness value == 5. The happiness value of the remaining children becomes [1,2,3].
The sum of the happiness values of the selected children is 5.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n == happiness.length &lt;= 2 * 10<sup>5</sup></code></li>
	<li><code>1 &lt;= happiness[i] &lt;= 10<sup>8</sup></code></li>
	<li><code>1 &lt;= k &lt;= n</code></li>
</ul>
</div>
 */
public class MaximizeHappinessOfSelectedChildren {
    public static void main(String[] args) {
        
    }
}

// 12 ms 71.6 MB
class MaximizeHappinessOfSelectedChildren_Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        
        int left = 0, right = k;
        while(left < right){
            int mid = left + right >> 1;
            if(check(happiness, mid))
                left = mid + 1;
            else
                right = mid;
        }
        
        k = left;
        int n = happiness.length;
        quickSort(happiness, 0, n - 1, n - k);
        long sum = -(long)k * (k - 1) >> 1;
        for(int i = n -1; k-- > 0; --i)
            sum += happiness[i];
        
        return sum;
    }
    
    public boolean check(int[] happiness, int mid) {
        int count = 0;
        for(int x:happiness){
            if(x < mid) continue;
            if(++count > mid) 
               return true;
        }
        
        return false;
    }
    
    private void quickSort(int nums[], int low, int high, int k) {
        if (low == high) 
            return;
        
        int left = low - 1, right = high + 1, mid = low + high >> 1;
        int x = nums[mid];
        while (left < right) {
            while (nums[++left] < x) continue;
            while (nums[--right] > x) continue;
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        } 
        
        if (right < k) 
            quickSort(nums, right + 1, high, k);
        else
            quickSort(nums, low, right, k);
    }        
}