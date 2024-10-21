package BetterCodeAnswer.Easy.Arrays;

import java.util.Arrays;
import java.util.HashSet;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/intersection-of-two-arrays/">349.Intersection of Two Arrays</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given two integer arrays <code>nums1</code> and <code>nums2</code>, return <em>an array of their intersection</em>. Each element in the result must be <strong>unique</strong> and you may return the result in <strong>any order</strong>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums1 = [1,2,2,1], nums2 = [2,2]
<strong>Output:</strong> [2]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums1 = [4,9,5], nums2 = [9,4,9,8,4]
<strong>Output:</strong> [9,4]
<strong>Explanation:</strong> [4,9] is also accepted.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums1.length, nums2.length &lt;= 1000</code></li>
	<li><code>0 &lt;= nums1[i], nums2[i] &lt;= 1000</code></li>
</ul>
</div>
 */
public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[][][] tests = {
            {{1,2,2,1},{2,2}},
            {{},{1,2,3}},
            {{4,9,5},{9,4,9,8,4}},
            {{1,2},{3,4}},
            {{1,5,78,454,122,544},{544,1,23,445,5}}
        };

        for (int[][] test : tests) {
            int[] num1 = test[0],
                  num2 = test[1];

            System.out.println(Arrays.toString(new IntersectionOfTwoArrays_Solution().intersection(num1, num2)));
        }
    }
}

// 0 ms 43.13 MB
class IntersectionOfTwoArrays_Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        final int N = 1001;
        var set = new int[N];
        for (var i : nums1) set[i] = 1;
        int resCount = 0;
        for (var i : nums2) {
            if (set[i] == 1) {
                set[i] = 2;
                ++resCount;
            }
        }
        var res = new int[resCount];
        var i = 0;
        var nums = nums2.length > nums1.length ? nums1 : nums2;
        for (var v : nums) {
            if (set[v] == 2) {
                res[i++] = v;
                set[v] = 1;
            }
        }
        return res;
    }
    public int[] intersectionOnSet(int[] nums1, int[] nums2) {
       var  s1 = new HashSet<Integer>(nums1.length);
       for (var i : nums1) s1.add(i);
       var s2 = new HashSet<Integer>(nums2.length);
       for (var i : nums2) {
           if (s1.contains(i)) s2.add(i);
       }
       var res = new int[s2.size()];
       int j = 0;
       for (var i : s2){
           System.out.println("v: " + res[j]);
            res[j++] = i;
       }
       return res;
    }
}