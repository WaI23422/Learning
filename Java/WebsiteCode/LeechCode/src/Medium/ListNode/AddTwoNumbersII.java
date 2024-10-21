package Medium.ListNode;

import java.util.Stack;

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

// 4 ms 44.7 MB
class AddTwoNumbersII_Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        Stack<Integer> stackElementList1 = addToStack(l1),
                       stackElementList2 = addToStack(l2);

        int remain = 0;
        while (!stackElementList1.empty() && !stackElementList2.empty()) {
            int add = stackElementList1.pop() + stackElementList2.pop() + remain;
            remain = 0;

            ListNode tail = new ListNode(add%10);
            tail.next = result;
            result = tail;

            if (add > 9) {remain = 1;}
        }

        if (!stackElementList1.empty()) {
            result = addStackToList(result, stackElementList1, remain);
        } else {
            result = addStackToList(result, stackElementList2, remain);
        }   

        return result;
    }

    private Stack<Integer> addToStack(ListNode list) {
        Stack<Integer> stack = new Stack<>();

        while (list != null) {
            stack.add(list.val);
            list = list.next;
        }
        
        return stack;
    }

    private ListNode addStackToList(ListNode list, Stack<Integer> stack, int remain) {
        while (!stack.empty()) {
            int add = stack.pop() + remain;
            remain = 0;

            ListNode tail = new ListNode(add%10);
            tail.next = list;
            list = tail;

            if (add > 9) {remain = 1;}
        }

        if (remain == 1) {
            ListNode tail = new ListNode(1);
            tail.next = list;
            list = tail;
        } 

        return list;
    }
}