package BetterCodeAnswer.Medium.ListNode;

import BetterCodeAnswer.Medium.ListNode.Class.ListNode;

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
        ListNode first=list1;
        ListNode second=list1;
        ListNode ans=first;
        int i=1;int j=0;

        while(i<a){
            first=first.next;
            i++;
        }
        
        while(j<b){
            second=second.next;j++;
        }
        first.next=list2;

        ListNode secon=list2;
        while(secon.next!=null){
            secon=secon.next;
        }
        secon.next=second.next;

        return ans;   
    }
}