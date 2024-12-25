package ds;

import java.util.LinkedList;

public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    public static Node arrToNode(Object[] arr) {
        LinkedList<Node> deque = new LinkedList<Node>();
        Node head = new Node();
        for (int i = 0; i < arr.length; i++) {
            Object e = arr[i];
            Node node;
            if (e != null) {
                if (deque.isEmpty()) {
                    node = new Node(Integer.parseInt(String.valueOf(e)));
                    head = node;
                    // System.out.println("head");
                } else {
                    node = deque.removeFirst();
                    node.val = Integer.parseInt(String.valueOf(e));
                    // node = new TreeNode(Integer.parseInt(String.valueOf(e)));
                    // System.out.println("leaf: " + node.getVal());
                }

                if (2 * i + 1 < arr.length && arr[2 * i + 1] != null) {
                    Node left = new Node();
                    node.left = left;
                }
                if (2 * i + 2 < arr.length && arr[2 * i + 2] != null) {
                    Node right = new Node();
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

    public static void print(Node node) {
        if (node == null) {
            System.out.println("null");
        } else {
            System.out.println(node.val);
            print(node.left);
            print(node.right);
        }
    }

    public static void printNext(Node node) {
        if (node != null) {
            System.out.println(node.val);
            printNext(node.next);
        }
    }
};
