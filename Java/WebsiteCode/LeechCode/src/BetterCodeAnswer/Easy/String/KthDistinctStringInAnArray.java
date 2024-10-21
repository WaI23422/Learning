package BetterCodeAnswer.Easy.String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/kth-distinct-string-in-an-array/">2053. Kth Distinct String in an Array</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>A <strong>distinct string</strong> is a string that is present only <strong>once</strong> in an array.</p>
 * 
 * <p>Given an array of strings <code>arr</code>, and an integer <code>k</code>, return <em>the </em><code>k<sup>th</sup></code><em> <strong>distinct string</strong> present in </em><code>arr</code>. If there are <strong>fewer</strong> than <code>k</code> distinct strings, return <em>an <strong>empty string </strong></em><code>""</code>.</p>
 * 
 * <p>Note that the strings are considered in the <strong>order in which they appear</strong> in the array.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> arr = ["d","b","c","b","c","a"], k = 2
 * <strong>Output:</strong> "a"
 * <strong>Explanation:</strong>
 * The only distinct strings in arr are "d" and "a".
 * "d" appears 1<sup>st</sup>, so it is the 1<sup>st</sup> distinct string.
 * "a" appears 2<sup>nd</sup>, so it is the 2<sup>nd</sup> distinct string.
 * Since k == 2, "a" is returned. 
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> arr = ["aaa","aa","a"], k = 1
 * <strong>Output:</strong> "aaa"
 * <strong>Explanation:</strong>
 * All strings in arr are distinct, so the 1<sup>st</sup> string "aaa" is returned.
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> arr = ["a","b","a"], k = 3
 * <strong>Output:</strong> ""
 * <strong>Explanation:</strong>
 * The only distinct string is "b". Since there are fewer than 3 distinct strings, we return an empty string "".
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= k &lt;= arr.length &lt;= 1000</code></li>
 * 	<li><code>1 &lt;= arr[i].length &lt;= 5</code></li>
 * 	<li><code>arr[i]</code> consists of lowercase English letters.</li>
 * </ul>
 * </div>
 */
public class KthDistinctStringInAnArray {
    public static void main(String[] args) {
        Object[][][] tests = {
            {
                {"d","b","c","b","c","a"},
                {2}
            }
        };

        for (Object[][] test : tests) {
            // String[] strArr = Arrays.stream(objArr).map(Object::toString).toArray(String[]::new);
            String[] arr = Arrays.copyOf(test[0], test[0].length, String[].class);
            int k = (int) test[1][0];

            System.out.println(new KthDistinctStringInAnArray_Solution().kthDistinct(arr, k));
        }
    }
}

// 4ms 43.93MB
class KthDistinctStringInAnArray_Solution {
    public String kthDistinct(String[] arr, int k) {
        int totalDistinctVal = 0;
        Set<String> nonDistinctSet = new HashSet<>();
        Set<String> distinctSet = new HashSet<>();
        for(String s:arr) {
            if(!nonDistinctSet.contains(s)) {
                if(!distinctSet.contains(s)) {
                    distinctSet.add(s);
                    totalDistinctVal++;
                } else {
                    nonDistinctSet.add(s);
                    distinctSet.remove(s);
                    totalDistinctVal--;
                }
            }
        }
        if(totalDistinctVal<k) {
            return "";
        }
        for(String s:arr) {
            if(distinctSet.contains(s)){
                k--;
                if(k==0){
                    return s;
                }
            }
        }
        return "";
    }
}

// 6ms 44.14MB
class KthDistinctStringInAnArray_Solution2 {
    public String kthDistinct(String[] arr, int k) {
        Map<String,Integer> count=new HashMap<>();
        for(final String s:arr){
            count.merge(s,1,Integer::sum);
        }
        for(final String s:arr){
            if(count.get(s)==1 &&--k==0)
                return s;
        }
    return "";}
}