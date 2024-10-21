package Easy.Arrays;


import java.util.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/unique-number-of-occurrences/">1207.Unique Number of Occurrences</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given an array of integers <code>arr</code>, return <code>true</code> <em>if the number of occurrences of each value in the array is <strong>unique</strong> or </em><code>false</code><em> otherwise</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> arr = [1,2,2,1,1,3]
<strong>Output:</strong> true
<strong>Explanation:</strong>&nbsp;The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> arr = [1,2]
<strong>Output:</strong> false
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> arr = [-3,0,1,-3,1,1,1,-3,10,0]
<strong>Output:</strong> true
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= arr.length &lt;= 1000</code></li>
	<li><code>-1000 &lt;= arr[i] &lt;= 1000</code></li>
</ul>
</div>
 */
public class UniqueNumberOfOccurrences {
    public static void main(String[] args) {
        int[][] tests = {
            {1,2,2,1,1,3},
            {1,2},
            {-3,0,1,-3,1,1,1,-3,10,0}
        };

        for (int[] arr : tests) {
            System.out.println(new UniqueNumberOfOccurrences_Solution().uniqueOccurrences(arr));
        }
    }
}

// 2 ms 41.3 MB
class UniqueNumberOfOccurrences_Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Arrays.sort(arr);
        
        int[] occur = new int[arr.length];
        int index = 0;

        occur[0]++;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i-1]) {occur[index]++;}
            else {index++; occur[index]++;}
        }

        Arrays.sort(occur,0,index+1);

        for (int i = 1; i < index+1; i++) {
            if (occur[i] == occur[i-1]) {return false;}    
        }

        return true;
    }
}