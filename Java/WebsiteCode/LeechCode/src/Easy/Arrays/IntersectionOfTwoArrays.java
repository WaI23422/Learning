package Easy.Arrays;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

// 6 ms 42.7 MB
class IntersectionOfTwoArrays_Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int left = 0, right=0,
            len1 = nums1.length, len2 = nums2.length;

        List<Integer> ans = new ArrayList<>(); // ArrayList<Integer>: 6ms -> 7ms
        Arrays.sort(nums1);Arrays.sort(nums2);
        
        if (nums1.length==0 || nums2.length == 0 ||nums1[0] > nums2[len2-1] || nums2[0] > nums1[len1-1]) {return new int[0];}
        
        while (left < len1 && right < len2) {
            if (nums1[left] == nums2[right] && !ans.contains(nums1[left])) {
                ans.add(nums1[left]);
                left++; right++;
            } else if (nums1[left] == nums2[right] && ans.contains(nums1[left])) {
                left++; right++;
            } else if (nums1[left] > nums2[right]) {
                right++;
            } else {
                left++;
            }
        }
        

        return ans.stream()
                  .mapToInt(t -> t)
                  .toArray();
    }
}

// 2 ms 43.06 MB
class IntersectionOfTwoArrays_Solution2 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> appearSet = new HashSet<>();
        List<Integer> ans = new ArrayList<>();

        for (int num : nums1) {appearSet.add(num);}

        for (int num : nums2) {
            if (appearSet.contains(num)) {
                ans.add(num);
                appearSet.remove(num);
            }
        }   

        // 2ms -> 4ms
        // return ans.stream()
        //           .mapToInt(t -> t)
        //           .toArray();
        
        // 43.06 MB -> 43.2 MB
        // int[] arr = new int[l.size()];
        // for (int i = 0; i < l.size(); i++) {
        //     arr[i] = l.get(i);
        // }
        // return arr 

        return listToArray(ans);
    }

    private int[] listToArray(List<Integer> l) {
        int[] arr = new int[l.size()];
        for (int i = 0; i < l.size(); i++) {
            arr[i] = l.get(i);
        }

        return arr;
    }
}

// 1441 ms 45.1 MB
class IntersectionOfTwoArrays_Solution3 {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> ans = new ArrayList<>();

        for (int num1 : nums1) {
            for (int num2 : nums2) {
                if (!ans.contains(num1) && num1 == num2) {
                    ans.add(num1);
                }
            }
        }

        return ans.stream()
                  .mapToInt(t -> t)
                  .toArray();
    }
}