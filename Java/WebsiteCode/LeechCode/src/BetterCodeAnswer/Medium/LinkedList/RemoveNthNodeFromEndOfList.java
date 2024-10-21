package BetterCodeAnswer.Medium.LinkedList;

import BetterCodeAnswer.Medium.LinkedList.Class.ListNode;

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        int[][][] tests = {
            {{1,2,3,4,5},{2}},
            {{1},{1}},
            {{1,2},{2}}
        }; 

        for (int[][] test : tests) {
            ListNode headA = ListNode.addNode(test[0], 0);
            int n = test[1][0];
            ListNode ans = new RemoveNthNodeFromEndOfList_Solution().removeNthFromEnd(headA, n);
            System.out.println(ans == null? null : ans.toString());
        }
    }
}

// 0 ms 42 MB
class RemoveNthNodeFromEndOfList_Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode left = head;
        ListNode right = head.next;
        int i = 1;
        while(right != null){
            right = right.next;
            if (i > n){
                left = left.next;
            }
            i++;
        }

        if(i==n){
            return head.next;
        }

        left.next = left.next.next;
        return head;
    }
}