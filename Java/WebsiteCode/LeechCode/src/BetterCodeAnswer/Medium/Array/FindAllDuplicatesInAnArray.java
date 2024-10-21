package BetterCodeAnswer.Medium.Array;

import java.util.ArrayList;
import java.util.List;
import java.util.AbstractList;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/find-all-duplicates-in-an-array/">442.Find All Duplicates in an Array</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given an integer array <code>nums</code> of length <code>n</code> where all the integers of <code>nums</code> are in the range <code>[1, n]</code> and each integer appears <strong>once</strong> or <strong>twice</strong>, return <em>an array of all the integers that appears <strong>twice</strong></em>.</p>

<p>You must write an algorithm that runs in&nbsp;<code>O(n)&nbsp;</code>time and uses only constant extra space.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> nums = [4,3,2,7,8,2,3,1]
<strong>Output:</strong> [2,3]
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> nums = [1,1,2]
<strong>Output:</strong> [1]
</pre><p><strong class="example">Example 3:</strong></p>
<pre><strong>Input:</strong> nums = [1]
<strong>Output:</strong> []
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == nums.length</code></li>
	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= n</code></li>
	<li>Each element in <code>nums</code> appears <strong>once</strong> or <strong>twice</strong>.</li>
</ul>
</div>
 */
public class FindAllDuplicatesInAnArray {
    public static void main(String[] args) {
        int[][] tests = {
            {1,3,4,2,2},
            {3,1,3,4,2},
            {4,3,2,7,8,2,3,1},
            {},
            {1}
        };

        for (int[] nums : tests) {
            System.out.println(new FindAllDuplicatesInAnArray_Solution().findDuplicates(nums).toString());
        }
    }
}

// 0 ms 53.2 MB
class FindAllDuplicatesInAnArray_Solution {
    private List<Integer> res;
    public List<Integer> findDuplicates(int[] nums) {
        return new AbstractList<Integer>() {
            public Integer get(int index) {
                init();
                return res.get(index);
            }
            public int size() {
                init();
                return res.size();
            }
            private void init() {
                if(res != null) return;
                res = new ArrayList<>();
                int t;
                for(int i=0; i<nums.length; i++) {
                    t = Math.abs(nums[i]);
                    if(nums[t-1] < 0) {
                        res.add(t);
                    } else {
                        nums[t-1] *= -1;
                    }
                }
            }
        };
    }
}

// 3 ms 54.7 MB
class FindAllDuplicatesInAnArray_Solution2 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        int[]count = new int[nums.length+1];
        for(int freq : nums) 
            count[freq]++;

        for( int i =1 ; i <= nums.length ; i++){
            if(count[i] == 2){
                res.add(i);
            }
        }
        return res;  
    }
}