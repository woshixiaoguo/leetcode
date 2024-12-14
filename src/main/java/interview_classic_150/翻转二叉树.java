package interview_classic_150;

import org.junit.Test;

import ds.TreeNode;

/**
 * 226 翻转二叉树
 *
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 *
 * 示例 1：
 *
 * <img src="https://assets.leetcode.com/uploads/2021/03/14/invert1-tree.jpg"/>
 * 
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *
 * 示例 2：
 * 
 * <img src="https://assets.leetcode.com/uploads/2021/03/14/invert2-tree.jpg"/>
 * 
 * 输入：root = [2,1,3]
 * 输出：[2,3,1]
 *
 * 示例 3：
 * 
 * 输入：root = []
 * 输出：[]
 * 
 * 提示：
 * 
 * 树中节点数目范围在 [0, 100] 内
 * -100 <= Node.val <= 100
 * 
 */

public class 翻转二叉树 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;

    }

    @Test
    public void test() {
        Object[] root = { 4, 2, 7, 1, 3, 6, 9 };
        TreeNode node = TreeNode.arrToNode(root);
        TreeNode ans = invertTree(node);
        TreeNode.print(ans);

    }
}
