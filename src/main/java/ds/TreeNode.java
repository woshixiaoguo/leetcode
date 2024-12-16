package ds;

import java.util.LinkedList;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode arrToNode(Object[] arr) {
        LinkedList<TreeNode> deque = new LinkedList<TreeNode>();
        TreeNode head = new TreeNode();
        for (int i = 0; i < arr.length; i++) {
            Object e = arr[i];
            TreeNode node;
            if (e != null) {
                if (deque.isEmpty()) {
                    node = new TreeNode(Integer.parseInt(String.valueOf(e)));
                    head = node;
                    // System.out.println("head");
                } else {
                    node = deque.removeFirst();
                    node.val = Integer.parseInt(String.valueOf(e));
                    // node = new TreeNode(Integer.parseInt(String.valueOf(e)));
                    // System.out.println("leaf: " + node.getVal());
                }

                if (2 * i + 1 < arr.length && arr[2 * i + 1] != null) {
                    TreeNode left = new TreeNode();
                    node.left = left;
                }
                if (2 * i + 2 < arr.length && arr[2 * i + 2] != null) {
                    TreeNode right = new TreeNode();
                    node.right = right;
                }
                // TreeNode left = node.left;
                // TreeNode right = node.right;
                deque.add(node.left);
                // if (node.left == null)
                // System.out.println("add null left");
                deque.add(node.right);
                // if (node.right == null)
                // System.out.println("add null right");
                // System.out.println("size: " + deque.size());
            } else {
                deque.removeFirst();
                // System.out.print("null ");
                // System.out.println("size: " + deque.size());
            }
        }
        return head;
    }

    public static void print(TreeNode node) {
        if (node == null) {
            System.out.println("null");
        } else {
            System.out.println(node.val);
            print(node.left);
            print(node.right);
        }
    }
}
