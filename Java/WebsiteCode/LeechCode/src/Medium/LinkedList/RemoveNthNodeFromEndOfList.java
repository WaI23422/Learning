package Medium.LinkedList;

import Medium.LinkedList.Class.ListNode;

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

// 0 ms 42.1 MB
class RemoveNthNodeFromEndOfList_Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = findLength(head);
        int i = 0, traverseTill = length - n - 1;
        if(traverseTill == -1) return head.next;
        ListNode curr = head;
        while(i < traverseTill){
            curr = curr.next;
            i++;
        }
        curr.next = curr.next.next;
        return head;
    }

    public int findLength(ListNode head){
        int count = 0;
        if(head == null) return count;
        ListNode curr = head;
        while(curr != null){
            count++;
            curr = curr.next;
        }
        return count;
    }
}