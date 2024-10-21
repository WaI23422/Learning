package BetterCodeAnswer.Medium.ListNode;

import Medium.ListNode.Class.ListNode;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/add-two-numbers/">2. Add Two Numbers</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given two <strong>non-empty</strong> linked lists representing two non-negative integers. The digits are stored in <strong>reverse order</strong>, and each of their nodes contains a single digit. Add the two numbers and return the sum&nbsp;as a linked list.</p>

<p>You may assume the two numbers do not contain any leading zero, except the number 0 itself.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/02/addtwonumber1.jpg" style="width: 483px; height: 342px;">
<pre><strong>Input:</strong> l1 = [2,4,3], l2 = [5,6,4]
<strong>Output:</strong> [7,0,8]
<strong>Explanation:</strong> 342 + 465 = 807.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> l1 = [0], l2 = [0]
<strong>Output:</strong> [0]
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
<strong>Output:</strong> [8,9,9,9,0,0,0,1]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in each linked list is in the range <code>[1, 100]</code>.</li>
	<li><code>0 &lt;= Node.val &lt;= 9</code></li>
	<li>It is guaranteed that the list represents a number that does not have leading zeros.</li>
</ul>
</div>
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        int[][][] tests = {
            {{9,9,9,9,9,9,9},{9,9,9,9}},
            {{9,9,9,9},{9,9,9,9,9,9,9}},
            {{2,4,3},{5,6,4}},
        };

        for (int[][] test : tests) {
            ListNode list1 = ListNode.addNode(test[0]),
                     list2 = ListNode.addNode(test[1]);

            System.out.println(new AddTwoNumbers_Solution().addTwoNumbers(list1, list2).toString());
        }
    }
}

// 1 ms 44.4 MB
class AddTwoNumbers_Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        int carry = 0;

        while(l1 != null || l2 != null || carry != 0){
            int digit1 = (l1 != null) ? l1.val : 0;
            int digit2 = (l2 != null) ? l2.val : 0;

            int sum = digit1 + digit2 + carry;
            int digit = sum % 10;
            carry = sum / 10;

            ListNode node = new ListNode(digit);
            tail.next = node;
            tail = node;

            l1 = (l1 != null) ? l1.next: null;
            l2 = (l2 != null) ? l2.next: null;
        }

        ListNode result = dummyHead.next;
        dummyHead.next = null;
        return result;
    }
}