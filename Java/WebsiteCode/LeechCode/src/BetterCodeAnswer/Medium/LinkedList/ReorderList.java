package BetterCodeAnswer.Medium.LinkedList;

import Medium.LinkedList.Class.ListNode;

public class ReorderList {
    public static void main(String[] args) {
        int[][] tests = {
            {1,2,3,4,5},
            {1,2,3,4},
            {1,2,3,4,5},
            {1,2,3,-3,-2},
            {1,2,4,-3,1},
            {1,2,3,-6,-3,1}
        }; 

        for (int[] test : tests) {
            ListNode head = ListNode.addNode(test, 0);
            new ReorderList_Solution().reorderList(head);
            System.out.println(head.toString());
        }
    }
}

// 1 ms 49.10 MB
class ReorderList_Solution {
    
    private ListNode temp;
    private boolean isStop;

    public void reorderList(ListNode head) {
        temp = head;
        isStop = false;
        reorder(head);
    }

    private void reorder(ListNode head) {
        if (head == null) return;
        reorder(head.next);

        if (!isStop) {
            ListNode next = temp.next;
            temp.next = head;
            head.next = next;
            temp = next;
        }

        if (temp != null && temp.next == head) {
            temp.next = null;
            isStop = true;
        }
    }
}