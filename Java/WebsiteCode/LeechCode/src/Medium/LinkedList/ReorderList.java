package Medium.LinkedList;

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

// 2 ms 46.4 MB
class ReorderList_Solution {
    public void reorderList(ListNode head) {
        int index = 0, sw = 0,fromHeadArr=1;
        int[] arrHold = new int[50_000];
        ListNode copHead = head;

        while (copHead != null) {
            arrHold[index++] = copHead.val;
            copHead = copHead.next;
        }
        
        head = head.next; index--;
        while (head != null) {
            if (sw%2 == 0) {
                head.val = arrHold[index--];
            } else {
                head.val = arrHold[fromHeadArr++];
            }
            sw++;
            head = head.next;
        }
    }
}