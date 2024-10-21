package Easy.LinkedList.Class;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
        val = x;
        next = null;
    }

    public static ListNode addNode(int[] nums,int at) {
        if (at < nums.length-1) {
            ListNode lst = new ListNode(nums[at]);
            lst.next = addNode(nums, at+1);

            return lst;
        } else {
            return new ListNode(nums[at]);
        }
    }

    @Override
    public String toString() {
        String s = "[";
        s += val;
        
        ListNode hold = next;
        while (hold != null) {
            s += "," + hold.val;
            hold = hold.next;
        }

        return s + "]";
    }
}
