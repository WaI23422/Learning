package BetterCodeAnswer.Medium.String;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/find-unique-binary-string/">1980.Find Unique Binary String</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>Given an array of strings <code>nums</code> containing <code>n</code> <strong>unique</strong> binary strings each of length <code>n</code>, return <em>a binary string of length </em><code>n</code><em> that <strong>does not appear</strong> in </em><code>nums</code><em>. If there are multiple answers, you may return <strong>any</strong> of them</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = ["01","10"]
<strong>Output:</strong> "11"
<strong>Explanation:</strong> "11" does not appear in nums. "00" would also be correct.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = ["00","01"]
<strong>Output:</strong> "11"
<strong>Explanation:</strong> "11" does not appear in nums. "10" would also be correct.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> nums = ["111","011","001"]
<strong>Output:</strong> "101"
<strong>Explanation:</strong> "101" does not appear in nums. "000", "010", "100", and "110" would also be correct.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == nums.length</code></li>
	<li><code>1 &lt;= n &lt;= 16</code></li>
	<li><code>nums[i].length == n</code></li>
	<li><code>nums[i] </code>is either <code>'0'</code> or <code>'1'</code>.</li>
	<li>All the strings of <code>nums</code> are <strong>unique</strong>.</li>
</ul>
</div></div>
 */
public class FindUniqueBinaryString {
    public static void main(String[] args) {
        String[][] tests = {
            {"01","10"},
            {"00","01"},
            {"111","011","001"}
        };

        for (String[] nums : tests) {
            System.out.println(new FindUniqueBinaryString_Solution().findDifferentBinaryString(nums));
        }
    }
}

/**
 * <h4 id="approach-4-cantors-diagonal-argument">Approach 4: Cantor's Diagonal Argument</h4>
 * <p><strong>Intuition</strong></p>
 * <p><a href="https://en.wikipedia.org/wiki/Cantor%27s_diagonal_argument" target="_blank">Cantor's diagonal argument</a> is a proof in set theory.</p>
 * <p>While we do not need to fully understand the proof and its consequences, this approach uses very similar ideas.</p>
 * <p>We start by initializing the answer <code>ans</code> to an empty string. To build <code>ans</code>, we need to assign either <code>"0"</code> or <code>"1"</code> to each index <code>i</code> for indices <code>0</code> to <code>n - 1</code>. How do we assign them so <code>ans</code> is guaranteed to be different from every string in <code>nums</code>? We know that two strings are different, as long as they differ by at least one character. We can intentionally construct our <code>ans</code> based on this fact.</p>
 * <p>For each index <code>i</code>, we will check the <span class="math math-inline"><span class="katex"><span class="katex-mathml">ithi^{th}</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.8491em;"></span><span class="mord"><span class="mord mathnormal">i</span><span class="msupsub"><span class="vlist-t"><span class="vlist-r"><span class="vlist" style="height: 0.8491em;"><span style="top: -3.063em; margin-right: 0.05em;"><span class="pstrut" style="height: 2.7em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight"><span class="mord mathnormal mtight">t</span><span class="mord mathnormal mtight">h</span></span></span></span></span></span></span></span></span></span></span></span></span> character of the <span class="math math-inline"><span class="katex"><span class="katex-mathml">ithi^{th}</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.8491em;"></span><span class="mord"><span class="mord mathnormal">i</span><span class="msupsub"><span class="vlist-t"><span class="vlist-r"><span class="vlist" style="height: 0.8491em;"><span style="top: -3.063em; margin-right: 0.05em;"><span class="pstrut" style="height: 2.7em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight"><span class="mord mathnormal mtight">t</span><span class="mord mathnormal mtight">h</span></span></span></span></span></span></span></span></span></span></span></span></span> string in <code>ans</code>. That is, we check <code>curr = nums[i][i]</code>. We then assign <code>ans[i]</code> to the opposite of <code>curr</code>. That is, if <code>curr = "0"</code>, we assign <code>ans[i] = "1"</code>. If <code>curr = "1"</code>, we assign <code>ans[i] = "0"</code>.</p>
 * <p>What is the point of this strategy? <code>ans</code> will differ from every string in <strong>at least</strong> one position. More specifically:</p>
 * <ul>
<li><code>ans</code> differs from <code>nums[0]</code> in <code>nums[0][0]</code>.</li>
<li><code>ans</code> differs from <code>nums[1]</code> in  <code>nums[1][1]</code>.</li>
<li><code>ans</code> differs from <code>nums[2]</code> in  <code>nums[2][2]</code>.</li>
<li>...</li>
<li><code>ans</code> differs from <code>nums[n - 1]</code> in  <code>nums[n - 1][n - 1]</code>.</li>
</ul>
<p>Thus, it is guaranteed that <code>ans</code> does not appear in <code>nums</code> and is a valid answer.</p>
<blockquote>
<p>This strategy is applicable because both the length of <code>ans</code> and the length of each string in <code>nums</code> are larger than or equal to <code>n</code>, the number of strings in <code>nums</code>. Therefore, we can find one unique position for each string in <code>nums</code>.</p>
</blockquote>
<p><strong>Algorithm</strong></p>
<ol>
<li>Initialize the answer <code>ans</code>. Note that you should build the answer in an efficient manner according to the programming language you're using.</li>
<li>Iterate <code>i</code> over the indices of <code>nums</code>:
<ul>
<li>Set <code>curr = nums[i][i]</code>.</li>
<li>If <code>curr = "0"</code>, add <code>"1"</code> to <code>ans</code>. Otherwise, add <code>"0"</code> to <code>ans</code>.</li>
</ul>
</li>
<li>Return <code>ans</code>.</li>
</ol>
 */
class FindUniqueBinaryString_Solution {
    // 0 ms 40.8 MB 
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<nums.length;i++)
        {
            sb.append(nums[i].charAt(i) == '0'? "1": "0");
        }
        return new String(sb);
    }
}