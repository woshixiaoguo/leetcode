package interview_classic_150;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import ds.TreeNode;

/**
 * 114 二叉树展开为链表
 *
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * 
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 * 
 * 
 * 示例 1：
 * 
 * <img src="https://assets.leetcode.com/uploads/2021/01/14/flaten.jpg"/>
 * 
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 * 示例 2：
 * 
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * 
 * 输入：root = [0]
 * 输出：[0]
 * 
 * 
 * 提示：
 * 
 * 树中结点数在范围 [0, 2000] 内
 * -100 <= Node.val <= 100
 * 
 * 
 * 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？
 */

public class 二叉树展开为链表 {

    Deque<TreeNode> stack = new ArrayDeque<TreeNode>();

    /**
     * @param root
     *             将未展平的子树插入双端队列
     */
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        TreeNode head = root;
        if (root.right != null)
            stack.push(root.right);
        if (root.left != null)
            stack.push(root.left);
        root.left = null;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null)
                continue;
            if (node.right != null) {
                stack.push(node.right);
                System.out.println("node.right" + node.right.val);
            }
            head.right = node;
            head = head.right;
            if (node.left != null) {
                stack.push(node.left);
            }
            node.left = null;
        }
    }

    public void flatten2(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        TreeNode prev = null;
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (prev != null) {
                prev.left = null;
                prev.right = curr;
            }
            TreeNode left = curr.left, right = curr.right;
            if (right != null) {
                stack.push(right);
            }
            if (left != null) {
                stack.push(left);
            }
            prev = curr;
        }
    }

    public void flatten3(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        preorderTraversal(root, list);
        int size = list.size();
        for (int i = 1; i < size; i++) {
            TreeNode prev = list.get(i - 1), curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }

    public void preorderTraversal(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            preorderTraversal(root.left, list);
            preorderTraversal(root.right, list);
        }
    }

    @Test
    public void test() {
        Object[] node = { 1, 2, 5, 3, 4, null, 6 };
        Object[] node2 = { 0 };
        TreeNode root = TreeNode.arrToNode(node);
        flatten(root);
        // TreeNode.print(root);
        while (root != null) {
            System.out.println(root.val);
            root = root.right;
        }
    }
}
