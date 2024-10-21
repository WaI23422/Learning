package BetterCodeAnswer.Medium.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/">1442. Count Triplets That Can Form Two Arrays of Equal XOR</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given an array of integers <code>arr</code>.</p>
 * 
 * <p>We want to select three indices <code>i</code>, <code>j</code> and <code>k</code> where <code>(0 &lt;= i &lt; j &lt;= k &lt; arr.length)</code>.</p>
 * 
 * <p>Let's define <code>a</code> and <code>b</code> as follows:</p>
 * 
 * <ul>
 * 	<li><code>a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]</code></li>
 * 	<li><code>b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]</code></li>
 * </ul>
 * 
 * <p>Note that <strong>^</strong> denotes the <strong>bitwise-xor</strong> operation.</p>
 * 
 * <p>Return <em>the number of triplets</em> (<code>i</code>, <code>j</code> and <code>k</code>) Where <code>a == b</code>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> arr = [2,3,1,6,7]
 * <strong>Output:</strong> 4
 * <strong>Explanation:</strong> The triplets are (0,1,2), (0,2,2), (2,3,4) and (2,4,4)
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> arr = [1,1,1,1,1]
 * <strong>Output:</strong> 10
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= arr.length &lt;= 300</code></li>
 * 	<li><code>1 &lt;= arr[i] &lt;= 10<sup>8</sup></code></li>
 * </ul>
 * </div>
 */
public class CountTripletsThatCanFormTwoArraysOfEqualXOR {
    public static void main(String[] args) {
        int[][] tests = {
            {2,3,1,6,7}
        };

        for (int[] arr : tests) {
            System.out.println(new CountTripletsThatCanFormTwoArraysOfEqualXOR_Solution().countTriplets(arr));
        }
    }
}

// 24 ms 41 MB
/**
 * 
 * <h3 id="approach-1-brute-force-with-prefix" level="3" class="group/heading relative"><a href="#approach-1-brute-force-with-prefix" class="!text-sd-muted-foreground absolute right-full top-1/2 -translate-y-1/2 cursor-pointer pr-0.5 text-xs opacity-0 group-hover/heading:opacity-100" aria-hidden="true" tabindex="-1"><div class="relative text-[12px] leading-[normal] p-[1px] before:block before:h-3 before:w-3"><svg aria-hidden="true" focusable="false" data-prefix="fas" data-icon="link" class="svg-inline--fa fa-link absolute left-1/2 top-1/2 -translate-x-1/2 -translate-y-1/2" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 640 512" spacing="square"><path fill="currentColor" d="M579.8 267.7c56.5-56.5 56.5-148 0-204.5c-50-50-128.8-56.5-186.3-15.4l-1.6 1.1c-14.4 10.3-17.7 30.3-7.4 44.6s30.3 17.7 44.6 7.4l1.6-1.1c32.1-22.9 76-19.3 103.8 8.6c31.5 31.5 31.5 82.5 0 114L422.3 334.8c-31.5 31.5-82.5 31.5-114 0c-27.9-27.9-31.5-71.8-8.6-103.8l1.1-1.6c10.3-14.4 6.9-34.4-7.4-44.6s-34.4-6.9-44.6 7.4l-1.1 1.6C206.5 251.2 213 330 263 380c56.5 56.5 148 56.5 204.5 0L579.8 267.7zM60.2 244.3c-56.5 56.5-56.5 148 0 204.5c50 50 128.8 56.5 186.3 15.4l1.6-1.1c14.4-10.3 17.7-30.3 7.4-44.6s-30.3-17.7-44.6-7.4l-1.6 1.1c-32.1 22.9-76 19.3-103.8-8.6C74 372 74 321 105.5 289.5L217.7 177.2c31.5-31.5 82.5-31.5 114 0c27.9 27.9 31.5 71.8 8.6 103.9l-1.1 1.6c-10.3 14.4-6.9 34.4 7.4 44.6s34.4 6.9 44.6-7.4l1.1-1.6C433.5 260.8 427 182 377 132c-56.5-56.5-148-56.5-204.5 0L60.2 244.3z"></path></svg></div></a>Approach 1: Brute Force With Prefix</h3>
 * <h4 id="intuition">Intuition</h4>
 * <p>We can exhaustively iterate through every possible triplet <span class="math math-inline"><span class="katex"><span class="katex-mathml">(i,j,k)(i, j, k)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mopen">(</span><span class="mord mathnormal">i</span><span class="mpunct">,</span><span class="mspace" style="margin-right: 0.1667em;"></span><span class="mord mathnormal" style="margin-right: 0.05724em;">j</span><span class="mpunct">,</span><span class="mspace" style="margin-right: 0.1667em;"></span><span class="mord mathnormal" style="margin-right: 0.03148em;">k</span><span class="mclose">)</span></span></span></span></span> and check if the <strong>XOR</strong> of the subarrays <span class="math math-inline"><span class="katex"><span class="katex-mathml">(i,j−1)(i, j-1)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mopen">(</span><span class="mord mathnormal">i</span><span class="mpunct">,</span><span class="mspace" style="margin-right: 0.1667em;"></span><span class="mord mathnormal" style="margin-right: 0.05724em;">j</span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">−</span><span class="mspace" style="margin-right: 0.2222em;"></span></span><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord">1</span><span class="mclose">)</span></span></span></span></span> and <span class="math math-inline"><span class="katex"><span class="katex-mathml">(j,k)(j, k)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mopen">(</span><span class="mord mathnormal" style="margin-right: 0.05724em;">j</span><span class="mpunct">,</span><span class="mspace" style="margin-right: 0.1667em;"></span><span class="mord mathnormal" style="margin-right: 0.03148em;">k</span><span class="mclose">)</span></span></span></span></span> is equal.</p>
 * <p>First, we iterate over each possible starting index <code>start</code> of the triplet. For each <code>start</code>, we initialize a variable <code>xorA</code> to store the <strong>XOR</strong> (bitwise exclusive OR) of elements from the <code>start</code> index to the index just before the <code>mid</code> index. We then iterate over each possible <code>mid</code> index, updating <code>xorA</code> by <strong>XOR</strong>ing it with the element at the index just before <code>mid</code>.</p>
 * <p>Next, for each <code>mid</code> index, we initialize another variable, <code>xorB</code>, to store the <strong>XOR</strong> of elements from the <code>mid</code> index to the end of the array. We iterate over each possible ending index <code>end</code>, starting from <code>mid</code>, updating <code>xorB</code> by <strong>XOR</strong>ing it with the element at the <code>end</code> index.</p>
 * <p>After computing <code>xorA</code> and <code>xorB</code>, we check if they are equal. If they are, it means that the <strong>XOR</strong> of elements in the first subarray (from <code>start</code> to <code>mid - 1</code>) is equal to the <strong>XOR</strong> of elements in the second subarray (from <code>mid</code> to <code>end</code>). In this case, we have found a valid triplet satisfying the condition, so we increment the result counter.</p>
 * <h4 id="algorithm">Algorithm</h4>
 * <ul>
 * <li>Initialize a result variable <code>count</code> to 0 to store the count of valid triplets.</li>
 * <li>Iterate over each possible starting index <code>start</code>.
 * <ul>
 * <li>Initialize <code>xorA</code> to 0 (<strong>XOR</strong> value for the subarray from <code>start</code> to <code>mid - 1</code>)</li>
 * <li>Iterate over each possible middle index <code>mid</code>.
 * <ul>
 * <li>Update <code>xorA</code> by <strong>XOR</strong>ing it with <code>arr[mid - 1]</code> (including the element at <code>mid - 1</code> in the <strong>XOR</strong> computation).</li>
 * <li>Initialize <code>xorB</code> to 0 (<strong>XOR</strong> value for the subarray from <code>mid</code> to <code>end</code>).</li>
 * <li>Iterate over each possible ending index <code>end</code>, starting from <code>mid</code>.
 * <ul>
 * <li>Update <code>xorB</code> by <strong>XOR</strong>ing it with <code>arr[end]</code>.</li>
 * <li>If we find a valid triplet where the <strong>XOR</strong> of the first subarray is equal to the <strong>XOR</strong> of the second subarray(<code>xorA == xorB</code>), increment the count of valid triplets <code>count</code>.</li>
 * </ul>
 * </li>
 * </ul>
 * </li>
 * </ul>
 * </li>
 * <li>Return the final count of valid triplets <code>count</code>.</li>
 * </ul>
 * <h4 id="implementation">Implementation</h4>
 * <iframe src="https://leetcode.com/playground/42RCJ4NE/shared" width="100%" height="500" name="user-content-42RCJ4NE" allowfullscreen="" translate="no"></iframe>
 * <h4 id="complexity-analysis">Complexity Analysis</h4>
 * <p>Let <span class="math math-inline"><span class="katex"><span class="katex-mathml">nn</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.4306em;"></span><span class="mord mathnormal">n</span></span></span></span></span> be the size of the input array.</p>
 * <ul>
 * <li>
 * <p>Time complexity: <span class="math math-inline"><span class="katex"><span class="katex-mathml">O(n3)O(n^3)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1.0641em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mord"><span class="mord mathnormal">n</span><span class="msupsub"><span class="vlist-t"><span class="vlist-r"><span class="vlist" style="height: 0.8141em;"><span style="top: -3.063em; margin-right: 0.05em;"><span class="pstrut" style="height: 2.7em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight">3</span></span></span></span></span></span></span></span><span class="mclose">)</span></span></span></span></span></p>
 * <p>There are three nested loops, each iterating over the entire array, resulting in a time complexity of <span class="math math-inline"><span class="katex"><span class="katex-mathml">O(n⋅n⋅n)=O(n3)O(n \cdot n \cdot n) = O(n^3)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mord mathnormal">n</span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">⋅</span><span class="mspace" style="margin-right: 0.2222em;"></span></span><span class="base"><span class="strut" style="height: 0.4445em;"></span><span class="mord mathnormal">n</span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">⋅</span><span class="mspace" style="margin-right: 0.2222em;"></span></span><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal">n</span><span class="mclose">)</span><span class="mspace" style="margin-right: 0.2778em;"></span><span class="mrel">=</span><span class="mspace" style="margin-right: 0.2778em;"></span></span><span class="base"><span class="strut" style="height: 1.0641em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mord"><span class="mord mathnormal">n</span><span class="msupsub"><span class="vlist-t"><span class="vlist-r"><span class="vlist" style="height: 0.8141em;"><span style="top: -3.063em; margin-right: 0.05em;"><span class="pstrut" style="height: 2.7em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight">3</span></span></span></span></span></span></span></span><span class="mclose">)</span></span></span></span></span>.</p>
 * </li>
 * <li>
 * <p>Space complexity: <span class="math math-inline"><span class="katex"><span class="katex-mathml">O(1)O(1)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mord">1</span><span class="mclose">)</span></span></span></span></span></p>
 * <p>We only use a few variables (<code>count</code>, <code>xorA</code>, <code>xorB</code>) to store intermediate results, which take constant space.</p>
 * </li>
 * </ul>
 * <hr>
 */
