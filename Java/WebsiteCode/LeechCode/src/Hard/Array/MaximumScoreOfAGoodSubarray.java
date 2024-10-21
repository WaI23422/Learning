package Hard.Array;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/maximum-score-of-a-good-subarray/">1793.Maximum Score of a Good Subarray</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>You are given an array of integers <code>nums</code> <strong>(0-indexed)</strong> and an integer <code>k</code>.</p>

<p>The <strong>score</strong> of a subarray <code>(i, j)</code> is defined as <code>min(nums[i], nums[i+1], ..., nums[j]) * (j - i + 1)</code>. A <strong>good</strong> subarray is a subarray where <code>i &lt;= k &lt;= j</code>.</p>

<p>Return <em>the maximum possible <strong>score</strong> of a <strong>good</strong> subarray.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [1,4,3,7,4,5], k = 3
<strong>Output:</strong> 15
<strong>Explanation:</strong> The optimal subarray is (1, 5) with a score of min(4,3,7,4,5) * (5-1+1) = 3 * 5 = 15. 
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [5,5,4,5,4,1,1,1], k = 0
<strong>Output:</strong> 20
<strong>Explanation:</strong> The optimal subarray is (0, 4) with a score of min(5,5,4,5,4) * (4-0+1) = 4 * 5 = 20.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 2 * 10<sup>4</sup></code></li>
	<li><code>0 &lt;= k &lt; nums.length</code></li>
</ul>
</div></div>
 */
public class MaximumScoreOfAGoodSubarray {
    public static void main(String[] args) {
        int[][][] test = {
            {{1,4,3,7,4,5},{3}},
            {{5,5,4,5,4,1,1,1},{0}}
        };

        MaximumScoreOfAGoodSubarray_Solution res = new MaximumScoreOfAGoodSubarray_Solution();

        for (int i = 0; i < test.length; i++) {
            int[] nums = test[i][0];
            int k = test[i][1][0];

            System.out.println(res.maximumScore(nums, k));
        }

    }
}

// Time Limit Exceeded
class MaximumScoreOfAGoodSubarray_Solution {
    static int[] minArr(int[] nums, int start, int end){
        int[] minVal = {nums[start],start}; 
        
        if (start == end) {
            return minVal;
        }

        for (int i = start + 1; i < end+1; i++) {
            if (minVal[0] > nums[i]) {
                minVal[0] = nums[i];
                minVal[1] = i;
            }
        }

        return minVal;
    }

    public int maximumScore(int[] nums, int k) {
        int maxScore = Integer.MIN_VALUE, start = 0, end = nums.length-1;
        int minVal, pos, Score;

        while (start <= k && end >= k) {
            minVal = minArr(nums, start, end)[0];
            pos = minArr(nums, start, end)[1];

            Score = minVal * (end - start + 1);
            
            if (Score > maxScore) {
                maxScore = Score;
            }

            if (pos > k ) {
                end = pos - 1;
            } else {
                start = pos + 1;
            }
        }

        return maxScore;
    }
}

// Time Limit Exceeded:
class MaximumScoreOfAGoodSubarray_Solution2 {
    static int minArr(int[] nums, int start, int end){
        int minVal = nums[start]; 
        
        if (start == end) {
            return minVal;
        }

        for (int i = start + 1; i < end+1; i++) {
            if (minVal > nums[i]) {
                minVal = nums[i];
            }
        }

        return minVal;
    }

    public int maximumScore(int[] nums, int k) {
        int maxScore = Integer.MIN_VALUE;
        int start,end, Score;

        for (int i = k; i >= 0; i--) {
            start = i;
            for (int j = k; j < nums.length; j++) {
                end = j;

                Score = minArr(nums, start, end) * (end - start + 1);

                if (maxScore < Score) {
                    maxScore = Score;
                }
            }
        }

        return maxScore;
    }
}
