package BetterCodeAnswer.Easy.Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/rank-transform-of-an-array/">1331. Rank Transform of an Array</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given an array of integers&nbsp;<code>arr</code>, replace each element with its rank.</p>
 * 
 * <p>The rank represents how large the element is. The rank has the following rules:</p>
 * 
 * <ul>
 * 	<li>Rank is an integer starting from 1.</li>
 * 	<li>The larger the element, the larger the rank. If two elements are equal, their rank must be the same.</li>
 * 	<li>Rank should be as small as possible.</li>
 * </ul>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> arr = [40,10,20,30]
 * <strong>Output:</strong> [4,1,2,3]
 * <strong>Explanation</strong>: 40 is the largest element. 10 is the smallest. 20 is the second smallest. 30 is the third smallest.</pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> arr = [100,100,100]
 * <strong>Output:</strong> [1,1,1]
 * <strong>Explanation</strong>: Same elements share the same rank.
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> arr = [37,12,28,9,100,56,80,5,12]
 * <strong>Output:</strong> [5,3,4,2,8,6,7,1,3]
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>0 &lt;= arr.length &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>-10<sup>9</sup>&nbsp;&lt;= arr[i] &lt;= 10<sup>9</sup></code></li>
 * </ul>
 * </div>
 */
public class RankTransformOfAnArray {
    public static void main(String[] args) {
        int[][] tests = {
            {37,12,28,9,100,56,80,5,12},
            {40,10,20,30}
        };

        for (int[] arr : tests) {
            System.out.println(Arrays.toString(new RankTransformOfAnArray_Solution().arrayRankTransform(arr)));
        }
    }
}

// 6ms 60.91MB
class RankTransformOfAnArray_Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] res = new int [arr.length];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int val: arr) {
            max = Math.max(val, max);
            min = Math.min(val, min);
        } 
    
        if (max - min > 200 && arr.length < 10) {
            int [] tmp = arr.clone();
            Arrays.sort(arr);
            int index = 1;
            boolean isRepeat = false;
            for (int i = 0; i < arr.length; i++) {
                int val = arr[i];
                isRepeat = false;
                for (int j = 0; j < tmp.length; j++) {
                    if (tmp[j] == val) {
                        if (isRepeat) {
                            i++;
                        }
                        res[j] = index;
                        isRepeat = true;
                    }
                }
                index++;
            }
            return res;

        } else {
            // [40,10,20,30]  nums[0 - 30] 
            // [100]
            int[] nums = new int [max - min + 1];
            for (int i = 0; i < arr.length; i++) {
                nums[arr[i] - min] = 1;
            }

            int rank = 1;
            for (int i = 0; i < max - min + 1; i++) {
                if (nums[i] == 1) {
                    nums[i] = rank;
                    rank++;
                }
            }

            //System.out.println(Arrays.toString(nums));
            for (int i = 0; i < arr.length; i++) {
                res[i] = nums[arr[i]-min];
            }

            return res;
        }
    }
}

// 20ms 62.56MB
class RankTransformOfAnArray_Solution1 {
    public int[] arrayRankTransform(int[] arr) {
        int[] ranks = arr.clone();
        Arrays.sort(ranks);
        Map<Integer, Integer> map = new HashMap<>(ranks.length);
        int position = 1;
        int prev = Integer.MIN_VALUE;
        for (int x : ranks) {
            if (x == prev)
                continue;
            map.put(x, position++);
            prev = x;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
}