package BetterCodeAnswer.Medium.TreeNode.Class;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static int maxDepth(TreeNode root) {
        if(root == null) return 0;

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static String[] toArray(TreeNode root){
        int size = 0;
        for (int i = 0; i < TreeNode.maxDepth(root); i++) {
            size += Math.pow(2, i);
        }

        String[] arrNode = new String[size];

        addNodeToArray(arrNode, root, 0);

        return arrNode;
    }

    public static void addNodeToArray(String[] arr, TreeNode root, int i){
        if (i < arr.length) {
            if (root == null) {arr[i] = "null"; return;}

            arr[i] = String.valueOf(root.val);

            addNodeToArray(arr, root.left, 2*i + 1);
            addNodeToArray(arr, root.right, 2*i + 2);
        }
    }

    public static TreeNode addNode(Object[] arr,int i){
        TreeNode root = null;
        // Base case for recursion
        if (i < arr.length) {
            if (arr[i] == null) { return null;}

            root = new TreeNode((int) arr[i]);
 
            // insert left child
            root.left = addNode(arr, 2 * i + 1);
 
            // insert right child
            root.right = addNode(arr, 2 * i + 2);
        }
        return root;
    }
}
