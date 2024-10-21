package BetterCodeAnswer.Easy.ListNode.Class;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode addNode(int[] arr) {
        if (arr.length == 0) {return new ListNode();}

        ListNode head = new ListNode(arr[0]);

        for (int i = arr.length-1; i >= 1; i--) {
            head.next = new ListNode(arr[i],head.next);
        }

        return head;
    }
    
    @Override
    public String toString(){
        if (val == 0) {return "[]";}

        String ans = "";
        if (next != null) {
            ans = String.format("[%d,", val);
        } else {
            ans = String.format("[%d]", val);
        }
        ListNode temp = next;

        while (temp != null) {
            if (temp.next == null) {
                ans += String.format("%d]",temp.val);
            } else {
                ans += String.format("%d,",temp.val);
            }

            temp = temp.next;
        }

        return ans;
    }
}

