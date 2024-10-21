package Medium.TreeNode;

import Medium.TreeNode.Class.TreeNode;

/**
 * PseudoPalindromicPathsInABinaryTree
 */
public class PseudoPalindromicPathsInABinaryTree {
    public static void main(String[] args) {
        Object[][] tests = {
            {2,3,1,3,1,null,1},
            {2,1,1,1,3,null,null,null,null,null,1},
            {9},
        };

        for (Object[] test : tests) {
            TreeNode root = TreeNode.addNode(test, 0);

            System.out.println(new PseudoPalindromicPathsInABinaryTree_Solution().pseudoPalindromicPaths(root));
        }
    }
}

// 15 ms 69.9 MB
class PseudoPalindromicPathsInABinaryTree_Solution {
    int count = 0;

    public int pseudoPalindromicPaths (TreeNode root) {
        int[] freq = new int[10];

        DFS(root, freq);

        return count;
    }

    private void DFS(TreeNode root, int[] freq) {
        if(root == null) {
            return;
        }

        if(root.left == null && root.right == null) {
            freq[root.val]++;
            if(isPalindrome(freq)) {
                count++;
            }
            freq[root.val]--;
            return;
        }

        freq[root.val]++;
        DFS(root.left, freq);
        DFS(root.right, freq);
        freq[root.val]--;
    }

    private boolean isPalindrome(int[] freq) {
        int c = 0;

        for(int cur : freq) {
            if(cur %2 != 0) {
                c++;
            }
        }

        return c <= 1;
    }
}