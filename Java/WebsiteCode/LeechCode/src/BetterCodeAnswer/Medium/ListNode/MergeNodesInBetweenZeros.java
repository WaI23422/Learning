package BetterCodeAnswer.Medium.ListNode;

import BetterCodeAnswer.Medium.ListNode.Class.ListNode;

public class MergeNodesInBetweenZeros {
    public static void main(String[] args) {
        int[][] tests = {
            {0,1,2,3,4,5,6},
            {10,1,13,6,9,5},
        };

        for (int[] test : tests) {
            ListNode head = ListNode.addNode(test);

            System.out.println(new MergeNodesInBetweenZeros_Solution().mergeNodes(head).toString());
        }
    }
}

// 4 ms 83.7 MB
class MergeNodesInBetweenZeros_Solution {

    public ListNode mergeNodes(ListNode head) {
        // Initialize a sentinel/dummy node with the first non-zero value.
        ListNode modify = head.next;
        ListNode nextSum = modify;

        while (nextSum != null) {
            int sum = 0;
            // Find the sum of all nodes until you encounter a 0.
            while (nextSum.val != 0) {
                sum += nextSum.val;
                nextSum = nextSum.next;
            }

            // Assign the sum to the current node's value.
            modify.val = sum;
            // Move nextSum to the first non-zero value of the next block.
            nextSum = nextSum.next;
            // Move modify also to this node.
            modify.next = nextSum;
            modify = modify.next;
        }
        return head.next;
    }
}
