package Hard.Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/valid-arrangement-of-pairs/">2097. Valid Arrangement of Pairs</a>
 * 
 * <div><div class="elfjS" data-track-load="description_content"><p>You are given a <strong>0-indexed</strong> 2D integer array <code>pairs</code> where <code>pairs[i] = [start<sub>i</sub>, end<sub>i</sub>]</code>. An arrangement of <code>pairs</code> is <strong>valid</strong> if for every index <code>i</code> where <code>1 &lt;= i &lt; pairs.length</code>, we have <code>end<sub>i-1</sub> == start<sub>i</sub></code>.</p>
 * 
 * <p>Return <em><strong>any</strong> valid arrangement of </em><code>pairs</code>.</p>
 * 
 * <p><strong>Note:</strong> The inputs will be generated such that there exists a valid arrangement of <code>pairs</code>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <pre><strong>Input:</strong> pairs = [[5,1],[4,5],[11,9],[9,4]]
 * <strong>Output:</strong> [[11,9],[9,4],[4,5],[5,1]]
 * <strong>Explanation:
 * </strong>This is a valid arrangement since end<sub>i-1</sub> always equals start<sub>i</sub>.
 * end<sub>0</sub> = 9 == 9 = start<sub>1</sub> 
 * end<sub>1</sub> = 4 == 4 = start<sub>2</sub>
 * end<sub>2</sub> = 5 == 5 = start<sub>3</sub>
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <pre><strong>Input:</strong> pairs = [[1,3],[3,2],[2,1]]
 * <strong>Output:</strong> [[1,3],[3,2],[2,1]]
 * <strong>Explanation:</strong>
 * This is a valid arrangement since end<sub>i-1</sub> always equals start<sub>i</sub>.
 * end<sub>0</sub> = 3 == 3 = start<sub>1</sub>
 * end<sub>1</sub> = 2 == 2 = start<sub>2</sub>
 * The arrangements [[2,1],[1,3],[3,2]] and [[3,2],[2,1],[1,3]] are also valid.
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <pre><strong>Input:</strong> pairs = [[1,2],[1,3],[2,1]]
 * <strong>Output:</strong> [[1,2],[2,1],[1,3]]
 * <strong>Explanation:</strong>
 * This is a valid arrangement since end<sub>i-1</sub> always equals start<sub>i</sub>.
 * end<sub>0</sub> = 2 == 2 = start<sub>1</sub>
 * end<sub>1</sub> = 1 == 1 = start<sub>2</sub>
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= pairs.length &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>pairs[i].length == 2</code></li>
 * 	<li><code>0 &lt;= start<sub>i</sub>, end<sub>i</sub> &lt;= 10<sup>9</sup></code></li>
 * 	<li><code>start<sub>i</sub> != end<sub>i</sub></code></li>
 * 	<li>No two pairs are exactly the same.</li>
 * 	<li>There <strong>exists</strong> a valid arrangement of <code>pairs</code>.</li>
 * </ul>
 * </div></div>
 */
public class ValidArrangementOfPairs {
    public static void main(String[] args) {
        
    }
}

// 173ms 107MB
class ValidArrangementOfPairs_Solution {

    public int[][] validArrangement(int[][] pairs) {
        HashMap<Integer, LinkedList<Integer>> adjacencyMatrix = new HashMap<>();
        HashMap<Integer, Integer> inDegree = new HashMap<>(), outDegree =
            new HashMap<>();

        // Build the adjacency list and track in-degrees and out-degrees
        for (int[] pair : pairs) {
            int start = pair[0], end = pair[1];
            adjacencyMatrix.putIfAbsent(start, new LinkedList<>());
            adjacencyMatrix.get(start).add(end);
            outDegree.put(start, outDegree.getOrDefault(start, 0) + 1);
            inDegree.put(end, inDegree.getOrDefault(end, 0) + 1);
        }

        ArrayList<Integer> result = new ArrayList<>();

        // Find the start node (outDegree == inDegree + 1)
        int startNode = -1;
        for (int node : outDegree.keySet()) {
            if (outDegree.get(node) == inDegree.getOrDefault(node, 0) + 1) {
                startNode = node;
                break;
            }
        }

        // If no such node exists, start from the first pair's first element
        if (startNode == -1) {
            startNode = pairs[0][0];
        }

        Stack<Integer> nodeStack = new Stack<>();
        nodeStack.push(startNode);

        // Iterative DFS using stack
        while (!nodeStack.empty()) {
            int node = nodeStack.peek();
            if (
                adjacencyMatrix.getOrDefault(node, new LinkedList<>()).size() >
                0
            ) {
                // Visit the next node
                int nextNode = adjacencyMatrix.get(node).removeFirst();
                nodeStack.push(nextNode);
            } else {
                // No more neighbors to visit, add node to result
                result.add(node);
                nodeStack.pop();
            }
        }

        // Reverse the result since we collected nodes in reverse order
        Collections.reverse(result);

        // Construct the result pairs
        int[][] pairedResult = new int[result.size() - 1][2];
        for (int i = 1; i < result.size(); ++i) {
            pairedResult[i - 1][0] = result.get(i - 1);
            pairedResult[i - 1][1] = result.get(i);
        }

        return pairedResult;
    }
}