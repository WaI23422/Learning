package Medium.TreeNode;

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

// 20ms 80.63MB
class KthLargestSumInABinaryTree_Solution {
    long[] arr = new long[100_000];
    int max_level = 0;

    public long kthLargestLevelSum(TreeNode root, int k) {
        travelSum(root, 0);

        mergeSort(arr,0,max_level);

        return  k > max_level+1 ? -1 : arr[max_level-k+1];
    }

    public void travelSum(TreeNode root, int level) {
        if (root == null) {return;}
        arr[level] += root.val;
        if (max_level < level) {max_level = level;}
    
        travelSum(root.left, level+1);
        travelSum(root.right, level+1);
    }

    static void merge(long arr[], int l, int m, int r){
        int n1 = m - l + 1;
        int n2 = r - m;
 
        long L[] = new long[n1];
        long R[] = new long[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
 
        int i = 0, j = 0;
 
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
 
    public static void mergeSort(long arr[], int l, int r){
        if (l < r) {
 
            int m = l + (r - l) / 2;
 
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
 
            merge(arr, l, m, r);
        }
    }
}
