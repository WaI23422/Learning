package Medium.ListNode;

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

// 6 ms 83.7 MB
class MergeNodesInBetweenZeros_Solution {
    public ListNode mergeNodes(ListNode head) {
        head = head.next;
        ListNode res = new ListNode(),
                 temp = res;         
        int tempSum = 0;
        while (head.next != null) {
            if (head.val == 0) {
                temp.val = tempSum;
                temp.next = new ListNode();
                temp = temp.next;
                tempSum = 0;
            } else {
                tempSum += head.val;
            }
            head = head.next;
        }

        return res;
    }
}