package Easy.Arrays;

import java.util.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/sort-the-people/">2418. Sort the People</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given an array of strings <code>names</code>, and an array <code>heights</code> that consists of <strong>distinct</strong> positive integers. Both arrays are of length <code>n</code>.</p>
 * 
 * <p>For each index <code>i</code>, <code>names[i]</code> and <code>heights[i]</code> denote the name and height of the <code>i<sup>th</sup></code> person.</p>
 * 
 * <p>Return <code>names</code><em> sorted in <strong>descending</strong> order by the people's heights</em>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> names = ["Mary","John","Emma"], heights = [180,165,170]
 * <strong>Output:</strong> ["Mary","Emma","John"]
 * <strong>Explanation:</strong> Mary is the tallest, followed by Emma and John.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> names = ["Alice","Bob","Bob"], heights = [155,185,150]
 * <strong>Output:</strong> ["Bob","Alice","Bob"]
 * <strong>Explanation:</strong> The first Bob is the tallest, followed by Alice and the second Bob.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>n == names.length == heights.length</code></li>
 * 	<li><code>1 &lt;= n &lt;= 10<sup>3</sup></code></li>
 * 	<li><code>1 &lt;= names[i].length &lt;= 20</code></li>
 * 	<li><code>1 &lt;= heights[i] &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>names[i]</code> consists of lower and upper case English letters.</li>
 * 	<li>All the values of <code>heights</code> are distinct.</li>
 * </ul>
 * </div>
 */
public class SortThePeople {
    public static void main(String[] args) {
        Object[][][] tests = {
            {
                {"Mary","John","Emma"},
                {180,165,170}
            }
        };

        for (Object[][] test : tests) {
            String[] names = Arrays.stream(test[0])
                                   .map(Object::toString)
                                   .toArray(String[]::new);
            int[] heights = Arrays.stream(test[1])
                                  .mapToInt(t -> (int) t)
                                  .toArray();

            System.out.println(new SortThePeople_Solution().sortPeople(names, heights));
        }
    }
}

// 2 ms 45.1 MB
class SortThePeople_Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        Sort(names, heights, 0, heights.length-1);

        return names;
    }

    static void swap(String[] names, int[] heights , int i, int j){
        String tempName = names[i];
        names[i] = names[j];
        names[j] = tempName;

        int tempHeight = heights[i];
        heights[i] = heights[j];
        heights[j] = tempHeight;
    }

    static int partition(String[] names, int[] heights, int low, int high){
        int pivot = heights[high];
 
        int i = (low - 1);
 
        for (int j = low; j <= high - 1; j++) {
            if (heights[j] > pivot) {
                i++;
                swap(names,heights, i, j);
            }
        }
        swap(names,heights, i + 1, high);

        return (i + 1);
    }

    static void Sort(String[] names, int[] heights, int low, int high){
        if (low < high) {
            int pi = partition(names, heights, low, high);
            Sort(names, heights, low, pi - 1);
            Sort(names, heights, pi + 1, high);
        }
    }
}