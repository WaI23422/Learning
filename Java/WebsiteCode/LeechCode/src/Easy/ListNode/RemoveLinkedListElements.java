package Easy.ListNode;

import Easy.ListNode.Class.ListNode;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/remove-linked-list-elements/">203.Remove Linked List Elements</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given the <code>head</code> of a linked list and an integer <code>val</code>, remove all the nodes of the linked list that has <code>Node.val == val</code>, and return <em>the new head</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/03/06/removelinked-list.jpg" style="width: 500px; height: 142px;">
<pre><strong>Input:</strong> head = [1,2,6,3,4,5,6], val = 6
<strong>Output:</strong> [1,2,3,4,5]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> head = [], val = 1
<strong>Output:</strong> []
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> head = [7,7,7,7], val = 7
<strong>Output:</strong> []
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the list is in the range <code>[0, 10<sup>4</sup>]</code>.</li>
	<li><code>1 &lt;= Node.val &lt;= 50</code></li>
	<li><code>0 &lt;= val &lt;= 50</code></li>
</ul>
</div>
 */
public class RemoveLinkedListElements {
    public static void main(String[] args) {
        int[][][] tests = {
            {{1,2,6,3,4,5,6},{6}},
            {{},{1}},
            {{7,7,7,7},{7}},
            {{1},{1}},
            {{1,2,1},{1}},
            {{1,2,2,1},{1}},
            {{1,2,2,1},{2}},
            {{5,4,3,2,1,1},{1}}
        }; 

        for (int[][] test : tests) {
            ListNode head = ListNode.addNode(test[0]);
            int val = test[1][0];

            ListNode ans = new RemoveLinkedListElements_Solution().removeElements(head, val);

            System.out.println(ans==null ?"[]":ans.toString());
        }
    }
}

// 0 ms 45.4 MB
class RemoveLinkedListElements_Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;  

        head.next = removeElements(head.next, val); 

        if(head.val == val) head = head.next; 

        return head;
    }
}