package BetterCodeAnswer.Hard.TreeNode;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/find-the-maximum-sum-of-node-values/">3068. Find the Maximum Sum of Node Values</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>There exists an <strong>undirected</strong> tree with <code>n</code> nodes numbered <code>0</code> to <code>n - 1</code>. You are given a <strong>0-indexed</strong> 2D integer array <code>edges</code> of length <code>n - 1</code>, where <code>edges[i] = [u<sub>i</sub>, v<sub>i</sub>]</code> indicates that there is an edge between nodes <code>u<sub>i</sub></code> and <code>v<sub>i</sub></code> in the tree. You are also given a <strong>positive</strong> integer <code>k</code>, and a <strong>0-indexed</strong> array of <strong>non-negative</strong> integers <code>nums</code> of length <code>n</code>, where <code>nums[i]</code> represents the <strong>value</strong> of the node numbered <code>i</code>.</p>

<p>Alice wants the sum of values of tree nodes to be <strong>maximum</strong>, for which Alice can perform the following operation <strong>any</strong> number of times (<strong>including zero</strong>) on the tree:</p>

<ul>
	<li>Choose any edge <code>[u, v]</code> connecting the nodes <code>u</code> and <code>v</code>, and update their values as follows:

	<ul>
		<li><code>nums[u] = nums[u] XOR k</code></li>
		<li><code>nums[v] = nums[v] XOR k</code></li>
	</ul>
	</li>
</ul>

<p>Return <em>the <strong>maximum</strong> possible <strong>sum</strong> of the <strong>values</strong> Alice can achieve by performing the operation <strong>any</strong> number of times</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2023/11/09/screenshot-2023-11-10-012513.png" style="width: 300px; height: 277px; padding: 10px; background: rgb(255, 255, 255); border-radius: 0.5rem;">
<pre><strong>Input:</strong> nums = [1,2,1], k = 3, edges = [[0,1],[0,2]]
<strong>Output:</strong> 6
<strong>Explanation:</strong> Alice can achieve the maximum sum of 6 using a single operation:
- Choose the edge [0,2]. nums[0] and nums[2] become: 1 XOR 3 = 2, and the array nums becomes: [1,2,1] -&gt; [2,2,2].
The total sum of values is 2 + 2 + 2 = 6.
It can be shown that 6 is the maximum achievable sum of values.
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2024/01/09/screenshot-2024-01-09-220017.png" style="padding: 10px; background: rgb(255, 255, 255); border-radius: 0.5rem; width: 300px; height: 239px;">
<pre><strong>Input:</strong> nums = [2,3], k = 7, edges = [[0,1]]
<strong>Output:</strong> 9
<strong>Explanation:</strong> Alice can achieve the maximum sum of 9 using a single operation:
- Choose the edge [0,1]. nums[0] becomes: 2 XOR 7 = 5 and nums[1] become: 3 XOR 7 = 4, and the array nums becomes: [2,3] -&gt; [5,4].
The total sum of values is 5 + 4 = 9.
It can be shown that 9 is the maximum achievable sum of values.
</pre>

<p><strong class="example">Example 3:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2023/11/09/screenshot-2023-11-10-012641.png" style="width: 600px; height: 233px; padding: 10px; background: rgb(255, 255, 255); border-radius: 0.5rem;">
<pre><strong>Input:</strong> nums = [7,7,7,7,7,7], k = 3, edges = [[0,1],[0,2],[0,3],[0,4],[0,5]]
<strong>Output:</strong> 42
<strong>Explanation:</strong> The maximum achievable sum is 42 which can be achieved by Alice performing no operations.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= n == nums.length &lt;= 2 * 10<sup>4</sup></code></li>
	<li><code>1 &lt;= k &lt;= 10<sup>9</sup></code></li>
	<li><code>0 &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
	<li><code>edges.length == n - 1</code></li>
	<li><code>edges[i].length == 2</code></li>
	<li><code>0 &lt;= edges[i][0], edges[i][1] &lt;= n - 1</code></li>
	<li>The input is generated such that <code>edges</code> represent&nbsp;a valid tree.</li>
</ul>
</div>
 */
public class FindTheMaximumSumOfNodeValues {
    public static void main(String[] args) {
    }
}

// 8 ms 55.2 MB
class FindTheMaximumSumOfNodeValues_Solution {

    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        
        long sum = 0;
        long minExtra = 1000000;
        int count = 0;

        for( int val : nums) {
            if ((val ^ k) > val ) {
                sum += val ^ k;
                minExtra = Math.min(minExtra, (val ^ k)- val);
                count++;
            } else {
                sum += val;
                minExtra = Math.min(minExtra, val - (val ^ k));
            }
        }

