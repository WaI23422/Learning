package Medium.Array;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/minimum-number-of-days-to-make-m-bouquets/">1482. Minimum Number of Days to Make m Bouquets</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given an integer array <code>bloomDay</code>, an integer <code>m</code> and an integer <code>k</code>.</p>
 * 
 * <p>You want to make <code>m</code> bouquets. To make a bouquet, you need to use <code>k</code> <strong>adjacent flowers</strong> from the garden.</p>
 * 
 * <p>The garden consists of <code>n</code> flowers, the <code>i<sup>th</sup></code> flower will bloom in the <code>bloomDay[i]</code> and then can be used in <strong>exactly one</strong> bouquet.</p>
 * 
 * <p>Return <em>the minimum number of days you need to wait to be able to make </em><code>m</code><em> bouquets from the garden</em>. If it is impossible to make m bouquets return <code>-1</code>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> bloomDay = [1,10,3,10,2], m = 3, k = 1
 * <strong>Output:</strong> 3
 * <strong>Explanation:</strong> Let us see what happened in the first three days. x means flower bloomed and _ means flower did not bloom in the garden.
 * We need 3 bouquets each should contain 1 flower.
 * After day 1: [x, _, _, _, _]   // we can only make one bouquet.
 * After day 2: [x, _, _, _, x]   // we can only make two bouquets.
 * After day 3: [x, _, x, _, x]   // we can make 3 bouquets. The answer is 3.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> bloomDay = [1,10,3,10,2], m = 3, k = 2
 * <strong>Output:</strong> -1
 * <strong>Explanation:</strong> We need 3 bouquets each has 2 flowers, that means we need 6 flowers. We only have 5 flowers so it is impossible to get the needed bouquets and we return -1.
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> bloomDay = [7,7,7,7,12,7,7], m = 2, k = 3
 * <strong>Output:</strong> 12
 * <strong>Explanation:</strong> We need 2 bouquets each should have 3 flowers.
 * Here is the garden after the 7 and 12 days:
 * After day 7: [x, x, x, x, _, x, x]
 * We can make one bouquet of the first three flowers that bloomed. We cannot make another bouquet from the last three flowers that bloomed because they are not adjacent.
 * After day 12: [x, x, x, x, x, x, x]
 * It is obvious that we can make two bouquets in different ways.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>bloomDay.length == n</code></li>
 * 	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>1 &lt;= bloomDay[i] &lt;= 10<sup>9</sup></code></li>
 * 	<li><code>1 &lt;= m &lt;= 10<sup>6</sup></code></li>
 * 	<li><code>1 &lt;= k &lt;= n</code></li>
 * </ul>
 * </div>
 */
public class MinimumNumberOfDaysToMakeMBouquets {
    public static void main(String[] args) {
        int[][][] tests = {
            {
                {1,10,3,10,2},
                {3},
                {1},
            },
        };

        for (int[][] test : tests) {
            int bloomDay[] = test[0],
                m = test[1][0],
                k = test[2][0];

            System.out.println( new MinimumNumberOfDaysToMakeMBouquets_Solution().minDays(bloomDay, m, k));
        }
    }
}

// 24 ms 58.7 MB
class MinimumNumberOfDaysToMakeMBouquets_Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if (k*m > bloomDay.length) {return -1;}

        if (k == 1) {
            quick_sort(bloomDay,0,bloomDay.length-1);
            return bloomDay[m-1];
        }

        int start = 0;
        int end = 0;
        for (int day : bloomDay) {
            end = Math.max(end, day);
        }

        int minDay = -1;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (getNumOfBouquets(bloomDay, mid, k) >= m) {
                minDay = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return minDay;
    }

    private int getNumOfBouquets(int[] bloomDay, int mid, int k) {
        int numOfBouquets = 0;
        int count = 0;

        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= mid) {
                count++;
            } else {
                count = 0;
            }

            if (count == k) {
                numOfBouquets++;
                count = 0;
            }
        }

        return numOfBouquets;
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
 
        int i = (low - 1);
 
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    private static void quick_sort(int[] arr, int low, int high){
        if (low < high) {
            int pi = partition(arr, low, high);
            quick_sort(arr, low, pi - 1);
            quick_sort(arr, pi + 1, high);
        }
    }
}