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
public class AddTwoNumbersII {
    public static void main(String[] args) {
        int[][][] tests = {
            {{9,9,9,9,9,9,9},{9,9,9,9}},
            {{9,9,9,9},{9,9,9,9,9,9,9}},
            {{2,4,3},{5,6,4}},
            {{7,2,4,3},{5,6,4}}
        };

        for (int[][] test : tests) {
            ListNode list1 = ListNode.addNode(test[0]),
                     list2 = ListNode.addNode(test[1]);

            System.out.println(new AddTwoNumbersII_Solution().addTwoNumbers(list1, list2).toString());
        }
    }
}

// AddTwoNumbersII_Solution
class AddTwoNumbersII_Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode node = new ListNode();
    ListNode head = node;
    int flag = 0;
    l1 = reverse(l1);
    l2 = reverse(l2);
    while(l1 != null && l2 != null){
         int index = l1.val + l2.val + flag;
         flag = index/10;
         node.next = new ListNode(index %10);
         node = node.next;
         l1 = l1.next;
         l2 = l2.next;
    }
    while(l1 != null){
        int index = l1.val + flag;
        flag = index/10;
        node.next = new ListNode(index % 10);
        node = node.next;
        l1 = l1.next;
    }
    while(l2 != null){
        int index = l2.val + flag;
        flag = index / 10; // Update carry
        node.next = new ListNode(index % 10);
        node = node.next;
        l2 = l2.next;
    }
    if(flag > 0){
        node.next = new ListNode(flag);
    }
    return reverse(head.next);
        
    }
    public ListNode reverse(ListNode list){
        if(list == null){
            return null;
        }
        ListNode pre = null;
        while(list != null){
            ListNode temp = list.next;
            list.next = pre;
            pre = list;
            list = temp;
        }
        return pre;
    }
}