package BetterCodeAnswer.Easy.LinkedList;

import BetterCodeAnswer.Easy.LinkedList.Class.ListNode;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/middle-of-the-linked-list/">876.Middle of the Linked List</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given the <code>head</code> of a singly linked list, return <em>the middle node of the linked list</em>.</p>

<p>If there are two middle nodes, return <strong>the second middle</strong> node.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/07/23/lc-midlist1.jpg" style="width: 544px; height: 65px;">
<pre><strong>Input:</strong> head = [1,2,3,4,5]
<strong>Output:</strong> [3,4,5]
<strong>Explanation:</strong> The middle node of the list is node 3.
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/07/23/lc-midlist2.jpg" style="width: 664px; height: 65px;">
<pre><strong>Input:</strong> head = [1,2,3,4,5,6]
<strong>Output:</strong> [4,5,6]
<strong>Explanation:</strong> Since the list has two middle nodes with values 3 and 4, we return the second one.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the list is in the range <code>[1, 100]</code>.</li>
	<li><code>1 &lt;= Node.val &lt;= 100</code></li>
</ul>
</div>
 */
public class MiddleOfTheLinkedList {
    public static void main(String[] args) {
        int[][] tests = {
            {1,2,3,4,5},
            {1,2,3,4,5,6},
            {1,2,3},
            {1,2},
            {1},
        }; 

        for (int[] test : tests) {
            ListNode headA = ListNode.addNode(test, 0);
            ListNode ans = new MiddleOfTheLinkedList_Solution().middleNode(headA);
            System.out.println(ans == null? null : ans.toString());
        }
    }
}

// 0 ms 41 MB
class MiddleOfTheLinkedList_Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow =head;
        ListNode fast =head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}