class CountTripletsThatCanFormTwoArraysOfEqualXOR_Solution {

    public int countTriplets(int[] arr) {
        int count = 0;

        // Iterate over each possible starting index i
        for (int start = 0; start < arr.length - 1; ++start) {
            // Initialize XOR value for the subarray from start to mid-1
            int xorA = 0;

            // Iterate over each possible middle index j
            for (int mid = start + 1; mid < arr.length; ++mid) {
                // Update xorA to include arr[mid - 1]
                xorA ^= arr[mid - 1];

                // Initialize XOR value for the subarray from mid to end
                int xorB = 0;

                // Iterate over each possible ending index k (starting from mid)
                for (int end = mid; end < arr.length; ++end) {
                    // Update xorB to include arr[end]
                    xorB ^= arr[end];

                    // found a valid triplet (start, mid, end)
                    if (xorA == xorB) {
                        ++count;
                    }
                }
            }
        }

        return count;
    }
}

// 2 ms 41.3 MB
/**
 * <h3 id="approach-2-nested-prefix-xor" level="3" class="group/heading relative"><a href="#approach-2-nested-prefix-xor" class="!text-sd-muted-foreground absolute right-full top-1/2 -translate-y-1/2 cursor-pointer pr-0.5 text-xs opacity-0 group-hover/heading:opacity-100" aria-hidden="true" tabindex="-1"><div class="relative text-[12px] leading-[normal] p-[1px] before:block before:h-3 before:w-3"><svg aria-hidden="true" focusable="false" data-prefix="fas" data-icon="link" class="svg-inline--fa fa-link absolute left-1/2 top-1/2 -translate-x-1/2 -translate-y-1/2" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 640 512" spacing="square"><path fill="currentColor" d="M579.8 267.7c56.5-56.5 56.5-148 0-204.5c-50-50-128.8-56.5-186.3-15.4l-1.6 1.1c-14.4 10.3-17.7 30.3-7.4 44.6s30.3 17.7 44.6 7.4l1.6-1.1c32.1-22.9 76-19.3 103.8 8.6c31.5 31.5 31.5 82.5 0 114L422.3 334.8c-31.5 31.5-82.5 31.5-114 0c-27.9-27.9-31.5-71.8-8.6-103.8l1.1-1.6c10.3-14.4 6.9-34.4-7.4-44.6s-34.4-6.9-44.6 7.4l-1.1 1.6C206.5 251.2 213 330 263 380c56.5 56.5 148 56.5 204.5 0L579.8 267.7zM60.2 244.3c-56.5 56.5-56.5 148 0 204.5c50 50 128.8 56.5 186.3 15.4l1.6-1.1c14.4-10.3 17.7-30.3 7.4-44.6s-30.3-17.7-44.6-7.4l-1.6 1.1c-32.1 22.9-76 19.3-103.8-8.6C74 372 74 321 105.5 289.5L217.7 177.2c31.5-31.5 82.5-31.5 114 0c27.9 27.9 31.5 71.8 8.6 103.9l-1.1 1.6c-10.3 14.4-6.9 34.4 7.4 44.6s34.4 6.9 44.6-7.4l1.1-1.6C433.5 260.8 427 182 377 132c-56.5-56.5-148-56.5-204.5 0L60.2 244.3z"></path></svg></div></a>Approach 2: Nested Prefix <strong>XOR</strong></h3>
 * <h4 id="intuition-1">Intuition</h4>
 * <p>To improve the time complexity, we can precompute the prefix <strong>XOR</strong> of the array. The prefix <strong>XOR</strong> at an index <code>i</code> is the <strong>XOR</strong> of all elements from the beginning of the array up to (and including) index <code>i</code>.</p>
 * <p>First, we create a modified copy of the input array and insert 0 at the beginning to facilitate <strong>XOR</strong> operations. We then perform <strong>XOR</strong> operations on consecutive elements in this modified array, effectively storing the prefix <strong>XOR</strong> at each index.</p>
 * <p>Next, we iterate through the modified array (<code>prefixXOR</code>), considering each possible pair of indices <code>start</code> and <code>end</code>, where <code>start</code> is less than <code>end</code>. We use the equal <strong>XOR</strong> condition mentioned in the overview. If the prefix <strong>XOR</strong> values at indices <code>start</code> and <code>end</code> are equal, it means the <strong>XOR</strong> of elements between <code>start</code> and <code>end</code> (excluding <code>start</code> and <code>end</code>) is 0. In this case, we increment the result counter by the count of valid triplets that can be formed with <code>start</code> as the start index and <code>end</code> as the end index, which is <code>end - start - 1</code>.</p>
 * <p>By precomputing the prefix <strong>XOR</strong>, we became a little more efficient in counting the triplets without explicitly iterating over all possible triplets.</p>
 * <h4 id="algorithm-1">Algorithm</h4>
 * <ul>
 * <li>Create a modified copy <code>prefixXOR</code> of the input array <code>arr</code> to avoid modifying the original array.</li>
 * <li>Insert 0 at the beginning of the modified array <code>prefixXOR</code> to handle the case when the <strong>XOR</strong> operation is performed on the first element.</li>
 * <li>Calculate the prefix <strong>XOR</strong> at each position in <code>prefixXOR</code> so that we can reference the precomputed <strong>XOR</strong> of elements from the beginning up to each index.
 * <ul>
 * <li>Iterate over <code>prefixXOR</code> starting from index 1.
 * <ul>
 * <li>Update <code>prefixXOR[i]</code> by <strong>XOR</strong>ing it with <code>prefixXOR[i - 1]</code>.</li>
 * </ul>
 * </li>
 * </ul>
 * </li>
 * <li>Initialize <code>count</code> with 0 to store the count of valid triplets.</li>
 * <li>Iterate over <code>prefixXOR</code> starting from index 0:
 * <ul>
 * <li>Now, iterate over <code>prefixXOR</code> starting from <code>start + 1</code>:
 * <ul>
 * <li>If <code>prefixXOR[start] == prefixXOR[end]</code> (found a pair of indices <code>start</code> and <code>end</code> where the <strong>XOR</strong> of elements between them is 0)
 * <ul>
 * <li>Increment <code>count</code> by <code>end - start - 1</code> (count of valid triplets with <code>start</code> as start and <code>end</code> as end).</li>
 * </ul>
 * </li>
 * </ul>
 * </li>
 * </ul>
 * </li>
 * <li>Return the final count of valid triplets <code>count</code>.</li>
 * </ul>
 * <h4 id="implementation-1">Implementation</h4>
 * <iframe src="https://leetcode.com/playground/4fwgpDBp/shared" width="100%" height="500" name="user-content-4fwgpDBp" allowfullscreen="" translate="no"></iframe>
 * <h4 id="complexity-analysis-1">Complexity Analysis</h4>
 * <p>Let <span class="math math-inline"><span class="katex"><span class="katex-mathml">nn</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.4306em;"></span><span class="mord mathnormal">n</span></span></span></span></span> be the size of the input array.</p>
 * <ul>
 * <li>
 * <p>Time complexity: <span class="math math-inline"><span class="katex"><span class="katex-mathml">O(n2)O(n^2)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1.0641em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mord"><span class="mord mathnormal">n</span><span class="msupsub"><span class="vlist-t"><span class="vlist-r"><span class="vlist" style="height: 0.8141em;"><span style="top: -3.063em; margin-right: 0.05em;"><span class="pstrut" style="height: 2.7em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight">2</span></span></span></span></span></span></span></span><span class="mclose">)</span></span></span></span></span></p>
 * <p>There are two nested loops, each iterating over the array, resulting in a time complexity of <span class="math math-inline"><span class="katex"><span class="katex-mathml">O(n⋅n)=O(n2)O(n \cdot n) = O(n^2)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mord mathnormal">n</span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">⋅</span><span class="mspace" style="margin-right: 0.2222em;"></span></span><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal">n</span><span class="mclose">)</span><span class="mspace" style="margin-right: 0.2778em;"></span><span class="mrel">=</span><span class="mspace" style="margin-right: 0.2778em;"></span></span><span class="base"><span class="strut" style="height: 1.0641em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mord"><span class="mord mathnormal">n</span><span class="msupsub"><span class="vlist-t"><span class="vlist-r"><span class="vlist" style="height: 0.8141em;"><span style="top: -3.063em; margin-right: 0.05em;"><span class="pstrut" style="height: 2.7em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight">2</span></span></span></span></span></span></span></span><span class="mclose">)</span></span></span></span></span>.</p>
 * </li>
 * <li>
 * <p>Space complexity: <span class="math math-inline"><span class="katex"><span class="katex-mathml">O(n)O(n)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mord mathnormal">n</span><span class="mclose">)</span></span></span></span></span></p>
 * <p>We create a new array <code>prefixXOR</code> of the same size as the input array, taking <span class="math math-inline"><span class="katex"><span class="katex-mathml">O(n)O(n)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mord mathnormal">n</span><span class="mclose">)</span></span></span></span></span> space.</p>
 * <blockquote>
 * <p>Note: This approach could be implemented with <span class="math math-inline"><span class="katex"><span class="katex-mathml">O(1)O(1)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mord">1</span><span class="mclose">)</span></span></span></span></span> space by modifying the original array.</p>
 * </blockquote>
 * </li>
 * </ul>
 * <hr>
 */
