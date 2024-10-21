package BetterCodeAnswer.Medium.Array;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int[][] tests ={
            {1,2,3},
        };

        for (int[] nums : tests) {
            List<List<Integer>> subsets = new Subsets_Solution().subsets(nums);
            String ans = "[";
            for (List<Integer> subset : subsets) {
                ans += subset.toString();
            }
        
            System.out.println(ans+"]");
        }
    }
}

// 1 ms 42.7 MB
/**
 * <h3 id="approach-1-cascading" level="3" class="group/heading relative"><a href="#approach-1-cascading" class="!text-sd-muted-foreground absolute right-full top-1/2 -translate-y-1/2 cursor-pointer pr-0.5 text-xs opacity-0 group-hover/heading:opacity-100" aria-hidden="true" tabindex="-1"><div class="relative text-[12px] leading-[normal] p-[1px] before:block before:h-3 before:w-3"><svg aria-hidden="true" focusable="false" data-prefix="fas" data-icon="link" class="svg-inline--fa fa-link absolute left-1/2 top-1/2 -translate-x-1/2 -translate-y-1/2" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 640 512" spacing="square"><path fill="currentColor" d="M579.8 267.7c56.5-56.5 56.5-148 0-204.5c-50-50-128.8-56.5-186.3-15.4l-1.6 1.1c-14.4 10.3-17.7 30.3-7.4 44.6s30.3 17.7 44.6 7.4l1.6-1.1c32.1-22.9 76-19.3 103.8 8.6c31.5 31.5 31.5 82.5 0 114L422.3 334.8c-31.5 31.5-82.5 31.5-114 0c-27.9-27.9-31.5-71.8-8.6-103.8l1.1-1.6c10.3-14.4 6.9-34.4-7.4-44.6s-34.4-6.9-44.6 7.4l-1.1 1.6C206.5 251.2 213 330 263 380c56.5 56.5 148 56.5 204.5 0L579.8 267.7zM60.2 244.3c-56.5 56.5-56.5 148 0 204.5c50 50 128.8 56.5 186.3 15.4l1.6-1.1c14.4-10.3 17.7-30.3 7.4-44.6s-30.3-17.7-44.6-7.4l-1.6 1.1c-32.1 22.9-76 19.3-103.8-8.6C74 372 74 321 105.5 289.5L217.7 177.2c31.5-31.5 82.5-31.5 114 0c27.9 27.9 31.5 71.8 8.6 103.9l-1.1 1.6c-10.3 14.4-6.9 34.4 7.4 44.6s34.4 6.9 44.6-7.4l1.1-1.6C433.5 260.8 427 182 377 132c-56.5-56.5-148-56.5-204.5 0L60.2 244.3z"></path></svg></div></a>Approach 1: Cascading</h3>
 * <h4 id="intuition">Intuition</h4>
 * <p>Let's start from an empty subset in the output list. At each step, one takes a new integer into consideration and generates new subsets from the existing ones.</p>
 * <p><img src="../Figures/78/recursion.png" alt="diff"></p>
 * <h4 id="implementation">Implementation</h4>
 * <iframe src="https://leetcode.com/playground/BDLmByzz/shared" width="100%" height="463" name="user-content-BDLmByzz" allowfullscreen="" translate="no"></iframe>
 * <h4 id="complexity-analysis">Complexity Analysis</h4>
 * <ul>
 * <li>
 * <p>Time complexity: <span class="math math-inline"><span class="katex"><span class="katex-mathml">O(N×2N)\mathcal{O}(N \times 2^N)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathcal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mord mathnormal" style="margin-right: 0.10903em;">N</span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">×</span><span class="mspace" style="margin-right: 0.2222em;"></span></span><span class="base"><span class="strut" style="height: 1.0913em; vertical-align: -0.25em;"></span><span class="mord"><span class="mord">2</span><span class="msupsub"><span class="vlist-t"><span class="vlist-r"><span class="vlist" style="height: 0.8413em;"><span style="top: -3.063em; margin-right: 0.05em;"><span class="pstrut" style="height: 2.7em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mathnormal mtight" style="margin-right: 0.10903em;">N</span></span></span></span></span></span></span></span><span class="mclose">)</span></span></span></span></span> to generate all subsets and then copy them into the output list.</p>
 * </li>
 * <li>
 * <p>Space complexity: <span class="math math-inline"><span class="katex"><span class="katex-mathml">O(N×2N)\mathcal{O}(N \times 2^N)</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathcal" style="margin-right: 0.02778em;">O</span><span class="mopen">(</span><span class="mord mathnormal" style="margin-right: 0.10903em;">N</span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">×</span><span class="mspace" style="margin-right: 0.2222em;"></span></span><span class="base"><span class="strut" style="height: 1.0913em; vertical-align: -0.25em;"></span><span class="mord"><span class="mord">2</span><span class="msupsub"><span class="vlist-t"><span class="vlist-r"><span class="vlist" style="height: 0.8413em;"><span style="top: -3.063em; margin-right: 0.05em;"><span class="pstrut" style="height: 2.7em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mathnormal mtight" style="margin-right: 0.10903em;">N</span></span></span></span></span></span></span></span><span class="mclose">)</span></span></span></span></span>. This is exactly the number of solutions for subsets multiplied by the number <span class="math math-inline"><span class="katex"><span class="katex-mathml">NN</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.6833em;"></span><span class="mord mathnormal" style="margin-right: 0.10903em;">N</span></span></span></span></span> of elements to keep for each subset.</p>
 * <ul>
 * <li>For a given number, it could be present or absent (<em>i.e.</em> binary choice) in a subset solution. As a result, for <span class="math math-inline"><span class="katex"><span class="katex-mathml">NN</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.6833em;"></span><span class="mord mathnormal" style="margin-right: 0.10903em;">N</span></span></span></span></span> numbers, we would have in total <span class="math math-inline"><span class="katex"><span class="katex-mathml">2N2^N</span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.8413em;"></span><span class="mord"><span class="mord">2</span><span class="msupsub"><span class="vlist-t"><span class="vlist-r"><span class="vlist" style="height: 0.8413em;"><span style="top: -3.063em; margin-right: 0.05em;"><span class="pstrut" style="height: 2.7em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mathnormal mtight" style="margin-right: 0.10903em;">N</span></span></span></span></span></span></span></span></span></span></span></span> choices (solutions).
 * <br>
 * </li>
 * </ul>
 * </li>
 * </ul>
 */
