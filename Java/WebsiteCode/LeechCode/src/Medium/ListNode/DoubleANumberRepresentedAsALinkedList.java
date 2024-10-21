package Medium.ListNode;

import Medium.ListNode.Class.ListNode;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/double-a-number-represented-as-a-linked-list/">2816. Double a Number Represented as a Linked List</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given the <code>head</code> of a <strong>non-empty</strong> linked list representing a non-negative integer without leading zeroes.</p>

<p>Return <em>the </em><code>head</code><em> of the linked list after <strong>doubling</strong> it</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2023/05/28/example.png" style="width: 401px; height: 81px;">
<pre><strong>Input:</strong> head = [1,8,9]
<strong>Output:</strong> [3,7,8]
<strong>Explanation:</strong> The figure above corresponds to the given linked list which represents the number 189. Hence, the returned linked list represents the number 189 * 2 = 378.
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2023/05/28/example2.png" style="width: 401px; height: 81px;">
<pre><strong>Input:</strong> head = [9,9,9]
<strong>Output:</strong> [1,9,9,8]
<strong>Explanation:</strong> The figure above corresponds to the given linked list which represents the number 999. Hence, the returned linked list reprersents the number 999 * 2 = 1998. 
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the list is in the range <code>[1, 10<sup>4</sup>]</code></li>
	<li><font face="monospace"><code>0 &lt;= Node.val &lt;= 9</code></font></li>
	<li>The input is generated such that the list represents a number that does not have leading zeros, except the number <code>0</code> itself.</li>
</ul>
</div>
 */
public class DoubleANumberRepresentedAsALinkedList {
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

            System.out.println(new DoubleANumberRepresentedAsALinkedList_Solution().doubleIt(list1).toString());
        }
    }
}

// 7 ms 45.7 MB
class DoubleANumberRepresentedAsALinkedList_Solution {
    public ListNode doubleIt(ListNode head) {
        ListNode loop = head;
        int arr[] = new int[10_001],
            i = 0;

        while (loop != null) {
            arr[i++] = loop.val*2;

            loop = loop.next;
        }
        
        int remain = 0;
        for (int j = i-1; j >= 0; j--) {
            int num = arr[j]+remain;
            arr[j] = num > 9 ? num-10: num; 
            remain = num > 9 ? 1 : 0;
        }

        loop = head;
        for (int j = 0; j < i; j++) {
            loop.val = arr[j];
            loop = loop.next;
        }

        if (remain == 1) {
            ListNode first = new ListNode(1);
            first.next = head;
            head = first;
        }

        return head;
    }
}