package Medium.Array;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/maximum-total-importance-of-roads/">2285. Maximum Total Importance of Roads</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given an integer <code>n</code> denoting the number of cities in a country. The cities are numbered from <code>0</code> to <code>n - 1</code>.</p>
 * 
 * <p>You are also given a 2D integer array <code>roads</code> where <code>roads[i] = [a<sub>i</sub>, b<sub>i</sub>]</code> denotes that there exists a <strong>bidirectional</strong> road connecting cities <code>a<sub>i</sub></code> and <code>b<sub>i</sub></code>.</p>
 * 
 * <p>You need to assign each city with an integer value from <code>1</code> to <code>n</code>, where each value can only be used <strong>once</strong>. The <strong>importance</strong> of a road is then defined as the <strong>sum</strong> of the values of the two cities it connects.</p>
 * 
 * <p>Return <em>the <strong>maximum total importance</strong> of all roads possible after assigning the values optimally.</em></p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2022/04/07/ex1drawio.png" style="width: 290px; height: 215px;">
 * <pre><strong>Input:</strong> n = 5, roads = [[0,1],[1,2],[2,3],[0,2],[1,3],[2,4]]
 * <strong>Output:</strong> 43
 * <strong>Explanation:</strong> The figure above shows the country and the assigned values of [2,4,5,3,1].
 * - The road (0,1) has an importance of 2 + 4 = 6.
 * - The road (1,2) has an importance of 4 + 5 = 9.
 * - The road (2,3) has an importance of 5 + 3 = 8.
 * - The road (0,2) has an importance of 2 + 5 = 7.
 * - The road (1,3) has an importance of 4 + 3 = 7.
 * - The road (2,4) has an importance of 5 + 1 = 6.
 * The total importance of all roads is 6 + 9 + 8 + 7 + 7 + 6 = 43.
 * It can be shown that we cannot obtain a greater total importance than 43.
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2022/04/07/ex2drawio.png" style="width: 281px; height: 151px;">
 * <pre><strong>Input:</strong> n = 5, roads = [[0,3],[2,4],[1,3]]
 * <strong>Output:</strong> 20
 * <strong>Explanation:</strong> The figure above shows the country and the assigned values of [4,3,2,5,1].
 * - The road (0,3) has an importance of 4 + 5 = 9.
 * - The road (2,4) has an importance of 2 + 1 = 3.
 * - The road (1,3) has an importance of 3 + 5 = 8.
 * The total importance of all roads is 9 + 3 + 8 = 20.
 * It can be shown that we cannot obtain a greater total importance than 20.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>2 &lt;= n &lt;= 5 * 10<sup>4</sup></code></li>
 * 	<li><code>1 &lt;= roads.length &lt;= 5 * 10<sup>4</sup></code></li>
 * 	<li><code>roads[i].length == 2</code></li>
 * 	<li><code>0 &lt;= a<sub>i</sub>, b<sub>i</sub> &lt;= n - 1</code></li>
 * 	<li><code>a<sub>i</sub> != b<sub>i</sub></code></li>
 * 	<li>There are no duplicate roads.</li>
 * </ul>
 * </div>
 */
public class MaximumTotalImportanceOfRoads {
    public static void main(String[] args) {
        int[][][][] tests = { 
            {
                {{0,1}},
                {{5}}
            },
            {
                {
                    {0,1},
                    {1,2},
                    {2,3},
                    {0,2},
                    {1,3},
                    {2,4},
                },
                {
                    {5}
                }
            },
        };

        for (int[][][] test : tests) {
            int road[][] = test[0],
                n = test[1][0][0];

            System.out.println(new MaximumTotalImportanceOfRoads_Solution().maximumImportance(n, road));
        }
    }
}

// 92 ms 71.6 MB
class MaximumTotalImportanceOfRoads_Solution {
    public long maximumImportance(int n, int[][] roads) {
        HashMap<Integer,Long> connects = new HashMap<>();
        int[] roadsImportance = new int[n];
    
        for (int i = 0; i < n; i++) {
            connects.put(i, 0l);
        }

        for (int[] road : roads) {
            int in = road[0],
                out = road[1];
            connects.put(in, connects.getOrDefault(in, 0l)+1);
            connects.put(out, connects.getOrDefault(out, 0l)+1);
        }

        connects = connects.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(
                    Collectors.toMap(
                        Map.Entry::getKey, 
                        Map.Entry::getValue, 
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new)
                );
        
        int idx = 1;
        for (int connect  : connects.keySet()) {
            roadsImportance[connect] = idx++;
        }

        long total = 0;
        for (int i = 0; i < n; i++) {
            total += roadsImportance[i]*connects.getOrDefault(i,0l);
        }

        return total;
    }
}