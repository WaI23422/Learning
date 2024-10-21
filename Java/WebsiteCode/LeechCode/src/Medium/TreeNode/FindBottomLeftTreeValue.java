package Medium.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

import Medium.TreeNode.Class.TreeNode;

/**
 * FindBottomLeftTreeValue
 */
public class FindBottomLeftTreeValue {
    public static void main(String[] args) {
        Object[][] tests = {
            // {2,1,3},
            {1,2,3,4,null,5,6,null,null,7}
        };

        for (Object[] arr : tests) {
            TreeNode root = TreeNode.addNode(arr,0);
            System.out.println(new FindBottomLeftTreeValue_Solution().findBottomLeftValue(root));
        }
    }
}

// 1 ms 44.1 MB
class FindBottomLeftTreeValue_Solution {
    public int findBottomLeftValue(TreeNode root) {
        int last = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int count = q.size();
            for (int i = 0; i < count; i++) {
                TreeNode curr = q.poll();
                if (i == 0)
                    last = curr.val;  // last leftMost val
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
        }
        return last;
    }
}