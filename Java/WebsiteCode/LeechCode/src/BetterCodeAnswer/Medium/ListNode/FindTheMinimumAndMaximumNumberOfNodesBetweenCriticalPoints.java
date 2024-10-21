package BetterCodeAnswer.Medium.ListNode;

import java.util.Arrays;

import Medium.ListNode.Class.ListNode;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/">2058. Find the Minimum and Maximum Number of Nodes Between Critical Points</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>A <strong>critical point</strong> in a linked list is defined as <strong>either</strong> a <strong>local maxima</strong> or a <strong>local minima</strong>.</p>
 * 
 * <p>A node is a <strong>local maxima</strong> if the current node has a value <strong>strictly greater</strong> than the previous node and the next node.</p>
 * 
 * <p>A node is a <strong>local minima</strong> if the current node has a value <strong>strictly smaller</strong> than the previous node and the next node.</p>
 * 
 * <p>Note that a node can only be a local maxima/minima if there exists <strong>both</strong> a previous node and a next node.</p>
 * 
 * <p>Given a linked list <code>head</code>, return <em>an array of length 2 containing </em><code>[minDistance, maxDistance]</code><em> where </em><code>minDistance</code><em> is the <strong>minimum distance</strong> between <strong>any&nbsp;two distinct</strong> critical points and </em><code>maxDistance</code><em> is the <strong>maximum distance</strong> between <strong>any&nbsp;two distinct</strong> critical points. If there are <strong>fewer</strong> than two critical points, return </em><code>[-1, -1]</code>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/10/13/a1.png" style="width: 148px; height: 55px;">
 * <pre><strong>Input:</strong> head = [3,1]
 * <strong>Output:</strong> [-1,-1]
 * <strong>Explanation:</strong> There are no critical points in [3,1].
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/10/13/a2.png" style="width: 624px; height: 46px;">
 * <pre><strong>Input:</strong> head = [5,3,1,2,5,1,2]
 * <strong>Output:</strong> [1,3]
 * <strong>Explanation:</strong> There are three critical points:
 * - [5,3,<strong><u>1</u></strong>,2,5,1,2]: The third node is a local minima because 1 is less than 3 and 2.
 * - [5,3,1,2,<u><strong>5</strong></u>,1,2]: The fifth node is a local maxima because 5 is greater than 2 and 1.
 * - [5,3,1,2,5,<u><strong>1</strong></u>,2]: The sixth node is a local minima because 1 is less than 5 and 2.
 * The minimum distance is between the fifth and the sixth node. minDistance = 6 - 5 = 1.
 * The maximum distance is between the third and the sixth node. maxDistance = 6 - 3 = 3.
 * </pre>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/10/14/a5.png" style="width: 624px; height: 39px;">
 * <pre><strong>Input:</strong> head = [1,3,2,2,3,2,2,2,7]
 * <strong>Output:</strong> [3,3]
 * <strong>Explanation:</strong> There are two critical points:
 * - [1,<u><strong>3</strong></u>,2,2,3,2,2,2,7]: The second node is a local maxima because 3 is greater than 1 and 2.
 * - [1,3,2,2,<u><strong>3</strong></u>,2,2,2,7]: The fifth node is a local maxima because 3 is greater than 2 and 2.
 * Both the minimum and maximum distances are between the second and the fifth node.
 * Thus, minDistance and maxDistance is 5 - 2 = 3.
 * Note that the last node is not considered a local maxima because it does not have a next node.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li>The number of nodes in the list is in the range <code>[2, 10<sup>5</sup>]</code>.</li>
 * 	<li><code>1 &lt;= Node.val &lt;= 10<sup>5</sup></code></li>
 * </ul>
 * </div>
 */
public class FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints {
    public static void main(String[] args) {
        int[][] tests = {
            {2,2,1,3},
            {2,3,3,2},
            {5,3,1,2,5,1,2},
            {3,1},
        };

        for (int[] test : tests) {
            ListNode head = ListNode.addNode(test);

            System.out.println(Arrays.toString(new FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints_Solution().nodesBetweenCriticalPoints(head)));
        }
    }
}

// 4 ms 60.2 MB
class FindTheMinimumAndMaximumNumberOfNodesBetweenCriticalPoints_Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

       ListNode prev=head;
       ListNode curr=head.next;

       int first_index=-1;
       int last_index=-1;

       int index=1;

       int prev_index=-1;

       int min_dist=Integer.MAX_VALUE;

       while(curr.next!=null){

        if(prev.val>curr.val && curr.val<curr.next.val   || prev.val<curr.val && curr.val>curr.next.val){

            if(prev_index==-1){
                first_index=index;
                prev_index=index;
            }
            else{
                if(min_dist>index-prev_index){
                    min_dist=index-prev_index;
                }

                prev_index=index;
            }

        }

        index++;


        curr=curr.next;
        prev=prev.next;

       }

       last_index=prev_index;

       int max_dist=-1;

      

       if(min_dist==Integer.MAX_VALUE ){
         int[]arr={-1,-1};
         return arr;
       }
       else{
        max_dist=last_index-first_index;
        int []arr={min_dist,max_dist};
        return arr;
       }

    }
}