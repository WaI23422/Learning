package Medium.ListNode;

import Medium.ListNode.Class.ListNode;

public class MergeInBetweenLinkedLists {
    public static void main(String[] args) {
        int[][][] tests = {
            {{0,1,2,3,4,5,6},{1000000,1000001,1000002,1000003,1000004},{2,5}},
            {{10,1,13,6,9,5},{1000000,1000001,1000002},{3,4}},
        };

        for (int[][] test : tests) {
            ListNode list1 = ListNode.addNode(test[0]),
                     list2 = ListNode.addNode(test[1]);
            int a = test[2][0],
                b = test[2][1];

            System.out.println(new MergeInBetweenLinkedLists_Solution().mergeInBetween(list1, a, b, list2).toString());
        }
    }
}

// 2 ms 46.6 MB
class MergeInBetweenLinkedLists_Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int atNode = 0; 
        ListNode trackFirst = list1,
                 trackLast = list1;

        while (list1.next != null) {
            if (atNode == a-1) {
                trackLast = trackFirst.next;
                trackFirst.next = list2;
            } else if (atNode < a){trackFirst = trackFirst.next;}

            if (atNode == b+1) {
                trackFirst = trackLast.next;
                trackLast.next = null;
                trackLast = list2;
                while (trackLast.next != null) {
                    trackLast = trackLast.next;
                }
                trackLast.next = trackFirst;
                break;
            } else if (atNode > a) {trackLast = trackLast.next;}
            
            atNode++;
        }

        return list1;
    }
}