        if ( count %2 ==0 ) {
            return sum;
        } else {
            return sum - minExtra;
        }

    }
}

// 2 ms 54.4 MB
class FindTheMaximumSumOfNodeValues_Solution2 {
    public long maximumValueSum(int[] A, int k, int[][] edges) {
          long res = 0;
        int d = 1 << 30, c = 0;
        for (int a : A) {
            int b = a ^ k;
            res += Math.max(a, b);
            c ^= a < b ? 1 : 0;
            d = Math.min(d, Math.abs(a - b));
        }
        return res - d * c;
    }
}

// 1 ms 54.4 MB
/**
 * <h3 id="approach-4-greedy-finding-local-maxima-and-minima" level="3" class="group/heading relative"><a href="#approach-4-greedy-finding-local-maxima-and-minima" class="!text-sd-muted-foreground absolute right-full top-1/2 -translate-y-1/2 cursor-pointer pr-0.5 text-xs opacity-0 group-hover/heading:opacity-100" aria-hidden="true" tabindex="-1"><div class="relative text-[12px] leading-[normal] p-[1px] before:block before:h-3 before:w-3"><svg aria-hidden="true" focusable="false" data-prefix="fas" data-icon="link" class="svg-inline--fa fa-link absolute left-1/2 top-1/2 -translate-x-1/2 -translate-y-1/2" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 640 512" spacing="square"><path fill="currentColor" d="M579.8 267.7c56.5-56.5 56.5-148 0-204.5c-50-50-128.8-56.5-186.3-15.4l-1.6 1.1c-14.4 10.3-17.7 30.3-7.4 44.6s30.3 17.7 44.6 7.4l1.6-1.1c32.1-22.9 76-19.3 103.8 8.6c31.5 31.5 31.5 82.5 0 114L422.3 334.8c-31.5 31.5-82.5 31.5-114 0c-27.9-27.9-31.5-71.8-8.6-103.8l1.1-1.6c10.3-14.4 6.9-34.4-7.4-44.6s-34.4-6.9-44.6 7.4l-1.1 1.6C206.5 251.2 213 330 263 380c56.5 56.5 148 56.5 204.5 0L579.8 267.7zM60.2 244.3c-56.5 56.5-56.5 148 0 204.5c50 50 128.8 56.5 186.3 15.4l1.6-1.1c14.4-10.3 17.7-30.3 7.4-44.6s-30.3-17.7-44.6-7.4l-1.6 1.1c-32.1 22.9-76 19.3-103.8-8.6C74 372 74 321 105.5 289.5L217.7 177.2c31.5-31.5 82.5-31.5 114 0c27.9 27.9 31.5 71.8 8.6 103.9l-1.1 1.6c-10.3 14.4-6.9 34.4 7.4 44.6s34.4 6.9 44.6-7.4l1.1-1.6C433.5 260.8 427 182 377 132c-56.5-56.5-148-56.5-204.5 0L60.2 244.3z"></path></svg></div></a>Approach 4: Greedy (Finding local maxima and minima)</h3>
 * <h4 id="intuition-3">Intuition</h4>
 * <p>Recall that "effective operation" allows us to pick any two nodes and perform an operation on it. Let's assume for two nodes, the <code>netChange</code> values are positive. If we pick both these nodes as a pair to perform "effective operation", the node sum value will be increased. So, we can observe that if the number of elements with positive <code>netChange</code> values is even, then all of them can be included in the final sum to maximize it.</p>
 * <p>If the number of elements with positive <code>netChange</code> values is <strong>odd</strong>, then let's assume that <code>positiveMinimum</code> denotes the <strong>minimum positive</strong> value and <code>negativeMaximum</code> denotes the <strong>maximum non-positive</strong> value in the <code>netChange</code> array. It is clear that both these values will occur as a pair in the <code>netChange</code> array.</p>
 * <p>Now, there can be two cases for the same:-</p>
 * <ol>
<li>
<p>If the sum of <code>positiveMinimum</code> and <code>negativeMaximum</code> is greater than zero, then the node value sum will be increased by including this pair. So, we include both elements.</p>
</li>
<li>
<p>If the sum of <code>positiveMinimum</code> and <code>negativeMaximum</code> is less than or equal to zero, then the node value sum will be decreased or have no change on including this pair. So, we exclude this pair.</p>
</li>
</ol>
<p>Therefore, we don't need the <code>netChange</code> array from the previous approach. We calculate <code>positiveMinimum</code> and <code>negativeMaximum</code> values which is enough to calculate the maximum node value sum possible for the array.</p>
<h4 id="algorithm-3">Algorithm</h4>
<ol>
<li>Initialize integers <code>positiveMinimum</code> and <code>negativeMaximum</code> with <code>INT_MAX</code> and <code>INT_MIN</code> respectively. Also, initialize <code>count</code> and <code>sum</code> with <code>0</code>.</li>
<li>Iterate through the <code>nums</code> array (from <code>0</code> to <code>n - 1</code>):
<ul>
<li>Add the unchanged node values to <code>sum</code>.</li>
<li>Calculate the value of <code>netChange</code> for the current node.
<ul>
<li>If <code>netChange</code> is positive, assign the minimum of <code>netChange</code> and <code>positiveMinimum</code> to <code>positiveMinimum</code>. Add <code>netChange</code> to the <code>sum</code> and increment the <code>count</code> by 1.</li>
<li>If <code>netChange</code> is non-positive, assign the maximum of <code>netChange</code> and <code>negativeMaximum</code> to <code>negativeMaximum</code>.</li>
</ul>
</li>
</ul>
</li>
<li>If the <code>count</code> of number values with positive <code>netChange</code> is even, we return the current <code>sum</code> as the maximum node value sum possible.</li>
<li>If the <code>count</code> is odd, we can either subtract <code>positiveMinimum</code> or add <code>negativeMaximum</code> to make the <code>count</code> even. The maximum of both these cases is returned as the maximum node value sum.</li>
</ol>
<p><div class="relative mx-auto mb-6 flex flex-col overflow-hidden rounded-lg border-[1px] border-label-1" style="max-width: 960px;"><div class="rounded-lg" style="max-height: 540px;"><img alt="Current" class="object-fit-contain !mb-0 max-h-full max-w-full" src="blob:https://leetcode.com/c49c795a-0845-45e6-a752-1f8b060c5fbc"></div><div class="absolute top-[50%] left-[50%] flex h-12 w-12 translate-x-[-50%] translate-y-[-50%] items-center justify-center rounded-full bg-black/30"><div class="flex h-4 w-4 cursor-pointer items-center justify-center text-[35px]"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="1em" height="1em" fill="currentColor" class="h-full w-full text-white"><path fill-rule="evenodd" d="M18.97 12.871l-12.96 7.29a1 1 0 01-1.49-.87V4.71a1 1 0 011.49-.872l12.96 7.29a1 1 0 010 1.743z" clip-rule="evenodd"></path></svg></div></div><div class="relative flex h-8 select-none items-center justify-around bg-black"><div class="flex items-center space-x-7"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="1em" height="1em" fill="currentColor" class="w-4 cursor-pointer text-gray-6 dark:text-dark-gray-6 hover:text-gray-7 dark:hover:text-dark-gray-7"><path fill-rule="evenodd" d="M16.091 4.929l-7.057 7.078 7.057 7.064a1 1 0 01-1.414 1.414l-7.764-7.77a1 1 0 010-1.415l7.764-7.785a1 1 0 111.415 1.414z" clip-rule="evenodd"></path></svg><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="1em" height="1em" fill="currentColor" class="w-4 cursor-pointer text-gray-6 dark:text-dark-gray-6 hover:text-gray-7 dark:hover:text-dark-gray-7"><path fill-rule="evenodd" d="M18.97 12.871l-12.96 7.29a1 1 0 01-1.49-.87V4.71a1 1 0 011.49-.872l12.96 7.29a1 1 0 010 1.743z" clip-rule="evenodd"></path></svg><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="1em" height="1em" fill="currentColor" class="w-4 cursor-pointer text-gray-6 dark:text-dark-gray-6 hover:text-gray-7 dark:hover:text-dark-gray-7"><path fill-rule="evenodd" d="M7.913 19.071l7.057-7.078-7.057-7.064a1 1 0 011.414-1.414l7.764 7.77a1 1 0 010 1.415l-7.764 7.785a1 1 0 01-1.414-1.414z" clip-rule="evenodd"></path></svg></div><div class="absolute right-0 mr-5 text-xs font-medium text-white">1 / 9</div></div></div></p>
 */
class FindTheMaximumSumOfNodeValues_Solution3 {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long sum = 0;
        int count = 0, positiveMinimum = (1 << 30), negativeMaximum = -1 * (1 << 30);

        for (int nodeValue : nums) {
            int operatedNodeValue = nodeValue ^ k;
            sum += nodeValue;
            int netChange = operatedNodeValue - nodeValue;
            if (netChange > 0) {
                positiveMinimum = Math.min(positiveMinimum, netChange);
                sum += netChange;
                count++;
            } else {
                negativeMaximum = Math.max(negativeMaximum, netChange);
            }
        }

        // If the number of positive netChange values is even, return the sum.
        if (count % 2 == 0) {
            return sum;
        }

        // Otherwise return the maximum of both discussed cases.
        return Math.max(sum - positiveMinimum, sum + negativeMaximum);
    }
}
