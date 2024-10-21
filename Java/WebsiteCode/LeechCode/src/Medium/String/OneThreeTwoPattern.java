package Medium.String;

/**<div class="xFUwe" data-track-load="description_content"><p>Given an array of <code>n</code> integers <code>nums</code>, a <strong>132 pattern</strong> is a subsequence of three integers <code>nums[i]</code>, <code>nums[j]</code> and <code>nums[k]</code> such that <code>i &lt; j &lt; k</code> and <code>nums[i] &lt; nums[k] &lt; nums[j]</code>.</p>

<p>Return <code>true</code><em> if there is a <strong>132 pattern</strong> in </em><code>nums</code><em>, otherwise, return </em><code>false</code><em>.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [1,2,3,4]
<strong>Output:</strong> false
<strong>Explanation:</strong> There is no 132 pattern in the sequence.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [3,1,4,2]
<strong>Output:</strong> true
<strong>Explanation:</strong> There is a 132 pattern in the sequence: [1, 4, 2].
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> nums = [-1,3,2,0]
<strong>Output:</strong> true
<strong>Explanation:</strong> There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == nums.length</code></li>
	<li><code>1 &lt;= n &lt;= 2 * 10<sup>5</sup></code></li>
	<li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
</ul>
</div> */
public class OneThreeTwoPattern {
    public static void main(String[] args) {
        int[] nums = {1,2,3};

        OneThreeTwoPattern_Solution_Beta oneThreeTwoPattern_Solution = new OneThreeTwoPattern_Solution_Beta();

        System.out.println(oneThreeTwoPattern_Solution.find132pattern(nums));
    }
}

/**
 * <h4 id="approach-1-brute-force">Approach 1: Brute Force</h4>
 * 
 * <p>The simplest solution is to consider every triplet <span class="math math-inline"><span class="katex"><span class="katex-mathml">(i,j,k)(i, j, k)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mopen">(</span><span class="mord mathnormal">i</span><span class="mpunct">,</span><span class="mspace" style="margin-right: 0.1667em;"></span><span class="mord mathnormal" style="margin-right: 0.05724em;">j</span><span class="mpunct">,</span><span class="mspace" style="margin-right: 0.1667em;"></span><span class="mord mathnormal" style="margin-right: 0.03148em;">k</span><span class="mclose">)</span></span></span></span></span> and check if the corresponding numbers satisfy the 132 criteria. If any such triplet is found, we can return a True value. If no such triplet is found, we need to return a False value.</p>
 */
class OneThreeTwoPattern_Solution_Beta{
    // Time Limit Exceeded.
    public boolean find132pattern(int[] nums) {
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[k] > nums[i] && nums[j] > nums[k])
                        return true;
                }
            }
        }

        return false;
    }
}