class CountTripletsThatCanFormTwoArraysOfEqualXOR_Solution2 {

    public int countTriplets(int[] arr) {
        int[] prefixXOR = new int[arr.length + 1];
        prefixXOR[0] = 0;
        System.arraycopy(arr, 0, prefixXOR, 1, arr.length);
        int size = prefixXOR.length;

        // Perform XOR on consecutive elements in the modified array
        for (int i = 1; i < size; i++) {
            prefixXOR[i] ^= prefixXOR[i - 1];
        }

        int count = 0;

        // Iterate through the modified array to count triplets
        for (int start = 0; start < size; start++) {
            for (int end = start + 1; end < size; end++) {
                if (prefixXOR[start] == prefixXOR[end]) {
                    // Increment the result by the count of valid triplets
                    count += end - start - 1;
                }
            }
        }

        return count;
    }
}

// 2 ms 41.4 MB
/**
 * <h3 id="approach-3-two-pass-prefix-xor" level="3" class="group/heading relative"><a href="#approach-3-two-pass-prefix-xor" class="!text-sd-muted-foreground absolute right-full top-1/2 -translate-y-1/2 cursor-pointer pr-0.5 text-xs opacity-0 group-hover/heading:opacity-100" aria-hidden="true" tabindex="-1"><div class="relative text-[12px] leading-[normal] p-[1px] before:block before:h-3 before:w-3"><svg aria-hidden="true" focusable="false" data-prefix="fas" data-icon="link" class="svg-inline--fa fa-link absolute left-1/2 top-1/2 -translate-x-1/2 -translate-y-1/2" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 640 512" spacing="square"><path fill="currentColor" d="M579.8 267.7c56.5-56.5 56.5-148 0-204.5c-50-50-128.8-56.5-186.3-15.4l-1.6 1.1c-14.4 10.3-17.7 30.3-7.4 44.6s30.3 17.7 44.6 7.4l1.6-1.1c32.1-22.9 76-19.3 103.8 8.6c31.5 31.5 31.5 82.5 0 114L422.3 334.8c-31.5 31.5-82.5 31.5-114 0c-27.9-27.9-31.5-71.8-8.6-103.8l1.1-1.6c10.3-14.4 6.9-34.4-7.4-44.6s-34.4-6.9-44.6 7.4l-1.1 1.6C206.5 251.2 213 330 263 380c56.5 56.5 148 56.5 204.5 0L579.8 267.7zM60.2 244.3c-56.5 56.5-56.5 148 0 204.5c50 50 128.8 56.5 186.3 15.4l1.6-1.1c14.4-10.3 17.7-30.3 7.4-44.6s-30.3-17.7-44.6-7.4l-1.6 1.1c-32.1 22.9-76 19.3-103.8-8.6C74 372 74 321 105.5 289.5L217.7 177.2c31.5-31.5 82.5-31.5 114 0c27.9 27.9 31.5 71.8 8.6 103.9l-1.1 1.6c-10.3 14.4-6.9 34.4 7.4 44.6s34.4 6.9 44.6-7.4l1.1-1.6C433.5 260.8 427 182 377 132c-56.5-56.5-148-56.5-204.5 0L60.2 244.3z"></path></svg></div></a>Approach 3: Two Pass Prefix <strong>XOR</strong></h3>
 * <h4 id="intuition-2">Intuition</h4>
 * <p>Building upon the previous approach, we can further optimize the time complexity to <span class="math math-inline"><span class="katex"><span class="katex-mathml">O(n)O(n)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mord mathnormal">n</span><span class="mclose">)</span></span></span></span></span> by using two helper data structures: a map <code>countMap</code> to store the count of each <strong>XOR</strong> value encountered, and a map <code>totalMap</code> to store the total sum of indices for each <strong>XOR</strong> value.</p>
 * <p>The key observation is that for a given <strong>XOR</strong> value <code>x</code>, the contribution of <code>x</code> to the result is the count of occurrences of <code>x</code> multiplied by the number of valid triplets that can be formed with <code>x</code> as the middle <strong>XOR</strong> value. The number of valid triplets can be calculated as <code>(i - 1) - totalSum</code>, where <code>i</code> is the current index, and <code>totalSum</code> is the sum of indices where <code>x</code> occurred previously.</p>
 * <p>For example, let's say at index <code>i = 5</code>, the <strong>XOR</strong> value <code>x</code> is <code>6</code>. If <code>6</code> occurred previously at indices <code>1</code> and <code>2</code>, then <code>countMap[6] = 2</code> and <code>totalMap[6] = 3</code> (the sum of indices <code>1 + 2</code>). Now, the number of valid triplets at index <code>i = 5</code> is <code>(5 - 1) - 3 = 4 - 3 = 1</code>. So, the contribution of <code>6</code> to the total count of valid triplets is <code>2 * (1) = 2</code>. This calculation is performed for each <strong>XOR</strong> value encountered in the array, and the contributions are added up to find the total count of valid triplets.</p>
 * <p>First, we insert 0 at the beginning of the input array to handle the case when the <strong>XOR</strong> operation is performed on the first element. We then perform <strong>XOR</strong> operations on consecutive elements in the array, effectively storing the prefix <strong>XOR</strong> at each index.</p>
 * <p>Next, we maintain a map <code>countMap</code> with a key-value pair <code>{0: 1}</code> to handle the case when the <strong>XOR</strong> value is 0. Then, we iterate through the array and consider each index <code>i</code>. For the current index <code>i</code>, we calculate the contribution of the current <strong>XOR</strong> value (<code>prefixXOR[i]</code>) to the result by adding <code>countMap[prefixXOR[i]] * (i - 1) - totalMap[prefixXOR[i]]</code> to the result counter.</p>
 * <p>How did we develop this approach?</p>
 * <p>We want to find the count of triplets <span class="math math-inline"><span class="katex"><span class="katex-mathml">(i,j,k)(i, j, k)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mopen">(</span><span class="mord mathnormal">i</span><span class="mpunct">,</span><span class="mspace" style="margin-right: 0.1667em;"></span><span class="mord mathnormal" style="margin-right: 0.05724em;">j</span><span class="mpunct">,</span><span class="mspace" style="margin-right: 0.1667em;"></span><span class="mord mathnormal" style="margin-right: 0.03148em;">k</span><span class="mclose">)</span></span></span></span></span> such that the <strong>XOR</strong> of elements from index <span class="math math-inline"><span class="katex"><span class="katex-mathml">ii</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.6595em;"></span><span class="mord mathnormal">i</span></span></span></span></span> to <span class="math math-inline"><span class="katex"><span class="katex-mathml">j−1j-1</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.854em; vertical-align: -0.1944em;"></span><span class="mord mathnormal" style="margin-right: 0.05724em;">j</span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">−</span><span class="mspace" style="margin-right: 0.2222em;"></span></span><span class="base"><span class="strut" style="height: 0.6444em;"></span><span class="mord">1</span></span></span></span></span> is equal to the <strong>XOR</strong> of elements from index <span class="math math-inline"><span class="katex"><span class="katex-mathml">jj</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.854em; vertical-align: -0.1944em;"></span><span class="mord mathnormal" style="margin-right: 0.05724em;">j</span></span></span></span></span> to <span class="math math-inline"><span class="katex"><span class="katex-mathml">kk</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.6944em;"></span><span class="mord mathnormal" style="margin-right: 0.03148em;">k</span></span></span></span></span>. Let's call this common <strong>XOR</strong> value <span class="math math-inline"><span class="katex"><span class="katex-mathml">xx</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.4306em;"></span><span class="mord mathnormal">x</span></span></span></span></span>.</p>
 * <p>Now, consider a specific <strong>XOR</strong> value <span class="math math-inline"><span class="katex"><span class="katex-mathml">xx</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.4306em;"></span><span class="mord mathnormal">x</span></span></span></span></span>. We want to find the contribution of <span class="math math-inline"><span class="katex"><span class="katex-mathml">xx</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.4306em;"></span><span class="mord mathnormal">x</span></span></span></span></span> to the total count of triplets. To do this, we need to know two things:</p>
 * <ol>
 * <li>The count of occurrences of <span class="math math-inline"><span class="katex"><span class="katex-mathml">xx</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.4306em;"></span><span class="mord mathnormal">x</span></span></span></span></span> in the <code>prefixXOR</code> array. Let's call this <span class="math math-inline"><span class="katex"><span class="katex-mathml">countXcountX</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.6833em;"></span><span class="mord mathnormal">co</span><span class="mord mathnormal">u</span><span class="mord mathnormal">n</span><span class="mord mathnormal" style="margin-right: 0.07847em;">tX</span></span></span></span></span>.</li>
 * <li>The number of valid triplets that can be formed with <span class="math math-inline"><span class="katex"><span class="katex-mathml">xx</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.4306em;"></span><span class="mord mathnormal">x</span></span></span></span></span> as the middle <strong>XOR</strong> value.</li>
 * </ol>
 * <p>For the second part, let's think about what it means for <span class="math math-inline"><span class="katex"><span class="katex-mathml">xx</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.4306em;"></span><span class="mord mathnormal">x</span></span></span></span></span> to be the middle <strong>XOR</strong> value in a triplet <span class="math math-inline"><span class="katex"><span class="katex-mathml">(i,j,k)(i, j, k)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mopen">(</span><span class="mord mathnormal">i</span><span class="mpunct">,</span><span class="mspace" style="margin-right: 0.1667em;"></span><span class="mord mathnormal" style="margin-right: 0.05724em;">j</span><span class="mpunct">,</span><span class="mspace" style="margin-right: 0.1667em;"></span><span class="mord mathnormal" style="margin-right: 0.03148em;">k</span><span class="mclose">)</span></span></span></span></span>. It means that the <strong>XOR</strong> of elements from index <span class="math math-inline"><span class="katex"><span class="katex-mathml">ii</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.6595em;"></span><span class="mord mathnormal">i</span></span></span></span></span> to <span class="math math-inline"><span class="katex"><span class="katex-mathml">j−1j-1</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.854em; vertical-align: -0.1944em;"></span><span class="mord mathnormal" style="margin-right: 0.05724em;">j</span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">−</span><span class="mspace" style="margin-right: 0.2222em;"></span></span><span class="base"><span class="strut" style="height: 0.6444em;"></span><span class="mord">1</span></span></span></span></span> is <span class="math math-inline"><span class="katex"><span class="katex-mathml">xx</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.4306em;"></span><span class="mord mathnormal">x</span></span></span></span></span>, and the <strong>XOR</strong> of elements from index <span class="math math-inline"><span class="katex"><span class="katex-mathml">jj</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.854em; vertical-align: -0.1944em;"></span><span class="mord mathnormal" style="margin-right: 0.05724em;">j</span></span></span></span></span> to <span class="math math-inline"><span class="katex"><span class="katex-mathml">kk</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.6944em;"></span><span class="mord mathnormal" style="margin-right: 0.03148em;">k</span></span></span></span></span> is also <span class="math math-inline"><span class="katex"><span class="katex-mathml">xx</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.4306em;"></span><span class="mord mathnormal">x</span></span></span></span></span>.</p>
 * <p>Now, let's choose a specific starting index <span class="math math-inline"><span class="katex"><span class="katex-mathml">ii</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.6595em;"></span><span class="mord mathnormal">i</span></span></span></span></span>. We want to find the number of valid triplets that can be formed with this starting index <span class="math math-inline"><span class="katex"><span class="katex-mathml">ii</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.6595em;"></span><span class="mord mathnormal">i</span></span></span></span></span> and <span class="math math-inline"><span class="katex"><span class="katex-mathml">xx</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.4306em;"></span><span class="mord mathnormal">x</span></span></span></span></span> as the middle <strong>XOR</strong> value. To do this, we need to find the number of possible ending indices <span class="math math-inline"><span class="katex"><span class="katex-mathml">kk</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.6944em;"></span><span class="mord mathnormal" style="margin-right: 0.03148em;">k</span></span></span></span></span> such that the XOR of elements from index <span class="math math-inline"><span class="katex"><span class="katex-mathml">jj</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.854em; vertical-align: -0.1944em;"></span><span class="mord mathnormal" style="margin-right: 0.05724em;">j</span></span></span></span></span> to <span class="math math-inline"><span class="katex"><span class="katex-mathml">kk</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.6944em;"></span><span class="mord mathnormal" style="margin-right: 0.03148em;">k</span></span></span></span></span> is <span class="math math-inline"><span class="katex"><span class="katex-mathml">xx</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.4306em;"></span><span class="mord mathnormal">x</span></span></span></span></span>, where <span class="math math-inline"><span class="katex"><span class="katex-mathml">jj</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.854em; vertical-align: -0.1944em;"></span><span class="mord mathnormal" style="margin-right: 0.05724em;">j</span></span></span></span></span> is the index just after <span class="math math-inline"><span class="katex"><span class="katex-mathml">ii</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.6595em;"></span><span class="mord mathnormal">i</span></span></span></span></span>.</p>
 * <p>Here's the key observation: if we know the indices where <span class="math math-inline"><span class="katex"><span class="katex-mathml">xx</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.4306em;"></span><span class="mord mathnormal">x</span></span></span></span></span> has occurred previously, we can calculate the number of valid triplets with <span class="math math-inline"><span class="katex"><span class="katex-mathml">ii</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.6595em;"></span><span class="mord mathnormal">i</span></span></span></span></span> as the starting index and <span class="math math-inline"><span class="katex"><span class="katex-mathml">xx</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.4306em;"></span><span class="mord mathnormal">x</span></span></span></span></span> as the middle <strong>XOR</strong> value.</p>
 * <p>Let's say <span class="math math-inline"><span class="katex"><span class="katex-mathml">xx</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.4306em;"></span><span class="mord mathnormal">x</span></span></span></span></span> has occurred at indices <span class="math math-inline"><span class="katex"><span class="katex-mathml">idx1idx_1</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.8444em; vertical-align: -0.15em;"></span><span class="mord mathnormal">i</span><span class="mord mathnormal">d</span><span class="mord"><span class="mord mathnormal">x</span><span class="msupsub"><span class="vlist-t vlist-t2"><span class="vlist-r"><span class="vlist" style="height: 0.3011em;"><span style="top: -2.55em; margin-left: 0em; margin-right: 0.05em;"><span class="pstrut" style="height: 2.7em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight">1</span></span></span></span><span class="vlist-s">​</span></span><span class="vlist-r"><span class="vlist" style="height: 0.15em;"><span></span></span></span></span></span></span></span></span></span></span>, <span class="math math-inline"><span class="katex"><span class="katex-mathml">idx2idx_2</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.8444em; vertical-align: -0.15em;"></span><span class="mord mathnormal">i</span><span class="mord mathnormal">d</span><span class="mord"><span class="mord mathnormal">x</span><span class="msupsub"><span class="vlist-t vlist-t2"><span class="vlist-r"><span class="vlist" style="height: 0.3011em;"><span style="top: -2.55em; margin-left: 0em; margin-right: 0.05em;"><span class="pstrut" style="height: 2.7em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight">2</span></span></span></span><span class="vlist-s">​</span></span><span class="vlist-r"><span class="vlist" style="height: 0.15em;"><span></span></span></span></span></span></span></span></span></span></span>, <span class="math math-inline"><span class="katex"><span class="katex-mathml">idx3idx_3</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.8444em; vertical-align: -0.15em;"></span><span class="mord mathnormal">i</span><span class="mord mathnormal">d</span><span class="mord"><span class="mord mathnormal">x</span><span class="msupsub"><span class="vlist-t vlist-t2"><span class="vlist-r"><span class="vlist" style="height: 0.3011em;"><span style="top: -2.55em; margin-left: 0em; margin-right: 0.05em;"><span class="pstrut" style="height: 2.7em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight">3</span></span></span></span><span class="vlist-s">​</span></span><span class="vlist-r"><span class="vlist" style="height: 0.15em;"><span></span></span></span></span></span></span></span></span></span></span>, ..., <span class="math math-inline"><span class="katex"><span class="katex-mathml">idxmidx_m</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.8444em; vertical-align: -0.15em;"></span><span class="mord mathnormal">i</span><span class="mord mathnormal">d</span><span class="mord"><span class="mord mathnormal">x</span><span class="msupsub"><span class="vlist-t vlist-t2"><span class="vlist-r"><span class="vlist" style="height: 0.1514em;"><span style="top: -2.55em; margin-left: 0em; margin-right: 0.05em;"><span class="pstrut" style="height: 2.7em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mathnormal mtight">m</span></span></span></span><span class="vlist-s">​</span></span><span class="vlist-r"><span class="vlist" style="height: 0.15em;"><span></span></span></span></span></span></span></span></span></span></span> before the current index <span class="math math-inline"><span class="katex"><span class="katex-mathml">ii</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.6595em;"></span><span class="mord mathnormal">i</span></span></span></span></span>. Then, the number of valid triplets with <span class="math math-inline"><span class="katex"><span class="katex-mathml">ii</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.6595em;"></span><span class="mord mathnormal">i</span></span></span></span></span> as the starting index and <span class="math math-inline"><span class="katex"><span class="katex-mathml">xx</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.4306em;"></span><span class="mord mathnormal">x</span></span></span></span></span> as the middle <strong>XOR</strong> value is:</p>
 * <p><span class="math math-inline"><span class="katex"><span class="katex-mathml">(i−1)−(idx1+idx2+...+idxm)(i - 1) - (idx_1 + idx_2 + ... + idx_m)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mopen">(</span><span class="mord mathnormal">i</span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">−</span><span class="mspace" style="margin-right: 0.2222em;"></span></span><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord">1</span><span class="mclose">)</span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">−</span><span class="mspace" style="margin-right: 0.2222em;"></span></span><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mopen">(</span><span class="mord mathnormal">i</span><span class="mord mathnormal">d</span><span class="mord"><span class="mord mathnormal">x</span><span class="msupsub"><span class="vlist-t vlist-t2"><span class="vlist-r"><span class="vlist" style="height: 0.3011em;"><span style="top: -2.55em; margin-left: 0em; margin-right: 0.05em;"><span class="pstrut" style="height: 2.7em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight">1</span></span></span></span><span class="vlist-s">​</span></span><span class="vlist-r"><span class="vlist" style="height: 0.15em;"><span></span></span></span></span></span></span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">+</span><span class="mspace" style="margin-right: 0.2222em;"></span></span><span class="base"><span class="strut" style="height: 0.8444em; vertical-align: -0.15em;"></span><span class="mord mathnormal">i</span><span class="mord mathnormal">d</span><span class="mord"><span class="mord mathnormal">x</span><span class="msupsub"><span class="vlist-t vlist-t2"><span class="vlist-r"><span class="vlist" style="height: 0.3011em;"><span style="top: -2.55em; margin-left: 0em; margin-right: 0.05em;"><span class="pstrut" style="height: 2.7em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight">2</span></span></span></span><span class="vlist-s">​</span></span><span class="vlist-r"><span class="vlist" style="height: 0.15em;"><span></span></span></span></span></span></span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">+</span><span class="mspace" style="margin-right: 0.2222em;"></span></span><span class="base"><span class="strut" style="height: 0.6667em; vertical-align: -0.0833em;"></span><span class="mord">...</span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">+</span><span class="mspace" style="margin-right: 0.2222em;"></span></span><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal">i</span><span class="mord mathnormal">d</span><span class="mord"><span class="mord mathnormal">x</span><span class="msupsub"><span class="vlist-t vlist-t2"><span class="vlist-r"><span class="vlist" style="height: 0.1514em;"><span style="top: -2.55em; margin-left: 0em; margin-right: 0.05em;"><span class="pstrut" style="height: 2.7em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mathnormal mtight">m</span></span></span></span><span class="vlist-s">​</span></span><span class="vlist-r"><span class="vlist" style="height: 0.15em;"><span></span></span></span></span></span></span><span class="mclose">)</span></span></span></span></span></p>
 * <p>Here's why:</p>
 * <ul>
 * <li><span class="math math-inline"><span class="katex"><span class="katex-mathml">(i−1)(i - 1)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mopen">(</span><span class="mord mathnormal">i</span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">−</span><span class="mspace" style="margin-right: 0.2222em;"></span></span><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord">1</span><span class="mclose">)</span></span></span></span></span> represents the number of possible middle indices <span class="math math-inline"><span class="katex"><span class="katex-mathml">jj</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.854em; vertical-align: -0.1944em;"></span><span class="mord mathnormal" style="margin-right: 0.05724em;">j</span></span></span></span></span> (since <span class="math math-inline"><span class="katex"><span class="katex-mathml">jj</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.854em; vertical-align: -0.1944em;"></span><span class="mord mathnormal" style="margin-right: 0.05724em;">j</span></span></span></span></span> is just after <span class="math math-inline"><span class="katex"><span class="katex-mathml">ii</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.6595em;"></span><span class="mord mathnormal">i</span></span></span></span></span>).</li>
 * <li><span class="math math-inline"><span class="katex"><span class="katex-mathml">idx1+idx2+...+idxmidx_1 + idx_2 + ... + idx_m</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.8444em; vertical-align: -0.15em;"></span><span class="mord mathnormal">i</span><span class="mord mathnormal">d</span><span class="mord"><span class="mord mathnormal">x</span><span class="msupsub"><span class="vlist-t vlist-t2"><span class="vlist-r"><span class="vlist" style="height: 0.3011em;"><span style="top: -2.55em; margin-left: 0em; margin-right: 0.05em;"><span class="pstrut" style="height: 2.7em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight">1</span></span></span></span><span class="vlist-s">​</span></span><span class="vlist-r"><span class="vlist" style="height: 0.15em;"><span></span></span></span></span></span></span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">+</span><span class="mspace" style="margin-right: 0.2222em;"></span></span><span class="base"><span class="strut" style="height: 0.8444em; vertical-align: -0.15em;"></span><span class="mord mathnormal">i</span><span class="mord mathnormal">d</span><span class="mord"><span class="mord mathnormal">x</span><span class="msupsub"><span class="vlist-t vlist-t2"><span class="vlist-r"><span class="vlist" style="height: 0.3011em;"><span style="top: -2.55em; margin-left: 0em; margin-right: 0.05em;"><span class="pstrut" style="height: 2.7em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight">2</span></span></span></span><span class="vlist-s">​</span></span><span class="vlist-r"><span class="vlist" style="height: 0.15em;"><span></span></span></span></span></span></span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">+</span><span class="mspace" style="margin-right: 0.2222em;"></span></span><span class="base"><span class="strut" style="height: 0.6667em; vertical-align: -0.0833em;"></span><span class="mord">...</span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">+</span><span class="mspace" style="margin-right: 0.2222em;"></span></span><span class="base"><span class="strut" style="height: 0.8444em; vertical-align: -0.15em;"></span><span class="mord mathnormal">i</span><span class="mord mathnormal">d</span><span class="mord"><span class="mord mathnormal">x</span><span class="msupsub"><span class="vlist-t vlist-t2"><span class="vlist-r"><span class="vlist" style="height: 0.1514em;"><span style="top: -2.55em; margin-left: 0em; margin-right: 0.05em;"><span class="pstrut" style="height: 2.7em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mathnormal mtight">m</span></span></span></span><span class="vlist-s">​</span></span><span class="vlist-r"><span class="vlist" style="height: 0.15em;"><span></span></span></span></span></span></span></span></span></span></span> represents the sum of indices where <span class="math math-inline"><span class="katex"><span class="katex-mathml">xx</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.4306em;"></span><span class="mord mathnormal">x</span></span></span></span></span> has occurred previously.</li>
 * <li>Subtracting this sum from <span class="math math-inline"><span class="katex"><span class="katex-mathml">(i−1)(i - 1)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mopen">(</span><span class="mord mathnormal">i</span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">−</span><span class="mspace" style="margin-right: 0.2222em;"></span></span><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord">1</span><span class="mclose">)</span></span></span></span></span> gives us the number of valid triplets, because we need to exclude the cases where the middle <strong>XOR</strong> value is <span class="math math-inline"><span class="katex"><span class="katex-mathml">xx</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.4306em;"></span><span class="mord mathnormal">x</span></span></span></span></span>, but the ending <strong>XOR</strong> value is not <span class="math math-inline"><span class="katex"><span class="katex-mathml">xx</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.4306em;"></span><span class="mord mathnormal">x</span></span></span></span></span>.</li>
 * </ul>
 * <p>So, the contribution of <span class="math math-inline"><span class="katex"><span class="katex-mathml">xx</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.4306em;"></span><span class="mord mathnormal">x</span></span></span></span></span> to the total count of triplets is:</p>
 * <p><span class="math math-inline"><span class="katex"><span class="katex-mathml">countX∗((i−1)−(idx1+idx2+...+idxm))countX * ((i - 1) - (idx_1 + idx_2 + ... + idx_m))</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.6833em;"></span><span class="mord mathnormal">co</span><span class="mord mathnormal">u</span><span class="mord mathnormal">n</span><span class="mord mathnormal" style="margin-right: 0.07847em;">tX</span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">∗</span><span class="mspace" style="margin-right: 0.2222em;"></span></span><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mopen">((</span><span class="mord mathnormal">i</span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">−</span><span class="mspace" style="margin-right: 0.2222em;"></span></span><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord">1</span><span class="mclose">)</span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">−</span><span class="mspace" style="margin-right: 0.2222em;"></span></span><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mopen">(</span><span class="mord mathnormal">i</span><span class="mord mathnormal">d</span><span class="mord"><span class="mord mathnormal">x</span><span class="msupsub"><span class="vlist-t vlist-t2"><span class="vlist-r"><span class="vlist" style="height: 0.3011em;"><span style="top: -2.55em; margin-left: 0em; margin-right: 0.05em;"><span class="pstrut" style="height: 2.7em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight">1</span></span></span></span><span class="vlist-s">​</span></span><span class="vlist-r"><span class="vlist" style="height: 0.15em;"><span></span></span></span></span></span></span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">+</span><span class="mspace" style="margin-right: 0.2222em;"></span></span><span class="base"><span class="strut" style="height: 0.8444em; vertical-align: -0.15em;"></span><span class="mord mathnormal">i</span><span class="mord mathnormal">d</span><span class="mord"><span class="mord mathnormal">x</span><span class="msupsub"><span class="vlist-t vlist-t2"><span class="vlist-r"><span class="vlist" style="height: 0.3011em;"><span style="top: -2.55em; margin-left: 0em; margin-right: 0.05em;"><span class="pstrut" style="height: 2.7em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight">2</span></span></span></span><span class="vlist-s">​</span></span><span class="vlist-r"><span class="vlist" style="height: 0.15em;"><span></span></span></span></span></span></span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">+</span><span class="mspace" style="margin-right: 0.2222em;"></span></span><span class="base"><span class="strut" style="height: 0.6667em; vertical-align: -0.0833em;"></span><span class="mord">...</span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">+</span><span class="mspace" style="margin-right: 0.2222em;"></span></span><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal">i</span><span class="mord mathnormal">d</span><span class="mord"><span class="mord mathnormal">x</span><span class="msupsub"><span class="vlist-t vlist-t2"><span class="vlist-r"><span class="vlist" style="height: 0.1514em;"><span style="top: -2.55em; margin-left: 0em; margin-right: 0.05em;"><span class="pstrut" style="height: 2.7em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mathnormal mtight">m</span></span></span></span><span class="vlist-s">​</span></span><span class="vlist-r"><span class="vlist" style="height: 0.15em;"><span></span></span></span></span></span></span><span class="mclose">))</span></span></span></span></span></p>
 * <p>This is exactly what the key observation states. By maintaining the count of occurrences of each <strong>XOR</strong> value (<span class="math math-inline"><span class="katex"><span class="katex-mathml">countXcountX</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.6833em;"></span><span class="mord mathnormal">co</span><span class="mord mathnormal">u</span><span class="mord mathnormal">n</span><span class="mord mathnormal" style="margin-right: 0.07847em;">tX</span></span></span></span></span>) and the sum of indices where each <strong>XOR</strong> value has occurred (<span class="math math-inline"><span class="katex"><span class="katex-mathml">totalSum=idx1+idx2+...+idxmtotalSum = idx_1 + idx_2 + ... + idx_m</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.6944em;"></span><span class="mord mathnormal">t</span><span class="mord mathnormal">o</span><span class="mord mathnormal">t</span><span class="mord mathnormal">a</span><span class="mord mathnormal" style="margin-right: 0.05764em;">lS</span><span class="mord mathnormal">u</span><span class="mord mathnormal">m</span><span class="mspace" style="margin-right: 0.2778em;"></span><span class="mrel">=</span><span class="mspace" style="margin-right: 0.2778em;"></span></span><span class="base"><span class="strut" style="height: 0.8444em; vertical-align: -0.15em;"></span><span class="mord mathnormal">i</span><span class="mord mathnormal">d</span><span class="mord"><span class="mord mathnormal">x</span><span class="msupsub"><span class="vlist-t vlist-t2"><span class="vlist-r"><span class="vlist" style="height: 0.3011em;"><span style="top: -2.55em; margin-left: 0em; margin-right: 0.05em;"><span class="pstrut" style="height: 2.7em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight">1</span></span></span></span><span class="vlist-s">​</span></span><span class="vlist-r"><span class="vlist" style="height: 0.15em;"><span></span></span></span></span></span></span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">+</span><span class="mspace" style="margin-right: 0.2222em;"></span></span><span class="base"><span class="strut" style="height: 0.8444em; vertical-align: -0.15em;"></span><span class="mord mathnormal">i</span><span class="mord mathnormal">d</span><span class="mord"><span class="mord mathnormal">x</span><span class="msupsub"><span class="vlist-t vlist-t2"><span class="vlist-r"><span class="vlist" style="height: 0.3011em;"><span style="top: -2.55em; margin-left: 0em; margin-right: 0.05em;"><span class="pstrut" style="height: 2.7em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight">2</span></span></span></span><span class="vlist-s">​</span></span><span class="vlist-r"><span class="vlist" style="height: 0.15em;"><span></span></span></span></span></span></span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">+</span><span class="mspace" style="margin-right: 0.2222em;"></span></span><span class="base"><span class="strut" style="height: 0.6667em; vertical-align: -0.0833em;"></span><span class="mord">...</span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">+</span><span class="mspace" style="margin-right: 0.2222em;"></span></span><span class="base"><span class="strut" style="height: 0.8444em; vertical-align: -0.15em;"></span><span class="mord mathnormal">i</span><span class="mord mathnormal">d</span><span class="mord"><span class="mord mathnormal">x</span><span class="msupsub"><span class="vlist-t vlist-t2"><span class="vlist-r"><span class="vlist" style="height: 0.1514em;"><span style="top: -2.55em; margin-left: 0em; margin-right: 0.05em;"><span class="pstrut" style="height: 2.7em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mathnormal mtight">m</span></span></span></span><span class="vlist-s">​</span></span><span class="vlist-r"><span class="vlist" style="height: 0.15em;"><span></span></span></span></span></span></span></span></span></span></span>), we can efficiently calculate the contribution of each <strong>XOR</strong> value to the total count of triplets.</p>
 * <p>After calculating the contribution, we increment <code>countMap[prefixXOR[i]]</code> to count the occurrences of the current <strong>XOR</strong> value. We also update <code>totalMap[prefixXOR[i]]</code> by adding <code>i</code> to keep track of the total sum of indices for the current <strong>XOR</strong> value.</p>
 * <p>In summary, we preprocess the array by inserting a 0 at the beginning and computing the prefix <strong>XOR</strong>. Next, we initialize maps to store counts and totals of <strong>XOR</strong> values encountered during the iteration. While iterating through the array, we calculate the contribution of each element to the result count and update the count and total of each <strong>XOR</strong> value encountered. Finally, we return the total count of valid triplets found.</p>
 * <h4 id="algorithm-2">Algorithm</h4>
 * <ul>
 * <li>Create a modified copy <code>prefixXOR</code> of the input array <code>arr</code> to avoid modifying the original array.</li>
 * <li>Insert 0 at the beginning of the modified array <code>prefixXOR</code> to handle the case when the <strong>XOR</strong> operation is performed on the first element.</li>
 * <li>Calculate the prefix <strong>XOR</strong> of <code>prefixXOR</code> to precompute the <strong>XOR</strong> of elements from the beginning up to each index.
 * <ul>
 * <li>Iterate over <code>prefixXOR</code> starting from index 1:
 * <ul>
 * <li>Update <code>prefixXOR[i]</code> by <strong>XOR</strong>ing it with <code>prefixXOR[i - 1]</code>.</li>
 * </ul>
 * </li>
 * </ul>
 * </li>
 * <li>Initialize <code>count</code> with 0 to store the count of valid triplets.</li>
 * <li>Initialize <code>countMap</code> with <code>{0: 1}</code> to store the count of occurrences of each <strong>XOR</strong> value, initialized with the count of 0 as 1.</li>
 * <li>Initialize <code>totalMap</code> as an empty map to store the sum of indices where each <strong>XOR</strong> value has occurred.</li>
 * <li>Iterate over <code>prefixXOR</code>:
 * <ul>
 * <li>Calculate the contribution of <code>prefixXOR[i]</code> to <code>count</code> using <code>countMap[prefixXOR[i]]</code> and <code>totalMap[prefixXOR[i]]</code> (based on the count and sum of indices for the current <strong>XOR</strong> value).
 * <ul>
 * <li>Update <code>count</code> with the contribution.</li>
 * </ul>
 * </li>
 * <li>Increment <code>countMap[prefixXOR[i]]</code> by updating the count of the current <strong>XOR</strong> value.</li>
 * <li>Update <code>totalMap[prefixXOR[i]]</code> by adding <code>i</code> to update the sum of indices for the current <strong>XOR</strong> value.</li>
 * </ul>
 * </li>
 * <li>Return the final count of valid triplets <code>count</code>.</li>
 * </ul>
 * <p>The algorithm is visualized below:</p>
 * <p><div class="relative mx-auto mb-6 flex flex-col overflow-hidden rounded-lg border-[1px] border-label-1" style="max-width: 975px;"><div class="rounded-lg" style="max-height: 587px;"><img alt="Current" class="object-fit-contain !mb-0 max-h-full max-w-full" src="blob:https://leetcode.com/72493bd4-09ad-47b6-99b2-ad16789fd445"></div><div class="absolute top-[50%] left-[50%] flex h-12 w-12 translate-x-[-50%] translate-y-[-50%] items-center justify-center rounded-full bg-black/30"><div class="flex h-4 w-4 cursor-pointer items-center justify-center text-[35px]"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="1em" height="1em" fill="currentColor" class="h-full w-full text-white"><path fill-rule="evenodd" d="M18.97 12.871l-12.96 7.29a1 1 0 01-1.49-.87V4.71a1 1 0 011.49-.872l12.96 7.29a1 1 0 010 1.743z" clip-rule="evenodd"></path></svg></div></div><div class="relative flex h-8 select-none items-center justify-around bg-black"><div class="flex items-center space-x-7"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="1em" height="1em" fill="currentColor" class="w-4 cursor-pointer text-gray-6 dark:text-dark-gray-6 hover:text-gray-7 dark:hover:text-dark-gray-7"><path fill-rule="evenodd" d="M16.091 4.929l-7.057 7.078 7.057 7.064a1 1 0 01-1.414 1.414l-7.764-7.77a1 1 0 010-1.415l7.764-7.785a1 1 0 111.415 1.414z" clip-rule="evenodd"></path></svg><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="1em" height="1em" fill="currentColor" class="w-4 cursor-pointer text-gray-6 dark:text-dark-gray-6 hover:text-gray-7 dark:hover:text-dark-gray-7"><path fill-rule="evenodd" d="M18.97 12.871l-12.96 7.29a1 1 0 01-1.49-.87V4.71a1 1 0 011.49-.872l12.96 7.29a1 1 0 010 1.743z" clip-rule="evenodd"></path></svg><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="1em" height="1em" fill="currentColor" class="w-4 cursor-pointer text-gray-6 dark:text-dark-gray-6 hover:text-gray-7 dark:hover:text-dark-gray-7"><path fill-rule="evenodd" d="M7.913 19.071l7.057-7.078-7.057-7.064a1 1 0 011.414-1.414l7.764 7.77a1 1 0 010 1.415l-7.764 7.785a1 1 0 01-1.414-1.414z" clip-rule="evenodd"></path></svg></div><div class="absolute right-0 mr-5 text-xs font-medium text-white">1 / 8</div></div></div></p>
 * <h4 id="implementation-2">Implementation</h4>
 * <iframe src="https://leetcode.com/playground/easRUUxG/shared" width="100%" height="500" name="user-content-easRUUxG" allowfullscreen="" translate="no"></iframe>
 * <h4 id="complexity-analysis-2">Complexity Analysis</h4>
 * <p>Let <span class="math math-inline"><span class="katex"><span class="katex-mathml">nn</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.4306em;"></span><span class="mord mathnormal">n</span></span></span></span></span> be the size of the input array.</p>
 * <ul>
 * <li>
 * <p>Time complexity: <span class="math math-inline"><span class="katex"><span class="katex-mathml">O(n)O(n)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mord mathnormal">n</span><span class="mclose">)</span></span></span></span></span></p>
 * <p>There are two different loops iterating over the array, resulting in a time complexity of <span class="math math-inline"><span class="katex"><span class="katex-mathml">O(2⋅n)O(2 \cdot n)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mord">2</span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">⋅</span><span class="mspace" style="margin-right: 0.2222em;"></span></span><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal">n</span><span class="mclose">)</span></span></span></span></span>, which can be simplified to <span class="math math-inline"><span class="katex"><span class="katex-mathml">O(n)O(n)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mord mathnormal">n</span><span class="mclose">)</span></span></span></span></span>.</p>
 * </li>
 * <li>
 * <p>Space complexity: <span class="math math-inline"><span class="katex"><span class="katex-mathml">O(n)O(n)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mord mathnormal">n</span><span class="mclose">)</span></span></span></span></span></p>
 * <p>In the worst case, each element in the array can have a unique <strong>XOR</strong> value, requiring <span class="math math-inline"><span class="katex"><span class="katex-mathml">O(n)O(n)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mord mathnormal">n</span><span class="mclose">)</span></span></span></span></span> space to store the counts and totals in the maps.</p>
 * </li>
 * </ul>
 * <hr>
 */
