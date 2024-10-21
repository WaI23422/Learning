package Medium.ListNode;

import BetterCodeAnswer.Medium.ListNode.Class.ListNode;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/split-linked-list-in-parts/">725. Split Linked List in Parts</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>Given the <code>head</code> of a singly linked list and an integer <code>k</code>, split the linked list into <code>k</code> consecutive linked list parts.</p>
 * 
 * <p>The length of each part should be as equal as possible: no two parts should have a size differing by more than one. This may lead to some parts being null.</p>
 * 
 * <p>The parts should be in the order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal to parts occurring later.</p>
 * 
 * <p>Return <em>an array of the </em><code>k</code><em> parts</em>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/06/13/split1-lc.jpg" style="width: 400px; height: 134px;">
 * <pre><strong>Input:</strong> head = [1,2,3], k = 5
 * <strong>Output:</strong> [[1],[2],[3],[],[]]
 * <strong>Explanation:</strong>
 * The first element output[0] has output[0].val = 1, output[0].next = null.
 * The last element output[4] is null, but its string representation as a ListNode is [].
 * </pre>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2021/06/13/split2-lc.jpg" style="width: 600px; height: 60px;">
 * <pre><strong>Input:</strong> head = [1,2,3,4,5,6,7,8,9,10], k = 3
 * <strong>Output:</strong> [[1,2,3,4],[5,6,7],[8,9,10]]
 * <strong>Explanation:</strong>
 * The input has been split into consecutive parts with size difference at most 1, and earlier parts are a larger size than the later parts.
 * </pre>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li>The number of nodes in the list is in the range <code>[0, 1000]</code>.</li>
 * 	<li><code>0 &lt;= Node.val &lt;= 1000</code></li>
 * 	<li><code>1 &lt;= k &lt;= 50</code></li>
 * </ul>
 * </div>
 */
public class SplitLinkedListInParts {
    public static void main(String[] args) {
        int[][][] tests = {
            {
                {1,2,3,4,5,6,7,8,9,10},
                {3}
            },
            {
                {1,2,3},
                {5}
            },
        };

        for (int[][] test : tests) {
            ListNode head = ListNode.addNode(test[0]);
            int k = test[1][0];

            ListNode[] ans = new SplitLinkedListInParts_Solution().splitListToParts(head,k);

            System.out.print('[');
            for (int i = 0; i < ans.length; i++) {
                if (i == ans.length-1) {
                    System.out.print((ans[i] == null ? "[]": ans[i].toString()));
                } else {
                    System.out.print((ans[i] == null ? "[]": ans[i].toString())+",");
                }
            }
            System.out.println("]");
        }
    }
}

// 0ms 43.26MB
class SplitLinkedListInParts_Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] list_arr = new ListNode[k];;
        int list_len = lenList(head);

        if (list_len > k) {
            int average = list_len/k,
                left = list_len%k;

            ListNode temp,
                     temp2 = head;

            for (int i = 0; i < k; i++) {
                head = temp2;
                temp = head;
                int loop = average-1 + (left-- > 0 ? 1 : 0);
                for (int j = 0; j < loop; j++) {
                    head = head.next;
                }
                temp2 = head.next;
                head.next = null;
                list_arr[i] = temp;
            }
        } else {
            for (int i = 0; i < list_len; i++) {
                list_arr[i] = new ListNode(head.val);
                head = head.next;
            }
        }

        return list_arr;
    }

    private int lenList(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }

        return len;
    }
}