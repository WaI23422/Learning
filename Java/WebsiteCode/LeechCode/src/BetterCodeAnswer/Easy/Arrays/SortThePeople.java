package BetterCodeAnswer.Easy.Arrays;

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

// 1 ms 45.1 MB
class SortThePeople_Solution {
    private <T> void insertionSortReverseOrder(int[] main, T[] side, int left, int right) {
            for(int i = left+1; i <= right; i++) {
                for(int j = i - 1; j >= 0; j--) {
                    if(main[j+1] > main[j]) { // reverse order
                        int t = main[j+1];
                        main[j+1] = main[j];
                        main[j] = t;

                        T tT = side[j+1];
                        side[j+1] = side[j];
                        side[j] = tT;
                    }else break;
                }
            }
        }
    private <T> void quickSortReverseOrder(int[] main, T[] side, int left, int right) {
        if(left >= right) return;
        if(right - left <= 11) {
            // Do insertion sort
            insertionSortReverseOrder(main, side, left, right);
            return;
        }
        // Choose pivot of median between left, left+1, left+2
        int pivot;
        {
            int aV = main[left], bV = main[left+1], cV = main[left+2];
            if(aV <= bV && aV <= cV) {
                // a is smallest
                pivot = bV <= cV ? (left+1) : (left+2);
            }else if(bV <= aV && bV <= cV) {
                // b is smallest
                pivot = aV <= cV ? (left) : (left+2);
            }else {
                // c is smallest
                pivot = aV <= bV ? (left) : (left+1);
            }
        }

        int val = main[pivot];
        { // swap pivot with right
            main[pivot] = main[right];
            main[right] = val;
        }
        {
            T x = side[pivot];
            side[pivot] = side[right];
            side[right] = x;
        }
        int L = left, R = right - 1;
        while(true) {
            while(L <= R && main[L] >= val) L++; // Reverse order
            while(L <= R && main[R] <= val) R--;
            if(L < R) {
                { // swap idx L and R
                    int z = main[L];
                    main[L] = main[R];
                    main[R] = z;
                }
                {
                    T z = side[L];
                    side[L] = side[R];
                    side[R] = z;
                }
                L++; R--;
            }else {
                break;
            }
        }
    { // swap idx L and right
            int z = main[L];
            main[L] = main[right];
            main[right] = z;
        }
        {
            T z = side[L];
            side[L] = side[right];
            side[right] = z;
        }
        quickSortReverseOrder(main, side, left, L-1);
        quickSortReverseOrder(main, side, L+1, right);
    }
    
    public String[] sortPeople(String[] names, int[] heights) {
        quickSortReverseOrder(heights, names, 0, names.length-1);
        return names;
    }
}