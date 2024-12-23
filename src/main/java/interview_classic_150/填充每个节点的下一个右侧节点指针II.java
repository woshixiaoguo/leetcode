package interview_classic_150;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

import org.junit.Test;

import ds.Node;

/**
 * 117 填充每个节点的下一个右侧节点指针II
 *
 * 给定一个二叉树：
 * 
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 *
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL 。
 * 
 * 初始状态下，所有 next 指针都被设置为 NULL 。
 * 
 * 示例 1：
 * 
 * <img src="https://assets.leetcode.com/uploads/2019/02/15/117_sample.png"/>
 * 
 * 输入：root = [1,2,3,4,5,null,7]
 * 输出：[1,#,2,3,#,4,5,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化输出按层序遍历顺序（由 next
 * 指针连接），'#' 表示每层的末尾。
 * 示例 2：
 * 
 * 输入：root = []
 * 输出：[]
 * 
 * 提示：
 * 
 * 树中的节点数在范围 [0, 6000] 内
 * -100 <= Node.val <= 100
 *
 * 进阶：
 * 
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序的隐式栈空间不计入额外空间复杂度。
 */

public class 填充每个节点的下一个右侧节点指针II {

    public Node connect(Node root) {
        if (root == null)
            return root;
        ArrayList<ArrayList<Node>> table = new ArrayList<ArrayList<Node>>();
        ArrayList<Node> row = new ArrayList<Node>();
        row.add(root);
        table.add(row);
        while (!table.isEmpty()) {
            ArrayList<Node> r = table.remove(0);
            Node head = new Node();
            ArrayList<Node> newrow = new ArrayList<Node>();
            while (!r.isEmpty()) {
                head.next = r.remove(0);
                head = head.next;
                // System.out.println(head.val);
                if (head.left != null) {
                    newrow.add(head.left);
                    // System.out.println("left");
                }
                if (head.right != null) {
                    newrow.add(head.right);
                    // System.out.println("right");
                }
            }
            if (newrow.isEmpty())
                break;
            // System.out.println("newrow");
            table.add(newrow);
        }

        return root;
    }

    public Node connect2(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new ArrayDeque<Node>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            Node last = null;
            for (int i = 1; i <= n; ++i) {
                Node f = queue.poll();
                if (f.left != null) {
                    queue.offer(f.left);
                }
                if (f.right != null) {
                    queue.offer(f.right);
                }
                if (i != 1) {
                    last.next = f;
                }
                last = f;
            }
        }
        return root;
    }

    @Test
    public void test() {
        Object[] arr = { 1, 2, 3, 4, 5, null, 7 };
        Node root = Node.arrToNode(arr);
        // Node.print(root);
        Node ans = connect(root);
    }
}
