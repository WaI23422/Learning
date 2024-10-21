package Hard.Number;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/">1269.Number of Ways to Stay in the Same Place After Some Steps</a>
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>You have a pointer at index <code>0</code> in an array of size <code>arrLen</code>. At each step, you can move 1 position to the left, 1 position to the right in the array, or stay in the same place (The pointer should not be placed outside the array at any time).</p>

<p>Given two integers <code>steps</code> and <code>arrLen</code>, return the number of ways such that your pointer is still at index <code>0</code> after <strong>exactly</strong> <code>steps</code> steps. Since the answer may be too large, return it <strong>modulo</strong> <code>10<sup>9</sup> + 7</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> steps = 3, arrLen = 2
<strong>Output:</strong> 4
<strong>Explanation: </strong>There are 4 differents ways to stay at index 0 after 3 steps.
Right, Left, Stay
Stay, Right, Left
Right, Stay, Left
Stay, Stay, Stay
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> steps = 2, arrLen = 4
<strong>Output:</strong> 2
<strong>Explanation:</strong> There are 2 differents ways to stay at index 0 after 2 steps
Right, Left
Stay, Stay
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> steps = 4, arrLen = 2
<strong>Output:</strong> 8
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= steps &lt;= 500</code></li>
	<li><code>1 &lt;= arrLen &lt;= 10<sup>6</sup></code></li>
</ul>
</div></div>
 */
public class NumberOfWaysToStayInTheSamePlaceAfterSomeSteps {
    public static void main(String[] args) {
        int steps = 3,arrLen = 4;

        NumberOfWaysToStayInTheSamePlaceAfterSomeSteps_Solution result = new NumberOfWaysToStayInTheSamePlaceAfterSomeSteps_Solution();

        System.out.println(result.numWays(steps, arrLen));
    } 
}   

class NumberOfWaysToStayInTheSamePlaceAfterSomeSteps_Solution {
    public int numWays(int steps, int arrLen) {
        
        // @see: BetterCodeAnswer.Hard.Number.NumberOfWaysToStayInTheSamePlaceAfterSomeSteps

        return 0;
    }
}