package Easy.ListNode;

import Easy.ListNode.Class.ListNode;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/reverse-linked-list/">206.Reverse Linked List</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given the <code>head</code> of a singly linked list, reverse the list, and return <em>the reversed list</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/rev1ex1.jpg" style="width: 542px; height: 222px;">
<pre><strong>Input:</strong> head = [1,2,3,4,5]
<strong>Output:</strong> [5,4,3,2,1]
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/rev1ex2.jpg" style="width: 182px; height: 222px;">
<pre><strong>Input:</strong> head = [1,2]
<strong>Output:</strong> [2,1]
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> head = []
<strong>Output:</strong> []
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the list is the range <code>[0, 5000]</code>.</li>
	<li><code>-5000 &lt;= Node.val &lt;= 5000</code></li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong> A linked list can be reversed either iteratively or recursively. Could you implement both?</p>
</div>
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        int[][] tests = {
            {1,2,3,4,5},
            {1,2,3,4,5,6},
            {1,2,3},
            // {1,2},
            // {1},
            // {}
        }; 

        for (int[] test : tests) {
            ListNode headA = ListNode.addNode(test);
            ListNode ans = new ReverseLinkedList_Solution().reverseList(headA);
            
            System.out.println(ans == null? null : ans.toString());
        }
    }
}

// 0 ms 42.8 MB
class ReverseLinkedList_Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {return head;}

        ListNode prevHead = head, inverListNode = head.next; 
        
        while (head.next != null && head.next.next != null) {
            head.next = head.next.next;
            inverListNode.next = prevHead;
            prevHead = inverListNode;
            inverListNode = head.next;
        }   
        
        inverListNode.next = prevHead;
        head.next = null;

        return inverListNode;
    }
}
