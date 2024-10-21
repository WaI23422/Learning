package Easy.ListNode;

import java.util.ArrayList;
import java.util.List;

import Easy.ListNode.Class.ListNode;

/**
 * <a class="mr-2 text-label-1 dark:text-dark-label-1 hover:text-label-1 dark:hover:text-dark-label-1 text-lg font-medium" href="/problems/remove-duplicates-from-sorted-list/">83.Remove Duplicates from Sorted List</a>
 * 
 * <div class="px-5 pt-4"><div class="flex"></div><div class="xFUwe" data-track-load="description_content"><p>Given the <code>head</code> of a sorted linked list, <em>delete all duplicates such that each element appears only once</em>. Return <em>the linked list <strong>sorted</strong> as well</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/04/list1.jpg" style="width: 302px; height: 242px;">
<pre><strong>Input:</strong> head = [1,1,2]
<strong>Output:</strong> [1,2]
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/04/list2.jpg" style="width: 542px; height: 222px;">
<pre><strong>Input:</strong> head = [1,1,2,3,3]
<strong>Output:</strong> [1,2,3]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the list is in the range <code>[0, 300]</code>.</li>
	<li><code>-100 &lt;= Node.val &lt;= 100</code></li>
	<li>The list is guaranteed to be <strong>sorted</strong> in ascending order.</li>
</ul>
</div></div>
 */
public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        int[][] tests = {
            {1,1,2},
            {1,1,2,2,3},
        };

        for (int[] test : tests) {
            ListNode head = new ListNode(test[0]);

            for (int i = test.length-1; i >= 1; i--) {
                head.next = new ListNode(test[i],head.next);
            }

            ListNode ans = new RemoveDuplicatesFromSortedList_Solution().deleteDuplicates(head);
            List<Integer> ansList = new ArrayList<>();

            while (ans != null) {
                ansList.add(ans.val);
                ans = ans.next;
            }

            System.out.println(ansList.toString());
        }
    }    
}

// 0 ms 43.1 MB
class RemoveDuplicatesFromSortedList_Solution {
   public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;

        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }
}