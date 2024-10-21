package Medium.ListNode;

import Medium.ListNode.Class.ListNode;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/remove-nodes-from-linked-list/">2487. Remove Nodes From Linked List</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given the <code>head</code> of a linked list.</p>

<p>Remove every node which has a node with a greater value anywhere to the right side of it.</p>

<p>Return <em>the </em><code>head</code><em> of the modified linked list.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2022/10/02/drawio.png" style="width: 631px; height: 51px;">
<pre><strong>Input:</strong> head = [5,2,13,3,8]
<strong>Output:</strong> [13,8]
<strong>Explanation:</strong> The nodes that should be removed are 5, 2 and 3.
- Node 13 is to the right of node 5.
- Node 13 is to the right of node 2.
- Node 8 is to the right of node 3.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> head = [1,1,1,1]
<strong>Output:</strong> [1,1,1,1]
<strong>Explanation:</strong> Every node has value 1, so no nodes are removed.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of the nodes in the given list is in the range <code>[1, 10<sup>5</sup>]</code>.</li>
	<li><code>1 &lt;= Node.val &lt;= 10<sup>5</sup></code></li>
</ul>
</div>
 */
public class RemoveNodesFromLinkedList {
    public static void main(String[] args) {
        int[][] tests = {
            {5,2,13,3,8},
            {5,2,13,3,2,8,6,5,4,3,5},
            {9,9,9,9,9,9,9},
            {9,9,9,9},
            {2,4,3},
            {7,2,4,3}
        };

        for (int[] test : tests) {
            ListNode list1 = ListNode.addNode(test);

            System.out.println(new RemoveNodesFromLinkedList_Solution().removeNodes(list1).toString());
        }
    }
}

//9 ms 68.8 MB
class RemoveNodesFromLinkedList_Solution {
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode nextTemp = null;

        // Set each node's next pointer to the previous node
        while (current != null) {
            nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }
        
        return prev;
    }

    public ListNode removeNodes(ListNode head) {
        // Reverse the original linked list
        head = reverseList(head);

        int maximum = 0;
        ListNode prev = null;
        ListNode current = head;

        // Traverse the list deleting nodes
        while (current != null) {
            maximum = Math.max(maximum, current.val);

            // Delete nodes that are smaller than maximum
            if (current.val < maximum) {
                // Delete current by skipping
                prev.next = current.next;
                ListNode deleted = current;
                current = current.next;
                deleted.next = null;
            }

            // Current does not need to be deleted
            else {
                prev = current;
                current = current.next;
            }
        }
        
        // Reverse and return the modified linked list
        return reverseList(head);
    }
}