package BetterCodeAnswer.Medium.TreeNode;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import Medium.TreeNode.Class.TreeNode;

public class KthLargestSumInABinaryTree {
    public static void main(String[] args) {
        Object[][][] tests = {
            {
                {411310,211244,111674},
                {2}
            },
            {
                {5,8,9,2,1,3,7},
                {4}
            },
            {
                {5,8,9,2,1,3,7,4,6},
                {2}
            },
            {
                {5,8,9,2,1,3,7,4,6},
                {1}
            },
        };

        for (Object[][] arr : tests) {
            TreeNode root = TreeNode.addNode(arr[0],0);
            int k = (int) arr[1][0];

            System.out.println(new KthLargestSumInABinaryTree_Solution().kthLargestLevelSum(root,k));
        }
    }
}

// 11ms 79.91MB
class KthLargestSumInABinaryTree_Solution {
    private int exploreLevels(TreeNode root, int level, long[] level_to_sum) {
        level_to_sum[level] += root.val;
        int left_level = level;
        if (root.left != null) {
            left_level = exploreLevels(root.left, level + 1, level_to_sum);
        }
        int right_level = level;
        if (root.right != null) {
            right_level = exploreLevels(root.right, level + 1, level_to_sum);
        }
        return Math.max(left_level, right_level);
    }

    private void swap(long[] values, int left, int right) {
        long temp = values[left];
        values[left] = values[right];
        values[right] = temp;
    }

    private int partition(long[] values, int start, int end, int target) {
        int current = start;
        long pivot_value = values[start];
        for (int i = current + 1; i <= end; i++) {
            long value = values[i];
            if (value <= pivot_value) {
                swap(values, current + 1, i);
                current++;
            }
        }
        swap(values, start, current);
        return current;
    }

    private long largest(long[] values, int start, int end, int target) {
        int index = partition(values, start, end, target);
        if (index < target) {
            return largest(values, index + 1, end, target);
        } else if (index == target) {
            return values[index];
        } else {
            long pivot_value = values[index];
            while (index > target && values[index] == pivot_value) {
                index--;
            }
            return largest(values, start, index, target);
        }
    }

    public long kthLargestLevelSum(TreeNode root, int k) {
        long[] level_to_sum = new long[100001];
        int max_level = exploreLevels(root, 0, level_to_sum);
        if (k > (max_level + 1)) {
            return -1;
        }
        return largest(level_to_sum, 0, max_level, max_level + 1 - k);
    }
}

// 33ms 63.54MB
class KthLargestSumInABinaryTree_Solution2 {

    public long kthLargestLevelSum(TreeNode root, int k) {
        // min heap of size k
        // at the end, top element is kth largest
        PriorityQueue<Long> pq = new PriorityQueue<>();

        Queue<TreeNode> bfsQueue = new LinkedList<>();
        bfsQueue.add(root);
        while (!bfsQueue.isEmpty()) {
            //level order traversal
            int size = bfsQueue.size();
            long sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode poppedNode = bfsQueue.remove();
                sum += poppedNode.val;
                if (poppedNode.left != null) {
                    //add left child
                    bfsQueue.add(poppedNode.left);
                }
                if (poppedNode.right != null) {
                    // add right child
                    bfsQueue.add(poppedNode.right);
                }
            }
            pq.add(sum);
            if (pq.size() > k) {
                // evict top element
                pq.remove();
            }
        }
        if (pq.size() < k) return -1;
        return pq.peek();
    }
}