class CountTripletsThatCanFormTwoArraysOfEqualXOR_Solution3 {

    public int countTriplets(int[] arr) {
        int[] prefixXOR = new int[arr.length + 1];
        prefixXOR[0] = 0;
        System.arraycopy(arr, 0, prefixXOR, 1, arr.length);
        int size = prefixXOR.length;
        int count = 0;

        // Performing XOR operation on the array elements
        for (int i = 1; i < size; ++i) prefixXOR[i] ^= prefixXOR[i - 1];

        // Maps to store counts and totals of XOR values encountered
        HashMap<Integer, Integer> countMap = new HashMap<>();
        HashMap<Integer, Integer> totalMap = new HashMap<>();

        // Iterating through the array
        for (int i = 0; i < size; ++i) {
            // Calculating contribution of current element to the result
            count +=
            countMap.getOrDefault(prefixXOR[i], 0) * (i - 1) -
            totalMap.getOrDefault(prefixXOR[i], 0);

            // Updating total count of current XOR value
            totalMap.put(
                prefixXOR[i],
                totalMap.getOrDefault(prefixXOR[i], 0) + i
            );
            countMap.put(
                prefixXOR[i],
                countMap.getOrDefault(prefixXOR[i], 0) + 1
            );
        }

        return count;
    }
}

