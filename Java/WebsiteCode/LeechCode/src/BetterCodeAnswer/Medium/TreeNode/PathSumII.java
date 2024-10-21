package BetterCodeAnswer.Medium.TreeNode;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

import Medium.TreeNode.Class.TreeNode;

public class PathSumII {
    public static void main(String[] args) {
        Object[][][] tests = {
            {{5,4,8,11,null,13,4,7,2,null,null,5,1},{22}},
        };

        for (Object[][] arr : tests) {
            TreeNode root = TreeNode.addNode(arr[0],0);
            int targetSum = (int) arr[1][0];

            List<List<Integer>> ans = new PathSumII_Solution().pathSum(root, targetSum);

            System.out.print("[");
            for (List<Integer> list : ans) {
                System.out.print(list.toString() + ",");
            }
            System.out.print("]");
        }
    }
}

// 0ms 44.70MB
class PathSumII_Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        return new AbstractList<List<Integer>>() {

            private List<List<Integer>> resList;

            private void onload() {
                resList = new ArrayList<>();
                if (null == root) {
                    return;
                }
                ArrayList<Integer> path = new ArrayList<Integer>();
                path.add(root.val);

                dfs(root, path, root.val, targetSum);
            }

            private void dfs(TreeNode root, ArrayList<Integer> path, int sum, int target) {
                    //meet leaf
                    if (root.left == null && root.right == null) {
                        if (sum == target) {
                            resList.add(new ArrayList<Integer> (path));
                        }
                        return;
                    }

                    //go left
                    if (root.left != null) {
                        path.add(root.left.val);
                        dfs(root.left, path, sum + root.left.val, target);
                        path.remove(path.size() - 1);
                    }

                    //go right
                    if (root.right != null) {
                        path.add(root.right.val);
                        dfs(root.right, path, sum + root.right.val, target);
                        path.remove(path.size() - 1);
                    }
                }

            private void init() {
                if (null == resList) {
                    onload();
                    System.gc();
                }
            }

            @Override
            public List<Integer> get(int index) {
                init();
                return resList.get(index);
            }

            @Override
            public int size() {
                init();
                return resList.size();
            }

        };
    }
}