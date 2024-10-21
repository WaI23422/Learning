package Medium.ListNode;

import BetterCodeAnswer.Medium.ListNode.Class.ListNode;

public class InsertGreatestCommonDivisorsInLinkedList {
    public static void main(String[] args) {
        int[][] tests = {
            {18,6,10,3},
        };

        for (int[] test : tests) {
            ListNode head = ListNode.addNode(test);

            System.out.println(new InsertGreatestCommonDivisorsInLinkedList_Solution().insertGreatestCommonDivisors(head).toString());
        }
    }
}

// 2ms 45.08MB
class InsertGreatestCommonDivisorsInLinkedList_Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode temp = head;
        while (temp.next != null) {
            int gcd = gcd(temp.val, temp.next.val);

            ListNode gcd_Node = new ListNode(gcd);
            gcd_Node.next = temp.next;
            temp.next = gcd_Node;

            temp = temp.next.next;
        }


        return head;
    }

    private int gcd(int a, int b) {
        if (b == 0) {return a;}

        return gcd(b,a%b);
    }
}