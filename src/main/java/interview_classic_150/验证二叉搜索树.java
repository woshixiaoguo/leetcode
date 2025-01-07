package interview_classic_150;

import java.util.Stack;

import org.junit.Test;

import ds.TreeNode;

/**
 * 98 验证二叉搜索树
 *
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * 
 * 有效 二叉搜索树定义如下：
 * 
 * 节点的左
 * 子树
 * 只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 
 * 示例 1：
 * 
 * <img src="https://assets.leetcode.com/uploads/2020/12/01/tree1.jpg"/>
 * 
 * 输入：root = [2,1,3]
 * 输出：true
 * 
 * 示例 2：
 * 
 * <img src="https://assets.leetcode.com/uploads/2020/12/01/tree2.jpg"/>
 * 
 * 输入：root = [5,1,4,null,null,3,6]
 * 输出：false
 * 解释：根节点的值是 5 ，但是右子节点的值是 4 。
 * 
 * 提示：
 * 
 * 树中节点数目范围在[1, 104] 内
 * -231 <= Node.val <= 231 - 1
 */

public class 验证二叉搜索树 {

    public boolean isValidBST(TreeNode root) {
        double flag = -Double.MAX_VALUE;
        // System.out.println(flag);
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= flag)
                return false;
            flag = root.val;
            root = root.right;
        }
        return true;
    }

    public boolean isValidBST2(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }

    @Test
    public void test() {
        // Object[] root = { 5, 1, 4, null, null, 3, 6 };
        // Object[] root = { 5, 4, 6, null, null, 3, 7 };
        Object[] root = { -2147483648 };

        TreeNode node = TreeNode.arrToNode(root);
        boolean ans = isValidBST(node);
        System.out.println(ans);
    }
}
