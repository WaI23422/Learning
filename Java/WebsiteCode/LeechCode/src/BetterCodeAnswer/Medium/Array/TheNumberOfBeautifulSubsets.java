package BetterCodeAnswer.Medium.Array;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/the-number-of-beautiful-subsets/">2597. The Number of Beautiful Subsets</a>
 * <div class="elfjS" data-track-load="description_content"><p>You are given an array <code>nums</code> of positive integers and a <strong>positive</strong> integer <code>k</code>.</p>
 * 
 * <p>A subset of <code>nums</code> is <strong>beautiful</strong> if it does not contain two integers with an absolute difference equal to <code>k</code>.</p>
 * 
 * <p>Return <em>the number of <strong>non-empty beautiful </strong>subsets of the array</em> <code>nums</code>.</p>
 * 
 * <p>A <strong>subset</strong> of <code>nums</code> is an array that can be obtained by deleting some (possibly none) elements from <code>nums</code>. Two subsets are different if and only if the chosen indices to delete are different.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [2,4,6], k = 2
 * <strong>Output:</strong> 4
 * <strong>Explanation:</strong> The beautiful subsets of the array nums are: [2], [4], [6], [2, 6].
 * It can be proved that there are only 4 beautiful subsets in the array [2,4,6].
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> nums = [1], k = 1
 * <strong>Output:</strong> 1
 * <strong>Explanation:</strong> The beautiful subset of the array nums is [1].
 * It can be proved that there is only 1 beautiful subset in the array [1].
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= nums.length &lt;= 20</code></li>
 * 	<li><code>1 &lt;= nums[i], k &lt;= 1000</code></li>
 * </ul>
 * </div>
 */
public class TheNumberOfBeautifulSubsets {
    public static void main(String[] args) {
        int[][][] tests = {
            {{2,4,6},{2}},
        };

        for (int[][] test : tests) {
            int[] nums = test[0];
            int k = test[1][0];

            System.out.println(new TheNumberOfBeautifulSubsets_Solution().beautifulSubsets(nums, k));
        }
    }
}

// 5 ms 43.8 MB
class TheNumberOfBeautifulSubsets_Solution {
  public int beautifulSubsets(int[] nums, int k) {
      
      Map<Integer, Integer> m = new HashMap<>();

      for (int num : nums) m.put(num, m.getOrDefault(num, 0) + 1);

      int res = 1, prev = 0, prevPrev = 0;

      for (Map.Entry<Integer, Integer> e : m.entrySet()) {
          int cur = e.getKey();

          if (m.containsKey(cur - k)) continue;
          
          prev = 0;

          while (m.containsKey(cur)) {
              prevPrev = prev;
              prev = ((1 << m.get(cur)) - 1) * res;
              res += prevPrev;
              cur += k;
          }
          res += prev;
      }
      return res - 1;
  }
}

// 406 ms 42.3 MB
class TheNumberOfBeautifulSubsets_Solution1 {
  public int beautifulSubsets(int[] nums, int k) {
      return countBeautifulSubsets(nums, k, 0, 0);
  }

  private int countBeautifulSubsets(int[] nums, int difference, int index, int mask) {
      // Base case: Return 1 if mask is greater than 0 (non-empty subset)
      if (index == nums.length)
          return mask > 0 ? 1 : 0;

      // Flag to check if the current subset is beautiful
      boolean isBeautiful = true;

      // Check if the current number forms a beautiful pair with any previous number
      // in the subset
      for (int j = 0; j < index && isBeautiful; ++j){
          isBeautiful = ((1 << j) & mask) == 0 || 
                      Math.abs(nums[j] - nums[index]) != difference;
          }

      // Recursively calculate beautiful subsets including and excluding the current
      // number
      int skip = countBeautifulSubsets(nums, difference, index + 1, mask);
      int take;
      if (isBeautiful) {
          take = countBeautifulSubsets(nums, difference,
                  index + 1, mask + (1 << index));
      } else {
          take = 0;
      }

      return skip + take;
  }
}

// // 5 ms 43.3 MB
class TheNumberOfBeautifulSubsets_Solution2 {
  public int beautifulSubsets(int[] nums, int k) {
      int totalCount = 1;
      Map<Integer, Map<Integer, Integer>> freqMap = new TreeMap<>();

      // Calculate frequencies based on remainder
      for (int num : nums) {
          Map<Integer, Integer> fr = freqMap.getOrDefault(num % k, new TreeMap<>());
          fr.put(num, fr.getOrDefault(num, 0) + 1);
          freqMap.put(num % k, fr);
      }

      // Iterate through each remainder group
      for (Map.Entry<Integer, Map<Integer, Integer>> entry : freqMap.entrySet()) {
          int prevNum = -k, prev2 = 0, prev1 = 1, curr = 1;

          // Iterate through each number in the current remainder group
          for (Map.Entry<Integer, Integer> freqEntry : entry.getValue().entrySet()) {
              int num = freqEntry.getKey();
              int freq = freqEntry.getValue();
              // Count of subsets skipping the current number
              int skip = prev1; 

              // Count of subsets including the current number
              // Check if the current number and the previous number 
              // form a beautiful pair
              int take;
              if (num - prevNum == k) {
                  take = ((1 << freq) - 1) * prev2;
              } else {
                  take = ((1 << freq) - 1) * prev1;
              }

              curr = skip + take; // Store the total count for the current number
              prev2 = prev1;
              prev1 = curr;
              prevNum = num;
          }
          totalCount *= curr;
      }
      return totalCount - 1;
  }
}