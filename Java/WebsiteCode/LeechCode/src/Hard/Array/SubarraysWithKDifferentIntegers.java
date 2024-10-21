package Hard.Array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/subarrays-with-k-different-integers/">992.Subarrays with K Different Integers</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given an integer array <code>nums</code> and an integer <code>k</code>, return <em>the number of <strong>good subarrays</strong> of </em><code>nums</code>.</p>

<p>A <strong>good array</strong> is an array where the number of different integers in that array is exactly <code>k</code>.</p>

<ul>
	<li>For example, <code>[1,2,3,1,2]</code> has <code>3</code> different integers: <code>1</code>, <code>2</code>, and <code>3</code>.</li>
</ul>

<p>A <strong>subarray</strong> is a <strong>contiguous</strong> part of an array.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [1,2,1,2,3], k = 2
<strong>Output:</strong> 7
<strong>Explanation:</strong> Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [1,2,1,3,4], k = 3
<strong>Output:</strong> 3
<strong>Explanation:</strong> Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 2 * 10<sup>4</sup></code></li>
	<li><code>1 &lt;= nums[i], k &lt;= nums.length</code></li>
</ul>
</div>
 */
public class SubarraysWithKDifferentIntegers {
    public static void main(String[] args) {
        int[][][] tests = {
            {{1,2,1,2,3},{2}},
            {{1,2,1,3,4},{3}}
        };

        for (int[][] test : tests) {
            int[] nums = test[0];
            int k = test[1][0];

            System.out.println(new SubarraysWithKDifferentIntegers_Solution().subarraysWithKDistinct(nums, k));
        }
    }
}

// Time Limit Exceeded
class SubarraysWithKDifferentIntegers_Solution1 {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int count =0 ;
        HashMap<Integer,Integer> numAppears = new HashMap<>();

        for (int num : nums) {
            numAppears.put(num, numAppears.getOrDefault(num, 0)+1);
            
            if (numAppears.size() == k) {count++;}

            count += countSubarraysKDistinctExistInArray(nums, numAppears, k);
        }

        return count;
    }

    private int countSubarraysKDistinctExistInArray(int[] nums, HashMap<Integer,Integer> numAppears, int k) {
        HashMap<Integer,Integer> numAppearsCopy = new HashMap<>(numAppears);
        int count = 0;
        
        for (int num : nums) {
            if (numAppearsCopy.size() < k) {return count;}

            numAppearsCopy.computeIfPresent(num, (key,value)-> value-1);

            if (numAppearsCopy.get(num) == 0) { numAppearsCopy.remove(num); }

            if (numAppearsCopy.size() == k) {
                count++;
            } else {
                continue;
            }
        }

        return count;
    }
}

// Time Limit Exceeded
class SubarraysWithKDifferentIntegers_Solution2 {
    int count = 0;

    public int subarraysWithKDistinct(int[] nums, int k) {
        Set<Integer> numAppears = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            numAppears.add(nums[i]);
            
            if (numAppears.size() == k) {count++;}

            countSubarraysKDistinctExistInArray(nums,1, i, k);
        }

        return count;
    }

    private void countSubarraysKDistinctExistInArray(int[] nums,int start, int end, int k) {
        if (end < k || start >= end) {return;}

        Set<Integer> numAppears = new HashSet<>();

        for (int i = end; i >= start; i--) {
            numAppears.add(nums[i]);
            
            if (numAppears.size() == k) {count++;}
            
        }
    }
}

// 45 ms 47.2 MB
class SubarraysWithKDifferentIntegers_Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int subWithMaxK = subarrayWithAtMostK(nums, k);
        int reducedSubWithMaxK = subarrayWithAtMostK(nums, k - 1);
        return subWithMaxK - reducedSubWithMaxK;
    }
    
    public int subarrayWithAtMostK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0, right = 0, ans = 0;
        
        while (right < nums.length) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            
            while (map.size() > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            
            ans += right - left + 1; // Size of subarray
            right++;
        }
        
        return ans;
    }
}
