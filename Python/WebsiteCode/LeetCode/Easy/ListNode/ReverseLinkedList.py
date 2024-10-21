from Class.ListNode import ListNode;

class Solution:
    def reverseList(self, head):
        prev=None
        cur=head
        while cur:
            nxt=cur.next
            cur.next=prev
            prev=cur
            cur=nxt
        head=prev
        return head

if __name__ == "__main__":
    a = ListNode()
    print(a)