package BetterCodeAnswer.Medium.Array;

import java.util.Arrays;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/shortest-distance-after-road-addition-queries-i/">3243. Shortest Distance After Road Addition Queries I</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>You are given an integer <code>n</code> and a 2D integer array <code>queries</code>.</p>
 * 
 * <p>There are <code>n</code> cities numbered from <code>0</code> to <code>n - 1</code>. Initially, there is a <strong>unidirectional</strong> road from city <code>i</code> to city <code>i + 1</code> for all <code>0 &lt;= i &lt; n - 1</code>.</p>
 * 
 * <p><code>queries[i] = [u<sub>i</sub>, v<sub>i</sub>]</code> represents the addition of a new <strong>unidirectional</strong> road from city <code>u<sub>i</sub></code> to city <code>v<sub>i</sub></code>. After each query, you need to find the <strong>length</strong> of the <strong>shortest path</strong> from city <code>0</code> to city <code>n - 1</code>.</p>
 * 
 * <p>Return an array <code>answer</code> where for each <code>i</code> in the range <code>[0, queries.length - 1]</code>, <code>answer[i]</code> is the <em>length of the shortest path</em> from city <code>0</code> to city <code>n - 1</code> after processing the <strong>first </strong><code>i + 1</code> queries.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <div class="example-block">
 * <p><strong>Input:</strong> <span class="example-io">n = 5, queries = [[2,4],[0,2],[0,4]]</span></p>
 * 
 * <p><strong>Output:</strong> <span class="example-io">[3,2,1]</span></p>
 * 
 * <p><strong>Explanation: </strong></p>
 * 
 * <p><img alt="" src="https://assets.leetcode.com/uploads/2024/06/28/image8.jpg" style="width: 350px; height: 60px;"></p>
 * 
 * <p>After the addition of the road from 2 to 4, the length of the shortest path from 0 to 4 is 3.</p>
 * 
 * <p><img alt="" src="https://assets.leetcode.com/uploads/2024/06/28/image9.jpg" style="width: 350px; height: 60px;"></p>
 * 
 * <p>After the addition of the road from 0 to 2, the length of the shortest path from 0 to 4 is 2.</p>
 * 
 * <p><img alt="" src="https://assets.leetcode.com/uploads/2024/06/28/image10.jpg" style="width: 350px; height: 96px;"></p>
 * 
 * <p>After the addition of the road from 0 to 4, the length of the shortest path from 0 to 4 is 1.</p>
 * </div>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <div class="example-block">
 * <p><strong>Input:</strong> <span class="example-io">n = 4, queries = [[0,3],[0,2]]</span></p>
 * 
 * <p><strong>Output:</strong> <span class="example-io">[1,1]</span></p>
 * 
 * <p><strong>Explanation:</strong></p>
 * 
 * <p><img alt="" src="https://assets.leetcode.com/uploads/2024/06/28/image11.jpg" style="width: 300px; height: 70px;"></p>
 * 
 * <p>After the addition of the road from 0 to 3, the length of the shortest path from 0 to 3 is 1.</p>
 * 
 * <p><img alt="" src="https://assets.leetcode.com/uploads/2024/06/28/image12.jpg" style="width: 300px; height: 70px;"></p>
 * 
 * <p>After the addition of the road from 0 to 2, the length of the shortest path remains 1.</p>
 * </div>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>3 &lt;= n &lt;= 500</code></li>
 * 	<li><code>1 &lt;= queries.length &lt;= 500</code></li>
 * 	<li><code>queries[i].length == 2</code></li>
 * 	<li><code>0 &lt;= queries[i][0] &lt; queries[i][1] &lt; n</code></li>
 * 	<li><code>1 &lt; queries[i][1] - queries[i][0]</code></li>
 * 	<li>There are no repeated roads among the queries.</li>
 * </ul>
 * </div></div>
 */
public class ShortestDistanceAfterRoadAdditionQueriesI {
    public static void main(String[] args) {
        
    }
}

// 7ms 45.5MB
class ShortestDistanceAfterRoadAdditionQueriesI_Solution {
    public int[] shortestDistanceAfterQueries(final int n, final int[][] queries) {
        final int[][] children = initialChildren(n, queries);

        final int[] distFromZero = new int[n];
        for (int i = 1; i < n; ++i) {
            distFromZero[i] = i;
        }

        final int[] bfsPad = new int[n];

        final int[] result = new int[queries.length];

        for (int q = 0; q < queries.length; ++q) {
            final int u = queries[q][0];
            final int v = queries[q][1];
            for (int c = 0; ; ++c) {
                if (children[u][c] == 0) {
                    children[u][c] = v;
                    break;
                }
            }
            bfsPad[0] = u;
            for (int bfsNext = 0, bfsEnd = 1; bfsNext < bfsEnd; ) {
                final int currNode = bfsPad[bfsNext++];
                for (final int nextNode : children[currNode]) {
                    if (nextNode == 0) {
                        break;
                    }
                    if (distFromZero[nextNode] <= distFromZero[currNode] + 1) {
                        continue;
                    }
                    distFromZero[nextNode] = distFromZero[currNode] + 1;
                    bfsPad[bfsEnd++] = nextNode;
                }
            }
            result[q] = distFromZero[n-1];
        }
        return result;
    }

    private int[][] initialChildren(final int n, final int[][] queries) {
        final int[] numChildren = new int[n];
        Arrays.fill(numChildren, 1);
        numChildren[n-1] = 0;

        for (final int[] query : queries) {
            final int u = query[0];
            numChildren[u]++;
        }

        final int[][] children = new int[n][];
        for (int i = 0; i < n - 1; ++i) {
            children[i] = new int[numChildren[i]];
            children[i][0] = i + 1;
        }
        assert numChildren[n-1] == 0;
        children[n-1] = new int[0];
        return children;
    }
}