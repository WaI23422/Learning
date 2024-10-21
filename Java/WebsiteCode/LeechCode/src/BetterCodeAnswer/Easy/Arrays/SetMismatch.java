package BetterCodeAnswer.Easy.Arrays;

import java.util.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/set-mismatch/">645.Set Mismatch</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You have a set of integers <code>s</code>, which originally contains all the numbers from <code>1</code> to <code>n</code>. Unfortunately, due to some error, one of the numbers in <code>s</code> got duplicated to another number in the set, which results in <strong>repetition of one</strong> number and <strong>loss of another</strong> number.</p>

<p>You are given an integer array <code>nums</code> representing the data status of this set after the error.</p>

<p>Find the number that occurs twice and the number that is missing and return <em>them in the form of an array</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> nums = [1,2,2,4]
<strong>Output:</strong> [2,3]
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> nums = [1,1]
<strong>Output:</strong> [1,2]
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
</ul>
</div>
 */
public class SetMismatch {
    public static void main(String[] args) {
        int[][] tests = {
            {1,2,2,4},
            {1,1},
        };

        for (int[] nums : tests) {
            System.out.println(Arrays.toString(new SetMismatch_Solution().findErrorNums(nums)));
        }
    }    
}

// 2 ms 45.9 MB
class SetMismatch_Solution {
    public int[] findErrorNums(int[] nums) {
        int x[] = new int[nums.length+1];

        for(int i:nums){
            x[i]++;
        }

        int dup=0 , miss=0;

        for(int i=1;i<x.length;i++){
            if(x[i]==2){dup=i;}
            if(x[i]==0){miss=i;}
        }

        return new int[]{dup,miss}; 
    }
}

// 2 ms 45.6 MB
class SetMismatch_Solution2 {
    public int[] findErrorNums(int[] nums) {
        int N = nums.length, sum = N * (N + 1) / 2;
        int[] result = new int[2];
        boolean[] seen = new boolean[N+1];
        for (int num : nums) {
            sum -= num;
            if (seen[num]) result[0] = num;
            seen[num] = true;
        }
        result[1] = sum + result[0];
        return result;
    }
}