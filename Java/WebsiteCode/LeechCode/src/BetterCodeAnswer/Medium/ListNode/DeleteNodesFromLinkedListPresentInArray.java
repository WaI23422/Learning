package BetterCodeAnswer.Medium.ListNode;

import Medium.ListNode.Class.ListNode;

/**
 * <a class="no-underline hover:text-blue-s dark:hover:text-dark-blue-s truncate cursor-text whitespace-normal hover:!text-[inherit]" href="/problems/delete-nodes-from-linked-list-present-in-array/">3217. Delete Nodes From Linked List Present in Array</a>
 * 
 * <div class="elfjS" data-track-load="description_content"><p>You are given an array of integers <code>nums</code> and the <code>head</code> of a linked list. Return the <code>head</code> of the modified linked list after <strong>removing</strong> all nodes from the linked list that have a value that exists in <code>nums</code>.</p>
 * 
 * <p>&nbsp;</p>
 * <p><strong class="example">Example 1:</strong></p>
 * 
 * <div class="example-block">
 * <p><strong>Input:</strong> <span class="example-io">nums = [1,2,3], head = [1,2,3,4,5]</span></p>
 * 
 * <p><strong>Output:</strong> <span class="example-io">[4,5]</span></p>
 * 
 * <p><strong>Explanation:</strong></p>
 * 
 * <p><strong><img alt="" src="https://assets.leetcode.com/uploads/2024/06/11/linkedlistexample0.png" style="width: 400px; height: 66px;"></strong></p>
 * 
 * <p>Remove the nodes with values 1, 2, and 3.</p>
 * </div>
 * 
 * <p><strong class="example">Example 2:</strong></p>
 * 
 * <div class="example-block">
 * <p><strong>Input:</strong> <span class="example-io">nums = [1], head = [1,2,1,2,1,2]</span></p>
 * 
 * <p><strong>Output:</strong> <span class="example-io">[2,2,2]</span></p>
 * 
 * <p><strong>Explanation:</strong></p>
 * 
 * <p><img alt="" src="https://assets.leetcode.com/uploads/2024/06/11/linkedlistexample1.png" style="height: 62px; width: 450px;"></p>
 * 
 * <p>Remove the nodes with value 1.</p>
 * </div>
 * 
 * <p><strong class="example">Example 3:</strong></p>
 * 
 * <div class="example-block">
 * <p><strong>Input:</strong> <span class="example-io">nums = [5], head = [1,2,3,4]</span></p>
 * 
 * <p><strong>Output:</strong> <span class="example-io">[1,2,3,4]</span></p>
 * 
 * <p><strong>Explanation:</strong></p>
 * 
 * <p><strong><img alt="" src="https://assets.leetcode.com/uploads/2024/06/11/linkedlistexample2.png" style="width: 400px; height: 83px;"></strong></p>
 * 
 * <p>No node has value 5.</p>
 * </div>
 * 
 * <p>&nbsp;</p>
 * <p><strong>Constraints:</strong></p>
 * 
 * <ul>
 * 	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
 * 	<li><code>1 &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
 * 	<li>All elements in <code>nums</code> are unique.</li>
 * 	<li>The number of nodes in the given list is in the range <code>[1, 10<sup>5</sup>]</code>.</li>
 * 	<li><code>1 &lt;= Node.val &lt;= 10<sup>5</sup></code></li>
 * 	<li>The input is generated such that there is at least one node in the linked list that has a value not present in <code>nums</code>.</li>
 * </ul>
 * </div>
 */
public class DeleteNodesFromLinkedListPresentInArray {
    public static void main(String[] args) {
        int[][][] tests = {
            {
                {9},
                {2,10,9}
            },
            {
                {1,2,3},
                {1,2,3,4,5}
            }
        };

        for (int[][] test : tests) {
            int nums[] = test[0];
            ListNode list1 = ListNode.addNode(test[1]);
            
            System.out.println(new DeleteNodesFromLinkedListPresentInArray_Solution().modifiedList(nums, list1));
        }
    }
}

// 3ms 71.82MB
class DeleteNodesFromLinkedListPresentInArray_Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        int max = 0;
        for(int n:nums){
            if(n > max){
                max = n;
            }
        }
        boolean[] seen = new boolean[max+1];

        for(int n:nums){
            seen[n] = true;
        }
        while(head != null && head.val <= max && seen[head.val]){
            head = head.next;
        }
        if(head == null){
            return head;
        }
        ListNode curr = head.next, prev = head;
        while(curr != null){
            if(curr.val <= max && seen[curr.val]){
                prev.next = curr.next;
            }else{
                prev = curr;
            }
            curr = curr.next;
        }        
        return head;
    }
}