// 2 ms 41.3 MB
/**
 * <h3 id="approach-4-one-pass-prefix-xor" level="3" class="group/heading relative"><a href="#approach-4-one-pass-prefix-xor" class="!text-sd-muted-foreground absolute right-full top-1/2 -translate-y-1/2 cursor-pointer pr-0.5 text-xs opacity-0 group-hover/heading:opacity-100" aria-hidden="true" tabindex="-1"><div class="relative text-[12px] leading-[normal] p-[1px] before:block before:h-3 before:w-3"><svg aria-hidden="true" focusable="false" data-prefix="fas" data-icon="link" class="svg-inline--fa fa-link absolute left-1/2 top-1/2 -translate-x-1/2 -translate-y-1/2" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 640 512" spacing="square"><path fill="currentColor" d="M579.8 267.7c56.5-56.5 56.5-148 0-204.5c-50-50-128.8-56.5-186.3-15.4l-1.6 1.1c-14.4 10.3-17.7 30.3-7.4 44.6s30.3 17.7 44.6 7.4l1.6-1.1c32.1-22.9 76-19.3 103.8 8.6c31.5 31.5 31.5 82.5 0 114L422.3 334.8c-31.5 31.5-82.5 31.5-114 0c-27.9-27.9-31.5-71.8-8.6-103.8l1.1-1.6c10.3-14.4 6.9-34.4-7.4-44.6s-34.4-6.9-44.6 7.4l-1.1 1.6C206.5 251.2 213 330 263 380c56.5 56.5 148 56.5 204.5 0L579.8 267.7zM60.2 244.3c-56.5 56.5-56.5 148 0 204.5c50 50 128.8 56.5 186.3 15.4l1.6-1.1c14.4-10.3 17.7-30.3 7.4-44.6s-30.3-17.7-44.6-7.4l-1.6 1.1c-32.1 22.9-76 19.3-103.8-8.6C74 372 74 321 105.5 289.5L217.7 177.2c31.5-31.5 82.5-31.5 114 0c27.9 27.9 31.5 71.8 8.6 103.9l-1.1 1.6c-10.3 14.4-6.9 34.4 7.4 44.6s34.4 6.9 44.6-7.4l1.1-1.6C433.5 260.8 427 182 377 132c-56.5-56.5-148-56.5-204.5 0L60.2 244.3z"></path></svg></div></a>Approach 4: One Pass Prefix <strong>XOR</strong></h3>
 * <h4 id="intuition-3">Intuition</h4>
 * <p>This approach is a slight variation of the previous one. The main difference is that it combines the prefix <strong>XOR</strong> computation and result calculation in a single pass through the array, whereas the third approach performs these steps separately.</p>
 * <p>Here we eliminate the need for a separate prefix <strong>XOR</strong> precomputation step. Instead, we maintain a running prefix variable that stores the <strong>XOR</strong> of elements up to the current index. We update this prefix variable as we iterate through the array by <strong>XOR</strong>ing it with the current element: <code>prefix ^= arr[i]</code></p>
 * <p>By maintaining this running prefix, we can calculate the contribution of the current <strong>XOR</strong> value (prefix) to the result on the fly, without the need for precomputed prefix <strong>XOR</strong> values.</p>
 * <p>The formula for calculating the contribution remains the same as in the third approach: <code>count += countMap[prefix] * i - totalSum[prefix]</code><br>
 * The difference is that we use the running prefix value instead of a precomputed prefix <strong>XOR</strong> array.</p>
 * <h4 id="algorithm-3">Algorithm</h4>
 * <ul>
 * <li>Initialize <code>count</code> with 0 to store the count of valid triplets.</li>
 * <li>Initialize <code>prefix</code> with 0 to store the running <strong>XOR</strong> value.</li>
 * <li>Initialize <code>countMap</code> with <code>{0: 1}</code> to store the count of occurrences of each <strong>XOR</strong> value, initialized with 0 count as 1.</li>
 * <li>Initialize <code>totalMap</code> as an empty map to store the sum of indices where each <strong>XOR</strong> value has occurred.</li>
 * <li>Iterate over <code>arr</code>:
 * <ul>
 * <li>Update <code>prefix</code> by <strong>XOR</strong>ing it with <code>arr[i]</code> (the running <strong>XOR</strong> value).</li>
 * <li>Calculate the contribution of <code>prefix</code> to <code>count</code> using <code>countMap[prefix]</code> and <code>totalMap[prefix]</code> (based on the count and sum of indices for the current <strong>XOR</strong> value).
 * <ul>
 * <li>Update <code>count</code> with the contribution.</li>
 * </ul>
 * </li>
 * <li>Increment <code>countMap[prefix]</code> by updating the count of the current <strong>XOR</strong> value.</li>
 * <li>Update <code>totalMap[prefix]</code> by adding <code>i + 1</code> to update the sum of indices for the current <strong>XOR</strong> value.</li>
 * </ul>
 * </li>
 * <li>Return the final count of valid triplets <code>count</code>.</li>
 * </ul>
 * <h4 id="implementation-3">Implementation</h4>
 * <iframe src="https://leetcode.com/playground/cuY5kJ4N/shared" width="100%" height="500" name="user-content-cuY5kJ4N" allowfullscreen="" translate="no"></iframe>
 * <h4 id="complexity-analysis-3">Complexity Analysis</h4>
 * <p>Let <span class="math math-inline"><span class="katex"><span class="katex-mathml">nn</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.4306em;"></span><span class="mord mathnormal">n</span></span></span></span></span> be the size of the input array.</p>
 * <ul>
 * <li>
 * <p>Time complexity: <span class="math math-inline"><span class="katex"><span class="katex-mathml">O(n)O(n)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mord mathnormal">n</span><span class="mclose">)</span></span></span></span></span></p>
 * <p>There is only a single loop iterating over the array, resulting in a time complexity of <span class="math math-inline"><span class="katex"><span class="katex-mathml">O(n)O(n)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mord mathnormal">n</span><span class="mclose">)</span></span></span></span></span>.</p>
 * </li>
 * <li>
 * <p>Space complexity: <span class="math math-inline"><span class="katex"><span class="katex-mathml">O(n)O(n)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mord mathnormal">n</span><span class="mclose">)</span></span></span></span></span></p>
 * <p>In the worst case, each element in the array can have a unique <strong>XOR</strong> value, requiring <span class="math math-inline"><span class="katex"><span class="katex-mathml">O(n)O(n)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mord mathnormal">n</span><span class="mclose">)</span></span></span></span></span> space to store the counts and totals in the maps.</p>
 * </li>
 * </ul>
 * <hr>
 */
class CountTripletsThatCanFormTwoArraysOfEqualXOR_Solution4 {

    public int countTriplets(int[] arr) {
        int size = arr.length;
        int count = 0;
        int prefix = 0;

        // Maps to store counts and totals of XOR values encountered
        Map<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0, 1);
        Map<Integer, Integer> totalMap = new HashMap<>();

        // Iterating through the array
        for (int i = 0; i < size; ++i) {
            // Calculating XOR prefix
            prefix ^= arr[i];

            // Calculating contribution of current element to the result
            count +=
            countMap.getOrDefault(prefix, 0) * i -
            totalMap.getOrDefault(prefix, 0);

            // Updating total count of current XOR value
            totalMap.put(prefix, totalMap.getOrDefault(prefix, 0) + i + 1);
            countMap.put(prefix, countMap.getOrDefault(prefix, 0) + 1);
        }

        return count;
    }
}