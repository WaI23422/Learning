package Medium.LinkedList;

import Medium.LinkedList.Class.ListNode;
import Medium.TreeNode.Class.TreeNode;
import java.util.Arrays;

public class LinkedListInBinaryTree {
    public static void main(String[] args) {
        Object[][][] tests = {
            {
                {4,2,8},
                {1,4,4,null,2,2,null,1,null,6,8,null,null,null,null,1,3}
            }    
        }; 

        for (Object[][] test : tests) {
            ListNode head = ListNode.addNode(
                Arrays.stream(test[0])
                      .mapToInt(x-> (int) x)
                      .toArray()
                , 0);
            TreeNode root = TreeNode.addNode(test[1],0);
            
            System.out.println(new LinkedListInBinaryTree_Solution().isSubPath(head, root));
        }
    }
}

// 0ms 44.73MB
class LinkedListInBinaryTree_Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        return dfs(head, head, root);
    }

    boolean dfs(ListNode head, ListNode cur, TreeNode root) {
        if(cur == null) return true;
        if(root == null) return false;
        if(cur.val == root.val) cur = cur.next;
        else if (head.val == root.val) head = head.next;
        else cur = head;
        return dfs(head, cur, root.left) || dfs(head, cur, root.right);
    }

}