class Subsets_Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        output.add(new ArrayList<Integer>());

        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList<>();
            for (List<Integer> curr : output) {
                newSubsets.add(
                    new ArrayList<Integer>(curr) {
                        {
                            add(num);
                        }
                    }
                );
            }
            for (List<Integer> curr : newSubsets) {
                output.add(curr);
            }
        }
        return output;
    }
}

// 1 ms 42.7 MB
/**
 * <h3 id="approach-3-lexicographic-binary-sorted-subsets" level="3" class="group/heading relative"><a href="#approach-3-lexicographic-binary-sorted-subsets" class="!text-sd-muted-foreground absolute right-full top-1/2 -translate-y-1/2 cursor-pointer pr-0.5 text-xs opacity-0 group-hover/heading:opacity-100" aria-hidden="true" tabindex="-1"><div class="relative text-[12px] leading-[normal] p-[1px] before:block before:h-3 before:w-3"><svg aria-hidden="true" focusable="false" data-prefix="fas" data-icon="link" class="svg-inline--fa fa-link absolute left-1/2 top-1/2 -translate-x-1/2 -translate-y-1/2" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 640 512" spacing="square"><path fill="currentColor" d="M579.8 267.7c56.5-56.5 56.5-148 0-204.5c-50-50-128.8-56.5-186.3-15.4l-1.6 1.1c-14.4 10.3-17.7 30.3-7.4 44.6s30.3 17.7 44.6 7.4l1.6-1.1c32.1-22.9 76-19.3 103.8 8.6c31.5 31.5 31.5 82.5 0 114L422.3 334.8c-31.5 31.5-82.5 31.5-114 0c-27.9-27.9-31.5-71.8-8.6-103.8l1.1-1.6c10.3-14.4 6.9-34.4-7.4-44.6s-34.4-6.9-44.6 7.4l-1.1 1.6C206.5 251.2 213 330 263 380c56.5 56.5 148 56.5 204.5 0L579.8 267.7zM60.2 244.3c-56.5 56.5-56.5 148 0 204.5c50 50 128.8 56.5 186.3 15.4l1.6-1.1c14.4-10.3 17.7-30.3 7.4-44.6s-30.3-17.7-44.6-7.4l-1.6 1.1c-32.1 22.9-76 19.3-103.8-8.6C74 372 74 321 105.5 289.5L217.7 177.2c31.5-31.5 82.5-31.5 114 0c27.9 27.9 31.5 71.8 8.6 103.9l-1.1 1.6c-10.3 14.4-6.9 34.4 7.4 44.6s34.4 6.9 44.6-7.4l1.1-1.6C433.5 260.8 427 182 377 132c-56.5-56.5-148-56.5-204.5 0L60.2 244.3z"></path></svg></div></a>Approach 3: Lexicographic (Binary Sorted) Subsets</h3>
 * <h4 id="intuition-1">Intuition</h4>
 * <p>The idea of this solution is originated from <a href="https://www-cs-faculty.stanford.edu/~knuth/taocp.html" target="_blank">Donald E. Knuth</a>.</p>
 * <blockquote>
 * <p>The idea is that we map each subset to a bitmask of length n,<br>
 * where <code>1</code> on the i<em>th</em> position in bitmask means the presence of <code>nums[i]</code><br>
 * in the subset, and <code>0</code> means its absence.</p>
 * </blockquote>
 * <p><img src="../Figures/78/bitmask4.png" alt="diff"></p>
 * <p>For instance, the bitmask <code>0..00</code> (all zeros) corresponds to an empty subset,<br>
 * and the bitmask <code>1..11</code> (all ones) corresponds to the entire input array <code>nums</code>.</p>
 * <p>Hence to solve the initial problem, we just need to generate n bitmasks<br>
 * from <code>0..00</code> to <code>1..11</code>.</p>
 * <p>It might seem simple at first glance to generate binary numbers, but<br>
 * the real problem here is how to deal with<br>
 * <a href="https://en.wikipedia.org/wiki/Padding_(cryptography)#Zero_padding" target="_blank">zero left padding</a>,<br>
 * because one has to generate bitmasks of fixed length, <em>i.e.</em> <code>001</code> and not just <code>1</code>.<br>
 * For that one could use standard bit manipulation trick:</p>
 * <iframe src="https://leetcode.com/playground/VaGYhWWg/shared" width="100%" height="123" name="user-content-VaGYhWWg" allowfullscreen="" translate="no"></iframe>
 * <p>or keep it simple stupid and shift iteration limits:</p>
 * <iframe src="https://leetcode.com/playground/9XqCUVSn/shared" width="100%" height="106" name="user-content-9XqCUVSn" allowfullscreen="" translate="no"></iframe>
 * <h4 id="algorithm-2">Algorithm</h4>
 * <ul>
 * <li>
 * <p>Generate all possible binary bitmasks of length n.</p>
 * </li>
 * <li>
 * <p>Map a subset to each bitmask:<br>
 * <code>1</code> on the i<em>th</em> position in bitmask means the presence of <code>nums[i]</code><br>
 * in the subset, and <code>0</code> means its absence.</p>
 * </li>
 * <li>
 * <p>Return output list.</p>
 * </li>
 * </ul>
 */
class Subsets_Solution2 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        int n = nums.length;

        for (int i = (int) Math.pow(2, n); i < (int) Math.pow(2, n + 1); ++i) {
            // generate bitmask, from 0..00 to 1..11
            String bitmask = Integer.toBinaryString(i).substring(1);

            // append subset corresponding to that bitmask
            List<Integer> curr = new ArrayList<>();
            for (int j = 0; j < n; ++j) {
                if (bitmask.charAt(j) == '1') curr.add(nums[j]);
            }
            output.add(curr);
        }
        return output;
    }
}