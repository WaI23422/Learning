package Easy.Arrays;


import java.util.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/relative-ranks/">506. Relative Ranks</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given an integer array <code>score</code> of size <code>n</code>, where <code>score[i]</code> is the score of the <code>i<sup>th</sup></code> athlete in a competition. All the scores are guaranteed to be <strong>unique</strong>.</p>

<p>The athletes are <strong>placed</strong> based on their scores, where the <code>1<sup>st</sup></code> place athlete has the highest score, the <code>2<sup>nd</sup></code> place athlete has the <code>2<sup>nd</sup></code> highest score, and so on. The placement of each athlete determines their rank:</p>

<ul>
	<li>The <code>1<sup>st</sup></code> place athlete's rank is <code>"Gold Medal"</code>.</li>
	<li>The <code>2<sup>nd</sup></code> place athlete's rank is <code>"Silver Medal"</code>.</li>
	<li>The <code>3<sup>rd</sup></code> place athlete's rank is <code>"Bronze Medal"</code>.</li>
	<li>For the <code>4<sup>th</sup></code> place to the <code>n<sup>th</sup></code> place athlete, their rank is their placement number (i.e., the <code>x<sup>th</sup></code> place athlete's rank is <code>"x"</code>).</li>
</ul>

<p>Return an array <code>answer</code> of size <code>n</code> where <code>answer[i]</code> is the <strong>rank</strong> of the <code>i<sup>th</sup></code> athlete.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> score = [5,4,3,2,1]
<strong>Output:</strong> ["Gold Medal","Silver Medal","Bronze Medal","4","5"]
<strong>Explanation:</strong> The placements are [1<sup>st</sup>, 2<sup>nd</sup>, 3<sup>rd</sup>, 4<sup>th</sup>, 5<sup>th</sup>].</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> score = [10,3,8,9,4]
<strong>Output:</strong> ["Gold Medal","5","Bronze Medal","Silver Medal","4"]
<strong>Explanation:</strong> The placements are [1<sup>st</sup>, 5<sup>th</sup>, 3<sup>rd</sup>, 2<sup>nd</sup>, 4<sup>th</sup>].

</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == score.length</code></li>
	<li><code>1 &lt;= n &lt;= 10<sup>4</sup></code></li>
	<li><code>0 &lt;= score[i] &lt;= 10<sup>6</sup></code></li>
	<li>All the values in <code>score</code> are <strong>unique</strong>.</li>
</ul>
</div>
 */
public class RelativeRanks {
    public static void main(String[] args) {
        int[][] tests = {
            {5,4,3,2,1},
            {10,3,8,9,4},
        };   

        for (int[] score : tests) {
            System.out.println(Arrays.toString(new RelativeRanks_Solution().findRelativeRanks(score)));
        }
    }
}

// 90 ms 45.9 MB
class RelativeRanks_Solution {
    public String[] findRelativeRanks(int[] score) {
        int len = score.length;
        String[] ans = new String[len];
        int[] scoreCopy = score.clone();
        Arrays.sort(score);

        for (int i = 0; i < len; i++) {
            for (int j = len-1; j >= 0; j--) {
                if (scoreCopy[i] == score[j]) {
                    if (j == len-1) {
                        ans[i] = "Gold Medal";
                    } else if (j == len-2) {
                        ans[i] = "Silver Medal";
                    } else if (j == len-3) {
                        ans[i] = "Bronze Medal";
                    } else {
                        ans[i] = String.valueOf(len-j);
                    }
                }
            }
        }

        return ans;
    }
}
